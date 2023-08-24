package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
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
import slay.nukolussy.modussy.block.entity.ent.ModBlockEntities;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.List;

public class YassificationDetectorEntity extends BlockEntity {
    public static final MutableComponent BLOCK_NAME = Component.literal("<")
            .append(Component.translatable("block.modussy.yassification_detector")).append("> ");

    public YassificationDetectorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.YASSIFICATION_DETECTOR.get(), pPos, pBlockState);
    }
    // 9 blocks down

    public static void makeLovelyPeachesChamber(Level lvl, Vec3 position) {
        if (lvl.isClientSide()) return;

        int x = (int)position.x;
        int y = (int)position.y;
        int z = (int)position.z;

        if (lvl instanceof ServerLevel server) {
            for (int xs = -4; xs <= 4; xs++) {
                for (int ys = -2; ys <= 2; ys++) {
                    for (int zs = -4; zs <= 4; zs++) {
                        server.destroyBlock(new BlockPos(x + xs, y + ys, z + zs), true);
                    }
                }
            }
        }

        for (int possibleX = -5; possibleX <= 5; possibleX++) {
            for (int possibleY = -3; possibleY <= 3; possibleY++) {
                lvl.setBlock(new BlockPos(x + possibleX, y + possibleY, z-5),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x + possibleX, y + possibleY, z+5),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
        }
        for (int possibleX = -5; possibleX <= 5; possibleX++) {
            for (int possibleZ = -5; possibleZ <= 5; possibleZ++) {
                lvl.setBlock(new BlockPos(x + possibleX, y+3, z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x + possibleX, y-3,  z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
        }
        for (int possibleY = -3; possibleY <= 3; possibleY++) {
            for (int possibleZ = -5; possibleZ <= 5; possibleZ++) {
                lvl.setBlock(new BlockPos(x-5, y + possibleY, z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);

                lvl.setBlock(new BlockPos(x+5, y + possibleY,  z + possibleZ),
                        ModBlocks.HARDENED_PERIOD_CVM.get().defaultBlockState(), 3);
            }
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
                        new AABB(new Vec3(x, y+1, z), new Vec3(x, y+4, z)).inflate(1), e -> true).stream().toList();
                for (LivingEntity entity : entities) {
                    if (EntityMethods.isMonster(entity) || (entity instanceof Player player && !PlayerMethods.isFlop(player))) {
                        makeLovelyPeachesChamber(lvl, new Vec3(x, y-11, z));
                        entity.teleportTo(x,y-11, z);
                        if (entity instanceof Player player) {
                            if (PlayerMethods.isNewgen(player)) {
                                player.sendSystemMessage(BLOCK_NAME.append(Component.translatable("subtitle.dangerous_nonflop"))
                                        .withStyle(ChatFormatting.RED));
                            } else {
                                player.sendSystemMessage(BLOCK_NAME.append(Component.translatable("subtitle.prove_flop"))
                                        .withStyle(ChatFormatting.GRAY));
                            }
                        }
                    } else if (entity instanceof Player player && lvl.getServer().getTickCount() % 20 == 0) {
                        player.sendSystemMessage(BLOCK_NAME.append(Component.translatable("subtitle.confirmed_flop"))
                                .withStyle(ChatFormatting.LIGHT_PURPLE));
                    }
                }
            }
        }
    }
}
