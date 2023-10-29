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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;

import java.util.List;

public class ChargedLovelyPeach extends AbstractHurtingProjectile implements ItemSupplier {
    public ChargedLovelyPeach(EntityType<ChargedLovelyPeach> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ChargedLovelyPeach(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(ModEntities.LOVELY_PEACH.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
    }

    public ChargedLovelyPeach(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.LOVELY_PEACH.get(), world);
    }

    public static void init() {
    }

    private void explode() {
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3f, true, Level.ExplosionInteraction.BLOCK);
            this.discard();
            AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            cloud.setRadius(2.5F);
            cloud.setRadiusOnUse(-0.5F);
            cloud.setWaitTime(10);
            cloud.setDuration(cloud.getDuration() / 2);
            cloud.setRadiusPerTick(-cloud.getRadius() / (float) cloud.getDuration());

            this.level().addFreshEntity(cloud);

            {
                final Vec3 center = new Vec3(this.getX(), this.getY(), this.getZ());
                List<LivingEntity> entities = level().getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                        .inflate(2.5 / 2d), e -> true).stream().toList();
                for (LivingEntity entity : entities) {
                    if (EntityMethods.isMonster(entity)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1000, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, true, false, false));
                    } else if (EntityMethods.isFlop(entity)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1000, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0, true, false, false));
                    }
                }
            }
            if (this.random.nextInt(6) == 0) {
                this.spawnAtLocation(ModItems.LOVELY_PEACH.get());
            }
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void onHit(HitResult pResult) {
        this.explode();
        int chance = (int) (Math.random() * 12);
        if (chance == 1) {
            LovelyPeaches peaches = new LovelyPeaches(ModEntities.LOVELY_PEACHES.get(), this.level());
            peaches.moveTo(this.getX(), this.getY(), this.getZ());
            this.level().addFreshEntity(peaches);
        }
        super.onHit(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!EntityMethods.isFlop(pResult.getEntity())) {
            super.onHitEntity(pResult);
        } else {
            this.remove(RemovalReason.DISCARDED);
        }
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
