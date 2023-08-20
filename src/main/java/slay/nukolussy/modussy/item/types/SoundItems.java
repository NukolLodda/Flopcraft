package slay.nukolussy.modussy.item.types;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;


public class SoundItems extends RecordItem {
    private final String fragment;
    public SoundItems(SoundEvent loc, int ticks, String fragment) {
        super(0, () -> loc,
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE), ticks);
        this.fragment = fragment;
    }
}
