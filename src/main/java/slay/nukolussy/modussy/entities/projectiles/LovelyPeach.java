package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;

public class LovelyPeach extends AbstractHurtingProjectile implements ItemSupplier {
    public LovelyPeach(EntityType<LovelyPeach> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LovelyPeach(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(ModEntities.LOVELY_PEACH.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
    }

    public LovelyPeach(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.LOVELY_PEACH.get(), world);
    }

    public static void init() {
    }

    private void explode() {
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3f, true, Level.ExplosionInteraction.BLOCK);
            this.discard();
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(2.5F);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(10);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1000, 0, true, false, false));
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 0, true, false, false));
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 0, true, false, false));
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 0, true, false, false));
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, true, false, false));

            this.level().addFreshEntity(areaeffectcloud);

        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void onHit(HitResult pResult) {
        this.explode();
        super.onHit(pResult);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.LOVELY_PEACH.get());
    }
}
