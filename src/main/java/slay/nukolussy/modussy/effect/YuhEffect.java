package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;

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
            if (EntityMethods.isMonster(pLivingEntity)) {
                addAttributeModifier(Attributes.MAX_HEALTH, "86784413-2a5f-4d2a-a0e4-5969885e8d07", -pAmplifier, AttributeModifier.Operation.ADDITION);
                addAttributeModifier(Attributes.ATTACK_DAMAGE, "cf3ee172-b543-4f0a-9136-25109b9ec057", -pAmplifier, AttributeModifier.Operation.ADDITION);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
