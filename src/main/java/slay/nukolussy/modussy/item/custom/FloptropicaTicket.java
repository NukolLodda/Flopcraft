package slay.nukolussy.modussy.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

public class FloptropicaTicket extends Item {
    public FloptropicaTicket() {
        super(new Item.Properties().tab(ModCreativeTabs.CVMSUMABLES).rarity(Rarity.RARE));
    }
}
