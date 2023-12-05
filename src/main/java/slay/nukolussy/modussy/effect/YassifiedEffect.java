package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slay.nukolussy.modussy.util.PlayerMethods;

public class YassifiedEffect extends AbstractSlayEffect {
    protected YassifiedEffect() {
        super(MobEffectCategory.BENEFICIAL, 16218043);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            if (pLivingEntity instanceof Player player) {
                PlayerMethods.addPlayerYassification(player, pAmplifier);
            }
        }
        pLivingEntity.armor
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
