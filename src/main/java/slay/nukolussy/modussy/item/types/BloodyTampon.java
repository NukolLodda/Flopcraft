package slay.nukolussy.modussy.item.types;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import slay.nukolussy.modussy.item.ModItems;

public class BloodyTampon extends ArrowItem {
    public BloodyTampon() {
        super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        Arrow arrow = new Arrow(pLevel, pShooter) {
            @Override
            protected ItemStack getPickupItem() {
                return new ItemStack(ModItems.TAMPON.get());
            }
        };
        arrow.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6900, 0, true, false));
        arrow.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6900, 1, true, false));
        arrow.addEffect(new MobEffectInstance(MobEffects.HUNGER, 6900, 0, true, false));
        arrow.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 6900, 1, true, false));
        arrow.addEffect(new MobEffectInstance(MobEffects.HARM, 6900, 0, true, false));
        return arrow;
    }
}
