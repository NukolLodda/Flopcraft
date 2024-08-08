package net.nukollodda.flopcraft.block.entity.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.block.entity.ent.CvmInfusionAlterEntity;
import net.nukollodda.flopcraft.block.entity.ent.MariahCareyIceBlockEntity;
import net.nukollodda.flopcraft.block.entity.ent.FlopBlockEntities;

public class MariahCareyIceBlock extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16,16);
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty IS_TOP = BooleanProperty.create("istop");

    public MariahCareyIceBlock() {
        super(Properties.ofFullCopy(Blocks.ICE).friction(0.98f));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, IS_TOP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level lvl = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState values = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        return values.setValue(IS_TOP, !lvl.getBlockState(pos.above()).isAir());

    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        if ((state.getValue(IS_TOP) && neighbor.below().equals(pos)) ||
                (!state.getValue(IS_TOP) && neighbor.above().equals(pos))) {
            ((Level)level).destroyBlock(neighbor, false);
        }
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (pState.getValue(IS_TOP) && pLevel.getBlockState(pPos.below()).hasProperty(IS_TOP)) {
            if (!pLevel.getBlockState(pPos.below()).getValue(IS_TOP)) {
                pLevel.destroyBlock(pPos.below(), false);
            }
        } else if (!pState.getValue(IS_TOP) && pLevel.getBlockState(pPos.above()).hasProperty(IS_TOP)) {
            if (pLevel.getBlockState(pPos.above()).getValue(IS_TOP)) {
                pLevel.destroyBlock(pPos.above(), false);
            }
        }
        super.destroy(pLevel, pPos, pState);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (place(pState, pLevel, pPos)) {
            super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        }
    }

    public boolean place(BlockState pState, Level pLevel, BlockPos pPos) {
        if (!pState.getValue(IS_TOP)) {
            BlockState state = pLevel.getBlockState(pPos.above());
            if (state.isAir()) {
                pLevel.setBlock(pPos.above(),
                        FlopBlocks.MARIAH_CAREY_ICE_BLOCK.get().defaultBlockState()
                                .setValue(FACING, pState.getValue(FACING)).setValue(IS_TOP, true), 3);
                return true;
            }
        } else {
            BlockState state = pLevel.getBlockState(pPos.below());
            if (state.isAir()) {
                pLevel.setBlock(pPos.below(),
                        ModBlocks.MARIAH_CAREY_ICE_BLOCK.get().defaultBlockState()
                                .setValue(FACING, pState.getValue(FACING)).setValue(IS_TOP, false), 3);
                return true;
            }
        }
        return false;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MariahCareyIceBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level lvl, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.MARIAH_CAREY_ICE_BLOCK.get(),
                MariahCareyIceBlockEntity::tick);
    }
}
