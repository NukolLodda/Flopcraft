package slay.nukolussy.modussy.item.types;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FloptropicaTicket extends Item {
    public FloptropicaTicket() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        int destination = pStack.getOrCreateTag().getInt("destination");
        Component dest = switch (destination) {
            case 1 -> Component.literal("CupcakKia").withStyle(ChatFormatting.DARK_PURPLE);
            case 2 -> Component.literal("Jiafeia").withStyle(ChatFormatting.DARK_RED);
            case 3 -> Component.literal("Potaxiana").withStyle(ChatFormatting.GREEN);
            case 4 -> Component.literal("CVM").withStyle(ChatFormatting.WHITE);
            case 5 -> Component.literal("New Barbados").withStyle(ChatFormatting.LIGHT_PURPLE);
            default -> Component.translatable("subtitle.invalid").withStyle(ChatFormatting.RED);
        };
        pTooltipComponents.add(Component.translatable("subtitle.destination").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(dest);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    // will contain 5 possible nbt values
}
