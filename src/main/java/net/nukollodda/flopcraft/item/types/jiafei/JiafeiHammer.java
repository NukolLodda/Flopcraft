package net.nukollodda.flopcraft.item.types.jiafei;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import net.nukollodda.flopcraft.util.ToolMethods;
import net.nukollodda.flopcraft.item.tiers.FlopTiers;

import java.util.List;

public class JiafeiHammer extends PickaxeItem implements IJiafeiProducts{
    public JiafeiHammer() {
        super(FlopTiers.JIAFEI, 2, -5f, new Properties().fireResistant());
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    @Override
    public String getEnding() {
        return "嘉菲的性感锤是从雅致的白宫到第一个嘉菲公司总部打造Floptropica的精美工具。";
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 2);
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(stack, world, state, pos, entity);
        ToolMethods.slayBreak(world, state, pos, entity);
        if (state.getBlock().equals(Blocks.CACTUS)) {
            state.spawnAfterBreak((ServerLevel) world, pos, new ItemStack(Items.GREEN_DYE), false);
        }
        return retval;
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
