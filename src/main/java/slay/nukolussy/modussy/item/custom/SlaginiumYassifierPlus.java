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
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.procedures.SlaginiumYassifierRightclicked;

public class SlaginiumYassifierPlus extends Item{
    public SlaginiumYassifierPlus() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(69420).fireResistant().rarity(Rarity.UNCOMMON));
    }


        @Override
        public float getDestroySpeed(@NotNull ItemStack itemStack, BlockState blockState) {
            blockState.getBlock();
            return 1;
        }

        @Override
        public boolean mineBlock(ItemStack itemstack, @NotNull Level world, @NotNull BlockState blockstate, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
            itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            return true;
        }

        @Override
        public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
            itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            return true;
        }

        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(ModItem.SLAGINIUM.get()));
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
            InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
            SlaginiumYassifierRightclicked.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getMainHandItem(), 2);
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
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 12f, AttributeModifier.Operation.ADDITION));
                builder.put(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -1, AttributeModifier.Operation.ADDITION));
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
