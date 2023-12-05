package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.util.EntityMethods;

import java.util.List;

public abstract class AbstractSlayEffect extends MobEffect {
    private int multiplier = 0;
    protected AbstractSlayEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (EntityMethods.isFlop(pLivingEntity) || pLivingEntity instanceof AbstractTwink) {
            pLivingEntity.heal(pAmplifier);
            if (EntityMethods.isFlop(pLivingEntity)) {
                this.multiplier = pAmplifier;
            }
        }
        if (EntityMethods.isMonster(pLivingEntity)) {
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(), pAmplifier);
            this.multiplier = -pAmplifier;
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public double getAttributeModifierValue(int pAmplifier, AttributeModifier pModifier) {
        return pModifier.getAmount() * multiplier;
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of();
    }
}
