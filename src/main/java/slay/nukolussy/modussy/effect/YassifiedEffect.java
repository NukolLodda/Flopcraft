package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

public class YassifiedEffect extends AbstractSlayEffect {
    protected YassifiedEffect() {
        super(MobEffectCategory.BENEFICIAL, 16218043);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            float multiplier = 0.2f;
            if (EntityMethods.isFlop(pLivingEntity)) {
                multiplier += 0.2f;
                if (pLivingEntity instanceof AbstractFlopFigures ||
                        (pLivingEntity instanceof Player player && PlayerMethods.isMagicFlop(player))) {
                    multiplier += 0.2f;
                }
            } else if (EntityMethods.isMonster(pLivingEntity)) {
                multiplier -= 0.4f;
                if (pLivingEntity instanceof Player player && PlayerMethods.isDaboyz(player)) {
                    multiplier -= 0.2f;
                }
            }
            float val = multiplier * (pAmplifier / 2f + 0.5f);
            float posVal = (multiplier + 0.5f) * (pAmplifier / 2f + 0.5f);
            double modifiedVal = Math.pow(Math.E, val - 1);
            // addAttributeModifier(Attributes.MOVEMENT_SPEED, "cc06449d-bd87-48c6-b1b7-72e227630fb0", multiplier, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.JUMP_STRENGTH, "258a2f70-c04e-43af-ae0c-daa8929d60ce", val, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "295edf3b-8090-44f1-bb19-2437307cc8de", val, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.MAX_HEALTH, "520d7b43-1497-43f7-b38b-f04e9caeeff7", Math.ceil(posVal * 10), AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.ATTACK_DAMAGE, "aad677b6-5262-414b-a487-182f5695becf", Math.ceil(modifiedVal * 10), AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.ATTACK_SPEED, "320803d7-9782-47b4-9bb0-f14ea3dd772b", Math.ceil(modifiedVal * 20), AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.ATTACK_KNOCKBACK, "6bebae1c-0836-45f6-a07c-99dafd02fd52", Math.ceil(modifiedVal * 5), AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.LUCK, "49909a69-702e-4588-8310-944229e47fde", val, AttributeModifier.Operation.ADDITION);
            pLivingEntity.setAbsorptionAmount(pLivingEntity.getAbsorptionAmount() * (val + multiplier));

            // temp code to avoid weirdness
            if (pLivingEntity.getMaxHealth() <= 0) {
                pLivingEntity.remove(Entity.RemovalReason.DISCARDED);
            }
        }
        // must cause a new glorified face upon activation
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
