package slay.nukolussy.modussy.item.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundItems extends RecordItem {
    public SoundItems(String loc, int ticks) {
        super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(loc)),
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE), ticks);
    }
}
