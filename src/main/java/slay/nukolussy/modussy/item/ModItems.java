package slay.nukolussy.modussy.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.fluids.ModFluids;
import slay.nukolussy.modussy.datagen.tags.ModTrimPatterns;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.types.*;
import slay.nukolussy.modussy.item.types.jiafei.*;
import slay.nukolussy.modussy.item.types.sextoys.ClitmasButtplug;
import slay.nukolussy.modussy.item.types.sextoys.Deeldo;
import slay.nukolussy.modussy.item.types.sextoys.Rosetoy;
import slay.nukolussy.modussy.item.types.tampons.BloodyTampon;
import slay.nukolussy.modussy.item.types.tampons.ExtraBloodyTampon;
import slay.nukolussy.modussy.item.types.tampons.Tampon;
import slay.nukolussy.modussy.item.types.tools.Pickaxol;
import slay.nukolussy.modussy.item.types.tools.SlaginiumYassifier;
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

    public static final RegistryObject<Item> BLOOD_CLUMP = ITEMS.register("blood_clump", BloodClump::new);

    public static final RegistryObject<Item> FLOPIUM = ITEMS.register("flopium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GAGASTONE = ITEMS.register("gagastone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GAGINA = ITEMS.register("gagina",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HAIRUSSY = ITEMS.register("hairussy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HUNBAO = ITEMS.register("hunbao", Hunbao::new);

    public static final RegistryObject<Item> JIAFEI_PRODUCT = ITEMS.register("jiafei_product",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BUSSIAN_DOLLAR = ITEMS.register("bussian_dollar",
            () -> new Item(new Item.Properties().fireResistant()));

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
    public static final RegistryObject<Item> EXTRA_BLOODY_TAMPON = ITEMS.register("extra_bloody_tampon", ExtraBloodyTampon::new);

    public static final RegistryObject<Item> TWINK_EGG = ITEMS.register("twink_egg", TwinkEgg::new);

    public static final RegistryObject<Item> TWINK_EGG_SHELLS = ITEMS.register("twink_egg_shells",
            () -> new Item(new Item.Properties()));

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
    public static final RegistryObject<Item> CLITMAS_PRESENT = ITEMS.register("clitmas_present", ClitmasPresent::new);
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
    public static final RegistryObject<Item> CLITMAS_BUTTPLUG = ITEMS.register("clitmas_buttplug", ClitmasButtplug::new);
    public static final RegistryObject<Item> DEELDO = ITEMS.register("deeldo", Deeldo::new);
    public static final RegistryObject<Item> ROSETOY = ITEMS.register("rosetoy", Rosetoy::new);

    public static final RegistryObject<Item> CVM_FLUID_BUCKET = ITEMS.register("cvm_fluid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CVM_FLUID, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> POOSAY_JUICE_BUCKET = ITEMS.register("poosay_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_POOSAY_JUICE, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> DISC_C1 = ITEMS.register("music_disc_c1", () -> new ModDiscs(ModSounds.DISC_C1.get(), 3480));
    public static final RegistryObject<Item> DISC_C2 = ITEMS.register("music_disc_c2", () -> new ModDiscs(ModSounds.DISC_C2.get(), 620));
    public static final RegistryObject<Item> DISC_C3 = ITEMS.register("music_disc_c3",  () -> new ModDiscs(ModSounds.DISC_C3.get(), 5860));
    public static final RegistryObject<Item> DISC_C4 = ITEMS.register("music_disc_c4",  () -> new ModDiscs(ModSounds.DISC_C4.get(), 3850));
    public static final RegistryObject<Item> DISC_C5 = ITEMS.register("music_disc_c5",  () -> new ModDiscs(ModSounds.DISC_C5.get(), 2840));
    public static final RegistryObject<Item> DISC_C6 = ITEMS.register("music_disc_c6",  () -> new ModDiscs(ModSounds.DISC_C6.get(), 3140));
    public static final RegistryObject<Item> DISC_C7 = ITEMS.register("music_disc_c7",  () -> new ModDiscs(ModSounds.DISC_C7.get(), 3840));
    public static final RegistryObject<Item> DISC_C8 = ITEMS.register("music_disc_c8",  () -> new ModDiscs(ModSounds.DISC_C8.get(), 1640));
    public static final RegistryObject<Item> DISC_C9 = ITEMS.register("music_disc_c9",  () -> new ModDiscs(ModSounds.DISC_C9.get(), 4320));
    public static final RegistryObject<Item> DISC_C10 = ITEMS.register("music_disc_c10",  () -> new ModDiscs(ModSounds.DISC_C10.get(), 3600));
    public static final RegistryObject<Item> DISC_C11 = ITEMS.register("music_disc_c11",  () -> new ModDiscs(ModSounds.DISC_C11.get(), 2900));
    public static final RegistryObject<Item> DISC_C12 = ITEMS.register("music_disc_c12",  () -> new ModDiscs(ModSounds.DISC_C12.get(), 4760));
    public static final RegistryObject<Item> DISC_C13 = ITEMS.register("music_disc_c13",  () -> new ModDiscs(ModSounds.DISC_C13.get(), 4200));
    public static final RegistryObject<Item> DISC_C14 = ITEMS.register("music_disc_c14",  () -> new ModDiscs(ModSounds.DISC_C14.get(), 3640));
    public static final RegistryObject<Item> DISC_C15 = ITEMS.register("music_disc_c15",  () -> new ModDiscs(ModSounds.DISC_C15.get(), 4700));
    public static final RegistryObject<Item> DISC_C16 = ITEMS.register("music_disc_c16",  () -> new ModDiscs(ModSounds.DISC_C16.get(), 4200));
    public static final RegistryObject<Item> DISC_C17 = ITEMS.register("music_disc_c17",  () -> new ModDiscs(ModSounds.DISC_C17.get(), 3600));
    public static final RegistryObject<Item> DISC_C18 = ITEMS.register("music_disc_c18",  () -> new ModDiscs(ModSounds.DISC_C18.get(), 3320));
    public static final RegistryObject<Item> DISC_C19 = ITEMS.register("music_disc_c19",  () -> new ModDiscs(ModSounds.DISC_C19.get(), 3120));
    public static final RegistryObject<Item> DISC_C20 = ITEMS.register("music_disc_c20",  () -> new ModDiscs(ModSounds.DISC_C20.get(), 3320));
    public static final RegistryObject<Item> DISC_C21 = ITEMS.register("music_disc_c21",  () -> new ModDiscs(ModSounds.DISC_C21.get(), 4300));
    public static final RegistryObject<Item> DISC_C22 = ITEMS.register("music_disc_c22",  () -> new ModDiscs(ModSounds.DISC_C22.get(), 5220));
    public static final RegistryObject<Item> DISC_C23 = ITEMS.register("music_disc_c23",  () -> new ModDiscs(ModSounds.DISC_C23.get(), 3800));
    public static final RegistryObject<Item> DISC_C24 = ITEMS.register("music_disc_c24",  () -> new ModDiscs(ModSounds.DISC_C24.get(), 4860));
    public static final RegistryObject<Item> DISC_C25 = ITEMS.register("music_disc_c25",  () -> new ModDiscs(ModSounds.DISC_C25.get(), 4880));
    public static final RegistryObject<Item> DISC_C26 = ITEMS.register("music_disc_c26",  () -> new ModDiscs(ModSounds.DISC_C26.get(), 4000));
    public static final RegistryObject<Item> DISC_C27 = ITEMS.register("music_disc_c27",  () -> new ModDiscs(ModSounds.DISC_C27.get(), 3800));// only obtainable from christmas
    public static final RegistryObject<Item> DISC_CJ1 = ITEMS.register("music_disc_cj1",  () -> new ModDiscs(ModSounds.DISC_CJ1.get(), 5100));
    public static final RegistryObject<Item> DISC_CPM1 = ITEMS.register("music_disc_cpm1",  () -> new ModDiscs(ModSounds.DISC_CPM1.get(), 3300));
    public static final RegistryObject<Item> DISC_CUPCAKKE1 = ITEMS.register("music_disc_cupcakke1",  () -> new ModDiscs(ModSounds.DISC_CUPCAKKE1.get(), 4160));
    public static final RegistryObject<Item> DISC_CUPCAKKE2 = ITEMS.register("music_disc_cupcakke2",  () -> new ModDiscs(ModSounds.DISC_CUPCAKKE2.get(), 3960));
    public static final RegistryObject<Item> DISC_CUPCAKKE3 = ITEMS.register("music_disc_cupcakke3",  () -> new ModDiscs(ModSounds.DISC_CUPCAKKE3.get(), 4120));
    public static final RegistryObject<Item> DISC_CUPCAKKE4 = ITEMS.register("music_disc_cupcakke4",  () -> new ModDiscs(ModSounds.DISC_CUPCAKKE4.get(), 3720));
    public static final RegistryObject<Item> DISC_DB1 = ITEMS.register("music_disc_db1",  () -> new ModDiscs(ModSounds.DISC_DB1.get(), 2260));
    public static final RegistryObject<Item> DISC_DEJE_BULLYING = ITEMS.register("music_disc_deje_bullying",  () -> new ModDiscs(ModSounds.DISC_DEJE_BULLYING.get(), 480));
    public static final RegistryObject<Item> DISC_J1 = ITEMS.register("music_disc_j1",  () -> new ModDiscs(ModSounds.DISC_J1.get(), 5820));
    public static final RegistryObject<Item> DISC_J2 = ITEMS.register("music_disc_j2",  () -> new ModDiscs(ModSounds.DISC_J2.get(), 4740));
    public static final RegistryObject<Item> DISC_J3 = ITEMS.register("music_disc_j3",  () -> new ModDiscs(ModSounds.DISC_J3.get(), 1420));
    public static final RegistryObject<Item> DISC_J4 = ITEMS.register("music_disc_j4",  () -> new ModDiscs(ModSounds.DISC_J4.get(), 1760));
    public static final RegistryObject<Item> DISC_J5 = ITEMS.register("music_disc_j5",  () -> new ModDiscs(ModSounds.DISC_J5.get(), 4060));
    public static final RegistryObject<Item> DISC_JC1 = ITEMS.register("music_disc_jc1",  () -> new ModDiscs(ModSounds.DISC_JC1.get(), 3340));
    public static final RegistryObject<Item> DISC_JC2 = ITEMS.register("music_disc_jc2",  () -> new ModDiscs(ModSounds.DISC_JC2.get(), 4160));
    public static final RegistryObject<Item> DISC_JC3 = ITEMS.register("music_disc_jc3",  () -> new ModDiscs(ModSounds.DISC_JC3.get(), 1300));
    public static final RegistryObject<Item> DISC_JIAFEI = ITEMS.register("music_disc_jiafei",  () -> new ModDiscs(ModSounds.DISC_JIAFEI.get(), 3800));
    public static final RegistryObject<Item> DISC_PM1 = ITEMS.register("music_disc_pm1",  () -> new ModDiscs(ModSounds.DISC_PM1.get(), 6160));
    public static final RegistryObject<Item> DISC_PONMI = ITEMS.register("music_disc_ponmi",  () -> new ModDiscs(ModSounds.DISC_PONMI.get(), 2740));
    public static final RegistryObject<Item> DISC_RANVISION = ITEMS.register("music_disc_ranvision",  () -> new ModDiscs(ModSounds.DISC_RANVISION.get(), 720));

    public static final RegistryObject<Item> CUPCAKKE_SPAWN_EGG = ITEMS.register("cupcakke_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CUPCAKKE, -13108, -7328129,  new Item.Properties()));
    public static final RegistryObject<Item> JIAFEI_SPAWN_EGG = ITEMS.register("jiafei_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.JIAFEI,  -5389115, 14354697,  new Item.Properties()));
    public static final RegistryObject<Item> LOVELY_PEACHES_SPAWN_EGG = ITEMS.register("lovely_peaches_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LOVELY_PEACHES,  14241460, 16733695,  new Item.Properties()));
    public static final RegistryObject<Item> MARIAH_CAREY_SPAWN_EGG = ITEMS.register("mariah_carey_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MARIAH_CAREY,  13378335, 3450463,  new Item.Properties()));
    public static final RegistryObject<Item> NICKI_MINAJ_SPAWN_EGG = ITEMS.register("nicki_minaj_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.NICKI_MINAJ,  43690, 15782375,  new Item.Properties()));
    public static final RegistryObject<Item> RANVISION_SPAWN_EGG = ITEMS.register("ranvision_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RANVISION,  16757057, 12538804,  new Item.Properties()));
    public static final RegistryObject<Item> TWINK_SPAWN_EGG = ITEMS.register("twink_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TWINK,  170, 5636095,  new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
