package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;

import java.time.Month;
import java.util.List;

public class FlopPlates extends PressurePlateBlock {
    public FlopPlates(Block pPlate, BlockSetType pType) {
        super(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(pPlate), pType);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof ItemEntity itemEntity && itemEntity.getItem().is(ModItems.CVM_FLUID_BUCKET.get())
                && ModUtil.monthIs(Month.DECEMBER)) {
            boolean isCookie = false;
            List<ItemEntity> ents = ModUtil.getEntityListOfDist(pLevel, ItemEntity.class, pEntity.position(), 1);
            for (ItemEntity item : ents) {
                if (item.getItem().is(Items.COOKIE)) {
                    isCookie = true;
                    break;
                }
            }
            if (isCookie) {
                MariahCarey cvmrey = new MariahCarey(ModEntities.MARIAH_CAREY.get(), pLevel);
                cvmrey.setPos(pEntity.position());
                pLevel.playSound(null, pPos, ModSounds.MARIAH_CAREY_DEFROSTING.get(), SoundSource.AMBIENT);
                this.destroy(pLevel, pPos, pState);
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
