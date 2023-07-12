package slay.nukolussy.modussy.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import slay.nukolussy.modussy.Modussy;

public final class ItemTags {
    public static final TagKey<Item> SLAGINIUM_INGOT = createForge("ingots/slaginium");
    public static final TagKey<Item> INFUSED_SLAGINIUM_INGOT = createForge("ingots/infused_slaginium");
    public static final TagKey<Item> FLOPIUM = createForge("gems/flopium");
    public static final TagKey<Item> MYSTICAL_FLOPIUM = createForge("gems/mystical_flopium");
    public static final TagKey<Item> SHENSEIUM = createForge("gems/shenseium");
    public static final TagKey<Item> YASSIFER = createForge("yassifers/basic");
    public static final TagKey<Item> ADVANCED_YASSIFER = createForge("yassifers/advanced");
    public static final TagKey<Item> ELITE_YASSIFER = createForge("yassifers/elite");
    public static final TagKey<Item> ULTIMATE_YASSIFER = createForge("yassifers/ultimate");

    public static final TagKey<Item> SHENSEIUM_ORE = createForge("ores/shenseium");

    private static TagKey<Item> createForge(String loc) {
        return net.minecraft.tags.ItemTags.create(new ResourceLocation("forge", loc));
    }

    private static TagKey<Item> createModussy(String location) {
        return net.minecraft.tags.ItemTags.create(new ResourceLocation(Modussy.MODID, location));
    }
    private static TagKey<Item> create(String location) {
        return net.minecraft.tags.ItemTags.create(new ResourceLocation("minecraft", location));
    }
}
