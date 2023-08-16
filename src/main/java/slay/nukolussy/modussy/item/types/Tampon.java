package slay.nukolussy.modussy.item.types;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class Tampon extends ArrowItem {
    public Tampon() {
        super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
    }
}
