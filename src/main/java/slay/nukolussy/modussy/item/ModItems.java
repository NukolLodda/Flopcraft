package slay.nukolussy.modussy.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.datagen.tags.ModTrimPatterns;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.types.*;
import slay.nukolussy.modussy.item.types.jiafei.*;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.item.tiers.ModTiers;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modussy.MODID);

    public static final RegistryObject<Item> BARBIE_CRYSTALS = ITEMS.register("barbie_crystals",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(10f).build())));

    public static final RegistryObject<Item> LOVELY_PEACH = ITEMS.register("lovely_peach",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(5f).build())));

    public static final RegistryObject<Item> CVM = ITEMS.register("cvm", CvmItem::new);

    public static final RegistryObject<Item> CVMIUM = ITEMS.register("cvmium", CvmItem::new);

    public static final RegistryObject<Item> CVMTITPLASM = ITEMS.register("cvmtitplasm",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLOPIUM = ITEMS.register("flopium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GAGASTONE = ITEMS.register("gagastone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GAGINA = ITEMS.register("gagina",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HAIRUSSY = ITEMS.register("hairussy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JIAFEI_PRODUCT = ITEMS.register("jiafei_product",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MYSTICAL_FLOPIUM = ITEMS.register("mystical_flopium",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> POSEI = ITEMS.register("posei",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCARUSSY = ITEMS.register("scarussy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLAGINIUM = ITEMS.register("slaginium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INFUSED_SLAGINIUM = ITEMS.register("infused_slaginium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHENSEIUM = ITEMS.register("shenseium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TAMPON = ITEMS.register("tampon", Tampon::new);
    public static final RegistryObject<Item> BLOODY_TAMPON = ITEMS.register("bloody_tampon", BloodyTampon::new);

    public static final RegistryObject<Item> TWINK_EGG = ITEMS.register("twink_egg", TwinkEgg::new);

    public static final RegistryObject<Item> WONYOUNG_ESSENCE = ITEMS.register("wonyoung_essence",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER = ITEMS.register("slaginium_yassifier",
            () -> new SlaginiumYassifier(ModTiers.SLAGINIUM,42069, 1, Rarity.COMMON));

    public static final RegistryObject<Item> SLAGINIUM_PICKAXOL = ITEMS.register("slaginium_pickaxol",
            () -> new Pickaxol(ModTiers.SLAGINIUM, 3, -2.8f, Rarity.COMMON));
    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER_PLUS = ITEMS.register("slaginium_yassifier_plus",
            () -> new SlaginiumYassifier(ModTiers.INFUSED_SLAGINIUM,69420, 2, Rarity.UNCOMMON));

    public static final RegistryObject<Item> INFUSED_SLAGINIUM_PICKAXOL = ITEMS.register("infused_slaginium_pickaxol",
            () -> new Pickaxol(ModTiers.INFUSED_SLAGINIUM, 3, -2.8f, Rarity.UNCOMMON));
    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER_PREMIUM = ITEMS.register("slaginium_yassifier_premium",
            () -> new SlaginiumYassifier(ModTiers.FLOPIUM,71690, 3, Rarity.RARE));

    public static final RegistryObject<Item> FLOPIUM_PICKAXOL = ITEMS.register("flopium_pickaxol",
            () -> new Pickaxol(ModTiers.FLOPIUM, 3, -2.8f, Rarity.RARE));
    public static final RegistryObject<Item> SLAGINIUM_YASSIFIER_DELUXE = ITEMS.register("slaginium_yassifier_deluxe",
            () -> new SlaginiumYassifier(ModTiers.MYSTICAL_FLOPIUM,97169, 4, Rarity.EPIC));

    public static final RegistryObject<Item> MYSTICAL_FLOPIUM_PICKAXOL = ITEMS.register("mystical_flopium_pickaxol",
            () -> new Pickaxol(ModTiers.MYSTICAL_FLOPIUM, 3, -2.8f, Rarity.EPIC));

    public static final RegistryObject<Item> JIAFEI_BOOTS = ITEMS.register("jiafei_boots", JiafeiArmor.Boots::new);
    public static final RegistryObject<Item> JIAFEI_LEGGINGS = ITEMS.register("jiafei_leggings", JiafeiArmor.Leggings::new);
    public static final RegistryObject<Item> JIAFEI_CHESTPLATE = ITEMS.register("jiafei_chestplate", JiafeiArmor.Chestplate::new);
    public static final RegistryObject<Item> JIAFEI_HELMET = ITEMS.register("jiafei_helmet", JiafeiArmor.Helmet::new);
    public static final RegistryObject<Item> ARANA_GRANDE = ITEMS.register("arana_grande", AranaGrande::new);
    public static final RegistryObject<Item> JIAFEI_PERFUME = ITEMS.register("jiafei_perfume", JiafeiPerfume::new);
    public static final RegistryObject<Item> KYLIE_JENNER_LIPSTICK = ITEMS.register("kylie_jenner_lipstick", KylieJennerLipstick::new);
    public static final RegistryObject<Item> LANCVM_CREAM = ITEMS.register("lancvm_cream", LancvmCream::new);
    public static final RegistryObject<Item> FLOPTROPICA_TICKET = ITEMS.register("floptropica_ticket", FloptropicaTicket::new);
    public static final RegistryObject<Item> JIAFEI_SEED = ITEMS.register("jiafei_seed", JiafeiSeed::new);
    public static final RegistryObject<Item> BRA = ITEMS.register("bra", InnerWear.Bra::new);
    public static final RegistryObject<Item> THONGS = ITEMS.register("thongs", InnerWear.Thongs::new);
    public static final RegistryObject<Item> JIAFEI_TRIM_TEMPLATE = ITEMS.register("jiafei_armor_trim_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ModTrimPatterns.JIAFEI));

    public static final RegistryObject<Item> JIAFEI_UPGRADE_TEMPLATE = ITEMS.register("jiafei_upgrade_smithing_template",
            ModSmithingTemplates::createJiafeiUpgradeTemplate);

    public static final RegistryObject<Item> JIAFEI_AXE = ITEMS.register("jiafei_axe", JiafeiAxe::new);
    public static final RegistryObject<Item> JIAFEI_HAMMER = ITEMS.register("jiafei_hammer", JiafeiHammer::new);
    public static final RegistryObject<Item> JIAFEI_PICKAXE = ITEMS.register("jiafei_pickaxe", JiafeiPickaxe::new);
    public static final RegistryObject<Item> JIAFEI_SICKLE = ITEMS.register("jiafei_sickle", JiafeiSickle::new);
    public static final RegistryObject<Item> JIAFEI_SHOVEL = ITEMS.register("jiafei_shovel", JiafeiShovel::new);
    public static final RegistryObject<Item> DEELDO = ITEMS.register("deeldo", Deeldo::new);

    public static final RegistryObject<Item> DISC_C1 = ITEMS.register("music_disc_c1", () -> new SoundItems(ModSounds.DISC_C1.get(), 3480,
            "FfmPctW89Y0"));
    public static final RegistryObject<Item> DISC_C2 = ITEMS.register("music_disc_c2", () -> new SoundItems(ModSounds.DISC_C2.get(), 620,
            "6tGJkLYINhE"));
    public static final RegistryObject<Item> DISC_C3 = ITEMS.register("music_disc_c3",  () -> new SoundItems(ModSounds.DISC_C3.get(), 5860,
            "6Ri4vLxrOEw"));
    public static final RegistryObject<Item> DISC_C4 = ITEMS.register("music_disc_c4",  () -> new SoundItems(ModSounds.DISC_C4.get(), 3850,
            "oeK5yPAvRf8"));
    public static final RegistryObject<Item> DISC_C5 = ITEMS.register("music_disc_c5",  () -> new SoundItems(ModSounds.DISC_C5.get(), 2840,
            "I2edUZHiwmA"));
    public static final RegistryObject<Item> DISC_C6 = ITEMS.register("music_disc_c6",  () -> new SoundItems(ModSounds.DISC_C6.get(), 3140,
            "itUNIzqkKPs"));
    public static final RegistryObject<Item> DISC_C7 = ITEMS.register("music_disc_c7",  () -> new SoundItems(ModSounds.DISC_C7.get(), 3840,
            "BMsaU0CxFf8"));
    public static final RegistryObject<Item> DISC_C8 = ITEMS.register("music_disc_c8",  () -> new SoundItems(ModSounds.DISC_C8.get(), 1640,
            "KTB7CwyJkv8"));
    public static final RegistryObject<Item> DISC_C9 = ITEMS.register("music_disc_c9",  () -> new SoundItems(ModSounds.DISC_C9.get(), 4320,
            "8NO6oFOPeNo"));
    public static final RegistryObject<Item> DISC_C10 = ITEMS.register("music_disc_c10",  () -> new SoundItems(ModSounds.DISC_C10.get(), 3600,
            "mh9QhWIGsEQ"));
    public static final RegistryObject<Item> DISC_C11 = ITEMS.register("music_disc_c11",  () -> new SoundItems(ModSounds.DISC_C11.get(), 2900,
            "FSDCu7cbJnU"));
    public static final RegistryObject<Item> DISC_C12 = ITEMS.register("music_disc_c12",  () -> new SoundItems(ModSounds.DISC_C12.get(), 4760,
            "IdY2jV8hVfk"));
    public static final RegistryObject<Item> DISC_C13 = ITEMS.register("music_disc_c13",  () -> new SoundItems(ModSounds.DISC_C13.get(), 4200,
            "byueHxMGiEw"));
    public static final RegistryObject<Item> DISC_C14 = ITEMS.register("music_disc_c14",  () -> new SoundItems(ModSounds.DISC_C14.get(), 3640,
            "WgDPslCb5Tw"));
    public static final RegistryObject<Item> DISC_C15 = ITEMS.register("music_disc_c15",  () -> new SoundItems(ModSounds.DISC_C15.get(), 4700,
            "nLh5XTDwXaI"));
    public static final RegistryObject<Item> DISC_C16 = ITEMS.register("music_disc_c16",  () -> new SoundItems(ModSounds.DISC_C16.get(), 4200,
            "8B2wtJ2zRq8"));
    public static final RegistryObject<Item> DISC_C17 = ITEMS.register("music_disc_c17",  () -> new SoundItems(ModSounds.DISC_C17.get(), 3600,
            "nX6v8-o_ptc"));
    public static final RegistryObject<Item> DISC_C18 = ITEMS.register("music_disc_c18",  () -> new SoundItems(ModSounds.DISC_C18.get(), 3320,
            "NJyXgBoNncQ"));
    public static final RegistryObject<Item> DISC_C19 = ITEMS.register("music_disc_c19",  () -> new SoundItems(ModSounds.DISC_C19.get(), 3120,
            "Ff5BZE8yPrk"));
    public static final RegistryObject<Item> DISC_C20 = ITEMS.register("music_disc_c20",  () -> new SoundItems(ModSounds.DISC_C20.get(), 3320,
            "QsF5x0VyMjs"));
    public static final RegistryObject<Item> DISC_C21 = ITEMS.register("music_disc_c21",  () -> new SoundItems(ModSounds.DISC_C21.get(), 4300,
            "j8m2mjCun6M"));
    public static final RegistryObject<Item> DISC_C22 = ITEMS.register("music_disc_c22",  () -> new SoundItems(ModSounds.DISC_C22.get(), 5220,
            "OnClMS6ZY2A"));
    public static final RegistryObject<Item> DISC_C23 = ITEMS.register("music_disc_c23",  () -> new SoundItems(ModSounds.DISC_C23.get(), 3800,
            "q2_iIaI3KHI"));
    public static final RegistryObject<Item> DISC_C24 = ITEMS.register("music_disc_c24",  () -> new SoundItems(ModSounds.DISC_C24.get(), 4860,
            "Qd2YGwXF2O0"));
    public static final RegistryObject<Item> DISC_C25 = ITEMS.register("music_disc_c25",  () -> new SoundItems(ModSounds.DISC_C25.get(), 4880,
            "tDDJENXAlRI"));
    public static final RegistryObject<Item> DISC_C26 = ITEMS.register("music_disc_c26",  () -> new SoundItems(ModSounds.DISC_C26.get(), 4000,
            "bmI--Y1q7l4"));
    public static final RegistryObject<Item> DISC_CJ1 = ITEMS.register("music_disc_cj1",  () -> new SoundItems(ModSounds.DISC_CJ1.get(), 5100,
            "4uuGucFBtPI"));
    public static final RegistryObject<Item> DISC_CPM1 = ITEMS.register("music_disc_cpm1",  () -> new SoundItems(ModSounds.DISC_CPM1.get(), 3300,
            "Ge_mOcf0ImE"));
    public static final RegistryObject<Item> DISC_CUPCAKKE1 = ITEMS.register("music_disc_cupcakke1",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE1.get(), 4160,
            "aRO4wQ4SVTk"));
    public static final RegistryObject<Item> DISC_CUPCAKKE2 = ITEMS.register("music_disc_cupcakke2",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE2.get(), 3960,
            "TYWINwURoRc"));
    public static final RegistryObject<Item> DISC_CUPCAKKE3 = ITEMS.register("music_disc_cupcakke3",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE3.get(), 4120,
            "8bsbs-c-GDo"));
    public static final RegistryObject<Item> DISC_CUPCAKKE4 = ITEMS.register("music_disc_cupcakke4",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE4.get(), 3720,
            "2J4Sz7Q2muk"));
    public static final RegistryObject<Item> DISC_DB1 = ITEMS.register("music_disc_db1",  () -> new SoundItems(ModSounds.DISC_DB1.get(), 2260,
            "4L_EKMtiGiQ"));
    public static final RegistryObject<Item> DISC_DEJE_BULLYING = ITEMS.register("music_disc_deje_bullying",  () -> new SoundItems(ModSounds.DISC_DEJE_BULLYING.get(), 480,
            ""));
    public static final RegistryObject<Item> DISC_J1 = ITEMS.register("music_disc_j1",  () -> new SoundItems(ModSounds.DISC_J1.get(), 5820,
            "P8am7O7R8fw"));
    public static final RegistryObject<Item> DISC_J2 = ITEMS.register("music_disc_j2",  () -> new SoundItems(ModSounds.DISC_J2.get(), 4740,
            "Z9MNu2Kr2ok"));
    public static final RegistryObject<Item> DISC_J4 = ITEMS.register("music_disc_j4",  () -> new SoundItems(ModSounds.DISC_J4.get(), 1760,
            "SQ_U3TPd7Dc"));
    public static final RegistryObject<Item> DISC_J5 = ITEMS.register("music_disc_j5",  () -> new SoundItems(ModSounds.DISC_J5.get(), 4060,
            "EQdl5f1npT0"));
    public static final RegistryObject<Item> DISC_JC1 = ITEMS.register("music_disc_jc1",  () -> new SoundItems(ModSounds.DISC_JC1.get(), 1480,
            "cX7itW3yfD4"));
    public static final RegistryObject<Item> DISC_JC2 = ITEMS.register("music_disc_jc2",  () -> new SoundItems(ModSounds.DISC_JC2.get(), 4160,
            "cX7itW3yfD4"));
    public static final RegistryObject<Item> DISC_JIAFEI = ITEMS.register("music_disc_jiafei",  () -> new SoundItems(ModSounds.DISC_JIAFEI.get(), 3800,
            "5jx2nW0khhk"));
    public static final RegistryObject<Item> DISC_PM1 = ITEMS.register("music_disc_pm1",  () -> new SoundItems(ModSounds.DISC_PM1.get(), 6160,
            "r0WBPloHthY"));
    public static final RegistryObject<Item> DISC_PONMI = ITEMS.register("music_disc_ponmi",  () -> new SoundItems(ModSounds.DISC_PONMI.get(), 2740,
            "4IZtb_84h"));
    public static final RegistryObject<Item> DISC_RANVISION = ITEMS.register("music_disc_ranvision",  () -> new SoundItems(ModSounds.DISC_RANVISION.get(), 720,
            ""));

    public static final RegistryObject<Item> CUPCAKKE_SPAWN_EGG = ITEMS.register("cupcakke_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CUPCAKKE, -13108, -7328129,  new Item.Properties()));
    public static final RegistryObject<Item> JIAFEI_SPAWN_EGG = ITEMS.register("jiafei_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.JIAFEI,  -5389115, 14354697,  new Item.Properties()));

    public static final RegistryObject<Item> LOVELY_PEACHES_SPAWN_EGG = ITEMS.register("lovely_peaches_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LOVELY_PEACHES,  14241460, 16733695,  new Item.Properties()));
    public static final RegistryObject<Item> NICKI_MINAJ_SPAWN_EGG = ITEMS.register("nicki_minaj_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.NICKI_MINAJ,  43690, 15782375,  new Item.Properties()));
    public static final RegistryObject<Item> TWINK_SPAWN_EGG = ITEMS.register("twink_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TWINK,  170, 5636095,  new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
