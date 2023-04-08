package slay.nukolussy.modussy.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.item.ModItem;

public class SlayAttack {
    public static void execute(Entity source, Entity target, int lvl) {
        int amp = (lvl + 1) / 2;

        if (target instanceof Monster) {
            ((Monster) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
            ((Monster) target).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
            if (lvl == 1) ((Monster) target).addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
            else {
                ((Monster) target).addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                ((Monster) target).addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                if (target instanceof Spider) {
                    (target).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.ARANA_GRANDE.get()));
                    ((Spider) target).setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    (target).kill();
                }
                if (lvl > 2) ((Monster) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
            }

        }
    }
}
