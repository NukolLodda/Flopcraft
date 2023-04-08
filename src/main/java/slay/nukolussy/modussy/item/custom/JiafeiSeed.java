package slay.nukolussy.modussy.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

import java.util.List;

public class JiafeiSeed extends BlockItem {

    public JiafeiSeed() {
        super(ModBlocks.GROWING_JIAFEI.get(), new Item.Properties().tab(ModCreativeTabs.CVMSUMABLES));
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
