package slay.nukolussy.modussy.item.types;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.Random;

public class ClitmasPresent extends Item {
    public ClitmasPresent() {
        super(new Properties().fireResistant());
    }

    private Item randomGiftItem() {
        int val = new Random().nextInt(20);
        return switch (val) {
            case 1 -> ModItems.INFUSED_SLAGINIUM.get();
            case 2 -> ModItems.FLOPIUM.get();
            case 3 -> ModItems.ROSETOY.get();
            case 4 -> ModItems.LANCVM_CREAM.get();
            case 5 -> ModItems.KYLIE_JENNER_LIPSTICK.get();
            case 6 -> ModItems.JIAFEI_PERFUME.get();
            case 7 -> ModItems.JIAFEI_BOOTS.get();
            case 8 -> ModItems.JIAFEI_LEGGINGS.get();
            case 9 -> ModItems.JIAFEI_CHESTPLATE.get();
            case 10 -> ModItems.JIAFEI_HELMET.get();
            case 11 -> ModItems.JIAFEI_PRODUCT.get();
            case 12 -> ModItems.CLITMAS_BUTTPLUG.get();
            case 13 -> ModItems.JIAFEI_UPGRADE_TEMPLATE.get();
            case 14 -> ModItems.CUPCAKE.get();
            case 15 -> ModItems.ARANA_GRANDE.get();
            case 16 -> ModItems.WONYOUNG_ESSENCE.get();
            case 17 -> ModItems.POSEI.get();
            case 18 -> ModItems.HAIRUSSY.get();
            case 19 -> ModItems.DISC_DEJE_BULLYING.get();
            default -> ModItems.SLAGINIUM.get();
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
            case 1 -> ModItems.JIAFEI_PRODUCT.get();
            case 2 -> ModItems.CUPCAKE.get();
            case 3 -> ModItems.ARANA_GRANDE.get();
            case 4 -> ModItems.POSEI.get();
            default -> ModItems.SLAGINIUM.get();
        };
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (PlayerMethods.isFlop(pPlayer)) {
            pPlayer.addItem(new ItemStack(randomGiftItem()));
            if (PlayerMethods.isMagicFlop(pPlayer)) {
                pPlayer.addItem(new ItemStack(ModItems.SLAGINIUM.get()));
            }
            if (PlayerMethods.isFlopIcon(pPlayer)) {
                pPlayer.addItem(new ItemStack(ModItems.FLOPIUM.get()));
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
