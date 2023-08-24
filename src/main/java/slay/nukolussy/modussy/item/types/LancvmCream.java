package slay.nukolussy.modussy.item.types;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;

public class LancvmCream extends Item implements Vanishable {
    public LancvmCream() {
        super(new Item.Properties().durability(20));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ToolMethods.makeupUse(entity, entity.getMainHandItem(), 2);
        if (entity.getMainHandItem().getDamageValue() >= entity.getMainHandItem().getMaxDamage()) {
            entity.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
        }
        return ar;
    }
    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
