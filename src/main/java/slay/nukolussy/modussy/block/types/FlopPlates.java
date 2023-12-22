package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;

import java.time.Month;
import java.util.List;

public class FlopPlates extends PressurePlateBlock {
    public FlopPlates(Block pPlate, BlockSetType pType) {
        super(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(pPlate), pType);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof ItemEntity itemEntity && itemEntity.getItem().is(ModItems.CVM_FLUID_BUCKET.get())
                && ModUtil.isClitmas() && ModUtil.blocksAboveAreAir(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), 17)
                && EntityMethods.canCertainEntitySpawn(MariahCarey.class, pLevel, pPos.getCenter())) {
            boolean isCookie = false;
            List<ItemEntity> ents = ModUtil.getEntityListOfDist(pLevel, ItemEntity.class, pEntity.position(), 2);
            for (ItemEntity item : ents) {
                if (item.getItem().is(Items.COOKIE)) {
                    isCookie = true;
                    item.remove(Entity.RemovalReason.DISCARDED);
                    break;
                }
            }
            if (isCookie) {
                MariahCarey cvmrey = new MariahCarey(ModEntities.MARIAH_CAREY.get(), pLevel);
                cvmrey.setPos(pEntity.position().add(0, 12, 0));
                cvmrey.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 2, true, false, false));
                pLevel.addFreshEntity(cvmrey);
                pLevel.playSound(null, pPos, ModSounds.MARIAH_CAREY_DEFROSTING.get(), SoundSource.AMBIENT);
                pEntity.remove(Entity.RemovalReason.DISCARDED);
                for (int i = 0; i < 24; i++) {
                    cvmrey.spawnAtLocation(ModItems.CLITMAS_PRESENT.get());
                }
                this.destroy(pLevel, pPos, pState);
            }
        }
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        this.stepOn(pLevel, pPos, pState, pEntity);
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
