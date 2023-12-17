package slay.nukolussy.modussy.item.types.jiafei;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.util.ToolMethods;
import slay.nukolussy.modussy.item.tiers.ModTiers;

import java.util.List;

public class JiafeiPickaxe extends PickaxeItem implements IJiafeiProducts {
    public JiafeiPickaxe() {
        super(ModTiers.JIAFEI, 1, -2.8f, new Properties().fireResistant());
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    @Override
    public String getEnding() {
        return "嘉菲的性感镐是挖掘和砍掉石头的强大工具。用于建造Floptropica的矿物是通过嘉菲的镐收集的。";
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 2);
        return true;
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
}
