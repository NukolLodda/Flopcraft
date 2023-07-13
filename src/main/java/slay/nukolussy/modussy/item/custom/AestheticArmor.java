package slay.nukolussy.modussy.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class AestheticArmor extends ArmorItem {
    public AestheticArmor(ArmorMaterial pMaterial, Type pType) {
        super(pMaterial, pType, new Item.Properties().fireResistant());
    }
    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String layer = "1";
        if (slot == EquipmentSlot.LEGS) layer = "2";
        return "tekora:textures/models/armor/" + this.material.getName() + "_layer" + layer + ".png";
    }
}
