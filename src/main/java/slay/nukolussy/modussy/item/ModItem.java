package slay.nukolussy.modussy.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.item.custom.*;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modussy.MODID);

    public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(10f).build())));

    public static final RegistryObject<Item> CVM = ITEMS.register("cvm",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CVMTITPLASM = ITEMS.register("cvmtitplasm",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> FLOPIUM = ITEMS.register("flopium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> GAGASTONE = ITEMS.register("gagastone",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> HAIRUSSY = ITEMS.register("hairussy",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> JIAFEI_PRODUCT = ITEMS.register("jiafei_product",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SCARUSSY = ITEMS.register("scarussy",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SLAGINIUM = ITEMS.register("slaginium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> INFUSED_SLAGINIUM = ITEMS.register("infused_slaginium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SHENSEIUM = ITEMS.register("shenseium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> POSEI = ITEMS.register("posei",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER = ITEMS.register("slaginium_yassifier", SlaginiumYassifier::new);
    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER_PLUS = ITEMS.register("slaginium_yassifier_plus", SlaginiumYassifierPlus::new);
    public static final RegistryObject<Item> ARANA_GRANDE = ITEMS.register("arana_grande", AranaGrande::new);

    public static final RegistryObject<Item> AFTER_LIKE = ITEMS.register("after_like", () -> new SoundItems("modussy:after_like", 3500));
    public static final RegistryObject<Item> BACK_BEAT = ITEMS.register("back_beat", () -> new SoundItems("modussy:back_beat", 700));
    public static final RegistryObject<Item> BAD_HOEMANCE = ITEMS.register("bad_hoemance",  () -> new SoundItems("modussy:bad_hoemance", 6000));
    public static final RegistryObject<Item> BAD_ROMANCE = ITEMS.register("bad_romance",  () -> new SoundItems("modussy:bad_romance", 6000));
    public static final RegistryObject<Item> BOLLYWOOD = ITEMS.register("bollywood",  () -> new SoundItems("modussy:bollywood", 4000));
    public static final RegistryObject<Item> CPR = ITEMS.register("cpr",  () -> new SoundItems("modussy:cpr", 4500));
    public static final RegistryObject<Item> DEEPTHROAT = ITEMS.register("deepthroat",  () -> new SoundItems("modussy:deepthroat", 4000));
    public static final RegistryObject<Item> GET_INTO = ITEMS.register("get_into",  () -> new SoundItems("modussy:get_into", 3500));
    public static final RegistryObject<Item> GIMME_MORE = ITEMS.register("gimme_more",  () -> new SoundItems("modussy:gimme_more", 1500));
    public static final RegistryObject<Item> HALLO_AUS = ITEMS.register("hallo_aus",  () -> new SoundItems("modussy:hallo_aus", 4000));
    public static final RegistryObject<Item> HIP_DONT = ITEMS.register("hip_dont",  () -> new SoundItems("modussy:hip_dont", 4500));
    public static final RegistryObject<Item> IEVEN_POLKKA = ITEMS.register("ieven_polkka",  () -> new SoundItems("modussy:ieven_polkka", 3000));
    public static final RegistryObject<Item> INTO_YOU = ITEMS.register("into_you",  () -> new SoundItems("modussy:into_you", 4800));
    public static final RegistryObject<Item> JIAFEI = ITEMS.register("jiafei",  () -> new SoundItems("modussy:jiafei", 3800));
    public static final RegistryObject<Item> METRO = ITEMS.register("metro",  () -> new SoundItems("modussy:metro", 800));
    public static final RegistryObject<Item> MISERY = ITEMS.register("misery",  () -> new SoundItems("modussy:misery", 4500));
    public static final RegistryObject<Item> NEED_DOCTOR = ITEMS.register("need_doctor",  () -> new SoundItems("modussy:need_doctor", 5100));
    public static final RegistryObject<Item> PINK_VENOM = ITEMS.register("pink_venom",  () -> new SoundItems("modussy:pink_venom", 4000));
    public static final RegistryObject<Item> POKER_FACE = ITEMS.register("poker_face",  () -> new SoundItems("modussy:poker_face", 5000));
    public static final RegistryObject<Item> PON_MI = ITEMS.register("pon_mi",  () -> new SoundItems("modussy:pon_mi", 2800));
    public static final RegistryObject<Item> POP = ITEMS.register("pop",  () -> new SoundItems("modussy:pop", 3500));
    public static final RegistryObject<Item> ROUND_LIFE = ITEMS.register("round_life",  () -> new SoundItems("modussy:round_life", 6200));
    public static final RegistryObject<Item> SEE_TINH = ITEMS.register("see_tinh",  () -> new SoundItems("modussy:see_tinh", 4000));
    public static final RegistryObject<Item> TITANIC = ITEMS.register("titanic",  () -> new SoundItems("modussy:titanic", 5400));
    public static final RegistryObject<Item> TUKAH_TAKA = ITEMS.register("tukah_taka",  () -> new SoundItems("modussy:tukah_taka", 4000));
    public static final RegistryObject<Item> VAGINA= ITEMS.register("vagina",  () -> new SoundItems("modussy:vagina", 4500));
    public static final RegistryObject<Item> WEDNESDAY = ITEMS.register("wednesday",  () -> new SoundItems("modussy:wednesday", 5000));
    public static final RegistryObject<Item> WHAM = ITEMS.register("wham",  () -> new SoundItems("modussy:wham", 5000));

    public static final RegistryObject<Item> CUPCAKKE_EGG = ITEMS.register("cupcakke_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CUPCAKKE, -13108, -7328129,  new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> twink_EGG = ITEMS.register("twink_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TWINK,  -1, -1,  new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
