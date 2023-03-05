package slay.nukolussy.modussy.client.renderer.twink;


import java.util.Arrays;
import java.util.Comparator;

public enum Variant {
    FEM(0),
    SUIT(1),
    FLOWER(2),
    FLANNEL(3);


    private static final Variant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(Variant::getId)).toArray(Variant[]::new);
    private final int id;

    private Variant(int p_30984_) {
        this.id = p_30984_;
    }

    public int getId() {
        return this.id;
    }

    public static Variant byId(int p_30987_) {
        return BY_ID[p_30987_ % BY_ID.length];
    }
}
