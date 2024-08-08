package net.nukollodda.flopcraft.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ToolsTag {
    public static TagKey<Block> MINEABLE_WITH_PICKAXOL = forgeTag("mineable/pickaxol");

    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(ResourceLocation.withDefaultNamespace("forge", name));
    }
}
