package net.nukollodda.flopcraft.entities.twink;

import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import net.nukollodda.flopcraft.entities.AbstractModEntity;
import net.nukollodda.flopcraft.entities.FlopEntities;
import net.nukollodda.flopcraft.entities.goal.FlopcraftBreedingGoal;
import net.nukollodda.flopcraft.item.FlopItems;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class Twink extends AbstractTwink {
    private static final EntityDataAccessor<Integer> TWINK_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Twink.class, EntityDataSerializers.INT);
    private final boolean summonedByTroye;

    public Twink(PlayMessages.SpawnEntity packet, Level world) {
        super(FlopEntities.TWINK.get(), world);
        this.summonedByTroye = false;
    }

    public Twink(EntityType<Twink> type, Level world) {
        this(type, world, false);
    }

    Twink(EntityType<Twink> type, Level world, boolean summonedByTroye) {
        super(type, world);
        this.setCanPickUpLoot(true);

        this.applyOpenDoorsAbility();
        this.summonedByTroye = summonedByTroye;
        xpReward = 0;
        setNoAi(false);

        setPersistenceRequired();
    }

    public Brain<Twink> getBrain() {
        return (Brain<Twink>) super.getBrain();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TWINK_ID_DATATYPE_VARIANT, 0);
    }

    protected void pickUpItem(ItemEntity item) {
        this.onItemPickup(item);
        TwinkAI.pickUpItem(this, item);
    }

    protected void holdInOffHand(ItemStack item) {
        if (item.is(FlopItems.CVM.get())) {
            this.setItemSlot(EquipmentSlot.OFFHAND, item);
            this.setGuaranteedDrop(EquipmentSlot.OFFHAND);
        } else {
            this.setItemSlotAndDropWhenKilled(EquipmentSlot.OFFHAND, item);
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.put("Inventory", this.inventory.createTag());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setTypeVariant(tag.getInt("Variant"));
        this.inventory.fromTag(tag.getList("Inventory",10));
    }

    public void setVariant(Variant variant) {
        this.setTypeVariant(variant.getId());
    }

    public void setRandomVariant() {
        this.setTypeVariant(this.random.nextInt(5));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new FlopcraftBreedingGoal(this, 1.0d));
        // add a follow twink sivan part
    }

    public boolean isSummonedByTroye() {
        return summonedByTroye;
    }

    public ItemStack addToInventory(ItemStack item) {
        return this.inventory.addItem(item);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.withDefaultNamespace("entity.genertic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.withDefaultNamespace("entity.genertic.hurt"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level world = this.level();
        int dropChance = this.random.nextInt(8400);
        if (dropChance == 1) {
            int randX = (int)((Math.random() - 0.5) * 10);
            int randZ = (int)((Math.random() - 0.5) * 10);
            if (world.isClientSide()) {
                ItemEntity entityToSpawn = new ItemEntity(world, this.getX() + randX, this.getY(), this.getZ() + randZ, new ItemStack(FlopItems.TWINK_EGG.get()));
                entityToSpawn.setPickUpDelay(10);
                world.addFreshEntity(entityToSpawn);
            }
        }
    }

    @Override
    public boolean canMate(AbstractModEntity pEntity) {
        if (pEntity == this || pEntity.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && pEntity.isInLove();
        }
    }

    @Override
    public void die(DamageSource pSource) {
        if (pSource.getEntity() != null & pSource.getEntity() instanceof Zombie) {
            this.convertTo(EntityType.ZOMBIE, true);
        }
        super.die(pSource);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.IS_DROWNING)) {
            return false;
        }
        return super.hurt(source, amount);
    }

    public boolean wantsToPickUp(ItemStack item) {
        boolean twinkStat = true;
        if (!item.is(FlopItems.CVM.get())) {
            twinkStat = this.canReplaceCurrentItem(item);
        }
        return net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && this.canPickUpLoot() && twinkStat;
    }

    protected boolean canReplaceCurrentItem(ItemStack item) {
        EquipmentSlot slot = Mob.getEquipmentSlotForItem(item);
        ItemStack slotItem = this.getItemBySlot(slot);
        return this.canReplaceCurrentItem(item, slotItem);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        InteractionResult result = super.mobInteract(player, hand);
        if (result.consumesAction()) return result;
        else if (!this.level().isClientSide) return TwinkAI.mobInteract(this, player, hand);
        else {
            boolean canAdmire = TwinkAI.canAdmire(this, player.getItemInHand(hand));
            if (player.isHolding(FlopItems.CVM.get()) || player.isHolding(FlopItems.CVMIUM.get())) {
                this.getNavigation().moveTo(player.getX(), player.getY(), player.getZ(), 1);
            }
            return canAdmire ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
    }

    public void aiStep() {
        super.aiStep();
    }

    public static void init() {
    }

    public static boolean canSpawn(EntityType<Twink> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
    }
    private void setTypeVariant(int id) {
        this.entityData.set(TWINK_ID_DATATYPE_VARIANT, id);
    }
    private int getTypeVariant() {
        return this.entityData.get(TWINK_ID_DATATYPE_VARIANT);
    }
    public Variant getVariant() {
        return Variant.byId(this.getTypeVariant() & 255);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        Variant variant = Util.getRandom(Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    @Override
    public void onBreeding(Level pLevel) {
        this.spawnAtLocation(FlopItems.TWINK_EGG.get());
        RandomSource random = RandomSource.create();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        for (int i = 0; i < 4; i++) {
            double x0 = x + random.nextFloat();
            double y0 = y + random.nextFloat();
            double z0 = z + random.nextFloat();
            double dx = (random.nextFloat() - 0.5) * 0.5;
            double dy = (random.nextFloat() - 0.5) * 0.5;
            double dz = (random.nextFloat() - 0.5) * 0.5;

            this.level().addParticle(ParticleTypes.END_ROD, x0, y0, z0, dx, dy, dz);
        }
    }

    public enum Variant implements StringRepresentable {
        BLOND(0, "blond"),
        BEACH(1, "beach"),
        FLOWER(2, "flower"),
        PINK(3, "pink"),
        JIAFEIAN(4, "noirette");

        public static final Codec<Variant> CODEC = StringRepresentable.fromEnum(Variant::values);
        private static final IntFunction<Variant> BY_ID = ByIdMap.continuous(Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        public final int id;
        public final String name;
        Variant(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return this.id;
        }
        @Override
        public String getSerializedName() {
            return this.name;
        }
        public static Variant byId(int id) {
            return BY_ID.apply(id);
        }
    }
}
