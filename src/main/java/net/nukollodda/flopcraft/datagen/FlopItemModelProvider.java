package net.nukollodda.flopcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.item.FlopItems;

public class FlopItemModelProvider extends ItemModelProvider {
    public FlopItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Flopcraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(FlopItems.BARBIE_CRYSTALS);
        simpleItem(FlopItems.BLOOD_CLUMP);
        simpleItem(FlopItems.BLOODY_TAMPON);
        simpleItem(FlopItems.BRAT);
        simpleItem(FlopItems.BRAT_APPLE);
        simpleItem(FlopItems.CLITMAS_BUTTPLUG);
        simpleItem(FlopItems.CUPCAKE);
        simpleItem(FlopItems.CVM);
        simpleItem(FlopItems.CVMIUM);
        simpleItem(FlopItems.CVM_PIE);
        simpleItem(FlopItems.EXTRA_BLOODY_TAMPON);
        simpleItem(FlopItems.CLITMAS_PRESENT);
        simpleItem(FlopItems.REMIX_PRESENT);
        simpleItem(FlopItems.FLOPTROPICA_TICKET);
        simpleItem(FlopItems.JIAFEI_PRODUCT);
        simpleItem(FlopItems.JIAFEI_PERFUME);
        simpleItem(FlopItems.JIAFEI_SEED);
        simpleItem(FlopItems.KYLIE_JENNER_LIPSTICK);
        simpleItem(FlopItems.LANCVM_CREAM);
        simpleItem(FlopItems.LOVELY_PEACH);
        simpleItem(FlopItems.KAMALOCONUT);
        simpleItem(FlopItems.SLAGINIUM_YASSIFIER);
        simpleItem(FlopItems.SLAGINIUM_YASSIFIER_PLUS);
        simpleItem(FlopItems.SLAGINIUM_YASSIFIER_PREMIUM);
        simpleItem(FlopItems.SLAGINIUM_YASSIFIER_DELUXE);
        simpleItem(FlopItems.SLAGINIUM_PICKAXOL);
        simpleItem(FlopItems.ROSETOY);
        simpleItem(FlopItems.INFUSED_SLAGINIUM_PICKAXOL);
        simpleItem(FlopItems.FLOPIUM_PICKAXOL);
        simpleItem(FlopItems.MYSTICAL_FLOPIUM_PICKAXOL);
        simpleItem(FlopItems.TWINK_TRANSFORMER);
        simpleItem(FlopItems.ARANA_GRANDE);
        simpleItem(FlopItems.BRATIFICATIONER);
        simpleItem(FlopItems.JIAFEI_AXE);
        simpleItem(FlopItems.JIAFEI_HAMMER);
        simpleItem(FlopItems.JIAFEI_SICKLE);
        simpleItem(FlopItems.JIAFEI_PICKAXE);
        simpleItem(FlopItems.JIAFEI_SHOVEL);
        simpleItem(FlopItems.JIAFEI_BOOTS);
        simpleItem(FlopItems.JIAFEI_LEGGINGS);
        simpleItem(FlopItems.JIAFEI_CHESTPLATE);
        simpleItem(FlopItems.JIAFEI_HELMET);
        simpleItem(FlopItems.DEELDO);
        simpleItem(FlopItems.ENDER_DRAGON_DEELDO);
        simpleItem(FlopItems.RANPAPI_TABLET);
        simpleItem(FlopItems.BRA);
        simpleItem(FlopItems.THONGS);
        simpleItem(FlopItems.DISC_C1);
        simpleItem(FlopItems.DISC_C2);
        simpleItem(FlopItems.DISC_C3);
        simpleItem(FlopItems.DISC_C4);
        simpleItem(FlopItems.DISC_C5);
        simpleItem(FlopItems.DISC_C6);
        simpleItem(FlopItems.DISC_C7);
        simpleItem(FlopItems.DISC_C8);
        simpleItem(FlopItems.DISC_C9);
        simpleItem(FlopItems.DISC_C10);
        simpleItem(FlopItems.DISC_C11);
        simpleItem(FlopItems.DISC_C12);
        simpleItem(FlopItems.DISC_C13);
        simpleItem(FlopItems.DISC_C14);
        simpleItem(FlopItems.DISC_C15);
        simpleItem(FlopItems.DISC_C16);
        simpleItem(FlopItems.DISC_C17);
        simpleItem(FlopItems.DISC_C18);
        simpleItem(FlopItems.DISC_C20);
        simpleItem(FlopItems.DISC_C19);
        simpleItem(FlopItems.DISC_C21);
        simpleItem(FlopItems.DISC_C22);
        simpleItem(FlopItems.DISC_C23);
        simpleItem(FlopItems.DISC_C24);
        simpleItem(FlopItems.DISC_C25);
        simpleItem(FlopItems.DISC_C26);
        simpleItem(FlopItems.DISC_C27);
        simpleItem(FlopItems.DISC_C28);
        simpleItem(FlopItems.DISC_C29);
        simpleItem(FlopItems.DISC_C30);
        simpleItem(FlopItems.DISC_C31);
        simpleItem(FlopItems.DISC_C32);
        simpleItem(FlopItems.DISC_CJ1);
        simpleItem(FlopItems.DISC_CPM1);
        simpleItem(FlopItems.DISC_CUPCAKKE1);
        simpleItem(FlopItems.DISC_CUPCAKKE2);
        simpleItem(FlopItems.DISC_CUPCAKKE3);
        simpleItem(FlopItems.DISC_CUPCAKKE4);
        simpleItem(FlopItems.DISC_CUPCAKKE5);
        simpleItem(FlopItems.DISC_CUPCAKKE6);
        simpleItem(FlopItems.DISC_DB1);
        simpleItem(FlopItems.DISC_DEJE_BULLYING);
        simpleItem(FlopItems.DISC_J1);
        simpleItem(FlopItems.DISC_J2);
        simpleItem(FlopItems.DISC_J3);
        simpleItem(FlopItems.DISC_J4);
        simpleItem(FlopItems.DISC_J5);
        simpleItem(FlopItems.DISC_J6);
        simpleItem(FlopItems.DISC_J7);
        simpleItem(FlopItems.DISC_JC1);
        simpleItem(FlopItems.DISC_JC2);
        simpleItem(FlopItems.DISC_JC3);
        simpleItem(FlopItems.DISC_JIAFEI);
        simpleItem(FlopItems.DISC_K1);
        simpleItem(FlopItems.DISC_K2);
        simpleItem(FlopItems.DISC_K3);
        simpleItem(FlopItems.DISC_PM1);
        simpleItem(FlopItems.DISC_PONMI);
        simpleItem(FlopItems.DISC_RANVISION);
        simpleItem(FlopItems.CVMTITPLASM);
        simpleItem(FlopItems.FLOPIUM);
        simpleItem(FlopItems.GAGASTONE);
        simpleItem(FlopItems.GAGINA);
        simpleItem(FlopItems.HAIRUSSY);
        simpleItem(FlopItems.HUNBAO);
        simpleItem(FlopItems.JIAFEI_TRIM_TEMPLATE);
        simpleItem(FlopItems.JIAFEI_UPGRADE_TEMPLATE);
        simpleItem(FlopItems.MYSTICAL_FLOPIUM);
        simpleItem(FlopItems.SCARUSSY);
        simpleItem(FlopItems.SLAGINIUM);
        simpleItem(FlopItems.INFUSED_SLAGINIUM);
        simpleItem(FlopItems.POSEI);
        simpleItem(FlopItems.SHENSEIUM);
        simpleItem(FlopItems.TAMPON);
        simpleItem(FlopItems.TWINK_EGG);
        simpleItem(FlopItems.TWINK_EGG_SHELLS);
        simpleItem(FlopItems.TWINK_EGG_PILE);
        simpleItem(FlopItems.WONYOUNG_ESSENCE);
        simpleItem(FlopItems.CVM_FLUID_BUCKET);
        simpleItem(FlopItems.POOSAY_JUICE_BUCKET);

