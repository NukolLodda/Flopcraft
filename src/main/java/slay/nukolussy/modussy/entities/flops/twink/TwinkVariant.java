package slay.nukolussy.modussy.entities.flops.twink;


import com.mojang.serialization.Codec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum TwinkVariant implements StringRepresentable {
    BEACH(0, "beach"),
    FLOWER(1, "flower"),
    PINK(2, "pink");



    public static final Codec<TwinkVariant> CODEC = StringRepresentable.fromEnum(TwinkVariant::values);
    private static final IntFunction<TwinkVariant> BY_ID = ByIdMap.continuous(TwinkVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    public final int id;
    public final String name;

    TwinkVariant(int id, String name) {
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

    public static TwinkVariant byId(int id) {
        return BY_ID.apply(id);
    }

}
