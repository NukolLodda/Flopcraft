package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;

public class ShotExtraBloodyTampon extends ShotTampon {
    public ShotExtraBloodyTampon(EntityType<ShotExtraBloodyTampon> pEntity, Level pLevel) {
        super(pEntity, pLevel);
    }
    public ShotExtraBloodyTampon(double pX, double pY, double pZ, Level pLevel) {
        super(ModEntities.EXTRA_BLOODY_TAMPONS.get(), pX, pY, pZ, pLevel);
    }
    public ShotExtraBloodyTampon(LivingEntity pShooter, Level pLevel) {
        super(ModEntities.EXTRA_BLOODY_TAMPONS.get(), pShooter, pLevel);
    }
    public ShotExtraBloodyTampon(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.EXTRA_BLOODY_TAMPONS.get(), world);
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
        ModUtil.getEntityListOfDist(this.level(), LivingEntity.class, this.position(), 1.25)
                .forEach(entity -> EntityMethods.addEffects(entity, 3, 2));
        this.level().explode(null, this.getX(), this.getY(), this.getZ(), 3, Level.ExplosionInteraction.BLOCK);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.EXTRA_BLOODY_TAMPON.get());
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living) {
            EntityMethods.addEffects(living, 3, 2);
        }
        super.onHitEntity(pResult);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.discard();
    }
}
