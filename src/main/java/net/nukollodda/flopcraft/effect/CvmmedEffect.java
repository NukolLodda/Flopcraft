package net.nukollodda.flopcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.flopcraft.entities.flops.figures.CupcakKe;
import net.nukollodda.flopcraft.entities.twink.AbstractTwink;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.util.EntityMethods;
import net.nukollodda.flopcraft.util.PlayerMethods;

import java.util.List;

public class CvmmedEffect extends MobEffect {
    protected CvmmedEffect() {
        super(MobEffectCategory.NEUTRAL, 13750737);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            // attack damage and resistance should increase
            int mult = 0;
            if (pLivingEntity instanceof Player player && !PlayerMethods.isNewgen(player)) {
                player.heal(pAmplifier);
                player.getFoodData().eat(pAmplifier + 1, 1.0f);
                mult++;
            }
            if (pLivingEntity instanceof AbstractTwink twink) {
                twink.heal(pAmplifier * 2);
                addAttributeModifier(Attributes.ATTACK_DAMAGE, "0eae998f-1182-4b0e-bfca-0231d48db22d", pAmplifier * 3, AttributeModifier.Operation.ADDITION);
                addAttributeModifier(Attributes.MAX_HEALTH, "16fe1c99-7258-416d-8f68-79252ce8127b", pAmplifier * 3, AttributeModifier.Operation.ADDITION);
                addAttributeModifier(Attributes.LUCK, "8a380948-4c05-4a81-b905-cfa8b08d0bea", pAmplifier * 3, AttributeModifier.Operation.ADDITION);
                addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "219c7d49-938b-4e48-a1e6-4b8486a8f095", pAmplifier * 2, AttributeModifier.Operation.ADDITION);
                mult += 2;
            }
            if (pLivingEntity instanceof CupcakKe cupcakKe) {
                if (cupcakKe.getHealth() == cupcakKe.getMaxHealth() && cupcakKe.getRandom().nextInt(690) == 0) {
                    CupcakKe.cupcakkeDuplication(FlopItems.CVM.get(), cupcakKe);
                } else {
                    cupcakKe.heal(pAmplifier);
                }
            }
            if (EntityMethods.isMonster(pLivingEntity)) {
                pLivingEntity.hurt(pLivingEntity.damageSources().magic(), pAmplifier);
                mult--;
            }
            int val = (pAmplifier + 1) * mult;
            if (pLivingEntity instanceof Player player) {
                player.getFoodData().eat(val, val);
            }
            addAttributeModifier(Attributes.ARMOR, "597e1824-ccef-4134-8faf-37d8447833ce", val * 2, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.ATTACK_SPEED, "ccdf74c1-30c5-461b-8123-ca1a692e2f35", val, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.ATTACK_KNOCKBACK, "aa1ee75f-1b36-4a07-aeea-470f800db1c8", val, AttributeModifier.Operation.ADDITION);
            addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "e7743809-1f96-4426-a824-bc335ecf327c", mult, AttributeModifier.Operation.ADDITION);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of(FlopItems.POSEI.get().getDefaultInstance());
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
