package slay.nukolussy.modussy.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.procedures.CupcakKeDrops;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Collection;
import java.util.Random;

public class CupcakKe extends FlopFigures {
    public ItemLike item = ModItem.CVMTITPLASM.get();
    public CupcakKe(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntities.CUPCAKKE.get(), world);
        this.setCanPickUpLoot(true);
        this.applyOpenDoorsAbility();
    }

    public CupcakKe(EntityType<CupcakKe> type, Level world) {
        super(type, world);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        Random random = new Random();
        int hurtNum = random.nextInt(1,11);
        String hurtSound = "modussy:cupcakke_10";
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
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:cupcakke_death"));
    }

    public SoundEvent getEatingSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:cupcakke_slurp"));
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

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level.isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level.isClientSide) {
            boolean flag = itemStack.is(ModItem.CVM.get()) || itemStack.is(ModItem.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItem.CVM.get()) || item.equals(ModItem.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                if (this.getMaxHealth() == this.getHealth()) {
                    Collection<MobEffectInstance> inst = this.getActiveEffects();
                    Mob newMob = new CupcakKe(ModEntities.CUPCAKKE.get(), this.level);
                    newMob.moveTo(this.getX(), this.getY(), this.getZ());
                    newMob.setXRot(this.getXRot());
                    newMob.setYRot(this.getYRot());
                    if (item == ModItem.CVM.get()) {
                        newMob.hurt(DamageSource.FREEZE, 10);
                        this.hurt(DamageSource.FREEZE, 10);
                    }
                    for (MobEffectInstance effect : inst) {
                        newMob.addEffect(effect);
                    }
                    this.level.addFreshEntity(newMob);
                    this.spawnAtLocation(ModItem.CVMTITPLASM.get());
                }

                this.playSound(ModSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
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
}
