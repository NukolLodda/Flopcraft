package slay.nukolussy.modussy.item.types;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import org.jetbrains.annotations.NotNull;


public class ModDiscs extends RecordItem {
    public ModDiscs(SoundEvent loc, int ticks) {
        super(0, () -> loc,
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE), ticks);
    }
    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable("item.minecraft.music_disc_5");
    }
}
