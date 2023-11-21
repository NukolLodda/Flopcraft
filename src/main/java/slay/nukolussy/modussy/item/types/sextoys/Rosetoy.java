package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;

public class Rosetoy extends Item {
    public Rosetoy() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        EntityMethods.addEffects(pPlayer);
        pPlayer.playSound(pLevel.random.nextInt(2) == 0 ? ModSounds.ROSETOY_2.get() : ModSounds.ROSETOY_1.get());
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
