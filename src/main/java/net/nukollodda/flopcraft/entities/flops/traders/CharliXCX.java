package net.nukollodda.flopcraft.entities.flops.traders;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.datagen.tags.FlopTags;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSounds;

import java.util.Set;

public class CharliXCX extends AbstractIconicTraders {
    private static final EntityDataAccessor<Integer> CHARLI_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(CharliXCX.class, EntityDataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(FlopTags.Items.BRAT);

    public CharliXCX(PlayMessages.SpawnEntity spawnEntity, Level world) {
        super(spawnEntity.getEntity().getType(), world);
    }

    public CharliXCX(EntityType<CharliXCX> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 50);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 12);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);

        return builder;
    }

    public static void init() {
    }

    public static boolean canSpawn(EntityType<CharliXCX> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
    }

    private void setTypeVariant(int id) {
        this.entityData.set(CHARLI_ID_DATATYPE_VARIANT, id);
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
        return this.entityData.get(CHARLI_ID_DATATYPE_VARIANT);
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

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return FlopSounds.CHARLI_XCX_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return FlopSounds.CHARLI_XCX_DEATH.get();
    }

    @Override
    protected SoundEvent getTradelessSound() {
        return FlopSounds.CHARLI_XCX_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return switch (getRandom().nextInt(3)) {
            case 1 -> FlopSounds.CHARLI_XCX_1.get();
            case 2 -> FlopSounds.CHARLI_XCX_2.get();
            default -> FlopSounds.CHARLI_XCX_3.get();
        };
    }

    @Override
    protected boolean itemIsSpawnEgg(Item pItem) {
        return pItem.equals(FlopItems.CHARLI_XCX_SPAWN_EGG.get());
    }

    @Override
    protected boolean newYearsGifting(Player pPlayer) {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHARLI_ID_DATATYPE_VARIANT, 0);
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

    public void setVariant(Variant variant) {
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
    public void aiStep() {
        super.aiStep();

        Level level = Minecraft.getInstance().level;
        if (level != null && tickCount <= 120) {
            Vec3 loc = position();
            RandomSource random = getRandom();
            for (int i = 0; i < 4; i++) {
                double x = loc.x + random.nextFloat() - 0.5;
                double y = loc.y + random.nextFloat() - 0.5;
                double z = loc.z + random.nextFloat() - 0.5;

                double dx = (random.nextFloat() - 0.5) * 0.5;
                double dy = (random.nextFloat() - 0.5) * 0.5;
                double dz = (random.nextFloat() - 0.5) * 0.5;
                level.addParticle(ParticleTypes.POOF, x, y, z, dx, dy, dz);
            }
        }
    }

    @Override
    public void overrideXp(int pXp) {

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        setVariant(Variant.VARIANT);
        return super.finalizeSpawn(level, instance, type, data, tag);
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return FlopSounds.CHARLI_XCX_3.get();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    public enum Variant implements IFlopTraderVariant {
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
