package slay.nukolussy.modussy.item.types.jiafei;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.block.ModBlocks;

import java.util.List;

public class JiafeiSeed extends BlockItem {

    public JiafeiSeed() {
        super(ModBlocks.GROWING_JIAFEI.get(), new Item.Properties());
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent getDisplayName() {
        return Component.literal("宇宙中最性感的种子，嘉菲种子让你种出自己的嘉菲，让你获得源源不断的性感商品。");
    }
}
