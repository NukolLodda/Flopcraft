package slay.nukolussy.modussy.tiers;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

public enum ModArmorMaterials implements ArmorMaterial {
    JIAFEI("jiafei", ModSounds.JIAFEI_ARMOR.get(), 69, 1, 9, 4.5f, 0.5f,
            Ingredient.of(ModItem.JIAFEI_PRODUCT.get()));

    private final int durability;
    private final int defense;
    private final int enchant;
    private final SoundEvent equipSound;
    private final Ingredient repairIng;
    private final String name;
    private final float toughness;
    private final float knockbackRes;

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return new int[]{13, 15, 16, 11}[pType.ordinal()] * durability;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return new int[]{5, 13, 18, 5}[pType.ordinal()] * defense;
    }

    @Override
    public int getEnchantmentValue() {
        return enchant;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIng;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackRes;
    }

    ModArmorMaterials(String name, SoundEvent equipSound, int durability, int defense, int enchant,
                      float toughness, float knockback, Ingredient repairIng) {
        this.durability = durability;
        this.defense = defense;
        this.enchant = enchant;
        this.equipSound = equipSound;
        this.repairIng = repairIng;
        this.name = name;
        this.toughness = toughness;
        this.knockbackRes = knockback;
    }
}
