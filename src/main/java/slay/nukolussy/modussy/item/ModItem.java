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
import slay.nukolussy.modussy.item.types.*;
import slay.nukolussy.modussy.item.types.jiafei.*;
import slay.nukolussy.modussy.sound.ModSounds;
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

    public static final RegistryObject<Item> DISC_C1 = ITEMS.register("music_disc_c1", () -> new SoundItems(ModSounds.DISC_C1.get(), 3480));
    public static final RegistryObject<Item> DISC_C2 = ITEMS.register("music_disc_c2", () -> new SoundItems(ModSounds.DISC_C2.get(), 620));
    public static final RegistryObject<Item> DISC_C3 = ITEMS.register("music_disc_c3",  () -> new SoundItems(ModSounds.DISC_C3.get(), 5860));
    public static final RegistryObject<Item> DISC_C4 = ITEMS.register("music_disc_c4",  () -> new SoundItems(ModSounds.DISC_C4.get(), 3850));
    public static final RegistryObject<Item> DISC_C5 = ITEMS.register("music_disc_c5",  () -> new SoundItems(ModSounds.DISC_C5.get(), 2840));
    public static final RegistryObject<Item> DISC_C6 = ITEMS.register("music_disc_c6",  () -> new SoundItems(ModSounds.DISC_C6.get(), 3140));
    public static final RegistryObject<Item> DISC_C7 = ITEMS.register("music_disc_c7",  () -> new SoundItems(ModSounds.DISC_C7.get(), 3840));
    public static final RegistryObject<Item> DISC_C8 = ITEMS.register("music_disc_c8",  () -> new SoundItems(ModSounds.DISC_C8.get(), 1640));
    public static final RegistryObject<Item> DISC_C9 = ITEMS.register("music_disc_c9",  () -> new SoundItems(ModSounds.DISC_C9.get(), 4320));
    public static final RegistryObject<Item> DISC_C10 = ITEMS.register("music_disc_c10",  () -> new SoundItems(ModSounds.DISC_C10.get(), 3600));
    public static final RegistryObject<Item> DISC_C11 = ITEMS.register("music_disc_c11",  () -> new SoundItems(ModSounds.DISC_C11.get(), 2900));
    public static final RegistryObject<Item> DISC_C12 = ITEMS.register("music_disc_c12",  () -> new SoundItems(ModSounds.DISC_C12.get(), 4760));
    public static final RegistryObject<Item> DISC_C13 = ITEMS.register("music_disc_c13",  () -> new SoundItems(ModSounds.DISC_C13.get(), 4200));
    public static final RegistryObject<Item> DISC_C14 = ITEMS.register("music_disc_c14",  () -> new SoundItems(ModSounds.DISC_C14.get(), 3640));
    public static final RegistryObject<Item> DISC_C15 = ITEMS.register("music_disc_c15",  () -> new SoundItems(ModSounds.DISC_C15.get(), 4700));
    public static final RegistryObject<Item> DISC_C17 = ITEMS.register("music_disc_c17",  () -> new SoundItems(ModSounds.DISC_C17.get(), 3600));
    public static final RegistryObject<Item> DISC_C18 = ITEMS.register("music_disc_c18",  () -> new SoundItems(ModSounds.DISC_C18.get(), 3320));
    public static final RegistryObject<Item> DISC_C19 = ITEMS.register("music_disc_c19",  () -> new SoundItems(ModSounds.DISC_C19.get(), 3120));
    public static final RegistryObject<Item> DISC_C20 = ITEMS.register("music_disc_c20",  () -> new SoundItems(ModSounds.DISC_C20.get(), 3320));
    public static final RegistryObject<Item> DISC_C21 = ITEMS.register("music_disc_c21",  () -> new SoundItems(ModSounds.DISC_C21.get(), 4300));
    public static final RegistryObject<Item> DISC_C22 = ITEMS.register("music_disc_c22",  () -> new SoundItems(ModSounds.DISC_C22.get(), 5220));
    public static final RegistryObject<Item> DISC_C23 = ITEMS.register("music_disc_c23",  () -> new SoundItems(ModSounds.DISC_C23.get(), 3800));
    public static final RegistryObject<Item> DISC_C24 = ITEMS.register("music_disc_c24",  () -> new SoundItems(ModSounds.DISC_C24.get(), 4860));
    public static final RegistryObject<Item> DISC_C25 = ITEMS.register("music_disc_c25",  () -> new SoundItems(ModSounds.DISC_C25.get(), 4880));
    public static final RegistryObject<Item> DISC_CJ1 = ITEMS.register("music_disc_cj1",  () -> new SoundItems(ModSounds.DISC_CJ1.get(), 5100));
    public static final RegistryObject<Item> DISC_CPM1 = ITEMS.register("music_disc_cpm1",  () -> new SoundItems(ModSounds.DISC_CPM1.get(), 3300));
    public static final RegistryObject<Item> DISC_CUPCAKKE1 = ITEMS.register("music_disc_cupcakke1",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE1.get(), 4160));
    public static final RegistryObject<Item> DISC_CUPCAKKE2 = ITEMS.register("music_disc_cupcakke2",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE2.get(), 3960));
    public static final RegistryObject<Item> DISC_CUPCAKKE3 = ITEMS.register("music_disc_cupcakke3",  () -> new SoundItems(ModSounds.DISC_CUPCAKKE3.get(), 4120));
    public static final RegistryObject<Item> DISC_DB1 = ITEMS.register("music_disc_db1",  () -> new SoundItems(ModSounds.DISC_DB1.get(), 2260));
    public static final RegistryObject<Item> DISC_DEJE_BULLYING = ITEMS.register("music_disc_deje_bullying",  () -> new SoundItems(ModSounds.DISC_DEJE_BULLYING.get(), 480));
    public static final RegistryObject<Item> DISC_J1 = ITEMS.register("music_disc_j1",  () -> new SoundItems(ModSounds.DISC_J1.get(), 5820));
    public static final RegistryObject<Item> DISC_J2 = ITEMS.register("music_disc_j2",  () -> new SoundItems(ModSounds.DISC_J2.get(), 4740));
    public static final RegistryObject<Item> DISC_J4 = ITEMS.register("music_disc_j4",  () -> new SoundItems(ModSounds.DISC_J4.get(), 1760));
    public static final RegistryObject<Item> DISC_J5 = ITEMS.register("music_disc_j5",  () -> new SoundItems(ModSounds.DISC_J5.get(), 4060));
    public static final RegistryObject<Item> DISC_JC1 = ITEMS.register("music_disc_jc1",  () -> new SoundItems(ModSounds.DISC_JC1.get(), 1480));
    public static final RegistryObject<Item> DISC_JIAFEI = ITEMS.register("music_disc_jiafei",  () -> new SoundItems(ModSounds.DISC_JIAFEI.get(), 3800));
    public static final RegistryObject<Item> DISC_PM1 = ITEMS.register("music_disc_pm1",  () -> new SoundItems(ModSounds.DISC_PM1.get(), 6160));
    public static final RegistryObject<Item> DISC_PONMI = ITEMS.register("music_disc_ponmi",  () -> new SoundItems(ModSounds.DISC_PONMI.get(), 2740));
    public static final RegistryObject<Item> DISC_RANVISION = ITEMS.register("music_disc_ranvision",  () -> new SoundItems(ModSounds.DISC_RANVISION.get(), 720));

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
