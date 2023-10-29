package slay.nukolussy.modussy.entities.flops.traders;


import com.mojang.serialization.Codec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public class Ranvision {
    public enum Variant implements IFlopTraderVariant {
        KPOP(0, "kpop"), // modussy discs c1, c5, c10, c14, cpm1
        CULTURAL(1, "cultural"), // modussy discs c4, c8, c11, c17, c18
        POP(2, "pop"), // modussy discs c6, c7, c9, cj1, j3
        EVENT(3, "event"); // modussy discs c23, c24, j5, pm1, ranvision
        // the first two trades will be iron in exchange for slaginium and
        // slaginium in exchange for the ranpapi tablet - the musical tablet

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
