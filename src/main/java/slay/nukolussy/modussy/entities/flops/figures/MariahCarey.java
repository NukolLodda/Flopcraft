package slay.nukolussy.modussy.entities.flops.figures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.entity.blocks.MariahCareyIceBlock;
import slay.nukolussy.modussy.datagen.tags.ModTags;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.ToolMethods;

import java.time.Month;
import java.util.List;

public class MariahCarey extends AbstractFlopFigures implements RangedAttackMob {
    public MariahCarey(EntityType<MariahCarey> type, Level world) {
        super(type, world);
    }

    public MariahCarey(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public static void init() {
    }

    public static boolean canSpawn(EntityType<MariahCarey> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null; // wip
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null; // wip
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null; // wip
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public void aiStep() {
        BlockState snow = Blocks.SNOW.defaultBlockState();
        for(int i = 0; i < 4; ++i) {
            int x = Mth.floor(this.getX() + (double)((float)(i % 2 * 2 - 1) * 0.25F));
            int y = Mth.floor(this.getY());
            int z = Mth.floor(this.getZ() + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25F));
            BlockPos pos = new BlockPos(x, y, z);
            if (this.level().isEmptyBlock(pos) && snow.canSurvive(this.level(), pos)) {
                this.level().setBlockAndUpdate(pos, snow);
                this.level().gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(this, snow));
            }
        }
        if (ModUtil.isClitmas() && this.random.nextInt(1020) == 0) {
            this.spawnAtLocation(ModItems.CLITMAS_PRESENT.get());
        }
        if (ModUtil.isNewYears() && this.random.nextInt(1690) == 0) {
            this.spawnAtLocation(ModItems.HUNBAO.get());
        }
        super.aiStep();
    }

    @Override
    public void tick() {
        if (!ModUtil.getMonth().equals(Month.DECEMBER)) {
            int x = this.getBlockX();
            int y = this.getBlockY();
            int z = this.getBlockZ();
            int rot = Math.round(this.getYRot() / 90);
            Direction facing = switch (rot) {
                case 1 -> Direction.EAST;
                case 2 -> Direction.SOUTH;
                case 3 -> Direction.WEST;
                default -> Direction.NORTH;
            };
            this.level().setBlock(new BlockPos(x, y, z),
                    ModBlocks.MARIAH_CAREY_ICE_BLOCK.get().defaultBlockState()
                            .setValue(MariahCareyIceBlock.FACING, facing).setValue(MariahCareyIceBlock.IS_TOP, false), 3);
            this.level().setBlock(new BlockPos(x, y+1, z),
                    ModBlocks.MARIAH_CAREY_ICE_BLOCK.get().defaultBlockState()
                            .setValue(MariahCareyIceBlock.FACING, facing).setValue(MariahCareyIceBlock.IS_TOP, true), 3);
            this.remove(RemovalReason.DISCARDED);
        }
        {
            final Vec3 center = new Vec3(this.getX(), this.getY(), this.getZ());
            List<Player> players = this.level().getEntitiesOfClass(Player.class, new AABB(center, center).inflate(64)).stream().toList();
            final ItemStack slaginium = new ItemStack(ModItems.SLAGINIUM.get());
            for (Player player : players) {
                Inventory inv = player.getInventory();
                if (inv.contains(slaginium)) {
                    int slot = inv.findSlotMatchingItem(slaginium);
                    player.getInventory().removeItem(slot, inv.getItem(slot).getCount());
                }
            }
        }
        super.tick();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        double xDif = pTarget.getX() - this.getX();
        double yDif = pTarget.getY() - this.getY();
        double zDif = pTarget.getZ() - this.getZ();
        for (int i = 1; i <= 6; i++) {
            int inX = (int)((i * xDif / 6) + this.getX());
            int inY = (int)((i * yDif / 6) + this.getY());
            int inZ = (int)((i * zDif / 6) + this.getZ());
            ToolMethods.mariahCvmreyShoot(this.level(), inX, inY, inZ, pVelocity);
        }
    }
}
