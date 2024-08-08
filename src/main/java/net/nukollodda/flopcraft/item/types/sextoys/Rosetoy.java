package net.nukollodda.flopcraft.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.nukollodda.flopcraft.block.ModBlocks;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.util.EntityMethods;

public class Rosetoy extends Item {
    public Rosetoy() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        EntityMethods.addEffects(pPlayer);
        pPlayer.playSound(pLevel.random.nextBoolean() ? FlopSounds.ROSETOY_2.get() : FlopSounds.ROSETOY_1.get());
        if (pPlayer.getRandom().nextInt(5) == 1) {
            Block fluid = pPlayer.getRandom().nextBoolean() ? ModBlocks.POOSAY_JUICE.get() : ModBlocks.CVM_FLUID.get();
            pLevel.setBlock(pPlayer.getOnPos().above(), fluid.defaultBlockState(), 3);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
