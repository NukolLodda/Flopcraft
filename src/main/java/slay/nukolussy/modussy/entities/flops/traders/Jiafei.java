package slay.nukolussy.modussy.entities.flops.traders;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import slay.nukolussy.modussy.entities.AbstractModEntity;
import slay.nukolussy.modussy.entities.goal.ModussyBreedingGoal;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.IntFunction;

public class Jiafei extends AbstractFlopTraders {
    private static final EntityDataAccessor<Integer> JIAFEI_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Jiafei.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItems.JIAFEI_PRODUCT.get(), ModItems.SLAGINIUM.get(), ModItems.INFUSED_SLAGINIUM.get());

    public Jiafei(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public Jiafei(EntityType<Jiafei> type, Level world) {
        super(type, world);
    }

    protected SoundEvent getEatSound() {
        int randVal = this.random.nextInt(3);
        return switch (randVal) {
            case 1 -> ModSounds.JIAFEI_EAT_1.get();
            case 2 -> ModSounds.JIAFEI_EAT_2.get();
            default -> ModSounds.JIAFEI_EAT_3.get();
        };
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, FOOD_ITEMS, false));
        this.goalSelector.addGoal(10, new ModussyBreedingGoal(this, 1.0d));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        if (ModUtil.isNewYears()) {
            return ModSounds.JIAFEI_NEW_YEARS.get();
        }
        int hurtNum = this.random.nextInt(3);
        return switch(hurtNum) {
            case 1 -> ModSounds.JIAFEI_1.get();
            case 2 -> ModSounds.JIAFEI_2.get();
            default -> ModSounds.JIAFEI_3.get();
        };
    }

    @Override
    protected SoundEvent getTradelessSound() {
        return ModSounds.JIAFEI_PRODUCTLESS.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ModSounds.JIAFEI_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        int dedNum = this.random.nextInt(2);
        return dedNum == 1 ? ModSounds.JIAFEI_DEATH_1.get() : ModSounds.JIAFEI_DEATH_2.get();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(JIAFEI_ID_DATATYPE_VARIANT, 0);
    }

    @Override
    protected boolean itemIsFood(Item pItem) {
        return pItem.equals(ModItems.JIAFEI_PRODUCT.get());
    }

    @Override
    protected boolean itemIsSpawnEgg(Item pItem) {
        return pItem.equals(ModItems.JIAFEI_SPAWN_EGG.get());
    }

    @Override
    protected void newYearsGifting(Player pPlayer) {
        if (ModUtil.isNewYears() && !PlayerMethods.isNewgen(pPlayer)) {
            this.spawnAtLocation(ModItems.HUNBAO.get());
            this.level().playSound(null, new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ()),
                    ModSounds.JIAFEI_NEW_YEARS_TRADE.get(), SoundSource.AMBIENT);
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

    public static boolean canSpawn(EntityType<Jiafei> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
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
            FlopTrades.ItemListing tradelisting = pNewTrades[integer];
            MerchantOffer merchantoffer = tradelisting.getOffer(this, this.random);
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
        if (ModUtil.isNewYears()) {
            return ModSounds.JIAFEI_NEW_YEARS_TRADE.get();
        }
        int rand = this.random.nextInt(3);
        return switch(rand) {
            case 1 -> ModSounds.JIAFEI_TRADE_1.get();
            case 2 -> ModSounds.JIAFEI_TRADE_2.get();
            default -> ModSounds.JIAFEI_TRADE_3.get();
        };
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        Variant variant = Util.getRandom(Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    public boolean canMate(AbstractModEntity flops) {
        if (flops == this || flops.getClass() != this.getClass()) {
            return super.canMate(flops);
        } else {
            return this.isInLove() && flops.isInLove();
        }
    }

    @Override
    public void onBreeding(Level pLevel) {
        this.spawnAtLocation(ModItems.JIAFEI_SEED.get());
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

            this.level().addParticle(ParticleTypes.HEART, x0, y0, z0, dx, dy, dz);
        }
    }

    public enum Variant implements IFlopTraderVariant {
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