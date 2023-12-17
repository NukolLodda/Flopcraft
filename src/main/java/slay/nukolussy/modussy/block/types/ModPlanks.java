package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;

import java.time.Month;

public class ModPlanks extends Block {
    public ModPlanks() {
        super(Properties.copy(Blocks.CRIMSON_PLANKS));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (ModUtil.getMonth().equals(Month.DECEMBER) && pEntity instanceof ItemEntity item
                && ModUtil.itemsEqualsEachother(item, ModItems.LANCVM_CREAM.get(), Items.COOKIE, ModItems.CVM.get())) {
                MariahCarey carey = new MariahCarey(ModEntities.MARIAH_CAREY.get(), pLevel);
                carey.moveTo(pPos, 0, 0);
                pLevel.playSound(null, pPos, ModSounds.MARIAH_CAREY_DEFROSTING.get(), SoundSource.BLOCKS);
                pLevel.destroyBlock(pPos, false);
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
