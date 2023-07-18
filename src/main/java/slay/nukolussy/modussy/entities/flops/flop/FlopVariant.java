package slay.nukolussy.modussy.entities.flops.flop;

import net.minecraft.util.StringRepresentable;

public enum FlopVariant implements StringRepresentable {
    MERFLOP(0, "merflop"),
    JIAFEIAN(1, "jiafeian"),
    POTAXIE(2, "potaxie"),
    BADUSIAN(3, "badussian"),
    PEACHUSSIAN(4, "peachussian");
    private final String name;

    FlopVariant(int id, String name) {
        this.name = name;
    }
    @Override
    public String getSerializedName() {
        return this.name;
    }
}
