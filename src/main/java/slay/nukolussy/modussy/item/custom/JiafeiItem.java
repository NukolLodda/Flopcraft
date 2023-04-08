package slay.nukolussy.modussy.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

import java.util.List;

public class JiafeiItem extends ArmorItem {
    public JiafeiItem(EquipmentSlot slot, Item.Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
                return new int[]{13, 15, 16, 11}[equipmentSlot.getIndex()] * 69;
            }

            @Override
            public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
                return new int[]{5, 13, 18, 5}[equipmentSlot.getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 9;
            }

            @Override
            public SoundEvent getEquipSound() {
                return ModSounds.JIAFEI_ARMOR.get();
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(ModItem.JIAFEI_PRODUCT.get());
            }

            @Override
            public String getName() {
                return "jiafei";
            }

            @Override
            public float getToughness() {
                return 4.5f;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.5f;
            }
        }, slot, properties);
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }

    public static class Helmet extends JiafeiItem {
        public Helmet() {
            super(EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity ent, EquipmentSlot slot, String type) {
            return "modussy:textures/models/armor/jiafei_layer1.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player ent) {
            ent.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 15, 0,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5, 0,true, false));
        }
    }

    public static class Chestplate extends JiafeiItem {
        public Chestplate() {
            super(EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity ent, EquipmentSlot slot, String type) {
            return "modussy:textures/models/armor/jiafei_layer1.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player ent) {
            ent.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 1,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 1,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 1,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 5, 1,true, false));
        }
    }

    public static class Leggings extends JiafeiItem {
        public Leggings() {
            super(EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity ent, EquipmentSlot slot, String type) {
            return "modussy:textures/models/armor/jiafei_layer2.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player ent) {
            ent.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 1,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.LUCK, 5, 1,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5, 0,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 0,true, false));
        }
    }

    public static class Boots extends JiafeiItem {
        public Boots() {
            super(EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity ent, EquipmentSlot slot, String type) {
            return "modussy:textures/models/armor/jiafei_layer1.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player ent) {
            ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 0,true, false));
            ent.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 5, 0,true, false));
        }
    }
}
