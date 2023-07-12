package slay.nukolussy.modussy.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import slay.nukolussy.modussy.Modussy;

public final class BlockTags {
    public static final TagKey<Block> SHENSIEUM_ORE = createForge("ores/shenseium");
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
