
package net.cs.summercraft.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.cs.summercraft.init.SummercraftModBlocks;

import java.util.List;
import java.util.Collections;

public class TragaperrasBlock extends Block {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public TragaperrasBlock() {
		super(PROPERTIES);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return (switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 9, 16, 1, 16), box(0, 0, 0, 16, 32, 9), box(0, 13, 9, 16, 14, 11), box(0, 14, 9, 16, 15, 12), box(1, 15, 10, 2.5, 15.25, 11.25), box(3, 15, 10, 4.5, 15.25, 11.25), box(7, 15, 10, 8.5, 15.25, 11.25),
					box(5, 15, 10, 6.5, 15.25, 11.25), box(11, 15, 10, 12.5, 15.25, 11.25), box(13, 15, 9.5, 15.5, 15.25, 11.5), box(9, 15, 10, 10.5, 15.25, 11.25));
			case NORTH -> Shapes.or(box(0, 0, 0, 16, 1, 7), box(0, 0, 7, 16, 32, 16), box(0, 13, 5, 16, 14, 7), box(0, 14, 4, 16, 15, 7), box(13.5, 15, 4.75, 15, 15.25, 6), box(11.5, 15, 4.75, 13, 15.25, 6), box(7.5, 15, 4.75, 9, 15.25, 6),
					box(9.5, 15, 4.75, 11, 15.25, 6), box(3.5, 15, 4.75, 5, 15.25, 6), box(0.5, 15, 4.5, 3, 15.25, 6.5), box(5.5, 15, 4.75, 7, 15.25, 6));
			case EAST -> Shapes.or(box(9, 0, 0, 16, 1, 16), box(0, 0, 0, 9, 32, 16), box(9, 13, 0, 11, 14, 16), box(9, 14, 0, 12, 15, 16), box(10, 15, 13.5, 11.25, 15.25, 15), box(10, 15, 11.5, 11.25, 15.25, 13), box(10, 15, 7.5, 11.25, 15.25, 9),
					box(10, 15, 9.5, 11.25, 15.25, 11), box(10, 15, 3.5, 11.25, 15.25, 5), box(9.5, 15, 0.5, 11.5, 15.25, 3), box(10, 15, 5.5, 11.25, 15.25, 7));
			case WEST -> Shapes.or(box(0, 0, 0, 7, 1, 16), box(7, 0, 0, 16, 32, 16), box(5, 13, 0, 7, 14, 16), box(4, 14, 0, 7, 15, 16), box(4.75, 15, 1, 6, 15.25, 2.5), box(4.75, 15, 3, 6, 15.25, 4.5), box(4.75, 15, 7, 6, 15.25, 8.5),
					box(4.75, 15, 5, 6, 15.25, 6.5), box(4.75, 15, 11, 6, 15.25, 12.5), box(4.5, 15, 13, 6.5, 15.25, 15.5), box(4.75, 15, 9, 6, 15.25, 10.5));
		}).move(offset.x, offset.y, offset.z);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(SummercraftModBlocks.TRAGAPERRAS, RenderType.solid());
	}
}
