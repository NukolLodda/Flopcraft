package slay.nukolussy.modussy.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItem;

import java.util.Random;

public class FlopFigures extends Flops {
    public FlopFigures(EntityType type, Level world) {
        super(type, world);

        Random random = new Random();
        int toolChance = random.nextInt(1, 6971);
        if (toolChance <= 420) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.SLAGINIUM_YASSIFIER.get()));
        } else if (toolChance <= 500) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.SLAGINIUM_YASSIFIER_PLUS.get()));
        } else if (toolChance <= 569) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.SLAGINIUM_YASSIFIER_PREMIUM.get()));
        } else if (toolChance <= 571) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.SLAGINIUM_YASSIFIER_DELUXE.get()));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);

        return builder;

    }
}