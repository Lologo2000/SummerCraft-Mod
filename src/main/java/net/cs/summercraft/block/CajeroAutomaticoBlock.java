
package net.cs.summercraft.block;

import net.minecraft.sounds.SoundEvent;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.api.Environment;

public class CajeroAutomaticoBlock extends Block {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CajeroAutomaticoBlock() {
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
			default -> Shapes.or(box(1, 5, 3, 15, 6, 14), box(10, 13, 11, 14, 15, 11.5), box(10, 8, 11, 14, 10, 11.5), box(10, 6, 11, 13, 6.3, 13.5), box(2, 8, 11, 9, 15, 11.5), box(15, 2, 0, 16, 17, 16), box(0, 17, 0, 16, 18, 16),
					box(0, 2, 0, 1, 17, 16), box(0, 0, 0, 16, 3, 16), box(1, 2, 0, 15, 17, 10));
			case NORTH -> Shapes.or(box(1, 5, 2, 15, 6, 13), box(2, 13, 4.5, 6, 15, 5), box(2, 8, 4.5, 6, 10, 5), box(3, 6, 2.5, 6, 6.3, 5), box(7, 8, 4.5, 14, 15, 5), box(0, 2, 0, 1, 17, 16), box(0, 17, 0, 16, 18, 16), box(15, 2, 0, 16, 17, 16),
					box(0, 0, 0, 16, 3, 16), box(1, 2, 6, 15, 17, 16));
			case EAST -> Shapes.or(box(3, 5, 1, 14, 6, 15), box(11, 13, 2, 11.5, 15, 6), box(11, 8, 2, 11.5, 10, 6), box(11, 6, 3, 13.5, 6.3, 6), box(11, 8, 7, 11.5, 15, 14), box(0, 2, 0, 16, 17, 1), box(0, 17, 0, 16, 18, 16),
					box(0, 2, 15, 16, 17, 16), box(0, 0, 0, 16, 3, 16), box(0, 2, 1, 10, 17, 15));
			case WEST -> Shapes.or(box(2, 5, 1, 13, 6, 15), box(4.5, 13, 10, 5, 15, 14), box(4.5, 8, 10, 5, 10, 14), box(2.5, 6, 10, 5, 6.3, 13), box(4.5, 8, 2, 5, 15, 9), box(0, 2, 15, 16, 17, 16), box(0, 17, 0, 16, 18, 16), box(0, 2, 0, 16, 17, 1),
					box(0, 0, 0, 16, 3, 16), box(6, 2, 1, 16, 17, 15));
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
		BlockRenderLayerMap.INSTANCE.putBlock(SummercraftModBlocks.CAJERO_AUTOMATICO, RenderType.solid());
	}
}