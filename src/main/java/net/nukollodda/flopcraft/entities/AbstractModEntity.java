package net.nukollodda.flopcraft.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.entities.goal.FlopcraftBreedingGoal;
import net.nukollodda.flopcraft.network.yassification.PlayerYassificationProvider;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class AbstractModEntity extends PathfinderMob {
    private int inLove;
    @Nullable
    private UUID loveCause;
    protected Player tamedBy;
    public AbstractModEntity(EntityType type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return (4.0 + entity.getBbWidth() * entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 5.0f));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this,1));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatGoal(this));
        this.goalSelector.addGoal(7, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
    }

    public void setTamed(Player player) {
        if (player != null) {
            player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
                if (!yassification.isNewgen()) {
                    this.tamedBy = player;
                }
            });
        }
    }

    @Override
    public abstract MobType getMobType();

    public void setInLove(@Nullable Player player) {
        this.inLove = 600;
        if (player != null) {
            this.loveCause = player.getUUID();
        }

        this.level().broadcastEntityEvent(this, (byte)18);
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 20);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);

        return builder;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public boolean isInLove() {
        return this.inLove > 0;
    }

    protected void applyOpenDoorsAbility() {
        if (GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
        }
    }

    public Player getTamedBy() {
        return tamedBy;
    }

    public void onBreeding(Level pLevel) {
    }
    public abstract boolean canMate(AbstractModEntity pEntity);
}
