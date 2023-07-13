package slay.nukolussy.modussy.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS  = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Modussy.MODID);


    // ambient sounds

    public static final RegistryObject<SoundEvent> FLOPTROPICA_AMBIENT1 = SOUNDS.register("floptropica_ambient1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "floptropica_ambient1")));

    public static final RegistryObject<SoundEvent> FLOPTROPICA_AMBIENT2 = SOUNDS.register("floptropica_ambient2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "floptropica_ambient2")));

    public static final RegistryObject<SoundEvent> FLOPTROPICA_CAVE_AMBIENT = SOUNDS.register("floptropica_cave_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "floptropica_cave_ambient")));


    // music disc sounds

    public static final RegistryObject<SoundEvent> AFTER_LIKE = SOUNDS.register("after_like",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"after_like")));

    public static final RegistryObject<SoundEvent> BACK_BEAT = SOUNDS.register("back_beat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"back_beat")));

    public static final RegistryObject<SoundEvent> BAD_HOEMANCE = SOUNDS.register("bad_hoemance",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"bad_hoemance")));

    public static final RegistryObject<SoundEvent> BAD_ROMANCE = SOUNDS.register("bad_romance",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"bad_romance")));

    public static final RegistryObject<SoundEvent> BOLLYWOOD = SOUNDS.register("bollywood",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"bollywood")));

    public static final RegistryObject<SoundEvent> CPR = SOUNDS.register("cpr",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cpr")));

    public static final RegistryObject<SoundEvent> CUPID = SOUNDS.register("cupid",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupid")));

    public static final RegistryObject<SoundEvent> DEEPTHROAT = SOUNDS.register("deepthroat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"deepthroat")));
    public static final RegistryObject<SoundEvent> DEJE_BULLYING = SOUNDS.register("deje_bullying",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"deje_bullying")));

    public static final RegistryObject<SoundEvent> DRIVERS = SOUNDS.register("drivers",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"drivers")));

    public static final RegistryObject<SoundEvent> GET_INTO = SOUNDS.register("get_into",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"get_into")));

    public static final RegistryObject<SoundEvent> GIMME_MORE = SOUNDS.register("gimme_more",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"gimme_more")));
    public static final RegistryObject<SoundEvent> GOD_WOMAN = SOUNDS.register("god_woman",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"god_woman")));

    public static final RegistryObject<SoundEvent> HALLO_AUS = SOUNDS.register("hallo_aus",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"hallo_aus")));

    public static final RegistryObject<SoundEvent> HIP_DONT = SOUNDS.register("hip_dont",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"hip_dont")));

    public static final RegistryObject<SoundEvent> I_AM = SOUNDS.register("i_am",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"i_am")));

    public static final RegistryObject<SoundEvent> IEVEN_POLKKA = SOUNDS.register("ieven_polkka",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"ieven_polkka")));

    public static final RegistryObject<SoundEvent> INTO_YOU = SOUNDS.register("into_you",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"into_you")));

    public static final RegistryObject<SoundEvent> JIAFEI = SOUNDS.register("jiafei",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei")));

    public static final RegistryObject<SoundEvent> JIAFEI_REMIX = SOUNDS.register("jiafei_remix",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_remix")));

    public static final RegistryObject<SoundEvent> METRO = SOUNDS.register("metro",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"metro")));

    public static final RegistryObject<SoundEvent> MISERY = SOUNDS.register("misery",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"misery")));

    public static final RegistryObject<SoundEvent> NEED_DOCTOR = SOUNDS.register("need_doctor",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"need_doctor")));

    public static final RegistryObject<SoundEvent> PINK_VENOM = SOUNDS.register("pink_venom",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"pink_venom")));

    public static final RegistryObject<SoundEvent> POKER_FACE = SOUNDS.register("poker_face",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"poker_face")));

    public static final RegistryObject<SoundEvent> PON_MI = SOUNDS.register("pon_mi",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"pon_mi")));

    public static final RegistryObject<SoundEvent> POP = SOUNDS.register("pop",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"pop")));
    public static final RegistryObject<SoundEvent> RESONANCE = SOUNDS.register("resonance",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"resonance")));

    public static final RegistryObject<SoundEvent> ROUND_LIFE = SOUNDS.register("round_life",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"round_life")));
    public static final RegistryObject<SoundEvent> SAY_SO = SOUNDS.register("say_so",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"say_so")));

    public static final RegistryObject<SoundEvent> SEKALALI = SOUNDS.register("sekalali",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"sekalali")));

    public static final RegistryObject<SoundEvent> SEE_TINH = SOUNDS.register("see_tinh",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"see_tinh")));

    public static final RegistryObject<SoundEvent> SOLO = SOUNDS.register("solo",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "solo")));
    
    public static final RegistryObject<SoundEvent> SSERAFIM = SOUNDS.register("sserafim",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "sserafim")));

    public static final RegistryObject<SoundEvent> TELEPHONE = SOUNDS.register("telephone",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"telephone")));

    public static final RegistryObject<SoundEvent> TITANIC = SOUNDS.register("titanic",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"titanic")));

    public static final RegistryObject<SoundEvent> TUKAH_TAKA = SOUNDS.register("tukah_taka",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"tukah_taka")));

    public static final RegistryObject<SoundEvent> VAGINA = SOUNDS.register("vagina",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"vagina")));

    public static final RegistryObject<SoundEvent> WEDNESDAY = SOUNDS.register("wednesday",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"wednesday")));

    public static final RegistryObject<SoundEvent> WHAM = SOUNDS.register("wham",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"wham")));



    // item sounds

    public static final RegistryObject<SoundEvent> AESTHETIC_1 = SOUNDS.register("aesthetic_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_1")));

    public static final RegistryObject<SoundEvent> AESTHETIC_2 = SOUNDS.register("aesthetic_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_2")));

    public static final RegistryObject<SoundEvent> AESTHETIC_3 = SOUNDS.register("aesthetic_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_3")));

    public static final RegistryObject<SoundEvent> AESTHETIC_4 = SOUNDS.register("aesthetic_4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_4")));

    public static final RegistryObject<SoundEvent> AESTHETIC_5 = SOUNDS.register("aesthetic_5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_5")));

    public static final RegistryObject<SoundEvent> AESTHETIC_SHENSEEA = SOUNDS.register("aesthetic_shenseea",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_shenseea")));

    public static final RegistryObject<SoundEvent> AESTHETIC_JIAFEI = SOUNDS.register("aesthetic_jiafei",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"aesthetic_jiafei")));

    public static final RegistryObject<SoundEvent> SPRAY = SOUNDS.register("spray",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"spray")));

    public static final RegistryObject<SoundEvent> YUH = SOUNDS.register("yuh",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"yuh")));


    // entity sounds

    public static final RegistryObject<SoundEvent> CUPCAkKE_1 = SOUNDS.register("cupcakke_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_1")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_2 = SOUNDS.register("cupcakke_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_2")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_3 = SOUNDS.register("cupcakke_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_3")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_4 = SOUNDS.register("cupcakke_4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_4")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_5 = SOUNDS.register("cupcakke_5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_5")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_6 = SOUNDS.register("cupcakke_6",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_6")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_7 = SOUNDS.register("cupcakke_7",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_7")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_8 = SOUNDS.register("cupcakke_8",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_8")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_9 = SOUNDS.register("cupcakke_9",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_9")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_10 = SOUNDS.register("cupcakke_10",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_10")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_DEATH = SOUNDS.register("cupcakke_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_death")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT1 = SOUNDS.register("cupcakke_hurt1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_hurt1")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT2 = SOUNDS.register("cupcakke_hurt2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_hurt2")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT3 = SOUNDS.register("cupcakke_hurt3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_hurt3")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT4 = SOUNDS.register("cupcakke_hurt4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_hurt4")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_SLURP = SOUNDS.register("cupcakke_slurp",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_slurp")));

    public static final RegistryObject<SoundEvent> JIAFEI_1 = SOUNDS.register("jiafei_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_2 = SOUNDS.register("jiafei_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_3 = SOUNDS.register("jiafei_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_3")));

    public static final RegistryObject<SoundEvent> JIAFEI_ARMOR = SOUNDS.register("jiafei_armor",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_armor")));

    public static final RegistryObject<SoundEvent> JIAFEI_ANGRY_1 = SOUNDS.register("jiafei_angry_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_angry_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_ANGRY_2 = SOUNDS.register("jiafei_angry_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_angry_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_BOUGHT_1 = SOUNDS.register("jiafei_bought_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_bought_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_BOUGHT_2 = SOUNDS.register("jiafei_bought_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_bought_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_DEATH_1 = SOUNDS.register("jiafei_death_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_death_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_DEATH_2 = SOUNDS.register("jiafei_death_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_death_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_DEATH_3 = SOUNDS.register("jiafei_death_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_death_3")));

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_1 = SOUNDS.register("jiafei_eat_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_2 = SOUNDS.register("jiafei_eat_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_3 = SOUNDS.register("jiafei_eat_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_HURT = SOUNDS.register("jiafei_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_hurt")));

    public static final RegistryObject<SoundEvent> JIAFEI_PRODUCTLESS = SOUNDS.register("jiafei_productless",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_productless")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_1 = SOUNDS.register("jiafei_trade_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_2 = SOUNDS.register("jiafei_trade_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_3 = SOUNDS.register("jiafei_trade_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_3")));

    public static final RegistryObject<SoundEvent> SQUIRT = SOUNDS.register("squirt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"squirt")));
    public static final RegistryObject<SoundEvent> CVM = SOUNDS.register("cvm",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cvm")));



    public static void register(IEventBus eventBus) { SOUNDS.register(eventBus); }
}
