package slay.nukolussy.modussy.entities.flops.traders;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.IntFunction;

public class Jiafei extends AbstractFlopTraders {
    private static final EntityDataAccessor<Integer> JIAFEI_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Jiafei.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItem.JIAFEI_PRODUCT.get(), ModItem.SLAGINIUM.get(), ModItem.INFUSED_SLAGINIUM.get());

    public Jiafei(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public Jiafei(EntityType<Jiafei> type, Level world) {
        super(type, world);
    }

    private SoundEvent jiafeiEat() {
        int randVal = (int) (Math.random() * 3);
        return switch (randVal) {
            case 0 -> ModSounds.JIAFEI_EAT_3.get();
            case 1 -> ModSounds.JIAFEI_EAT_1.get();
            default -> ModSounds.JIAFEI_EAT_2.get();
        };
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(10, new FlopBreedingGoal(this, 1.0d));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        int hurtNum = (int) (Math.random() * 3 + 1);
        return switch(hurtNum) {
            case 1 -> ModSounds.JIAFEI_1.get();
            case 2 -> ModSounds.JIAFEI_2.get();
            default -> ModSounds.JIAFEI_3.get();
        };
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ModSounds.JIAFEI_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        int dedNum = (int) (Math.random() * 2 + 1);
        return dedNum == 1 ? ModSounds.JIAFEI_DEATH_1.get() : ModSounds.JIAFEI_DEATH_2.get();
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(ModItem.JIAFEI_PRODUCT.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItem.JIAFEI_PRODUCT.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                this.playSound(jiafeiEat());
                this.setInLove(player);
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            } else if (!item.equals(ModItem.JIAFEI_SPAWN_EGG.get()) && this.isAlive() && !this.isTrading() && !player.isSecondaryUseActive()) {
                if (this.getOffers().isEmpty()) {
                    this.playSound(ModSounds.JIAFEI_PRODUCTLESS.get());
                } else {
                    if (!this.level().isClientSide && !this.offers.isEmpty()) {
                        if (!(this.isTrading() || this.isInsidePortal || this.isUnderWater())) {
                            this.playSound(getNotifyTradeSound());
                            player.stopUsingItem();
                            this.startTrading(player);
                        }
                    }
                }
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }
        return result;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(JIAFEI_ID_DATATYPE_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        MerchantOffers offers = this.getOffers();
        tag.putInt("Variant", this.getTypeVariant());
        tag.put("Offers", offers.createTag());

        this.writeInventoryToTag(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setTypeVariant(tag.getInt("Variant"));
        this.offers = new MerchantOffers(tag.getCompound("Offers"));

        this.readInventoryFromTag(tag);
    }

    public void aiStep() {
        super.aiStep();
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.JIAFEI.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
    }

    private void setTypeVariant(int id) {
        this.entityData.set(JIAFEI_ID_DATATYPE_VARIANT, id);
    }

    private int getTypeVariant() {
        return this.entityData.get(JIAFEI_ID_DATATYPE_VARIANT);
    }

    @Override
    public MerchantOffers getOffers() {
        return super.getOffers();
    }

    @Override
    public void overrideOffers(MerchantOffers pOffers) {

    }

    public void setVariant(Variant variant) {
        this.setTypeVariant(variant.getId());
    }

    public int getJiafeiData() {
        return this.entityData.get(JIAFEI_ID_DATATYPE_VARIANT);
    }

    protected void updateTrades() {
        int data = getJiafeiData();
        Int2ObjectMap<FlopTrades.ItemListing[]> int2objectmap = FlopTrades.TRADES.get(Variant.byId(data));
        if (int2objectmap != null && !int2objectmap.isEmpty()) {
            FlopTrades.ItemListing[] afloptrades$itemlisting = int2objectmap.get(1);
            if (afloptrades$itemlisting != null) {
                MerchantOffers merchantoffers = this.getOffers();
                this.addOffersFromItemListings(merchantoffers, afloptrades$itemlisting, 7);
            }
        }
    }

    protected void addOffersFromItemListings(MerchantOffers pGivenMerchantOffers, FlopTrades.ItemListing[] pNewTrades, int pMaxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (pNewTrades.length > pMaxNumbers) {
            while(set.size() < pMaxNumbers) {
                set.add(this.random.nextInt(pNewTrades.length));
            }
        } else {
            for(int i = 0; i < pNewTrades.length; ++i) {
                set.add(i);
            }
        }

        for(Integer integer : set) {
            FlopTrades.ItemListing floptrades$itemlisting = pNewTrades[integer];
            MerchantOffer merchantoffer = floptrades$itemlisting.getOffer(this, this.random);
            if (merchantoffer != null) {
                pGivenMerchantOffers.add(merchantoffer);
            }
        }

    }

    @Override
    public void notifyTradeUpdated(ItemStack pStack) {
        getNotifyTradeSound();
    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int pXp) {

    }

    @Override
    public @NotNull SoundEvent getNotifyTradeSound() {
        int rand = (int)(Math.random() * 3);
        return switch(rand) {
            case 1 -> ModSounds.JIAFEI_TRADE_1.get();
            case 2 -> ModSounds.JIAFEI_TRADE_2.get();
            default -> ModSounds.JIAFEI_TRADE_3.get();
        };
    }

    private void startTrading(Player pPlayer) {
        this.setTradingPlayer(pPlayer);
        this.openTradingScreen(pPlayer, this.getDisplayName(), 1);
        this.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        this.getNavigation().stop();
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        Variant variant = Util.getRandom(Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    public enum Variant implements FlopTraderVariants {
        AESTHETIC(0, "aesthetic"),
        UTILITIES(1, "utilities"),
        MUSICIAN(2, "musician");

        public static final Codec<Variant> CODEC = StringRepresentable.fromEnum(Variant::values);
        private static final IntFunction<Variant> BY_ID = ByIdMap.continuous(Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        private final String name;
        private final int id;
        Variant(int id, String name) {
            this.name = name;
            this.id = id;
        }
        public int getId() {
            return this.id;
        }
        @Override
        public String getSerializedName() {
            return name;
        }
        public static Variant byId(int id) {
            return BY_ID.apply(id);
        }
    }
}