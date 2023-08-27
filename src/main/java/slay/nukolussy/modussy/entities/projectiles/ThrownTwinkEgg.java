package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.twink.Twink;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

public class ThrownTwinkEgg extends AbstractArrow implements ItemSupplier {
    public ThrownTwinkEgg(EntityType<ThrownTwinkEgg> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownTwinkEgg(double pX, double pY, double pZ, Level pLevel) {
        super(ModEntities.TWINK_EGG.get(), pX, pY, pZ, pLevel);
    }
    public ThrownTwinkEgg(LivingEntity pShooter, Level pLevel) {
        super(ModEntities.TWINK_EGG.get(), pShooter, pLevel);
    }

    public ThrownTwinkEgg(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.TWINK_EGG.get(), world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        if (!this.level().isClientSide()) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; j++) {
                    Twink twink = ModEntities.TWINK.get().create(this.level());
                    if (twink != null) {
                        twink.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0f);
                        this.level().addFreshEntity(twink);
                    }
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living) {
            if (EntityMethods.isFlop(living)) {
                if (this.getOwner() instanceof Player player) {
                    PlayerMethods.addPlayerYassification(player, 1);
                }
                EntityMethods.flopEffects(living);
                this.discard();
            } else if (EntityMethods.isMonster(living)) {
                if (this.getOwner() instanceof Player player) {
                    PlayerMethods.addPlayerYassification(player, 1);
                }
                EntityMethods.monsterEffects(living);
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.CVM.get());
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.TWINK_EGG.get());
    }
}
