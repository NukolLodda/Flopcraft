package net.nukollodda.flopcraft.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.nukollodda.flopcraft.util.EntityMethods;

public class YuhEffect extends AbstractSlayEffect {
    private double x;
    private double y;
    private double z;
    protected YuhEffect() {
        super(MobEffectCategory.HARMFUL, 8202617);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "489a445e-e349-4958-9ad0-3f1c752b198c", 0, AttributeModifier.Operation.MULTIPLY_TOTAL);
        if (EntityMethods.isMonster(pLivingEntity)) {
            addAttributeModifier(Attributes.ATTACK_DAMAGE, "cf3ee172-b543-4f0a-9136-25109b9ec057", -pAmplifier, AttributeModifier.Operation.ADDITION);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
