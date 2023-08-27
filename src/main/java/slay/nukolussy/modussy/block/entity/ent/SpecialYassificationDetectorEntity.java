package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.entity.blocks.YassificationDetector;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.bosses.LovelyPeachesBoss;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.List;

public class SpecialYassificationDetectorEntity extends BlockEntity {

    public SpecialYassificationDetectorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SPECIAL_YASSIFICATION_DETECTOR.get(), pPos, pBlockState);
    }
    // 9 blocks down

    public static void makeLovelyPeachesChamber(Level lvl, Vec3 position) {
        if (lvl.isClientSide()) return;

        int x = (int)position.x;
        int y = (int)position.y;
        int z = (int)position.z;

        if (lvl instanceof ServerLevel server) {
            for (int xs = -7; xs <= 7; xs++) {
                for (int ys = -3; ys <= 3; ys++) {
                    for (int zs = -7; zs <= 7; zs++) {
                        boolean isStructural = false;
                        BlockPos pos = new BlockPos(x + xs, y + ys, z + zs);
                        if (server.getBlockState(pos).getBlock().equals(ModBlocks.HARDENED_PERIOD_CVM.get()) ||
                                server.getBlockState(pos).getBlock().equals(ModBlocks.BARBIE_LANTERN.get()) ) {
                            isStructural = true;
                        }
                        server.destroyBlock(pos, !isStructural);
                    }
                }
            }
        }

        lvl.setBlock(new BlockPos(x-7, y-3, z-7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x+7, y-3, z-7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x-7, y-3, z+7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x+7, y-3, z+7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);

        lvl.setBlock(new BlockPos(x-7, y+3, z-7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x+7, y+3, z-7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x-7, y+3, z+7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);
        lvl.setBlock(new BlockPos(x+7, y+3, z+7),
                ModBlocks.BARBIE_LANTERN.get().defaultBlockState(), 3);

        for (int possibleX = -8; possibleX <= 8; possibleX++) {
            for (int possibleY = -4; possibleY <= 4; possibleY++) {
                lvl.setBlock(new BlockPos(x + possibleX, y + possibleY, z-8),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x + possibleX, y + possibleY, z+8),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
        }
        for (int possibleX = -8; possibleX <= 8; possibleX++) {
            for (int possibleZ = -8; possibleZ <= 8; possibleZ++) {
                lvl.setBlock(new BlockPos(x + possibleX, y+4, z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x + possibleX, y-4,  z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
        }
        for (int possibleY = -4; possibleY <= 4; possibleY++) {
            for (int possibleZ = -8; possibleZ <= 8; possibleZ++) {
                lvl.setBlock(new BlockPos(x-8, y + possibleY, z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x+8, y + possibleY,  z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
        }

        boolean lovelypeachesIsHere = false;
        {
            List<LivingEntity> entities = lvl.getEntitiesOfClass(LivingEntity.class,
                    new AABB(new Vec3(x-8, y-4, z-8), new Vec3(x+8, y+4, z+8)).inflate(1), e -> true).stream().toList();
            for (LivingEntity entity : entities) {
                if (entity instanceof LovelyPeachesBoss) {
                    lovelypeachesIsHere = true;
                    break;
                }
            }
        }

        if (!lovelypeachesIsHere) {
            LovelyPeachesBoss peaches = new LovelyPeachesBoss(ModEntities.LOVELY_PEACHES_BOSS.get(), lvl);
            peaches.moveTo(position);
            peaches.setTeleporterLocation(new BlockPos((int)position.get(Direction.Axis.X),
                    (int)position.get(Direction.Axis.Y) - 3,
                    (int)position.get(Direction.Axis.Z)));
            lvl.addFreshEntity(peaches);
        }
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
            {
                List<LivingEntity> entities = lvl.getEntitiesOfClass(LivingEntity.class,
                        new AABB(new Vec3(x, y+1, z), new Vec3(x, y+3, z)).inflate(1), e -> true).stream().toList();
                for (LivingEntity entity : entities) {
                    if (EntityMethods.isMonster(entity) || (entity instanceof Player player && !PlayerMethods.isFlop(player))) {
                        makeLovelyPeachesChamber(lvl, new Vec3(x, y-12, z));
                        entity.teleportTo(x,y-13, z);
                        if (entity instanceof Player player) {
                            if (PlayerMethods.isNewgen(player)) {
                                player.sendSystemMessage(PlayerMethods.getYassificationLevel(player));
                                player.sendSystemMessage(YassificationDetector.getBlockName().append(Component.translatable("subtitle.dangerous_nonflop"))
                                        .withStyle(ChatFormatting.RED));
                                EntityMethods.alertFlops(lvl, pos.getX(), pos.getY(), pos.getZ(), player);
                            } else if (!PlayerMethods.isFlop(player)) {
                                player.sendSystemMessage(PlayerMethods.getYassificationLevel(player));
                                player.sendSystemMessage(YassificationDetector.getBlockName().append(Component.translatable("subtitle.prove_flop"))
                                        .withStyle(ChatFormatting.GRAY));
                            }
                        }
                    } else if (entity instanceof Player player) {
                        if (lvl.getServer().getTickCount() % 15 == 0) {
                            player.sendSystemMessage(YassificationDetector.getBlockName().append(Component.translatable("subtitle.confirmed_flop"))
                                    .withStyle(ChatFormatting.LIGHT_PURPLE));
                        } else if (lvl.getServer().getTickCount() % 15 == 8) {
                            player.sendSystemMessage(PlayerMethods.getYassificationLevel(player));
                        }
                    }
                }
            }
        }
    }
}
