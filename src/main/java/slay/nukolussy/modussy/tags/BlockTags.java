package slay.nukolussy.modussy.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import slay.nukolussy.modussy.Modussy;

public final class BlockTags {
    public static final TagKey<Block> SHENSIEUM_ORE = createForge("ores/shenseium");

    public static final TagKey<Block> FLOPIUM_BLOCK = createForge("storage_blocks/flopium");
    public static final TagKey<Block> GAGASTONE_BLOCK = createForge("storage_blocks/gagastone");
    public static final TagKey<Block> GAGINA_BLOCK = createForge("storage_blocks/");
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
