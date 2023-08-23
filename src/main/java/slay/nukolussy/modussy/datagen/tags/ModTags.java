package slay.nukolussy.modussy.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import slay.nukolussy.modussy.Modussy;

public class ModTags {

    public static final class Items {
        public static final TagKey<Item> BARBIE_CRYSTALS = createForge("gems/barbie");
        public static final TagKey<Item> SLAGINIUM_INGOT = createForge("ingots/slaginium");
        public static final TagKey<Item> INFUSED_SLAGINIUM_INGOT = createForge("ingots/infused_slaginium");
        public static final TagKey<Item> FLOPIUM = createForge("gems/flopium");
        public static final TagKey<Item> MYSTICAL_FLOPIUM = createForge("gems/mystical_flopium");
        public static final TagKey<Item> SHENSEIUM = createForge("gems/shenseium");
        public static final TagKey<Item> YASSIFER = createForge("yassifers/basic");
        public static final TagKey<Item> ADVANCED_YASSIFER = createForge("yassifers/advanced");
        public static final TagKey<Item> ELITE_YASSIFER = createForge("yassifers/elite");
        public static final TagKey<Item> ULTIMATE_YASSIFER = createForge("yassifers/ultimate");

        public static final TagKey<Item> BARBIE_LANTERN = createForge("blocks/barbie_lantern");

        public static final TagKey<Item> SHENSEIUM_ORE = createForge("ores/shenseium");

        public static final TagKey<Item> FLOPIUM_BLOCK = createForge("storage_blocks/flopium");
        public static final TagKey<Item> GAGASTONE_BLOCK = createForge("storage_blocks/gagastone");
        public static final TagKey<Item> GAGINA_BLOCK = createForge("storage_blocks/gagina");
        public static final TagKey<Item> INFUSED_SLAGINIUM_BLOCK = createForge("storage_blocks/infused_slaginium");
        public static final TagKey<Item> MYSTICAL_FLOPIUM_BLOCK = createForge("storage_blocks/mystical_flopium");
        public static final TagKey<Item> SHENSEIUM_BLOCK = createForge("storage_blocks/shenseium");
        public static final TagKey<Item> SLAGINIUM_BLOCK = createForge("storage_blocks/slaginium");

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

    public static final class EntityTypes {
        private static TagKey<EntityType<?>> create(String location) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(location));
        }
    }

    public static final class Blocks {
        public static final TagKey<Block> BARBIE_LANTERN = createForge("blocks/barbie_lantern");
        public static final TagKey<Block> SHENSEIUM_ORE = createForge("ores/shenseium");

        public static final TagKey<Block> FLOPIUM_BLOCK = createForge("storage_blocks/flopium");
        public static final TagKey<Block> GAGASTONE_BLOCK = createForge("storage_blocks/gagastone");
        public static final TagKey<Block> GAGINA_BLOCK = createForge("storage_blocks/gagina");
        public static final TagKey<Block> INFUSED_SLAGINIUM_BLOCK = createForge("storage_blocks/infused_slaginium");
        public static final TagKey<Block> MYSTICAL_FLOPIUM_BLOCK = createForge("storage_blocks/mystical_flopium");
        public static final TagKey<Block> SHENSEIUM_BLOCK = createForge("storage_blocks/shenseium");
        public static final TagKey<Block> SLAGINIUM_BLOCK = createForge("storage_blocks/slaginium");
        private static TagKey<Block> createForge(String loc) {
            return net.minecraft.tags.BlockTags.create(new ResourceLocation("forge", loc));
        }

        private static TagKey<Block> createModussy(String location) {
            return net.minecraft.tags.BlockTags.create(new ResourceLocation(Modussy.MODID, location));
        }
        private static TagKey<Block> create(String location) {
            return net.minecraft.tags.BlockTags.create(new ResourceLocation("minecraft", location));
        }
    }
}
