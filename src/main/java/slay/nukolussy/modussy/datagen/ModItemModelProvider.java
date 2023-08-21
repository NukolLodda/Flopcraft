package slay.nukolussy.modussy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Modussy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BLOODY_TAMPON);
        simpleItem(ModItems.CUPCAKE);
        simpleItem(ModItems.CVM);
        simpleItem(ModItems.CVMIUM);
        simpleItem(ModItems.JIAFEI_PRODUCT);
        simpleItem(ModItems.JIAFEI_PERFUME);
        simpleItem(ModItems.JIAFEI_SEED);
        simpleItem(ModItems.FLOPTROPICA_TICKET);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_PLUS);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_PREMIUM);
        simpleItem(ModItems.SLAGINIUM_YASSIFIER_DELUXE);
        simpleItem(ModItems.SLAGINIUM_PICKAXOL);
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
        simpleItem(ModItems.DISC_J4);
        simpleItem(ModItems.DISC_J5);
        simpleItem(ModItems.DISC_JC1);
        simpleItem(ModItems.DISC_JC2);
        simpleItem(ModItems.DISC_JIAFEI);
        simpleItem(ModItems.DISC_PM1);
        simpleItem(ModItems.DISC_PONMI);
        simpleItem(ModItems.DISC_RANVISION);
        simpleItem(ModItems.CVMTITPLASM);
        simpleItem(ModItems.FLOPIUM);
        simpleItem(ModItems.GAGASTONE);
        simpleItem(ModItems.GAGINA);
        simpleItem(ModItems.HAIRUSSY);
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
        simpleItem(ModItems.WONYOUNG_ESSENCE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Modussy.MODID,"item/" + item.getId().getPath()));
    }
}
