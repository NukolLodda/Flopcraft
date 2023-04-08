package slay.nukolussy.modussy.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.procedures.SlayAttack;
import slay.nukolussy.modussy.procedures.SlayBreak;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;
import slay.nukolussy.modussy.tiers.ModTiers;

import java.util.List;

public class JiafeiHammer extends TieredItem {
    public JiafeiHammer() {
        super(ModTiers.JIAFEI, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).durability(6900).fireResistant());
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        SlayAttack.execute(itemStack, sourceentity, entity, 2);
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(stack, world, state, pos, entity);
        SlayBreak.execute(world, pos.getX(), pos.getY(), pos.getZ(), state, pos, entity);
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
