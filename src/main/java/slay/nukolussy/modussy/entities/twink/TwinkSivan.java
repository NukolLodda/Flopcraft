package slay.nukolussy.modussy.entities.twink;

import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.AbstractModEntity;

import java.util.function.IntFunction;

public class TwinkSivan extends AbstractTwink {
    private static final EntityDataAccessor<Integer> TWINK_ID_DATATYPE_VARIANT = SynchedEntityData.defineId(TwinkSivan.class, EntityDataSerializers.INT);
    public TwinkSivan(EntityType<TwinkSivan> type, Level world) {
        super(type, world);
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
        this.setTypeVariant((int) (Math.random() * 4));
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

        public static final Codec<TwinkSivan.Variant> CODEC = StringRepresentable.fromEnum(TwinkSivan.Variant::values);
        private static final IntFunction<TwinkSivan.Variant> BY_ID = ByIdMap.continuous(TwinkSivan.Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
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
        public static TwinkSivan.Variant byId(int id) {
            return BY_ID.apply(id);
        }
    }
}
