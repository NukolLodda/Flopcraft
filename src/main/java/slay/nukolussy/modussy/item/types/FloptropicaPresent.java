package slay.nukolussy.modussy.item.types;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FloptropicaPresent extends Item {
    public FloptropicaPresent() {
        super(new Properties().fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        // will drop something if it's Christmas.
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
