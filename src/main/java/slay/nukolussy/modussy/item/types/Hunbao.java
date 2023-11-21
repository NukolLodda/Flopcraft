package slay.nukolussy.modussy.item.types;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

public class Hunbao extends Item {
    public Hunbao() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        item.setCount(item.getCount() - 1);
        pPlayer.setItemInHand(pUsedHand, item);
        pPlayer.spawnAtLocation(ModItems.SLAGINIUM.get()); // will be replaced with bussian dollars at some point
        pPlayer.playSound(ModSounds.JIAFEI_ARMOR.get());
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
