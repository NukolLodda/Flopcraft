package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;

public class Rosetoy extends Item {
    public Rosetoy() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        EntityMethods.addEffects(pPlayer);
        pPlayer.playSound(pLevel.random.nextBoolean() ? ModSounds.ROSETOY_2.get() : ModSounds.ROSETOY_1.get());
        if (pPlayer.getRandom().nextInt(5) == 1) {
            Block fluid = pPlayer.getRandom().nextBoolean() ? ModBlocks.POOSAY_JUICE.get() : ModBlocks.CVM_FLUID.get();
            pLevel.setBlock(pPlayer.getOnPos().above(), fluid.defaultBlockState(), 3);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
