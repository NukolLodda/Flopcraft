package net.nukollodda.flopcraft.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nukollodda.flopcraft.util.PlayerMethods;

public class FlopAirlineTeleporter extends Block {
    public FlopAirlineTeleporter() {
        super(Properties.ofFullCopy(Blocks.BEDROCK).noLootTable().lightLevel(l -> 10).sound(SoundType.GLASS));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.teleportTo(pPlayer.getX(), pPos.getY() + 14, pPlayer.getZ());
        pLevel.destroyBlock(pPos, false, pPlayer);
        if (!PlayerMethods.isNewgen(pPlayer)) {
            PlayerMethods.setToFlop(pPlayer);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
