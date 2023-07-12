package slay.nukolussy.modussy.client.renderer.twink;


import com.mojang.serialization.Codec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public enum Variant implements StringRepresentable {
    BEACH(0, "beach"),
    FLOWER(1, "flower"),
    PINK(2, "pink");



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

    public static Variant byId(int id) {
        return BY_ID.apply(id);
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
