package net.nukollodda.flopcraft.item.types;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.effect.FlopEffects;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSounds;

public class InnerWear extends ArmorItem {
    public InnerWear(Type pType) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type pType) {
                return 690;
            }

            @Override
            public int getDefenseForType(Type pType) {
                return 5;
            }

            @Override
            public int getEnchantmentValue() {
                return 12;
            }

            @Override
            public SoundEvent getEquipSound() {
                return FlopSounds.JIAFEI_ARMOR.get();
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(FlopItems.SLAGINIUM.get());
            }

            @Override
            public String getName() {
                return "bra";
            }

            @Override
            public float getToughness() {
                return 2.5f;
            }

            @Override
            public float getKnockbackResistance() {
                return 0;
            }
        }, pType, new Properties());
    }

    public static class Bra extends InnerWear {
        public Bra() {
            super(Type.CHESTPLATE);
        }

        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "flopcraft:textures/models/armor/inner_layer1.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level level, Player player) {
            player.addEffect(new MobEffectInstance(FlopEffects.YASSIFIED.get(), 5, 0,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 5, 0,true, false));
        }
    }
    public static class Thongs extends InnerWear {
        public Thongs() {
            super(Type.LEGGINGS);
        }

        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "flopcraft:textures/models/armor/inner_layer2.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level level, Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 2,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 5, 0,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 2,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 1,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 1,true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 2,true, false));
        }
    }
}
