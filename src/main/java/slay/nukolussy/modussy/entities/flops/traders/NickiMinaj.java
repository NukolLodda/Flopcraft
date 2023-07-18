package slay.nukolussy.modussy.entities.flops.traders;

public class NickiMinaj /*extends AbstractFlopTraders*/ {
    public enum Variant implements FlopTraderVariants {
        COOK(0, "cook"),
        TOYMAKER(1, "toymaker");

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
