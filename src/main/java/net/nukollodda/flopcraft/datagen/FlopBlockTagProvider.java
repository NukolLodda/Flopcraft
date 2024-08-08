package net.nukollodda.flopcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.datagen.tags.FlopTags;

import java.util.concurrent.CompletableFuture;

public class FlopBlockTagProvider extends BlockTagsProvider {
    public FlopBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Flopcraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(FlopTags.Blocks.BARBIE_LANTERN).add(FlopBlocks.BARBIE_LANTERN.get());
        this.tag(FlopTags.Blocks.SHENSEIUM_ORE).add(FlopBlocks.SHENSEIUM_ORE.get());

        this.tag(FlopTags.Blocks.BRAT_ORE).add(
                FlopBlocks.BRAT_ORE.get(),
                FlopBlocks.DEEPSLATE_BRAT_ORE.get());

        this.tag(FlopTags.Blocks.BRAT_BLOCK).add(FlopBlocks.BRAT_BLOCK.get());
        this.tag(FlopTags.Blocks.FLOPIUM_BLOCK).add(FlopBlocks.FLOPIUM_BLOCK.get());
        this.tag(FlopTags.Blocks.GAGASTONE_BLOCK).add(FlopBlocks.GAGASTONE_BLOCK.get());
        this.tag(FlopTags.Blocks.GAGINA_BLOCK).add(FlopBlocks.GAGINA_BLOCK.get());
        this.tag(FlopTags.Blocks.INFUSED_SLAGINIUM_BLOCK).add(FlopBlocks.INFUSED_SLAGINIUM_BLOCK.get());
        this.tag(FlopTags.Blocks.MYSTICAL_FLOPIUM_BLOCK).add(FlopBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
        this.tag(FlopTags.Blocks.SHENSEIUM_BLOCK).add(FlopBlocks.SHENSEIUM_BLOCK.get());
        this.tag(FlopTags.Blocks.SLAGINIUM_BLOCK).add(FlopBlocks.SLAGINIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                FlopBlocks.AESTHETIC_STORE_BLOCK.get(),
                FlopBlocks.BARBIE_LANTERN.get(),
                FlopBlocks.BRAT_ORE.get(),
                FlopBlocks.BRAT_BLOCK.get(),
                FlopBlocks.CVM_INFUSION_ALTER.get(),
                FlopBlocks.DEEPSLATE_BRAT_ORE.get(),
                FlopBlocks.FLOP_AIRLINE_TICKET_SCANNER.get(),
                FlopBlocks.FLOPBUCKS_BLOCK.get(),
                FlopBlocks.FLOPDONALDS_BLOCK.get(),
                FlopBlocks.FLOPIUM_BLOCK.get(),
                FlopBlocks.FLOPOTLE_BLOCK.get(),
                FlopBlocks.FLOP_AIRLINE_BLOCK.get(),
                FlopBlocks.GAGASTONE_BLOCK.get(),
                FlopBlocks.GAGINA_BLOCK.get(),
                FlopBlocks.HARDENED_PERIOD_CVM.get(),
                FlopBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                FlopBlocks.JIAFEI_EXPRESS_BLOCK.get(),
                FlopBlocks.LANCVM_BLOCK.get(),
                FlopBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                FlopBlocks.RANPAPI_BLOCK.get(),
                FlopBlocks.SHENSEIUM_BLOCK.get(),
                FlopBlocks.SLAGINIUM_BLOCK.get(),
                FlopBlocks.SHENSEIUM_ORE.get(),
                FlopBlocks.SPECIAL_YASSIFICATION_DETECTOR.get(),
                FlopBlocks.YASSIFICATION_DETECTOR.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                FlopBlocks.LOVELY_PEACH_LOG.get(),
                FlopBlocks.KAMALOCONUT_PALM_LOG.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                FlopBlocks.BARBIE_LANTERN.get(),
                FlopBlocks.LOVELY_PEACH_LOG.get(),
                FlopBlocks.KAMALOCONUT_PALM_LOG.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                FlopBlocks.CVM_INFUSION_ALTER.get(),
                FlopBlocks.SLAGINIUM_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                FlopBlocks.AESTHETIC_STORE_BLOCK.get(),
                FlopBlocks.BRAT_ORE.get(),
                FlopBlocks.BRAT_BLOCK.get(),
                FlopBlocks.DEEPSLATE_BRAT_ORE.get(),
                FlopBlocks.FLOP_AIRLINE_TICKET_SCANNER.get(),
                FlopBlocks.FLOPBUCKS_BLOCK.get(),
                FlopBlocks.FLOPDONALDS_BLOCK.get(),
                FlopBlocks.FLOPIUM_BLOCK.get(),
                FlopBlocks.FLOPOTLE_BLOCK.get(),
                FlopBlocks.FLOP_AIRLINE_BLOCK.get(),
                FlopBlocks.GAGASTONE_BLOCK.get(),
                FlopBlocks.GAGINA_BLOCK.get(),
                FlopBlocks.HARDENED_PERIOD_CVM.get(),
                FlopBlocks.INFUSED_SLAGINIUM_BLOCK.get(),
                FlopBlocks.JIAFEI_EXPRESS_BLOCK.get(),
                FlopBlocks.LANCVM_BLOCK.get(),
                FlopBlocks.MYSTICAL_FLOPIUM_BLOCK.get(),
                FlopBlocks.RANPAPI_BLOCK.get(),
                FlopBlocks.SHENSEIUM_BLOCK.get(),
                FlopBlocks.SHENSEIUM_ORE.get(),
                FlopBlocks.SPECIAL_YASSIFICATION_DETECTOR.get(),
                FlopBlocks.YASSIFICATION_DETECTOR.get()
        );

        this.tag(BlockTags.FENCES).add(FlopBlocks.LOVELY_PEACH_FENCE.get(), FlopBlocks.KAMALOCONUT_PALM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(FlopBlocks.LOVELY_PEACH_FENCE_GATE.get(), FlopBlocks.KAMALOCONUT_PALM_FENCE_GATE.get());
    }
}
