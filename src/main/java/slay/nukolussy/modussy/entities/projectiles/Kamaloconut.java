package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;

public class Kamaloconut extends AbstractHurtingProjectile implements ItemSupplier {
    public Kamaloconut(EntityType<Kamaloconut> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Kamaloconut(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(ModEntities.KAMALOCONUT.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
    }

    public Kamaloconut(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.KAMALOCONUT.get(), world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(ModEffects.CVMMED.get(), 600));
            living.hurt(living.damageSources().generic(), 8);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.discard();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.KAMALOCONUT.get());
    }
}
