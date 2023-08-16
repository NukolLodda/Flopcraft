package slay.nukolussy.modussy.item.types;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import slay.nukolussy.modussy.item.ActivateMethods;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class SoundItems extends RecordItem {
    private final String fragment;
    public SoundItems(SoundEvent loc, int ticks, String fragment) {
        super(0, () -> loc,
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE), ticks);
        this.fragment = fragment;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(Blocks.JUKEBOX) && !blockstate.getValue(JukeboxBlock.HAS_RECORD)) {
            if (!level.isClientSide) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof JukeboxBlockEntity) {
                    Player player = pContext.getPlayer();

                    if (player != null && ActivateMethods.notDaboyz(player)) {
                        ActivateMethods.addPlayerYassification(player, 5);
                    }
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(pContext);
    }
}
