package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

public class ShotTampon extends AbstractArrow implements ItemSupplier {
    public ShotTampon(EntityType<? extends ShotTampon> pEntity, Level pLevel) {
        super(pEntity, pLevel);
    }
    public ShotTampon(EntityType<? extends ShotTampon> pEntity, double pX, double pY, double pZ, Level pLevel) {
        super(pEntity, pX, pY, pZ, pLevel);
    }
    public ShotTampon(EntityType<? extends ShotTampon> pEntity, LivingEntity pShooter, Level pLevel) {
        super(pEntity, pShooter, pLevel);
    }

    public ShotTampon(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.TAMPONS.get(), world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.TAMPON.get());
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living && EntityMethods.isFlop(living)) {
            living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 1, false, true, true));
            living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 500, 0, false, true, true));
            if (this.getOwner() instanceof Player player) {
                PlayerMethods.addPlayerYassification(player, 2);
            }
            this.remove(RemovalReason.DISCARDED);
        } else {
            super.onHitEntity(pResult);
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.TAMPON.get());
    }

    @Override
    public boolean isCritArrow() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
    }
}
