package slay.nukolussy.modussy.entities.flops.traders;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
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
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import javax.annotation.Nullable;
import java.util.Set;

public class Jiafei extends AbstractFlopTraders {
    private static final EntityDataAccessor<Integer> JIAFEI_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(Jiafei.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItem.JIAFEI_PRODUCT.get(), ModItem.SLAGINIUM.get(), ModItem.INFUSED_SLAGINIUM.get(), ModItem.FLOPIUM.get(), ModItem.MYSTICAL_FLOPIUM.get());

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
        this.goalSelector.addGoal(10, new FlopBreedingGoal(this, 1.0d));
        this.goalSelector.addGoal(11, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        int hurtNum = (int) (Math.random() * 3 + 1);
        String sound = "modussy:jiafei_" + hurtNum;
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(sound));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:jiafei_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        int dedNum = (int) (Math.random() * 2 + 1);
        String deathSound = "modussy:jiafei_death_" + dedNum;
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(deathSound));
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
            } else if (!item.equals(ModItem.JIAFEI_EGG.get()) && this.isAlive() && !this.isTrading() && !player.isSecondaryUseActive()) {
                boolean offerless = this.getOffers().isEmpty();

                if (!offerless) {
                    if (!this.level().isClientSide && !this.offers.isEmpty()) {
                        this.playSound(getNotifyTradeSound());
                        this.startTrading(player);
                    }
                } else {
                    this.playSound(ModSounds.JIAFEI_PRODUCTLESS.get());
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
        // mob should spawn under certain circumstance
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

    public void setVariant(JiafeiVariant variant) {
        this.setTypeVariant(variant.getId());
    }

    public int getJiafeiData() {
        return this.entityData.get(JIAFEI_ID_DATATYPE_VARIANT);
    }

    protected void updateTrades() {
        int jiafeiData = getJiafeiData();
        Int2ObjectMap<FlopTrades.ItemListing[]> int2objectmap = FlopTrades.TRADES.get(JiafeiVariant.byId(jiafeiData));
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
        JiafeiVariant variant = Util.getRandom(JiafeiVariant.values(), randomSource);
        setVariant(variant);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }
}