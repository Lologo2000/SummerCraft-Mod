
package net.cs.summercraft.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
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

public class ExpendRojaBlock extends Block {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ExpendRojaBlock() {
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
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 3, 0, 2, 32, 16), box(2, 31, 0, 14, 32, 16), box(14, 3, 0, 16, 32, 16), box(2, 3, 15, 14, 29, 16), box(0, 0, 0, 16, 3, 16), box(2, 29, 0, 14, 32, 16), box(2, 10, 0, 14, 29, 1), box(2, 22, 3, 14, 23, 15),
					box(2, 10, 3, 14, 11, 15), box(2, 16, 3, 14, 17, 15), box(2, 26, 3, 14, 29, 15), box(2, 3, 0, 14, 7, 1), box(11, 11, 4, 13, 15, 6), box(11, 11, 7, 13, 15, 9), box(11, 11, 10, 13, 15, 12), box(11, 11, 13, 13, 15, 15),
					box(5, 17, 4, 7, 21, 6), box(5, 17, 7, 7, 21, 9), box(5, 17, 10, 7, 21, 12), box(5, 17, 13, 7, 21, 15), box(11, 17, 10, 13, 21, 12), box(11, 17, 13, 13, 21, 15), box(11, 17, 7, 13, 21, 9), box(11, 17, 4, 13, 21, 6),
					box(8, 17, 10, 10, 21, 12), box(8, 17, 13, 10, 21, 15), box(8, 17, 7, 10, 21, 9), box(8, 17, 4, 10, 21, 6), box(8, 11, 4, 10, 14, 6), box(8.5, 14, 4.5, 9.5, 15, 5.5), box(8, 11, 7, 10, 14, 9), box(8.5, 14, 7.5, 9.5, 15, 8.5),
					box(8, 11, 10, 10, 14, 12), box(8.5, 14, 10.5, 9.5, 15, 11.5), box(8, 11, 13, 10, 14, 15), box(8.5, 14, 13.5, 9.5, 15, 14.5), box(5, 11, 4, 7, 15, 6), box(2, 11, 4, 4, 15, 6), box(2, 11, 7, 4, 15, 9), box(5, 11, 7, 7, 15, 9),
					box(2, 11, 10, 4, 15, 12), box(5, 11, 10, 7, 15, 12), box(2, 17, 4, 4, 21, 6), box(2, 17, 7, 4, 21, 9), box(2, 17, 10, 4, 21, 12), box(2, 17, 13, 4, 21, 15), box(2, 17, 4, 4, 21, 6), box(2, 17, 7, 4, 21, 9),
					box(2, 17, 10, 4, 21, 12), box(2, 17, 13, 4, 21, 15));
			case NORTH -> Shapes.or(box(14, 3, 0, 16, 32, 16), box(2, 31, 0, 14, 32, 16), box(0, 3, 0, 2, 32, 16), box(2, 3, 0, 14, 29, 1), box(0, 0, 0, 16, 3, 16), box(2, 29, 0, 14, 32, 16), box(2, 10, 15, 14, 29, 16), box(2, 22, 1, 14, 23, 13),
					box(2, 10, 1, 14, 11, 13), box(2, 16, 1, 14, 17, 13), box(2, 26, 1, 14, 29, 13), box(2, 3, 15, 14, 7, 16), box(3, 11, 10, 5, 15, 12), box(3, 11, 7, 5, 15, 9), box(3, 11, 4, 5, 15, 6), box(3, 11, 1, 5, 15, 3),
					box(9, 17, 10, 11, 21, 12), box(9, 17, 7, 11, 21, 9), box(9, 17, 4, 11, 21, 6), box(9, 17, 1, 11, 21, 3), box(3, 17, 4, 5, 21, 6), box(3, 17, 1, 5, 21, 3), box(3, 17, 7, 5, 21, 9), box(3, 17, 10, 5, 21, 12),
					box(6, 17, 4, 8, 21, 6), box(6, 17, 1, 8, 21, 3), box(6, 17, 7, 8, 21, 9), box(6, 17, 10, 8, 21, 12), box(6, 11, 10, 8, 14, 12), box(6.5, 14, 10.5, 7.5, 15, 11.5), box(6, 11, 7, 8, 14, 9), box(6.5, 14, 7.5, 7.5, 15, 8.5),
					box(6, 11, 4, 8, 14, 6), box(6.5, 14, 4.5, 7.5, 15, 5.5), box(6, 11, 1, 8, 14, 3), box(6.5, 14, 1.5, 7.5, 15, 2.5), box(9, 11, 10, 11, 15, 12), box(12, 11, 10, 14, 15, 12), box(12, 11, 7, 14, 15, 9), box(9, 11, 7, 11, 15, 9),
					box(12, 11, 4, 14, 15, 6), box(9, 11, 4, 11, 15, 6), box(12, 17, 10, 14, 21, 12), box(12, 17, 7, 14, 21, 9), box(12, 17, 4, 14, 21, 6), box(12, 17, 1, 14, 21, 3), box(12, 17, 10, 14, 21, 12), box(12, 17, 7, 14, 21, 9),
					box(12, 17, 4, 14, 21, 6), box(12, 17, 1, 14, 21, 3));
			case EAST -> Shapes.or(box(0, 3, 14, 16, 32, 16), box(0, 31, 2, 16, 32, 14), box(0, 3, 0, 16, 32, 2), box(15, 3, 2, 16, 29, 14), box(0, 0, 0, 16, 3, 16), box(0, 29, 2, 16, 32, 14), box(0, 10, 2, 1, 29, 14), box(3, 22, 2, 15, 23, 14),
					box(3, 10, 2, 15, 11, 14), box(3, 16, 2, 15, 17, 14), box(3, 26, 2, 15, 29, 14), box(0, 3, 2, 1, 7, 14), box(4, 11, 3, 6, 15, 5), box(7, 11, 3, 9, 15, 5), box(10, 11, 3, 12, 15, 5), box(13, 11, 3, 15, 15, 5),
					box(4, 17, 9, 6, 21, 11), box(7, 17, 9, 9, 21, 11), box(10, 17, 9, 12, 21, 11), box(13, 17, 9, 15, 21, 11), box(10, 17, 3, 12, 21, 5), box(13, 17, 3, 15, 21, 5), box(7, 17, 3, 9, 21, 5), box(4, 17, 3, 6, 21, 5),
					box(10, 17, 6, 12, 21, 8), box(13, 17, 6, 15, 21, 8), box(7, 17, 6, 9, 21, 8), box(4, 17, 6, 6, 21, 8), box(4, 11, 6, 6, 14, 8), box(4.5, 14, 6.5, 5.5, 15, 7.5), box(7, 11, 6, 9, 14, 8), box(7.5, 14, 6.5, 8.5, 15, 7.5),
					box(10, 11, 6, 12, 14, 8), box(10.5, 14, 6.5, 11.5, 15, 7.5), box(13, 11, 6, 15, 14, 8), box(13.5, 14, 6.5, 14.5, 15, 7.5), box(4, 11, 9, 6, 15, 11), box(4, 11, 12, 6, 15, 14), box(7, 11, 12, 9, 15, 14), box(7, 11, 9, 9, 15, 11),
					box(10, 11, 12, 12, 15, 14), box(10, 11, 9, 12, 15, 11), box(4, 17, 12, 6, 21, 14), box(7, 17, 12, 9, 21, 14), box(10, 17, 12, 12, 21, 14), box(13, 17, 12, 15, 21, 14), box(4, 17, 12, 6, 21, 14), box(7, 17, 12, 9, 21, 14),
					box(10, 17, 12, 12, 21, 14), box(13, 17, 12, 15, 21, 14));
			case WEST -> Shapes.or(box(0, 3, 0, 16, 32, 2), box(0, 31, 2, 16, 32, 14), box(0, 3, 14, 16, 32, 16), box(0, 3, 2, 1, 29, 14), box(0, 0, 0, 16, 3, 16), box(0, 29, 2, 16, 32, 14), box(15, 10, 2, 16, 29, 14), box(1, 22, 2, 13, 23, 14),
					box(1, 10, 2, 13, 11, 14), box(1, 16, 2, 13, 17, 14), box(1, 26, 2, 13, 29, 14), box(15, 3, 2, 16, 7, 14), box(10, 11, 11, 12, 15, 13), box(7, 11, 11, 9, 15, 13), box(4, 11, 11, 6, 15, 13), box(1, 11, 11, 3, 15, 13),
					box(10, 17, 5, 12, 21, 7), box(7, 17, 5, 9, 21, 7), box(4, 17, 5, 6, 21, 7), box(1, 17, 5, 3, 21, 7), box(4, 17, 11, 6, 21, 13), box(1, 17, 11, 3, 21, 13), box(7, 17, 11, 9, 21, 13), box(10, 17, 11, 12, 21, 13),
					box(4, 17, 8, 6, 21, 10), box(1, 17, 8, 3, 21, 10), box(7, 17, 8, 9, 21, 10), box(10, 17, 8, 12, 21, 10), box(10, 11, 8, 12, 14, 10), box(10.5, 14, 8.5, 11.5, 15, 9.5), box(7, 11, 8, 9, 14, 10), box(7.5, 14, 8.5, 8.5, 15, 9.5),
					box(4, 11, 8, 6, 14, 10), box(4.5, 14, 8.5, 5.5, 15, 9.5), box(1, 11, 8, 3, 14, 10), box(1.5, 14, 8.5, 2.5, 15, 9.5), box(10, 11, 5, 12, 15, 7), box(10, 11, 2, 12, 15, 4), box(7, 11, 2, 9, 15, 4), box(7, 11, 5, 9, 15, 7),
					box(4, 11, 2, 6, 15, 4), box(4, 11, 5, 6, 15, 7), box(10, 17, 2, 12, 21, 4), box(7, 17, 2, 9, 21, 4), box(4, 17, 2, 6, 21, 4), box(1, 17, 2, 3, 21, 4), box(10, 17, 2, 12, 21, 4), box(7, 17, 2, 9, 21, 4), box(4, 17, 2, 6, 21, 4),
					box(1, 17, 2, 3, 21, 4));
		};
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
		BlockRenderLayerMap.INSTANCE.putBlock(SummercraftModBlocks.EXPEND_ROJA, RenderType.solid());
	}
}
