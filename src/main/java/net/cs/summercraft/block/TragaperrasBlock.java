
package net.cs.summercraft.block;

import net.minecraft.sounds.SoundEvent;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.api.Environment;

public class TragaperrasBlock extends Block {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);

	public TragaperrasBlock() {
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
		Vec3 offset = state.getOffset(world, pos);
		return Shapes.or(box(0, 0, 0, 16, 1, 7), box(0, 0, 7, 16, 32, 16), box(0, 13, 5, 16, 14, 7), box(0, 14, 4, 16, 15, 7), box(13.5, 15, 4.75, 15, 15.25, 6), box(11.5, 15, 4.75, 13, 15.25, 6), box(7.5, 15, 4.75, 9, 15.25, 6),
				box(9.5, 15, 4.75, 11, 15.25, 6), box(3.5, 15, 4.75, 5, 15.25, 6), box(0.5, 15, 4.5, 3, 15.25, 6.5), box(5.5, 15, 4.75, 7, 15.25, 6)).move(offset.x, offset.y, offset.z);
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