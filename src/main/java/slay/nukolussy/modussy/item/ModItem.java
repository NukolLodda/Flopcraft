package slay.nukolussy.modussy.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.custom.*;
import slay.nukolussy.modussy.item.custom.jiafei.*;
import slay.nukolussy.modussy.tiers.ModTiers;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modussy.MODID);

    public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(10f).build())));

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

    public static final RegistryObject<Item> SCARUSSY = ITEMS.register("scarussy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLAGINIUM = ITEMS.register("slaginium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INFUSED_SLAGINIUM = ITEMS.register("infused_slaginium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHENSEIUM = ITEMS.register("shenseium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> POSEI = ITEMS.register("posei",
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
    public static final RegistryObject<Item> FLOPTROPICA_TICKET = ITEMS.register("floptropica_ticket", FloptropicaTicket::new);
    public static final RegistryObject<Item> JIAFEI_SEED = ITEMS.register("jiafei_seed", JiafeiSeed::new);

    public static final RegistryObject<Item> JIAFEI_AXE = ITEMS.register("jiafei_axe", JiafeiAxe::new);
    public static final RegistryObject<Item> JIAFEI_HAMMER = ITEMS.register("jiafei_hammer", JiafeiHammer::new);
    public static final RegistryObject<Item> JIAFEI_PICKAXE = ITEMS.register("jiafei_pickaxe", JiafeiPickaxe::new);
    public static final RegistryObject<Item> JIAFEI_SICKLE = ITEMS.register("jiafei_sickle", JiafeiSickle::new);
    public static final RegistryObject<Item> JIAFEI_SHOVEL = ITEMS.register("jiafei_shovel", JiafeiShovel::new);
    public static final RegistryObject<Item> DEELDO = ITEMS.register("deeldo", Deeldo::new);

    public static final RegistryObject<Item> AFTER_LIKE = ITEMS.register("after_like", () -> new SoundItems("modussy:after_like", 3480));
    public static final RegistryObject<Item> BACK_BEAT = ITEMS.register("back_beat", () -> new SoundItems("modussy:back_beat", 620));
    public static final RegistryObject<Item> BAD_HOEMANCE = ITEMS.register("bad_hoemance",  () -> new SoundItems("modussy:bad_hoemance", 5860));
    public static final RegistryObject<Item> BAD_ROMANCE = ITEMS.register("bad_romance",  () -> new SoundItems("modussy:bad_romance", 5820));
    public static final RegistryObject<Item> BOLLYWOOD = ITEMS.register("bollywood",  () -> new SoundItems("modussy:bollywood", 3850));
    public static final RegistryObject<Item> CPR = ITEMS.register("cpr",  () -> new SoundItems("modussy:cpr", 4160));
    public static final RegistryObject<Item> CUPID = ITEMS.register("cupid",  () -> new SoundItems("modussy:cupid", 2840));
    public static final RegistryObject<Item> DEEPTHROAT = ITEMS.register("deepthroat",  () -> new SoundItems("modussy:deepthroat", 3960));
    public static final RegistryObject<Item> DEJE_BULLYING = ITEMS.register("deje_bullying",  () -> new SoundItems("modussy:deje_bullying", 480));
    public static final RegistryObject<Item> DRIVERS = ITEMS.register("drivers",  () -> new SoundItems("modussy:drivers", 4740));
    public static final RegistryObject<Item> GET_INTO = ITEMS.register("get_into",  () -> new SoundItems("modussy:get_into", 3140));
    public static final RegistryObject<Item> GIMME_MORE = ITEMS.register("gimme_more",  () -> new SoundItems("modussy:gimme_more", 1480));
    public static final RegistryObject<Item> GOD_WOMAN = ITEMS.register("god_woman",  () -> new SoundItems("modussy:god_woman", 3840));
    public static final RegistryObject<Item> HALLO_AUS = ITEMS.register("hallo_aus",  () -> new SoundItems("modussy:hallo_aus", 1640));
    public static final RegistryObject<Item> HIP_DONT = ITEMS.register("hip_dont",  () -> new SoundItems("modussy:hip_dont", 4320));
    public static final RegistryObject<Item> I_AM = ITEMS.register("i_am",  () -> new SoundItems("modussy:i_am", 3600));
    public static final RegistryObject<Item> IEVEN_POLKKA = ITEMS.register("ieven_polkka",  () -> new SoundItems("modussy:ieven_polkka", 2900));
    public static final RegistryObject<Item> INTO_YOU = ITEMS.register("into_you",  () -> new SoundItems("modussy:into_you", 4760));
    public static final RegistryObject<Item> JIAFEI = ITEMS.register("jiafei",  () -> new SoundItems("modussy:jiafei", 3800));
    public static final RegistryObject<Item> JIAFEI_REMIX = ITEMS.register("jiafei_remix",  () -> new SoundItems("modussy:jiafei_remix", 1760));
    public static final RegistryObject<Item> METRO = ITEMS.register("metro",  () -> new SoundItems("modussy:metro", 720));
    public static final RegistryObject<Item> MISERY = ITEMS.register("misery",  () -> new SoundItems("modussy:misery", 4200));
    public static final RegistryObject<Item> NEED_DOCTOR = ITEMS.register("need_doctor",  () -> new SoundItems("modussy:need_doctor", 5100));
    public static final RegistryObject<Item> PINK_VENOM = ITEMS.register("pink_venom",  () -> new SoundItems("modussy:pink_venom", 3640));
    public static final RegistryObject<Item> POKER_FACE = ITEMS.register("poker_face",  () -> new SoundItems("modussy:poker_face", 4700));
    public static final RegistryObject<Item> PON_MI = ITEMS.register("pon_mi",  () -> new SoundItems("modussy:pon_mi", 2740));
    public static final RegistryObject<Item> POP = ITEMS.register("pop",  () -> new SoundItems("modussy:pop", 3300));
    public static final RegistryObject<Item> RESONANCE = ITEMS.register("resonance",  () -> new SoundItems("modussy:resonance", 4060));
    public static final RegistryObject<Item> ROUND_LIFE = ITEMS.register("round_life",  () -> new SoundItems("modussy:round_life", 6160));
    public static final RegistryObject<Item> SAY_SO = ITEMS.register("say_so",  () -> new SoundItems("modussy:say_so", 2260));
    public static final RegistryObject<Item> SEE_TINH = ITEMS.register("see_tinh",  () -> new SoundItems("modussy:see_tinh", 3320));
    public static final RegistryObject<Item> SEKALALI = ITEMS.register("sekalali",  () -> new SoundItems("modussy:sekalali", 3600));
    public static final RegistryObject<Item> SOLO = ITEMS.register("solo",  () -> new SoundItems("modussy:solo", 3120));
    public static final RegistryObject<Item> SSERAFIM = ITEMS.register("sserafim",  () -> new SoundItems("modussy:sserafim", 3320));
    public static final RegistryObject<Item> TELEPHONE = ITEMS.register("telephone",  () -> new SoundItems("modussy:telephone", 4300));
    public static final RegistryObject<Item> TITANIC = ITEMS.register("titanic",  () -> new SoundItems("modussy:titanic", 5220));
    public static final RegistryObject<Item> TUKAH_TAKA = ITEMS.register("tukah_taka",  () -> new SoundItems("modussy:tukah_taka", 3800));
    public static final RegistryObject<Item> VAGINA= ITEMS.register("vagina",  () -> new SoundItems("modussy:vagina", 4120));
    public static final RegistryObject<Item> WEDNESDAY = ITEMS.register("wednesday",  () -> new SoundItems("modussy:wednesday", 4860));
    public static final RegistryObject<Item> WHAM = ITEMS.register("wham",  () -> new SoundItems("modussy:wham", 4880));

    public static final RegistryObject<Item> CUPCAKKE_EGG = ITEMS.register("cupcakke_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CUPCAKKE, -13108, -7328129,  new Item.Properties()));
    public static final RegistryObject<Item> JIAFEI_EGG = ITEMS.register("jiafei_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.JIAFEI,  -5389115, 14354697,  new Item.Properties()));
    public static final RegistryObject<Item> TWINK_EGG = ITEMS.register("twink_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TWINK,  -1, -1,  new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
