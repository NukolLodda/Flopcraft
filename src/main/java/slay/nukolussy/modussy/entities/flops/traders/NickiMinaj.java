package slay.nukolussy.modussy.entities.flops.traders;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Set;

public class NickiMinaj extends AbstractFlopTraders {
    private static final EntityDataAccessor<Integer> NICKI_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(NickiMinaj.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItems.HAIRUSSY.get(), ModItems.SLAGINIUM.get(), ModItems.INFUSED_SLAGINIUM.get());
    public NickiMinaj(PlayMessages.SpawnEntity spawnEntity, Level world) {
        super(spawnEntity.getEntity().getType(), world);
    }


    public NickiMinaj(EntityType<NickiMinaj> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 69);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 12);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);

        return builder;
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.NICKI_MINAJ.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
    }

    private void setTypeVariant(int id) {
        this.entityData.set(NICKI_ID_DATATYPE_VARIANT, id);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
    }

    @Override
    public MerchantOffers getOffers() {
        return super.getOffers();
    }

    @Override
    public void overrideOffers(MerchantOffers pOffers) {

    }

    protected void updateTrades() {
        Int2ObjectMap<FlopTrades.ItemListing[]> int2objectmap = FlopTrades.TRADES.get(Variant.VARIANT);
        if (int2objectmap != null && !int2objectmap.isEmpty()) {
            FlopTrades.ItemListing[] afloptrades$itemlisting = int2objectmap.get(1);
            if (afloptrades$itemlisting != null) {
                MerchantOffers merchantoffers = this.getOffers();
                this.addOffersFromItemListings(merchantoffers, afloptrades$itemlisting, 7);
            }
        }
    }

    private int getTypeVariant() {
        return this.entityData.get(NICKI_ID_DATATYPE_VARIANT);
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

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        int hurtVal = (int) (Math.random() * 2);
        return hurtVal == 1 ? ModSounds.NICKI_MINAJ_HURT1.get() : ModSounds.NICKI_MINAJ_HURT2.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.NICKI_MINAJ_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        int randVal = (int) (Math.random() * 3);
        return switch (randVal) {
            case 1 -> ModSounds.NICKI_MINAJ_1.get();
            case 2 -> ModSounds.NICKI_MINAJ_2.get();
            default -> ModSounds.NICKI_MINAJ_3.get();
        };
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (!this.level().isClientSide) {
            if (!item.equals(ModItems.NICKI_MINAJ_SPAWN_EGG.get()) && this.isAlive() && !this.isTrading() && !player.isSecondaryUseActive()) {
                if (!this.getOffers().isEmpty()) {
                    if (!(this.isTrading() || this.isInsidePortal || this.isUnderWater())) {
                        this.playSound(ModSounds.NICKI_MINAJ_TRADE.get());
                        player.stopUsingItem();
                        this.startTrading(player);
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
        this.entityData.define(NICKI_ID_DATATYPE_VARIANT, 0);
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

    private void startTrading(Player pPlayer) {
        this.setTradingPlayer(pPlayer);
        this.openTradingScreen(pPlayer, this.getDisplayName(), 1);
        this.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        this.getNavigation().stop();
    }

    public void setVariant(NickiMinaj.Variant variant) {
        this.setTypeVariant(variant.getId());
    }

    @Override
    public void notifyTradeUpdated(ItemStack pStack) {

    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int pXp) {

    }

    @javax.annotation.Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        RandomSource randomSource = level.getRandom();
        NickiMinaj.Variant variant = Util.getRandom(NickiMinaj.Variant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return ModSounds.NICKI_MINAJ_TRADE.get();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    public enum Variant implements FlopTraderVariants {
        VARIANT(0, "variant");

        private final int id;
        private final String name;

        Variant(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }

        @Override
        public int getId() {
            return id;
        }
    }
}
