package slay.nukolussy.modussy.item.tiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import slay.nukolussy.modussy.item.ModItems;

import java.util.function.Supplier;

public enum ModTiers implements Tier {
    SLAGINIUM(3, 1069, 9.8f, 3.0f, 12,
            () -> Ingredient.of(ModItems.SLAGINIUM.get())),
    INFUSED_SLAGINIUM(4, 2471, 10.1f, 4.0f, 18,
            () -> Ingredient.of(ModItems.INFUSED_SLAGINIUM.get())),
    FLOPIUM(5, 3069, 11.5f, 5.0f, 22,
            () -> Ingredient.of(ModItems.FLOPIUM.get())
    ),
    MYSTICAL_FLOPIUM(6, 6971, 14f, 6.0f, 27,
            () -> Ingredient.of(ModItems.MYSTICAL_FLOPIUM.get())
    ),
    JIAFEI(6, 6900, 12.75f, 5.5f, 24,
            () -> Ingredient.of(ModItems.JIAFEI_PRODUCT.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;

    private final int enchantmentValue;
    private final Ingredient repairIngredient;


    ModTiers(int lvl, int dura, float speed, float dmg, int enchantval, Supplier<Ingredient> ingredient) {
        this.level = lvl;
        this.uses = dura;
        this.speed = speed;
        this.damage = dmg;
        this.enchantmentValue = enchantval;
        this.repairIngredient = ingredient.get();
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
