package net.nukollodda.flopcraft.item.types;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.util.PlayerMethods;

import java.util.Random;

public class ClitmasPresent extends Item {
    public ClitmasPresent() {
        super(new Properties().fireResistant());
    }

    private Item randomGiftItem() {
        int val = new Random().nextInt(22);
        return switch (val) {
            case 1 -> FlopItems.INFUSED_SLAGINIUM.get();
            case 2 -> FlopItems.FLOPIUM.get();
            case 3 -> FlopItems.ROSETOY.get();
            case 4 -> FlopItems.LANCVM_CREAM.get();
            case 5 -> FlopItems.KYLIE_JENNER_LIPSTICK.get();
            case 6 -> FlopItems.JIAFEI_PERFUME.get();
            case 7 -> FlopItems.JIAFEI_BOOTS.get();
            case 8 -> FlopItems.JIAFEI_LEGGINGS.get();
            case 9 -> FlopItems.JIAFEI_CHESTPLATE.get();
            case 10 -> FlopItems.JIAFEI_HELMET.get();
            case 11 -> FlopItems.JIAFEI_PRODUCT.get();
            case 12 -> FlopItems.CLITMAS_BUTTPLUG.get();
            case 13 -> FlopItems.JIAFEI_UPGRADE_TEMPLATE.get();
            case 14 -> FlopItems.CUPCAKE.get();
            case 15 -> FlopItems.ARANA_GRANDE.get();
            case 16 -> FlopItems.WONYOUNG_ESSENCE.get();
            case 17 -> FlopItems.POSEI.get();
            case 18 -> FlopItems.HAIRUSSY.get();
            case 19 -> FlopItems.DEELDO.get();
            case 20 -> FlopItems.ENDER_DRAGON_DEELDO.get();
            case 21 -> FlopItems.CVM_PIE.get();
            default -> FlopItems.SLAGINIUM.get();
        };
    }

    private Item randomDaboyzItem() {
        int val = new Random().nextInt(8);
        return switch (val) {
            case 1 -> Items.COAL;
            case 2 -> Items.DIRT;
            case 3 -> Items.ROTTEN_FLESH;
            case 4 -> Items.POISONOUS_POTATO;
            case 5 -> Items.LEATHER_BOOTS;
            case 6 -> Items.LEATHER_HELMET;
            default -> Items.CHARCOAL;
        };
    }

    private Item randomItem() {
        int val = new Random().nextInt(5);
        return switch (val) {
            case 1 -> FlopItems.JIAFEI_PRODUCT.get();
            case 2 -> FlopItems.CUPCAKE.get();
            case 3 -> FlopItems.ARANA_GRANDE.get();
            case 4 -> FlopItems.POSEI.get();
            default -> FlopItems.SLAGINIUM.get();
        };
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (PlayerMethods.isFlop(pPlayer)) {
            pPlayer.addItem(new ItemStack(randomGiftItem()));
            if (PlayerMethods.isMagicFlop(pPlayer)) {
                pPlayer.addItem(new ItemStack(FlopItems.SLAGINIUM.get()));
            }
            if (PlayerMethods.isFlopIcon(pPlayer)) {
                pPlayer.addItem(new ItemStack(FlopItems.FLOPIUM.get()));
            }
        } else if (PlayerMethods.isNewgen(pPlayer)) {
            pPlayer.addItem(new ItemStack(randomDaboyzItem()));
            if (PlayerMethods.isDaboyz(pPlayer)) {
                pPlayer.addItem(new ItemStack(randomDaboyzItem()));
                pPlayer.sendSystemMessage(Component.translatable("subtitle.fuck_you"));
            }
        } else {
            pPlayer.addItem(new ItemStack(randomItem()));
        }
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        item.setCount(item.getCount() - 1);
        pPlayer.setItemInHand(pUsedHand, item);
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
