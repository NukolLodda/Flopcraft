package net.nukollodda.flopcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.FlopBlocks;

import java.util.Objects;

public class FlopBlockStateProvider extends BlockStateProvider {
    public FlopBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Flopcraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(FlopBlocks.AESTHETIC_STORE_BLOCK);
        blockWithItem(FlopBlocks.BARBIE_LANTERN);
        blockWithItem(FlopBlocks.BRAT_ORE);
        blockWithItem(FlopBlocks.BRAT_BLOCK);
        blockWithItem(FlopBlocks.DEEPSLATE_BRAT_ORE);
        blockWithItem(FlopBlocks.FLOPBUCKS_BLOCK);
        blockWithItem(FlopBlocks.FLOPDONALDS_BLOCK);
        blockWithItem(FlopBlocks.FLOPIUM_BLOCK);
        blockWithItem(FlopBlocks.FLOPOTLE_BLOCK);
        blockWithItem(FlopBlocks.FLOP_AIRLINE_BLOCK);
        blockWithItem(FlopBlocks.FLOP_AIRLINE_TELEPORTER);
        blockWithItem(FlopBlocks.GAGASTONE_BLOCK);
        blockWithItem(FlopBlocks.GAGINA_BLOCK);
        blockWithItem(FlopBlocks.HARDENED_PERIOD_CVM);
        blockWithItem(FlopBlocks.INFUSED_SLAGINIUM_BLOCK);
        blockWithItem(FlopBlocks.JIAFEI_EXPRESS_BLOCK);
        blockWithItem(FlopBlocks.LANCVM_BLOCK);
        blockWithItem(FlopBlocks.MYSTICAL_FLOPIUM_BLOCK);
        blockWithItem(FlopBlocks.RANPAPI_BLOCK);
        blockWithItem(FlopBlocks.SHENSEIUM_BLOCK);
        blockWithItem(FlopBlocks.SLAGINIUM_BLOCK);
        blockWithItem(FlopBlocks.SHENSEIUM_ORE);
        blockWithItem(FlopBlocks.LOVELY_PEACH_PLANKS);
        blockWithItem(FlopBlocks.KAMALOCONUT_PALM_PLANKS);

        saplingBlock(FlopBlocks.LOVELY_PEACH_SAPLING);
        saplingBlock(FlopBlocks.KAMALOCONUT_PALM_SAPLING);

        stairsBlock((StairBlock) FlopBlocks.LOVELY_PEACH_STAIRS.get(), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        slabBlock((SlabBlock) FlopBlocks.LOVELY_PEACH_SLABS.get(),
                blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        buttonBlock((ButtonBlock) FlopBlocks.LOVELY_PEACH_BUTTON.get(), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) FlopBlocks.LOVELY_PEACH_PRESSURE_PLATE.get(), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        fenceBlock((FenceBlock) FlopBlocks.LOVELY_PEACH_FENCE.get(), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) FlopBlocks.LOVELY_PEACH_FENCE_GATE.get(), blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) FlopBlocks.LOVELY_PEACH_DOOR.get(),
                modLoc("block/lovely_peach_door_bottom"), modLoc("block/lovely_peach_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) FlopBlocks.LOVELY_PEACH_TRAPDOOR.get(),
                modLoc("block/lovely_peach_trapdoor"), true, "cutout");

        signBlock((StandingSignBlock) FlopBlocks.LOVELY_PEACH_SIGN.get(), (WallSignBlock) FlopBlocks.LOVELY_PEACH_WALL_SIGN.get(),
                blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        hangingSignBlock(FlopBlocks.LOVELY_PEACH_HANGING_SIGN.get(), FlopBlocks.LOVELY_PEACH_WALL_HANGING_SIGN.get(),
                blockTexture(FlopBlocks.LOVELY_PEACH_PLANKS.get()));


        stairsBlock((StairBlock) FlopBlocks.KAMALOCONUT_PALM_STAIRS.get(), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        slabBlock((SlabBlock) FlopBlocks.KAMALOCONUT_PALM_SLABS.get(),
                blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        buttonBlock((ButtonBlock) FlopBlocks.KAMALOCONUT_PALM_BUTTON.get(), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) FlopBlocks.KAMALOCONUT_PALM_PRESSURE_PLATE.get(), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        fenceBlock((FenceBlock) FlopBlocks.KAMALOCONUT_PALM_FENCE.get(), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) FlopBlocks.KAMALOCONUT_PALM_FENCE_GATE.get(), blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) FlopBlocks.KAMALOCONUT_PALM_DOOR.get(),
                modLoc("block/kamaloconut_palm_door_bottom"), modLoc("block/kamaloconut_palm_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) FlopBlocks.KAMALOCONUT_PALM_TRAPDOOR.get(),
                modLoc("block/kamaloconut_palm_trapdoor"), true, "cutout");

        signBlock((StandingSignBlock) FlopBlocks.KAMALOCONUT_PALM_SIGN.get(), (WallSignBlock) FlopBlocks.KAMALOCONUT_PALM_WALL_SIGN.get(),
                blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        hangingSignBlock(FlopBlocks.KAMALOCONUT_PALM_HANGING_SIGN.get(), FlopBlocks.KAMALOCONUT_PALM_WALL_HANGING_SIGN.get(),
                blockTexture(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
    }

    private void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    private void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }
    
    private void blockWithItem(RegistryObject<Block> registryBlock) {
        simpleBlockWithItem(registryBlock.get(), cubeAll(registryBlock.get()));
    }

    private void saplingBlock(RegistryObject<Block> registryBlock) {
        simpleBlock(registryBlock.get(),
                models().crop(ForgeRegistries.BLOCKS.getKey(registryBlock.get()).getPath(), blockTexture(registryBlock.get())).renderType("cutout"));
    }
}
