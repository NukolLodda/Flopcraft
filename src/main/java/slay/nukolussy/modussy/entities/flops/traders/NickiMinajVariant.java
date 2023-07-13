package slay.nukolussy.modussy.entities.flops.traders;

public enum NickiMinajVariant implements FlopTraderVariants {
    DEFAULT(0, "default");

    private final int id;
    private final String name;

    NickiMinajVariant(int id, String name) {
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
