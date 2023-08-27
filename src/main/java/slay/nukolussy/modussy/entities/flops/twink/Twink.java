package slay.nukolussy.modussy.entities.flops.twink;

import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItems;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class Twink extends AbstractFlops implements Npc {
    // Nukol is following the rule that thou shall always be horknee
    private static final EntityDataAccessor<Integer> TWINK_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Twink.class, EntityDataSerializers.INT);
    private final SimpleContainer inventory = new SimpleContainer(8);
    public Twink(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.TWINK.get(), world);
    }

    public Twink(EntityType<Twink> type, Level world) {
        super(type, world);
        this.setCanPickUpLoot(true);

        this.applyOpenDoorsAbility();
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
        if (item.is(ModItems.CVM.get())) {
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


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, FOOD_ITEMS, false));
        this.goalSelector.addGoal(9, new FlopBreedingGoal(this, 1.0d));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Monster.class, 10.0f, 1.2, 1.2));

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
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.genertic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.genertic.hurt"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
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
        if (!item.is(ModItems.CVM.get())) {
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
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (result.consumesAction()) return result;
        else if (!this.level().isClientSide) return TwinkAI.mobInteract(this, player, hand);
        else {
            boolean flag = TwinkAI.canAdmire(this, player.getItemInHand(hand));
            if (player.isHolding(ModItems.CVM.get()) || player.isHolding(ModItems.CVMIUM.get())) {
                this.getNavigation().moveTo(player.getX(), player.getY(), player.getZ(), 1);
            }
            if (item.equals(ModItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                this.setInLove(player);
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
            return flag ? InteractionResult.SUCCESS : InteractionResult.PASS;
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

    public enum Variant implements StringRepresentable {
        BLOND(0, "blond"),
        BEACH(1, "beach"),
        FLOWER(2, "flower"),
        PINK(3, "pink"),
        JIAFEIAN(4, "noirette")
        /*
        TANNED(5, "tanned")
         */;

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
