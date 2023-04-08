package slay.nukolussy.modussy.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.procedures.SlaginiumYassifierRightclicked;
import slay.nukolussy.modussy.procedures.SlayAttack;
import slay.nukolussy.modussy.procedures.SlayBreak;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

public class SlaginiumYassifier extends TieredItem {
    private final int lvl;
    public SlaginiumYassifier(Tier tier,int dura, int lvl, Rarity rarity) {
        super(tier, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).durability(dura).fireResistant().rarity(rarity));
        this.lvl = lvl;
    }


    @Override
    public float getDestroySpeed(@NotNull ItemStack itemStack, BlockState blockState) {
        blockState.getBlock();
        return 1;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(stack, world, state, pos, entity);
        SlayBreak.execute(world, pos.getX(), pos.getY(), pos.getZ(), state, pos, entity);
        return retval;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        SlayAttack.execute(itemStack, sourceentity, entity, this.lvl);
        return true;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(ModItem.SLAGINIUM.get()));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        SlaginiumYassifierRightclicked.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getMainHandItem(), lvl);
        return ar;
    }

    @Override
    public int getEnchantmentValue() {
        return 2;
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
            builder.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 3f * Math.pow(2, lvl), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.0f / lvl, AttributeModifier.Operation.ADDITION));
            return builder.build();

        }
        return super.getDefaultAttributeModifiers(equipmentSlot);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack itemstack) {
        return false;
    }
}
