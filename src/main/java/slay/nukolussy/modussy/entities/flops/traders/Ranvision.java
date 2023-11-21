package slay.nukolussy.modussy.entities.flops.traders;


import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.IntFunction;

public class Ranvision extends AbstractFlopTraders {
    private static final EntityDataAccessor<Integer> RANVISION_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Ranvision.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItems.CUPCAKE.get(), ModItems.SLAGINIUM.get(), ModItems.INFUSED_SLAGINIUM.get());

    public Ranvision(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public Ranvision(EntityType<Ranvision> type, Level world) {
        super(type, world);
    }


    protected SoundEvent getEatSound() {
        return ModSounds.RANVISION_EAT.get();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, FOOD_ITEMS, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        int randVal = this.random.nextInt(5);
        return switch (randVal) {
            case 1 -> ModSounds.RANVISION_1.get();
            case 2 -> ModSounds.RANVISION_2.get();
            case 3 -> ModSounds.RANVISION_3.get();
            case 4 -> ModSounds.RANVISION_4.get();
            default -> ModSounds.RANVISION_5.get();
        };
    }

    @Override
    protected SoundEvent getTradelessSound() {
        return ModSounds.RANVISION_TRADELESS.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.PLAYER_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RANVISION_ID_DATATYPE_VARIANT, 0);
    }

    @Override
    protected boolean itemIsFood(Item pItem) {
        return false;
    }

    @Override
    protected boolean itemIsSpawnEgg(Item pItem) {
        return pItem.equals(ModItems.RANVISION_SPAWN_EGG.get());
    }

    @Override
    protected void newYearsGifting(Player pPlayer) {
        if (ModUtil.isNewYears() && !PlayerMethods.isNewgen(pPlayer)) {
            this.spawnAtLocation(ModItems.HUNBAO.get());
        }
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
    }

    public static boolean canSpawn(EntityType<Ranvision> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
    }


    private void setTypeVariant(int id) {
        this.entityData.set(RANVISION_ID_DATATYPE_VARIANT, id);
    }

    private int getTypeVariant() {
        return this.entityData.get(RANVISION_ID_DATATYPE_VARIANT);
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

    public int getRanvisionData() {
        return this.entityData.get(RANVISION_ID_DATATYPE_VARIANT);
    }

    protected void updateTrades() {
        int data = getRanvisionData();
        Int2ObjectMap<FlopTrades.ItemListing[]> trades = FlopTrades.TRADES.get(Variant.byId(data));
        if (trades != null && !trades.isEmpty()) {
            FlopTrades.ItemListing[] tradelisting = trades.get(1);
            if (tradelisting != null) {
                MerchantOffers merchantoffers = this.getOffers();
                this.addOffersFromItemListings(merchantoffers, tradelisting, 7);
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
        return this.random.nextInt(2) == 1 ? ModSounds.RANVISION_TRADE_1.get() : ModSounds.RANVISION_TRADE_2.get();
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        Variant variant = Util.getRandom(Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    public enum Variant implements IFlopTraderVariant {
        KPOP(0, "kpop"),
        CULTURAL(1, "cultural"),
        POP(2, "pop"),
        EVENT(3, "event");

        public static final Codec<Ranvision.Variant> CODEC = StringRepresentable.fromEnum(Ranvision.Variant::values);
        private static final IntFunction<Ranvision.Variant> BY_ID = ByIdMap.continuous(Ranvision.Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        final int id;
        final String name;
        Variant(int pId, String pName) {
            this.id = pId;
            this.name = pName;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
        public static Ranvision.Variant byId(int id) {
            return BY_ID.apply(id);
        }
    }
}
