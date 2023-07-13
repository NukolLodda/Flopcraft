package slay.nukolussy.modussy.entities.flops.traders;

import com.mojang.serialization.Codec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum JiafeiVariant implements FlopTraderVariants {
    AESTHETIC(0, "aesthetic"),
    UTILITIES(1, "utilities"),
    MUSICIAN(2, "musician");

    public static final Codec<JiafeiVariant> CODEC = StringRepresentable.fromEnum(JiafeiVariant::values);
    private static final IntFunction<JiafeiVariant> BY_ID = ByIdMap.continuous(JiafeiVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);

    private final String name;
    private final int id;

    JiafeiVariant(int id, String name) {
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

    public static JiafeiVariant byId(int id) {
        return BY_ID.apply(id);
    }

}
