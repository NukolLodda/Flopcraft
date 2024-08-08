package net.nukollodda.flopcraft.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.nukollodda.flopcraft.util.EntityMethods;
import net.nukollodda.flopcraft.util.ModUtil;
import net.nukollodda.flopcraft.util.PlayerMethods;

public class YassificationDetectorEntity extends BlockEntity {
    public YassificationDetectorEntity(BlockPos pPos, BlockState pBlockState) {
        super(FlopBlockEntities.YASSIFICATION_DETECTOR.get(), pPos, pBlockState);
    }

    public void tick() {
        Level lvl = this.level;
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();

        if (lvl != null && !lvl.isClientSide() && lvl.getServer() != null) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            switch (state.getValue(HorizontalDirectionalBlock.FACING)) {
                case EAST -> x++;
                case WEST -> x--;
                case SOUTH -> z++;
                case NORTH -> z--;
            }
            if (this.level != null && this.level.getServer() != null){
                ModUtil.getEntityListOfDist(lvl, LivingEntity.class, new Vec3(x, y+1, z), new Vec3(x, y+3, z), 1)
                        .forEach(entity -> {
                            if (EntityMethods.isMonster(entity)) {
                                EntityMethods.monsterEffects(entity);
                            }
                            if (entity instanceof Player player && this.level.getServer().getTickCount() % 5 == 0) {
                                player.sendSystemMessage(PlayerMethods.getYassificationLevel(player));
                            }
                        });
            }
        }
    }
}
