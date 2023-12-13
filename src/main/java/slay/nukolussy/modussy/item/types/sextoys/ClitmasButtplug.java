package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.sound.ModSounds;

public class ClitmasButtplug extends AbstractButtplug {
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        // upon use, the player will moan and spawn poosay juice on the ground
        pPlayer.playSound(ModSounds.INTENSE_MOANING.get());
        if (pPlayer.getRandom().nextInt(0, 3) == 1) {
            pLevel.setBlock(pPlayer.getOnPos().above(), ModBlocks.POOSAY_JUICE.get().defaultBlockState(), 3);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
