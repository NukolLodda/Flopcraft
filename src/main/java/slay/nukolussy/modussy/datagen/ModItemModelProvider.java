package slay.nukolussy.modussy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Modussy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BARBIE_CRYSTALS);
        simpleItem(ModItems.BLOOD_CLUMP);
        simpleItem(ModItems.BLOODY_TAMPON);
        simpleItem(ModItems.CLITMAS_BUTTPLUG);
        simpleItem(ModItems.CUPCAKE);
        simpleItem(ModItems.CVM);
        simpleItem(ModItems.CVMIUM);
        simpleItem(ModItems.CVM_PIE);
        simpleItem(ModItems.EXTRA_BLOODY_TAMPON);
        simpleItem(ModItems.CLITMAS_PRESENT);
        simpleItem(ModItems.REMIX_PRESENT);
        simpleItem(ModItems.FLOPTROPICA_TICKET);
        simpleItem(ModItems.JIAFEI_PRODUCT);
        simpleItem(ModItems.JIAFEI_PERFUME);
        simpleItem(ModItems.JIAFEI_SEED);
        simpleItem(ModItems.KYLIE_JENNER_LIPSTICK);
        simpleItem(ModItems.LANCVM_CREAM);
        simpleItem(ModItems.LOVELY_PEACH);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_PLUS);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_PREMIUM);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_DELUXE);
        simpleItem(ModItems.SLAGINIUM_PICKAXOL);
        simpleItem(ModItems.ROSETOY);
        simpleItem(ModItems.INFUSED_SLAGINIUM_PICKAXOL);
        simpleItem(ModItems.FLOPIUM_PICKAXOL);
        simpleItem(ModItems.MYSTICAL_FLOPIUM_PICKAXOL);
        simpleItem(ModItems.ARANA_GRANDE);
        simpleItem(ModItems.JIAFEI_AXE);
        simpleItem(ModItems.JIAFEI_HAMMER);
        simpleItem(ModItems.JIAFEI_SICKLE);
        simpleItem(ModItems.JIAFEI_PICKAXE);
        simpleItem(ModItems.JIAFEI_SHOVEL);
        simpleItem(ModItems.JIAFEI_BOOTS);
        simpleItem(ModItems.JIAFEI_LEGGINGS);
        simpleItem(ModItems.JIAFEI_CHESTPLATE);
        simpleItem(ModItems.JIAFEI_HELMET);
        simpleItem(ModItems.DEELDO);
        simpleItem(ModItems.ENDER_DRAGON_DEELDO);
        simpleItem(ModItems.RANPAPI_TABLET);
        simpleItem(ModItems.BRA);
        simpleItem(ModItems.THONGS);
        simpleItem(ModItems.DISC_C1);
        simpleItem(ModItems.DISC_C2);
        simpleItem(ModItems.DISC_C3);
        simpleItem(ModItems.DISC_C4);
        simpleItem(ModItems.DISC_C5);
        simpleItem(ModItems.DISC_C6);
        simpleItem(ModItems.DISC_C7);
        simpleItem(ModItems.DISC_C8);
        simpleItem(ModItems.DISC_C9);
        simpleItem(ModItems.DISC_C10);
        simpleItem(ModItems.DISC_C11);
        simpleItem(ModItems.DISC_C12);
        simpleItem(ModItems.DISC_C13);
        simpleItem(ModItems.DISC_C14);
        simpleItem(ModItems.DISC_C15);
        simpleItem(ModItems.DISC_C16);
        simpleItem(ModItems.DISC_C17);
        simpleItem(ModItems.DISC_C18);
        simpleItem(ModItems.DISC_C20);
        simpleItem(ModItems.DISC_C19);
        simpleItem(ModItems.DISC_C21);
        simpleItem(ModItems.DISC_C22);
        simpleItem(ModItems.DISC_C23);
        simpleItem(ModItems.DISC_C24);
        simpleItem(ModItems.DISC_C25);
        simpleItem(ModItems.DISC_C26);
        simpleItem(ModItems.DISC_C27);
        simpleItem(ModItems.DISC_CJ1);
        simpleItem(ModItems.DISC_CPM1);
        simpleItem(ModItems.DISC_CUPCAKKE1);
        simpleItem(ModItems.DISC_CUPCAKKE2);
        simpleItem(ModItems.DISC_CUPCAKKE3);
        simpleItem(ModItems.DISC_CUPCAKKE4);
        simpleItem(ModItems.DISC_DB1);
        simpleItem(ModItems.DISC_DEJE_BULLYING);
        simpleItem(ModItems.DISC_J1);
        simpleItem(ModItems.DISC_J2);
        simpleItem(ModItems.DISC_J3);
        simpleItem(ModItems.DISC_J4);
        simpleItem(ModItems.DISC_J5);
        simpleItem(ModItems.DISC_JC1);
        simpleItem(ModItems.DISC_JC2);
        simpleItem(ModItems.DISC_JC3);
        simpleItem(ModItems.DISC_JIAFEI);
        simpleItem(ModItems.DISC_PM1);
        simpleItem(ModItems.DISC_PONMI);
        simpleItem(ModItems.DISC_RANVISION);
        simpleItem(ModItems.CVMTITPLASM);
        simpleItem(ModItems.FLOPIUM);
        simpleItem(ModItems.GAGASTONE);
        simpleItem(ModItems.GAGINA);
        simpleItem(ModItems.HAIRUSSY);
        simpleItem(ModItems.HUNBAO);
        simpleItem(ModItems.JIAFEI_TRIM_TEMPLATE);
        simpleItem(ModItems.JIAFEI_UPGRADE_TEMPLATE);
        simpleItem(ModItems.MYSTICAL_FLOPIUM);
        simpleItem(ModItems.SCARUSSY);
        simpleItem(ModItems.SLAGINIUM);
        simpleItem(ModItems.INFUSED_SLAGINIUM);
        simpleItem(ModItems.POSEI);
        simpleItem(ModItems.SHENSEIUM);
        simpleItem(ModItems.TAMPON);
        simpleItem(ModItems.TWINK_EGG);
        simpleItem(ModItems.TWINK_EGG_SHELLS);
        simpleItem(ModItems.WONYOUNG_ESSENCE);
        simpleItem(ModItems.CVM_FLUID_BUCKET);
        simpleItem(ModItems.POOSAY_JUICE_BUCKET);

        //simpleItem(ModItems.LOVELY_PEACH_SIGN);
        //simpleItem(ModItems.LOVELY_PEACH_HANGING_SIGN);

        fenceItem(ModBlocks.LOVELY_PEACH_FENCE, ModBlocks.LOVELY_PEACH_PLANKS);
        buttonItem(ModBlocks.LOVELY_PEACH_BUTTON, ModBlocks.LOVELY_PEACH_PLANKS);
        saplingItem(ModBlocks.LOVELY_PEACH_SAPLING);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Modussy.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Modussy.MODID, "block/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(Modussy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Modussy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(Modussy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
}
