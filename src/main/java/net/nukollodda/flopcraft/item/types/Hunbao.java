package net.nukollodda.flopcraft.item.types;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.util.PlayerMethods;

public class Hunbao extends Item {
    public Hunbao() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!PlayerMethods.isNewgen(pPlayer)) {
            int max = 1;
            if (PlayerMethods.isFlop(pPlayer)) {
                max++;
                if (PlayerMethods.isMagicFlop(pPlayer)) {
                    max++;
                    if (PlayerMethods.isFlopIcon(pPlayer)) {
                        max++;
                    }
                }
            }
            ItemStack gift = new ItemStack(FlopItems.SLAGINIUM.get(), pPlayer.getRandom().nextInt(1, max * 3)); // will be replaced with bussian dollars at some point
            ItemStack item = pPlayer.getItemInHand(pUsedHand);
            item.setCount(item.getCount() - 1);
            pPlayer.setItemInHand(pUsedHand, item);
            pPlayer.spawnAtLocation(gift);
            pPlayer.playSound(FlopSounds.JIAFEI_ARMOR.get());
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
