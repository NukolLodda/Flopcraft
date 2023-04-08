package slay.nukolussy.modussy.entity.custom;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.item.ModItem;

import java.util.Random;

public class Jiafei extends PathfinderMob {
    public Jiafei(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntities.JIAFEI.get(), world);
        this.setCanPickUpLoot(true);
        this.applyOpenDoorsAbility();
    }

    public Jiafei(EntityType<Jiafei> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);

        Random random = new Random();
        int toolChance = random.nextInt(1, 69);
        if (toolChance == 1) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.SLAGINIUM_YASSIFIER.get()));
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 5.0f));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this,1));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatGoal(this));
        this.goalSelector.addGoal(7, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(9, new OpenDoorGoal(this, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        Random random = new Random();
        int randNum = random.nextInt(1,4);
        String sound = "modussy:jiafei_3";
        if (randNum == 1) sound = "modussy:jiafei_1";
        if (randNum == 2) sound = "modussy:jiafei_2";
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(sound));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:jiafei_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        Random random = new Random();
        int dedNum = random.nextInt(1,4);
        String deathSound = "modussy:jiafei_death_3";
        if (dedNum == 1) deathSound = "modussy:jiafei_death_1";
        if (dedNum == 2) deathSound = "modussy:jiafei_death_2";
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(deathSound));
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof AbstractArrow || source == DamageSource.FALL || source == DamageSource.CACTUS ||
                source == DamageSource.LIGHTNING_BOLT || source.isExplosion() || source.getMsgId().equals("trident") ||
                source == DamageSource.ANVIL || source == DamageSource.DRAGON_BREATH || source.isFire())
            return false;
        return super.hurt(source, amount);
    }

    public void aiStep() {
        super.aiStep();
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.JIAFEI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
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

    private void applyOpenDoorsAbility() {
        if (GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
        }
    }
}