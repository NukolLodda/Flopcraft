package slay.nukolussy.modussy.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.entity.custom.Flops;
import slay.nukolussy.modussy.item.ModItem;

public class SlayAttack {
    public static void execute(ItemStack item, Entity source, Entity target, int lvl) {
        int amp = (lvl + 1) / 2, itemDura = 0;
        if (source instanceof Player || source instanceof Flops) {
            ((LivingEntity) source).heal(3.0f);
        }

        if (target instanceof Monster ||
                ((target instanceof Hoglin || target instanceof Ghast || target instanceof Shulker || target instanceof Phantom) && lvl > 1)) {
            if (lvl == 1) ((Mob) target).addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
            else {
                if (target instanceof Spider) {
                    target.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.ARANA_GRANDE.get()));
                    ((Spider) target).setGuaranteedDrop(EquipmentSlot.MAINHAND);
                }
                ((Mob) target).addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                ((Mob) target).addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                if (lvl > 2) ((Mob) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
            }
            ((Mob) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
            ((Mob) target).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
            itemDura += 120;
        }
        (item).setDamageValue(item.getDamageValue() + itemDura);
    }
}
