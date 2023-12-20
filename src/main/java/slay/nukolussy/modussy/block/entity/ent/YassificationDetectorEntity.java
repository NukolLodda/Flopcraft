package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.entity.blocks.YassificationDetector;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;

public class YassificationDetectorEntity extends BlockEntity {
    public YassificationDetectorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.YASSIFICATION_DETECTOR.get(), pPos, pBlockState);
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
