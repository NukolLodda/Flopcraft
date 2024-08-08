package net.nukollodda.flopcraft.entities.flops.figures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.block.ModBlocks;
import net.nukollodda.flopcraft.block.entity.blocks.MariahCareyIceBlock;
import net.nukollodda.flopcraft.entities.flops.AbstractIconicFigures;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.util.EntityMethods;
import net.nukollodda.flopcraft.util.ModUtil;
import net.nukollodda.flopcraft.util.ToolMethods;

import java.time.Month;

public class MariahCarey extends AbstractIconicFigures implements RangedAttackMob {
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
            this.spawnAtLocation(FlopItems.CLITMAS_PRESENT.get());
        }
        if (this.hasEffect(MobEffects.SLOW_FALLING) && this.level().getBlockState(this.blockPosition().below()).is(Blocks.AIR)) {
            sendParticles(this.getX(), this.getY() - 1, this.getZ(), 10, 0.16);
        }
        super.aiStep();
    }

    @Override
    public void tick() {
        if (!ModUtil.monthIs(Month.DECEMBER)) {
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
        final ItemStack slaginium = new ItemStack(FlopItems.SLAGINIUM.get());
        ModUtil.getEntityListOfDist(this.level(), Entity.class, this.position(), 16).forEach(entity -> {
            if (entity instanceof Player player) {
                Inventory inv = player.getInventory();
                if (inv.contains(slaginium)) {
                    int slot = inv.findSlotMatchingItem(slaginium);
                    player.getInventory().removeItem(slot, inv.getItem(slot).getCount());
                    sendParticles(player.getX(), player.getY(), player.getZ(), 15, 0.16);
                }
            }
            if (entity instanceof ItemEntity item && item.getItem().is(FlopItems.SLAGINIUM.get())) {
                sendParticles(item.getX(), item.getY(), item.getZ(), 15, 0.16);
                item.remove(RemovalReason.DISCARDED);
            }
        });
        super.tick();
    }

    private void sendParticles(double x, double y, double z, int count, double speed) {
        ToolMethods.emitParticles(this.level(), x, y, z, count, speed, ParticleTypes.COMPOSTER, ParticleTypes.CRIMSON_SPORE);
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
            final Vec3 center = new Vec3(inX, inY, inZ);
            ModUtil.getEntityListOfDist(this.level(), LivingEntity.class, center, 2 * pVelocity / 2d)
                    .forEach(ent -> EntityMethods.addEffects(ent, (int)pVelocity * 20, (int)pVelocity));
            sendParticles(inX, inY, inZ, (int)(pVelocity * 15),  pVelocity * 0.16);
        }
    }
}
