package slay.nukolussy.modussy.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
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
import slay.nukolussy.modussy.procedures.CupcakKeDrops;

import java.util.Random;

public class CupcakKe extends PathfinderMob {
    public CupcakKe(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntities.CUPCAKKE.get(), world);
        this.setCanPickUpLoot(true);
        this.applyOpenDoorsAbility();
    }

    public CupcakKe(EntityType<CupcakKe> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);

        Random random = new Random();
        int toolChance = random.nextInt(1,69);
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
        this.goalSelector.addGoal(2, new RandomStrollGoal(this,1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
        this.goalSelector.addGoal(6, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(7, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(8, new OpenDoorGoal(this, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        Random random = new Random();
        int hurtNum = random.nextInt(1,11);
        String hurtSound = "modussy:cupcakke_hurt10";
        if (hurtNum == 1) hurtSound = "modussy:cupcakke_1";
        if (hurtNum == 2) hurtSound = "modussy:cupcakke_2";
        if (hurtNum == 3) hurtSound = "modussy:cupcakke_3";
        if (hurtNum == 4) hurtSound = "modussy:cupcakke_4";
        if (hurtNum == 5) hurtSound = "modussy:cupcakke_5";
        if (hurtNum == 6) hurtSound = "modussy:cupcakke_6";
        if (hurtNum == 7) hurtSound = "modussy:cupcakke_7";
        if (hurtNum == 8) hurtSound = "modussy:cupcakke_8";
        if (hurtNum == 9) hurtSound = "modussy:cupcakke_9";

        return ForgeRegistries.SOUND_EVENTS.getValue((new ResourceLocation(hurtSound)));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        Random random = new Random();
        int hurtNum = random.nextInt(1,5);
        String hurtSound = "modussy:cupcakke_hurt4";
        if (hurtNum == 1) hurtSound = "modussy:cupcakke_hurt1";
        if (hurtNum == 2) hurtSound = "modussy:cupcakke_hurt2";
        if (hurtNum == 3) hurtSound = "modussy:cupcakke_hurt3";
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(hurtSound));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
        CupcakKeDrops.execute(this.level, this.getX(), this.getY(), this.getZ());
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

        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level;
        for (int i = 0; i < 4; i++) {
            double x0 = x + random.nextFloat();
            double y0 = y + random.nextFloat();
            double z0 = z + random.nextFloat();
            double dx = (random.nextFloat() - 0.5D) * 0.5D;
            double dy = (random.nextFloat() - 0.5D) * 0.5D;
            double dz = (random.nextFloat() - 0.5D) * 0.5D;

            world.addParticle(ParticleTypes.DRAGON_BREATH, x0, y0, z0, dx, dy, dz);
        }
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.CUPCAKKE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
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
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }

    }
}