        eggItem(FlopItems.CHARLI_XCX_SPAWN_EGG);
        eggItem(FlopItems.CUPCAKKE_SPAWN_EGG);
        eggItem(FlopItems.JIAFEI_SPAWN_EGG);
        eggItem(FlopItems.LOVELY_PEACHES_SPAWN_EGG);
        eggItem(FlopItems.MARIAH_CAREY_SPAWN_EGG);
        eggItem(FlopItems.KAMALA_HARRIS_SPAWN_EGG);
        eggItem(FlopItems.NICKI_MINAJ_SPAWN_EGG);
        eggItem(FlopItems.RANVISION_SPAWN_EGG);
        eggItem(FlopItems.TWINK_SPAWN_EGG);
        eggItem(FlopItems.TWINK_SIVAN_SPAWN_EGG);

        //simpleItem(ModItems.LOVELY_PEACH_SIGN);
        //simpleItem(ModItems.LOVELY_PEACH_HANGING_SIGN);

        fenceItem(FlopBlocks.LOVELY_PEACH_FENCE, FlopBlocks.LOVELY_PEACH_PLANKS);
        buttonItem(FlopBlocks.LOVELY_PEACH_BUTTON, FlopBlocks.LOVELY_PEACH_PLANKS);
        saplingItem(FlopBlocks.LOVELY_PEACH_SAPLING);

        fenceItem(FlopBlocks.KAMALOCONUT_PALM_FENCE, FlopBlocks.KAMALOCONUT_PALM_PLANKS);
        buttonItem(FlopBlocks.KAMALOCONUT_PALM_BUTTON, FlopBlocks.KAMALOCONUT_PALM_PLANKS);
        saplingItem(FlopBlocks.KAMALOCONUT_PALM_SAPLING);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder eggItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/template_spawn_egg"));
    }

    public void fenceItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> pBlock, RegistryObject<Block> pBase) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(pBase.get()).getPath()));
    }
}
