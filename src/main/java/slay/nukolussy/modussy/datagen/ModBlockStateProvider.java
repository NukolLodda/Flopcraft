package slay.nukolussy.modussy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }
    
    private void blockWithItem(RegistryObject<Block> registryObject) {
        simpleBlockWithItem(registryObject.get(), cubeAll(registryObject.get()));
    }
}
