package slay.nukolussy.modussy.item.types;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.Random;

public class RemixPresent extends Item {
    public RemixPresent() {
        super(new Properties().fireResistant());
    }

    private Item randomGiftItem() {
        int val = new Random().nextInt(22);
        return switch (val) {
            case 1 -> ModItems.DISC_CUPCAKKE1.get();
            case 2 -> ModItems.DISC_CUPCAKKE3.get();
            case 3 -> ModItems.DISC_PONMI.get();
            case 4 -> ModItems.DISC_JIAFEI.get();
            case 5 -> ModItems.DISC_C2.get();
            case 6 -> ModItems.DISC_C3.get();
            case 7 -> ModItems.DISC_C10.get();
            case 8 -> ModItems.DISC_C20.get();
            case 9 -> ModItems.DISC_C21.get();
            case 10 -> ModItems.DISC_C25.get();
            case 11 -> ModItems.DISC_C27.get();
            case 12 -> ModItems.DISC_C28.get();
            case 13 -> ModItems.DISC_CPM1.get();
            case 14 -> ModItems.DISC_DB1.get();
            case 15 -> ModItems.DISC_J1.get();
            case 16 -> ModItems.DISC_J3.get();
            case 17 -> ModItems.DISC_J5.get();
            case 18 -> ModItems.DISC_JC1.get();
            case 19 -> ModItems.DISC_JC3.get();
            case 20 -> ModItems.DISC_PM1.get();
            case 21 -> ModItems.DISC_J6.get();
            default -> ModItems.DISC_DEJE_BULLYING.get();
        };
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (PlayerMethods.isFlop(pPlayer)) {
            pPlayer.addItem(new ItemStack(randomGiftItem()));
            if (PlayerMethods.isMagicFlop(pPlayer)) {
                pPlayer.addItem(new ItemStack(ModItems.DISC_RANVISION.get()));
                if (PlayerMethods.isFlopIcon(pPlayer)) {
                    pPlayer.addItem(new ItemStack(ModItems.DISC_DEJE_BULLYING.get()));
                }
            }
            if (pPlayer.getRandom().nextInt(69) == 0) {
                pPlayer.addItem(new ItemStack(ModItems.RANPAPI_TABLET.get()));
            }
        } else if (PlayerMethods.isNewgen(pPlayer)) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.WITHER, 1000, 2));
            if (PlayerMethods.isDaboyz(pPlayer)) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 2));
                pPlayer.sendSystemMessage(Component.translatable("subtitle.fuck_you"));
            }
        }
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        item.setCount(item.getCount() - 1);
        pPlayer.setItemInHand(pUsedHand, item);
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
