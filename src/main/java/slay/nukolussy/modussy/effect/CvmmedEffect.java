package slay.nukolussy.modussy.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;

import java.util.List;

public class CvmmedEffect extends MobEffect {
    protected CvmmedEffect() {
        super(MobEffectCategory.NEUTRAL, 13750737);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            if (pLivingEntity instanceof Player player) {
                player.heal(pAmplifier);
            }
            if (pLivingEntity instanceof AbstractTwink twink) {
                twink.heal(pAmplifier * 2);
            }
            if (pLivingEntity instanceof CupcakKe cupcakKe) {
                if (cupcakKe.getHealth() == cupcakKe.getMaxHealth()) {
                    CupcakKe.cupcakkeDuplication(ModItems.CVM.get(), cupcakKe);
                } else {
                    cupcakKe.heal(pAmplifier);
                }
            }
            if (EntityMethods.isMonster(pLivingEntity)) {
                pLivingEntity.hurt(pLivingEntity.damageSources().magic(), pAmplifier);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of(ModItems.POSEI.get().getDefaultInstance());
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
