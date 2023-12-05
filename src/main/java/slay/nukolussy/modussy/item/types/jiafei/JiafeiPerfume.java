package slay.nukolussy.modussy.item.types.jiafei;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;

public class JiafeiPerfume extends Item implements Vanishable, IJiafeiProducts {
    public JiafeiPerfume() {
        super(new Item.Properties().durability(20));
    }

    public ItemStack hasCraftRemainderItem(ItemStack itemstack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }

    public @NotNull ItemStack finishUsingItem(ItemStack item, Level lvl, LivingEntity entity) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ToolMethods.jiafeiPerfumeSpray(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getMainHandItem());
        if (entity.getMainHandItem().getDamageValue() >= entity.getMainHandItem().getMaxDamage()) {
            entity.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE));
        }
        return ar;
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    @Override
    public String getEnding() {
        return "这种香水能够让你摆脱难闻的汗味并治愈你。";
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }
}
