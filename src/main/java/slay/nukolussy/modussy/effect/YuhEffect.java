package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import slay.nukolussy.modussy.sound.ModSounds;

public class YuhEffect extends AbstractSlayEffect {
    private double x;
    private double y;
    private double z;
    protected YuhEffect() {
        super(MobEffectCategory.HARMFUL, 8202617);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            if (this.x == 0) {
                this.x = pLivingEntity.getX();
            }
            if (this.y == 0) {
                this.y = pLivingEntity.getY();
            }
            if (this.z == 0) {
                this.z = pLivingEntity.getZ();
            }
            if (pLivingEntity.tickCount % 200 == 0) {
                pLivingEntity.playSound(ModSounds.YUH.get());
            }
            pLivingEntity.teleportTo(this.x, this.y, this.z);
            pLivingEntity.setDeltaMovement(0, 0, 0);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
