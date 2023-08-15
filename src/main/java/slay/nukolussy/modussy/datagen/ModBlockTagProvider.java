package slay.nukolussy.modussy.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.datagen.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Modussy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.SHENSEIUM_ORE).add(ModBlocks.SHENSEIUM_ORE.get());
        this.tag(ModTags.Blocks.FLOPIUM_BLOCK).add(ModBlocks.FLOPIUM_BLOCK.get());
        this.tag(ModTags.Blocks.GAGASTONE_BLOCK).add(ModBlocks.GAGASTONE_BLOCK.get());
        this.tag(ModTags.Blocks.GAGINA_BLOCK).add(ModBlocks.GAGINA_BLOCK.get());
        this.tag(ModTags.Blocks.INFUSED_SLAGINIUM_BLOCK).add(ModBlocks.INFUSED_SLAGINIUM_BLOCK.get());
        this.tag(ModTags.Blocks.MYSTICAL_FLOPIUM_BLOCK).add(ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
        this.tag(ModTags.Blocks.SHENSEIUM_BLOCK).add(ModBlocks.SHENSEIUM_BLOCK.get());
        this.tag(ModTags.Blocks.SLAGINIUM_BLOCK).add(ModBlocks.SLAGINIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.FLOPIUM_BLOCK.get(),
                ModBlocks.GAGASTONE_BLOCK.get(),
                ModBlocks.GAGINA_BLOCK.get(),
                ModBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_BLOCK.get(),
                ModBlocks.SLAGINIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_ORE.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.CVM_INFUSION_ALTER.get(),
                ModBlocks.SLAGINIUM_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.FLOPIUM_BLOCK.get(),
                ModBlocks.GAGASTONE_BLOCK.get(),
                ModBlocks.GAGINA_BLOCK.get(),
                ModBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_ORE.get()
        );
    }
}