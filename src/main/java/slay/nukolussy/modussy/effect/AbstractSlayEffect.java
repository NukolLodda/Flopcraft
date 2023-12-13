package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.List;

public abstract class AbstractSlayEffect extends MobEffect {
    protected AbstractSlayEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            int mult = 1;
            if (EntityMethods.isFlop(pLivingEntity) || pLivingEntity instanceof AbstractTwink) {
                pLivingEntity.heal(pAmplifier + 1);
                mult++;
                if (pLivingEntity instanceof AbstractFlopFigures || (pLivingEntity instanceof Player player && PlayerMethods.isMagicFlop(player))) {
                    mult++;
                }
            }
            if (EntityMethods.isMonster(pLivingEntity)) {
                pLivingEntity.hurt(pLivingEntity.damageSources().magic(), pAmplifier + 1);
                mult -= 2;
                if (pLivingEntity instanceof Player player && PlayerMethods.isDaboyz(player)) {
                    mult--;
                }
            }
            int val = (pAmplifier + 1) * mult;
            if (pLivingEntity instanceof Player player) {
                player.getFoodData().eat(val, val);
            }
            addAttributeModifier(Attributes.ARMOR, "06e11f99-137e-41b4-832a-7a6ca950048c", val, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "33ae0058-f3db-401c-b45d-5cbe7c21281c", val, AttributeModifier.Operation.ADDITION);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of();
    }
}
