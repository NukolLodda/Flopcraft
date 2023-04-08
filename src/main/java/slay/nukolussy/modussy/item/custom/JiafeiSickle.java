package slay.nukolussy.modussy.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.procedures.SlayAttack;
import slay.nukolussy.modussy.procedures.SlayBreak;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;
import slay.nukolussy.modussy.tiers.ModTiers;

import java.util.List;

public class JiafeiSickle extends HoeItem {
    public JiafeiSickle() {
        super(ModTiers.JIAFEI, 3, -2.0f, new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant());
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
