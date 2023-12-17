package slay.nukolussy.modussy.entities.twink;

import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.AbstractModEntity;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.function.IntFunction;

public class TwinkSivan extends AbstractTwink {
    private static final EntityDataAccessor<Integer> TWINK_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(TwinkSivan.class, EntityDataSerializers.INT);
    public TwinkSivan(EntityType<TwinkSivan> type, Level world) {
        super(type, world);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return switch (this.random.nextInt(4)) {
            case 1 -> ModSounds.TWINK_SIVAN_1.get();
            case 2 -> ModSounds.TWINK_SIVAN_2.get();
            case 3 -> ModSounds.TWINK_SIVAN_3.get();
            default -> ModSounds.TWINK_SIVAN_4.get();
        };
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        // link here - https://youtu.be/0vArIdzT4K4?feature=shared
        return super.getDeathSound();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.random.nextBoolean() ? ModSounds.TWINK_SIVAN_HURT1.get() : ModSounds.TWINK_SIVAN_HURT2.get();
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(ModItems.CVM.get()) || itemStack.is(ModItems.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItems.CVM.get()) || item.equals(ModItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                player.spawnAtLocation(ModItems.TWINK_EGG.get());

                this.playSound(ModSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.IS_DROWNING) || source.is(DamageTypeTags.IS_FIRE) ||
                source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypeTags.IS_LIGHTNING) ||
                source.is(DamageTypeTags.IS_EXPLOSION) || source.is(DamageTypeTags.IS_FREEZING)) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    public void aiStep() {
        if (this.hasEffect(ModEffects.CVMMED.get()) && this.random.nextInt(6971) == 0) {
            this.sendSystemMessage(Component.literal("Twink Sivan - ").append(Component.translatable("subtitle.twink_sivan_sex")
                    .append(": https://youtu.be/K1TtnxaPRms?feature=shared")));
        }
        super.aiStep();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean canMate(AbstractModEntity pEntity) {
        return false;
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

    public void setVariant(Twink.Variant variant) {
        this.setTypeVariant(variant.getId());
    }

    public void setRandomVariant() {
        this.setTypeVariant(this.random.nextInt(4));
    }
    private void setTypeVariant(int id) {
        this.entityData.set(TWINK_ID_DATATYPE_VARIANT, id);
    }
    private int getTypeVariant() {
        return this.entityData.get(TWINK_ID_DATATYPE_VARIANT);
    }
    public Twink.Variant getVariant() {
        return Twink.Variant.byId(this.getTypeVariant() & 255);
    }

    public enum Variant implements StringRepresentable {
        RUSH(0, "rush"),
        STARTED(1, "started"),
        BATH(2, "bath"),
        VEST(3, "vest"); // girlboss sivan is his own entity

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
