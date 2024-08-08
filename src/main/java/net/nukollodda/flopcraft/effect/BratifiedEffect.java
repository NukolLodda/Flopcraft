package net.nukollodda.flopcraft.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.nukollodda.flopcraft.item.FlopItems;

import java.util.Random;

public class BratifiedEffect extends AbstractSlayEffect {
    protected BratifiedEffect() {
        super(MobEffectCategory.NEUTRAL, 9030660);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Player player) {
            Random random = new Random();
            if (random.nextInt(100 - (pAmplifier / 4)) == 0) {
                player.spawnAtLocation(FlopItems.BRAT.get());
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
