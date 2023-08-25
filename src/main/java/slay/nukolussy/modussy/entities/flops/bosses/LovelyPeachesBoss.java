package slay.nukolussy.modussy.entities.flops.bosses;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.entities.projectiles.LovelyPeach;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

import javax.annotation.Nullable;

public class LovelyPeachesBoss extends AbstractSpecialFlops implements RangedAttackMob {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(),
            BossEvent.BossBarColor.PINK, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    private BlockPos teleporterLocation;
    public LovelyPeachesBoss(EntityType type, Level world) {
        super(type, world);
    }

    public LovelyPeachesBoss(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2f);
        builder = builder.add(Attributes.MAX_HEALTH, 169);
        builder = builder.add(Attributes.ARMOR, 3);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 30);
        builder = builder.add(Attributes.FOLLOW_RANGE, 15);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);

        return builder;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
        super.addAdditionalSaveData(tag);
        tag.putInt("SpawnX", this.teleporterLocation.getX());
        tag.putInt("SpawnY", this.teleporterLocation.getY());
        tag.putInt("SpawnZ", this.teleporterLocation.getZ());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        int x = tag.getInt("SpawnX");
        int y = tag.getInt("SpawnY");
        int z = tag.getInt("SpawnZ");

        this.teleporterLocation = new BlockPos(x, y, z);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.tickCount % 20 == 0) {
            this.heal(1.0f);
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public void setCustomName(@Nullable Component pName) {
        super.setCustomName(pName);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void setTeleporterLocation(BlockPos pPos) {
        this.teleporterLocation = pPos;
    }

    public static void init() {
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.0, 40, 20.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class,
                0, false, false, ent -> ent.attackable() && !EntityMethods.isFlop(ent)));
        super.registerGoals();
    }

    @Override
    protected void onDie(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (PlayerMethods.isNewgen(player)) {
                    alertFlops(player);
                } else {
                    PlayerMethods.setToFlop(player);
                    player.level().setBlock(this.teleporterLocation,
                            ModBlocks.FLOP_AIRLINE_TELEPORTER.get().defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    protected void onHurt(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (PlayerMethods.isNewgen(player)) {
                    super.onHurt(pSource);
                } else if (PlayerMethods.isFlop(player)) {
                    PlayerMethods.addPlayerYassification(player, -1);
                    alertFlops(player);
                }
            } else {
                super.onHurt(pSource);
            }
        }
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.performRangedAttack(pTarget.getX(), pTarget.getY() + (double)pTarget.getEyeHeight() * 0.5, pTarget.getZ());

    }

    private void performRangedAttack(double x, double y, double z) {
        if (!this.isSilent()) {
            this.level().levelEvent((Player)null, 1024, this.blockPosition(), 0);
        }

        double x0 = this.getX();
        double y0 = this.getY() + 1;
        double z0 = this.getZ();
        double x1 = x - x0;
        double y1 = y - y0;
        double z1 = z - z0;
        LovelyPeach peach = new LovelyPeach(this.level(), this, x1, y1, z1);
        peach.setOwner(this);

        peach.setPosRaw(x0, y0, z0);
        this.level().addFreshEntity(peach);
    }

    public void startSeenByPlayer(ServerPlayer pPlayer) {
        super.startSeenByPlayer(pPlayer);
        if (!PlayerMethods.isFlop(pPlayer)) {
            this.bossEvent.addPlayer(pPlayer);
        }
    }
    public void stopSeenByPlayer(ServerPlayer pPlayer) {
        super.stopSeenByPlayer(pPlayer);
        if (this.bossEvent.getPlayers().contains(pPlayer)) {
            this.bossEvent.removePlayer(pPlayer);
        }
    }
}
