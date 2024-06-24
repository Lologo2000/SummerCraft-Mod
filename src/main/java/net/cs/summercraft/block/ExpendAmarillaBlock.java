
package net.cs.summercraft.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.cs.summercraft.init.SummercraftModBlocks;

import java.util.List;
import java.util.Collections;

public class ExpendAmarillaBlock extends Block {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);

	public ExpendAmarillaBlock() {
		super(PROPERTIES);
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
		return Shapes.or(box(14, 3, 0, 16, 32, 16), box(2, 31, 0, 14, 32, 16), box(0, 3, 0, 2, 32, 16), box(2, 3, 0, 14, 29, 1), box(0, 0, 0, 16, 3, 16), box(2, 29, 0, 14, 32, 16), box(2, 10, 15, 14, 29, 16), box(2, 22, 1, 14, 23, 13),
				box(2, 10, 1, 14, 11, 13), box(2, 16, 1, 14, 17, 13), box(2, 26, 1, 14, 29, 13), box(2, 3, 15, 14, 7, 16), box(3, 11, 10, 5, 15, 12), box(3, 11, 7, 5, 15, 9), box(3, 11, 4, 5, 15, 6), box(3, 11, 1, 5, 15, 3),
				box(9, 17, 10, 11, 21, 12), box(9, 17, 7, 11, 21, 9), box(9, 17, 4, 11, 21, 6), box(9, 17, 1, 11, 21, 3), box(3, 17, 4, 5, 21, 6), box(3, 17, 1, 5, 21, 3), box(3, 17, 7, 5, 21, 9), box(3, 17, 10, 5, 21, 12), box(6, 17, 4, 8, 21, 6),
				box(6, 17, 1, 8, 21, 3), box(6, 17, 7, 8, 21, 9), box(6, 17, 10, 8, 21, 12), box(6, 11, 10, 8, 14, 12), box(6.5, 14, 10.5, 7.5, 15, 11.5), box(6, 11, 7, 8, 14, 9), box(6.5, 14, 7.5, 7.5, 15, 8.5), box(6, 11, 4, 8, 14, 6),
				box(6.5, 14, 4.5, 7.5, 15, 5.5), box(6, 11, 1, 8, 14, 3), box(6.5, 14, 1.5, 7.5, 15, 2.5), box(9, 11, 10, 11, 15, 12), box(12, 11, 10, 14, 15, 12), box(12, 11, 7, 14, 15, 9), box(9, 11, 7, 11, 15, 9), box(12, 11, 4, 14, 15, 6),
				box(9, 11, 4, 11, 15, 6), box(12, 17, 10, 14, 21, 12), box(12, 17, 7, 14, 21, 9), box(12, 17, 4, 14, 21, 6), box(12, 17, 1, 14, 21, 3), box(12, 17, 10, 14, 21, 12), box(12, 17, 7, 14, 21, 9), box(12, 17, 4, 14, 21, 6),
				box(12, 17, 1, 14, 21, 3));
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
		BlockRenderLayerMap.INSTANCE.putBlock(SummercraftModBlocks.EXPEND_AMARILLA, RenderType.solid());
	}
}
