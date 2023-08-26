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
import slay.nukolussy.modussy.util.PlayerMethods;

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
                List<LivingEntity> entities = lvl.getEntitiesOfClass(LivingEntity.class,
                        new AABB(new Vec3(x, y+1, z), new Vec3(x, y+3, z)).inflate(1), e -> true).stream().toList();
                for (LivingEntity entity : entities) {
                    if (EntityMethods.isMonster(entity)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 0, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1000, 4, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 1, true, false, false));
                        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0, true, false, false));
                    }
                    if (entity instanceof Player player && this.level.getServer().getTickCount() % 5 == 0) {
                        player.sendSystemMessage(PlayerMethods.getYassificationLevel(player));
                    }
                }
            }
        }
    }
}
