package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FlopAirlineTeleporter extends Block {
    public FlopAirlineTeleporter() {
        super(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN).noLootTable().lightLevel(l -> 10));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.teleportTo(pPos.getX(), pPos.getY() + 16, pPos.getZ());
        pLevel.destroyBlock(pPos, false, pPlayer);
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
