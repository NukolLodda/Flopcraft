package slay.nukolussy.modussy.entities.flops.twink;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.client.renderer.twink.Variant;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItem;

import javax.annotation.Nullable;

public class Twink extends AbstractFlops {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Twink.class, EntityDataSerializers.INT);
    private final SimpleContainer inventory = new SimpleContainer(8);
    public Twink(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.TWINK.get(), world);
    }

    public Brain<Twink> getBrain() {
        return (Brain<Twink>) super.getBrain();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    protected void pickUpItem(ItemEntity item) {
        this.onItemPickup(item);
        TwinkAI.pickUpItem(this, item);
    }

    protected void holdInOffHand(ItemStack item) {
        if (item.is(ModItem.CVM.get())) {
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

    public Twink(EntityType<Twink> type, Level world) {
        super(type, world);
        this.setCanPickUpLoot(true);

        this.applyOpenDoorsAbility();
        xpReward = 0;
        setNoAi(false);

        setPersistenceRequired();
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
        this.goalSelector.addGoal(10, new FlopBreedingGoal(this, 1.0d));

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
    public boolean hurt(DamageSource source, float amount) {
        // if (source.is() || source == DamageSource.DROWN) they can't fall nor drown, please think of code for this
        return super.hurt(source, amount);
    }

    public boolean wantsToPickUp(ItemStack item) {
        boolean twinkStat = true;
        if (!item.is(ModItem.CVM.get())) {
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
            if (player.isHolding(ModItem.CVM.get()) || player.isHolding(ModItem.CVMIUM.get())) {
                this.getNavigation().moveTo(player.getX(), player.getY(), player.getZ(), 1);
            }
            if (item.equals(ModItem.CVMIUM.get())) {
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
        SpawnPlacements.register(ModEntities.TWINK.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
    }
    private void setTypeVariant(int id) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, id);
    }
    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    public Variant getVariant() {
        return Variant.byId(this.getTypeVariant() & 255);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();

        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 20);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);

        return builder;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        Variant variant = Util.getRandom(Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }
}
