package net.nukollodda.flopcraft.entities.flops;

import net.minecraft.util.StringRepresentable;
import net.nukollodda.flopcraft.entities.flops.traders.IFlopTraderVariant;

public class Flop {
    public enum FlopJobs implements IFlopTraderVariant {
        // determines outer layer && trades, none meaning they don't have a trade
        NONE(0, "none"),
        FLOPDONALDS(1, "flopdonalds"),
        FLOPBUCKS(2, "flopbucks"),
        FLOPOTLE(3, "flopotle"),
        JIAFEI_EXPRESS(4, "jiafei_express"),
        LANCVM(5, "lancvm"),
        AESTHETIC(6, "aesthetic"),
        REMIXER(7, "remixer");

        private final String name;
        private final int id;

        FlopJobs(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        @Override
        public int getId() {
            return this.id;
        }
    }

    public enum FlopVariant implements StringRepresentable {
        // determines inner layer
        MERFLOP(0, "merflop"), // of Cupcakkia
        JIAFEIAN(1, "jiafeian"), // of Jiafeia
        POTAXIE(2, "potaxie"), // of Potaxiene
        BADUSIAN(3, "barbie"), // of New Barbados
        PEACHUSSIAN(4, "peachussian"); // of CVM
        private final String name;
        private final int id;

        FlopVariant(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
