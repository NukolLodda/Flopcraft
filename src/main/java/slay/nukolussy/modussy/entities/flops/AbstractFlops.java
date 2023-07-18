package slay.nukolussy.modussy.entities.flops;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import slay.nukolussy.modussy.item.ModItem;

import javax.annotation.Nullable;
import java.util.*;

public abstract class AbstractFlops extends PathfinderMob {
    protected static final Ingredient FOOD_ITEMS = Ingredient.of(ModItem.CVM.get(), ModItem.CVMIUM.get());
    private int inLove;
    @Nullable
    private UUID loveCause;
    public AbstractFlops(EntityType type, Level world) {
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

    private void alertFlops(DamageSource pDamageSource) {
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(10d, 10.0d, 10d);
        List<Entity> list = this.level().getEntitiesOfClass(Entity.class, aabb, e -> true).stream()
                .sorted(Comparator.comparingDouble(_entcnd ->
                        _entcnd.distanceToSqr(this.getX(), this.getY(), this.getZ()))).toList();

        for (Entity ent : list) {
            if (ent instanceof Player player && player.isCreative()) continue;
            if (ent instanceof AbstractFlops flops && pDamageSource.getEntity() instanceof LivingEntity entity)
                flops.setTarget(entity);
            // if the causer was the player, it would reduce their yassification level
        }

    }

    @Override
    public void die(DamageSource pDamageSource) {
        if (pDamageSource.getEntity() != null) {
            alertFlops(pDamageSource);
        }
        super.die(pDamageSource);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.getEntity() != null) {
            alertFlops(pSource);
        }
        return super.hurt(pSource, pAmount);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 20);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);

        return builder;
    }

    public boolean isInLove() {
        return this.inLove > 0;
    }

    public boolean canMate(AbstractFlops flops) {
        if (flops == this) {
            return false;
        } else if (flops.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && flops.isInLove();
        }
    }

    protected void applyOpenDoorsAbility() {
        if (GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
        }
    }
}