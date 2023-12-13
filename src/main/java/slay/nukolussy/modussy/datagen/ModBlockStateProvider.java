package slay.nukolussy.modussy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Modussy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AESTHETIC_STORE_BLOCK);
        blockWithItem(ModBlocks.BARBIE_LANTERN);
        blockWithItem(ModBlocks.FLOPBUCKS_BLOCK);
        blockWithItem(ModBlocks.FLOPDONALDS_BLOCK);
        blockWithItem(ModBlocks.FLOPIUM_BLOCK);
        blockWithItem(ModBlocks.FLOPOTLE_BLOCK);
        blockWithItem(ModBlocks.FLOP_AIRLINE_BLOCK);
        blockWithItem(ModBlocks.FLOP_AIRLINE_TELEPORTER);
        blockWithItem(ModBlocks.GAGASTONE_BLOCK);
        blockWithItem(ModBlocks.GAGINA_BLOCK);
        blockWithItem(ModBlocks.HARDENED_PERIOD_CVM);
        blockWithItem(ModBlocks.INFUSED_SLAGINIUM_BLOCK);
        blockWithItem(ModBlocks.JIAFEI_EXPRESS_BLOCK);
        blockWithItem(ModBlocks.LANCVM_BLOCK);
        blockWithItem(ModBlocks.MYSTICAL_FLOPIUM_BLOCK);
        blockWithItem(ModBlocks.RANPAPI_BLOCK);
        blockWithItem(ModBlocks.SHENSEIUM_BLOCK);
        blockWithItem(ModBlocks.SLAGINIUM_BLOCK);
        blockWithItem(ModBlocks.SHENSEIUM_ORE);
        blockWithItem(ModBlocks.LOVELY_PEACH_PLANKS);

        saplingBlock(ModBlocks.LOVELY_PEACH_SAPLING);

        stairsBlock((StairBlock) ModBlocks.LOVELY_PEACH_STAIRS.get(), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.LOVELY_PEACH_SLABS.get(),
                blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.LOVELY_PEACH_BUTTON.get(), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.LOVELY_PEACH_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.LOVELY_PEACH_FENCE.get(), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.LOVELY_PEACH_FENCE_GATE.get(), blockTexture(ModBlocks.LOVELY_PEACH_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.LOVELY_PEACH_DOOR.get(),
                modLoc("block/lovely_peach_door_bottom"), modLoc("block/lovely_peach_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.LOVELY_PEACH_TRAPDOOR.get(),
                modLoc("block/lovely_peach_trapdoor"), true, "cutout");
    }
    
    private void blockWithItem(RegistryObject<Block> registryBlock) {
        simpleBlockWithItem(registryBlock.get(), cubeAll(registryBlock.get()));
    }

    private void saplingBlock(RegistryObject<Block> registryBlock) {
        simpleBlock(registryBlock.get(),
                models().crop(ForgeRegistries.BLOCKS.getKey(registryBlock.get()).getPath(), blockTexture(registryBlock.get())).renderType("cutout"));
    }
}
