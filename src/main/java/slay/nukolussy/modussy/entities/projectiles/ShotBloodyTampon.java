package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.List;

public class ShotBloodyTampon extends ShotTampon {
    public ShotBloodyTampon(EntityType<ShotBloodyTampon> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public ShotBloodyTampon(double pX, double pY, double pZ, Level pLevel) {
        super(ModEntities.BLOODY_TAMPONS.get(), pX, pY, pZ, pLevel);
    }
    public ShotBloodyTampon(LivingEntity pShooter, Level pLevel) {
        super(ModEntities.BLOODY_TAMPONS.get(), pShooter, pLevel);
    }
    public ShotBloodyTampon(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.BLOODY_TAMPONS.get(), world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
        cloud.setRadius(2.5F);
        cloud.setRadiusOnUse(-0.5F);
        cloud.setWaitTime(10);
        cloud.setDuration(cloud.getDuration() / 2);
        cloud.setRadiusPerTick(-cloud.getRadius() / (float) cloud.getDuration());
        ModUtil.getEntityListOfDist(this.level(), LivingEntity.class, this.position(), 1.25).forEach(entity -> {
            if (EntityMethods.isMonster(entity)) {
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1000, 0, true, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, true, false, false));
            } else if (EntityMethods.isFlop(entity)) {
                entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0, true, false, false));
            }
            entity.addEffect(new MobEffectInstance(ModEffects.YASSIFIED.get(), 1000, 0, true, false, false));
        });
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.BLOODY_TAMPON.get());
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living) {
            if (EntityMethods.isFlop(living)) {
                living.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 500, 1, false, true, true));
                living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 500, 1, false, true, true));
                if (living instanceof Player player) {
                    PlayerMethods.addPlayerYassification(player, 1);
                }
            }

            if (EntityMethods.isMonster(living)) {
                living.addEffect(new MobEffectInstance(MobEffects.POISON, 500, 1, false, true, true));
            }
        }
        super.onHitEntity(pResult);
    }
}
