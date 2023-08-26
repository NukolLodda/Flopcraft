package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.util.EntityMethods;

import java.util.List;

public class LovelyPeachesBossBlocks extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final Type type;

    public LovelyPeachesBossBlocks(Type type) {
        super(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).noLootTable());
        this.type = type;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    /*for the block entity stuff*/
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
        // ensures the block is visible
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        {
            final Vec3 center = new Vec3(pPos.getX(), pPos.getY(), pPos.getZ());
            List<LivingEntity> _entfound = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(2 / 2d), e -> true).stream().toList();
            for (LivingEntity entity : _entfound) {
                if (!EntityMethods.isMonster(entity)) {
                    if (this.type == Type.EFFECT_REMOVE) {
                        entity.removeAllEffects();
                    }
                    for (MobEffectInstance instance : type.getEffects()) {
                        entity.addEffect(instance);
                    }
                }
            }
        }
        super.destroy(pLevel, pPos, pState);
    }

    public enum Type {
        HEALTH(List.of(new MobEffectInstance(MobEffects.REGENERATION, 250, 0, true, false, false),
                new MobEffectInstance(MobEffects.ABSORPTION, 500, 1, true, false, false))),
        STRENGTH(List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 250, 0, true, false, false),
                new MobEffectInstance(MobEffects.SATURATION, 500, 1, true, false, false))),
        EFFECT_REMOVE(List.of());

        List<MobEffectInstance> effects;
        Type(List<MobEffectInstance> effects) {
            this.effects = effects;
        }

        public List<MobEffectInstance> getEffects() {
            return effects;
        }
    }
}
