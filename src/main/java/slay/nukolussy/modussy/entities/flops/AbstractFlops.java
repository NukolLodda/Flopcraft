package slay.nukolussy.modussy.entities.flops;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.AbstractModEntity;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.network.yassification.PlayerYassificationProvider;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import javax.annotation.Nullable;
import java.util.*;

public abstract class AbstractFlops extends AbstractModEntity implements IFlopEntity {
    protected static final Ingredient FOOD_ITEMS = Ingredient.of(ModItems.CVM.get(), ModItems.CVMIUM.get());
    private int inLove;
    @Nullable
    private UUID loveCause;
    protected Player tamedBy;
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

    @Override
    public void baseTick() {
        super.baseTick();
    }

    protected void alertFlops(DamageSource pDamageSource) {
        Entity attacker = pDamageSource.getEntity();
        alertFlops(attacker);
    }

    public void alertFlops(Entity attacker) {
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(10d, 10.0d, 10d);
        List<LivingEntity> list = ModUtil.getEntityListOfDist(this.level(), LivingEntity.class, this.position(), 10);
        for (LivingEntity living : list) {
            if (attacker instanceof LivingEntity entity && living instanceof IFlopEntity flops) {
                if (entity instanceof Player player) {
                    PlayerMethods.addPlayerYassification(player, -5);
                    if (player.equals(flops.getTamedBy())) flops.setTamed(null);
                    else if (player.isCreative()) entity = null;
                }
                if (entity != null) flops.setTarget(entity);
            }
        }
    }

    protected void onDie(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            alertFlops(pSource.getEntity());
        }
    }

    protected void onHurt(DamageSource pSource) {
        if (pSource.getEntity() instanceof Player player && player == this.tamedBy) {
            this.setTamed(null);
            PlayerMethods.addPlayerYassification(player, -1);
        }
        if (pSource.getEntity() != null) {
            alertFlops(pSource);
        }
    }
    @Override
    public void die(DamageSource pSource) {
        onDie(pSource);
        super.die(pSource);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        onHurt(pSource);
        return super.hurt(pSource, pAmount);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide && this.tamedBy != null) {
            DamageSource lastDmg = this.tamedBy.getLastDamageSource();
            if (this.tamedBy != null && lastDmg != null) {
                Entity ent = lastDmg.getEntity();
                if (!(ent instanceof IFlopEntity) && ent instanceof LivingEntity entity) {
                    this.setTarget(entity);
                    this.alertFlops(lastDmg);
                }
            }
        }
    }

    public boolean canMate(AbstractModEntity flops) {
        return false;
    }
}