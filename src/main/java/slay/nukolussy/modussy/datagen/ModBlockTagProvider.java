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
        this.tag(ModTags.Blocks.BARBIE_LANTERN).add(ModBlocks.BARBIE_LANTERN.get());
        this.tag(ModTags.Blocks.SHENSEIUM_ORE).add(ModBlocks.SHENSEIUM_ORE.get());
        this.tag(ModTags.Blocks.FLOPIUM_BLOCK).add(ModBlocks.FLOPIUM_BLOCK.get());
        this.tag(ModTags.Blocks.GAGASTONE_BLOCK).add(ModBlocks.GAGASTONE_BLOCK.get());
        this.tag(ModTags.Blocks.GAGINA_BLOCK).add(ModBlocks.GAGINA_BLOCK.get());
        this.tag(ModTags.Blocks.INFUSED_SLAGINIUM_BLOCK).add(ModBlocks.INFUSED_SLAGINIUM_BLOCK.get());
        this.tag(ModTags.Blocks.MYSTICAL_FLOPIUM_BLOCK).add(ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
        this.tag(ModTags.Blocks.SHENSEIUM_BLOCK).add(ModBlocks.SHENSEIUM_BLOCK.get());
        this.tag(ModTags.Blocks.SLAGINIUM_BLOCK).add(ModBlocks.SLAGINIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.AESTHETIC_STORE_BLOCK.get(),
                ModBlocks.BARBIE_LANTERN.get(),
                ModBlocks.CVM_INFUSION_ALTER.get(),
                ModBlocks.FLOP_AIRLINE_TICKET_SCANNER.get(),
                ModBlocks.FLOPBUCKS_BLOCK.get(),
                ModBlocks.FLOPDONALDS_BLOCK.get(),
                ModBlocks.FLOPIUM_BLOCK.get(),
                ModBlocks.FLOPOTLE_BLOCK.get(),
                ModBlocks.FLOP_AIRLINE_BLOCK.get(),
                ModBlocks.GAGASTONE_BLOCK.get(),
                ModBlocks.GAGINA_BLOCK.get(),
                ModBlocks.HARDENED_PERIOD_CVM.get(),
                ModBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                ModBlocks.JIAFEI_EXPRESS_BLOCK.get(),
                ModBlocks.LANCVM_BLOCK.get(),
                ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                ModBlocks.RANPAPI_BLOCK.get(),
                ModBlocks.SHENSEIUM_BLOCK.get(),
                ModBlocks.SLAGINIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_ORE.get(),
                ModBlocks.YASSIFICATION_DETECTOR.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.BARBIE_LANTERN.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.CVM_INFUSION_ALTER.get(),
                ModBlocks.SLAGINIUM_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.AESTHETIC_STORE_BLOCK.get(),
                ModBlocks.FLOP_AIRLINE_TICKET_SCANNER.get(),
                ModBlocks.FLOPBUCKS_BLOCK.get(),
                ModBlocks.FLOPDONALDS_BLOCK.get(),
                ModBlocks.FLOPIUM_BLOCK.get(),
                ModBlocks.FLOPOTLE_BLOCK.get(),
                ModBlocks.FLOP_AIRLINE_BLOCK.get(),
                ModBlocks.GAGASTONE_BLOCK.get(),
                ModBlocks.GAGINA_BLOCK.get(),
                ModBlocks.HARDENED_PERIOD_CVM.get(),
                ModBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                ModBlocks.JIAFEI_EXPRESS_BLOCK.get(),
                ModBlocks.LANCVM_BLOCK.get(),
                ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                ModBlocks.RANPAPI_BLOCK.get(),
                ModBlocks.SHENSEIUM_BLOCK.get(),
                ModBlocks.SHENSEIUM_ORE.get(),
                ModBlocks.YASSIFICATION_DETECTOR.get()
        );
    }
}
