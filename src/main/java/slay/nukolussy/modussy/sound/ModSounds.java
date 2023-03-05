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

    public static final RegistryObject<SoundEvent> AFTER_LIKE = SOUNDS.register("after_like",
            () -> new SoundEvent(new ResourceLocation("modussy","after_like")));

    public static final RegistryObject<SoundEvent> BACK_BEAT = SOUNDS.register("back_beat",
            () -> new SoundEvent(new ResourceLocation("modussy","back_beat")));

    public static final RegistryObject<SoundEvent> BAD_HOEMANCE = SOUNDS.register("bad_hoemance",
            () -> new SoundEvent(new ResourceLocation("modussy","bad_hoemance")));

    public static final RegistryObject<SoundEvent> BAD_ROEMANCE = SOUNDS.register("bad_romance",
            () -> new SoundEvent(new ResourceLocation("modussy","bad_romance")));

    public static final RegistryObject<SoundEvent> BOLLYWOOD = SOUNDS.register("bollywood",
            () -> new SoundEvent(new ResourceLocation("modussy","bollywood")));

    public static final RegistryObject<SoundEvent> CPR = SOUNDS.register("cpr",
            () -> new SoundEvent(new ResourceLocation("modussy","cpr")));

    public static final RegistryObject<SoundEvent> DEEPTHROAT = SOUNDS.register("deepthroat",
            () -> new SoundEvent(new ResourceLocation("modussy","deepthroat")));

    public static final RegistryObject<SoundEvent> GET_INTO = SOUNDS.register("get_into",
            () -> new SoundEvent(new ResourceLocation("modussy","get_into")));

    public static final RegistryObject<SoundEvent> GIMME_MORE = SOUNDS.register("gimme_more",
            () -> new SoundEvent(new ResourceLocation("modussy","gimme_more")));

    public static final RegistryObject<SoundEvent> HALLO_AUS = SOUNDS.register("hallo_aus",
            () -> new SoundEvent(new ResourceLocation("modussy","hallo_aus")));

    public static final RegistryObject<SoundEvent> HIP_DONT = SOUNDS.register("hip_dont",
            () -> new SoundEvent(new ResourceLocation("modussy","hip_dont")));

    public static final RegistryObject<SoundEvent> IEVEN_POLKKA = SOUNDS.register("ieven_polkka",
            () -> new SoundEvent(new ResourceLocation("modussy","ieven_polkka")));

    public static final RegistryObject<SoundEvent> INTO_YOU = SOUNDS.register("into_you",
            () -> new SoundEvent(new ResourceLocation("modussy","into_you")));

    public static final RegistryObject<SoundEvent> JIAFEI = SOUNDS.register("jiafei",
            () -> new SoundEvent(new ResourceLocation("modussy","jiafei")));

    public static final RegistryObject<SoundEvent> METRO = SOUNDS.register("metro",
            () -> new SoundEvent(new ResourceLocation("modussy","metro")));

    public static final RegistryObject<SoundEvent> MISERY = SOUNDS.register("misery",
            () -> new SoundEvent(new ResourceLocation("modussy","misery")));

    public static final RegistryObject<SoundEvent> NEED_DOCTOR = SOUNDS.register("need_doctor",
            () -> new SoundEvent(new ResourceLocation("modussy","need_doctor")));

    public static final RegistryObject<SoundEvent> PINK_VENOM = SOUNDS.register("pink_venom",
            () -> new SoundEvent(new ResourceLocation("modussy","pink_venom")));

    public static final RegistryObject<SoundEvent> POKER_FACE = SOUNDS.register("poker_face",
            () -> new SoundEvent(new ResourceLocation("modussy","poker_face")));

    public static final RegistryObject<SoundEvent> PON_MI = SOUNDS.register("pon_mi",
            () -> new SoundEvent(new ResourceLocation("modussy","pon_mi")));

    public static final RegistryObject<SoundEvent> POP = SOUNDS.register("pop",
            () -> new SoundEvent(new ResourceLocation("modussy","pop")));

    public static final RegistryObject<SoundEvent> ROUND_LIFE = SOUNDS.register("round_life",
            () -> new SoundEvent(new ResourceLocation("modussy","round_life")));

    public static final RegistryObject<SoundEvent> SEE_TINH = SOUNDS.register("see_tinh",
            () -> new SoundEvent(new ResourceLocation("modussy","see_tinh")));

    public static final RegistryObject<SoundEvent> TECHNO_CPR = SOUNDS.register("techno_cpr",
            () -> new SoundEvent(new ResourceLocation("modussy","techno_cpr")));

    public static final RegistryObject<SoundEvent> TITANIC = SOUNDS.register("titanic",
            () -> new SoundEvent(new ResourceLocation("modussy","titanic")));

    public static final RegistryObject<SoundEvent> TUKAH_TAKA = SOUNDS.register("tukah_taka",
            () -> new SoundEvent(new ResourceLocation("modussy","tukah_taka")));

    public static final RegistryObject<SoundEvent> VAGINA = SOUNDS.register("vagina",
            () -> new SoundEvent(new ResourceLocation("modussy","vagina")));

    public static final RegistryObject<SoundEvent> WEDNESDAY = SOUNDS.register("wednesday",
            () -> new SoundEvent(new ResourceLocation("modussy","wednesday")));

    public static final RegistryObject<SoundEvent> WHAM = SOUNDS.register("wham",
            () -> new SoundEvent(new ResourceLocation("modussy","wham")));


    public static final RegistryObject<SoundEvent> AESTHETIC_1 = SOUNDS.register("aesthetic_1",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_1")));

    public static final RegistryObject<SoundEvent> AESTHETIC_2 = SOUNDS.register("aesthetic_2",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_2")));

    public static final RegistryObject<SoundEvent> AESTHETIC_3 = SOUNDS.register("aesthetic_3",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_3")));

    public static final RegistryObject<SoundEvent> AESTHETIC_4 = SOUNDS.register("aesthetic_4",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_4")));

    public static final RegistryObject<SoundEvent> AESTHETIC_5 = SOUNDS.register("aesthetic_5",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_5")));

    public static final RegistryObject<SoundEvent> AESTHETIC_SHENSEEA = SOUNDS.register("aesthetic_shenseea",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_shenseea")));

    public static final RegistryObject<SoundEvent> AESTHETIC_JIAFEI = SOUNDS.register("aesthetic_jiafei",
            () -> new SoundEvent(new ResourceLocation("modussy","aesthetic_jiafei")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_1 = SOUNDS.register("cupcakke_1",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_1")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_2 = SOUNDS.register("cupcakke_2",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_2")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_3 = SOUNDS.register("cupcakke_3",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_3")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_4 = SOUNDS.register("cupcakke_4",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_4")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_5 = SOUNDS.register("cupcakke_5",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_5")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_6 = SOUNDS.register("cupcakke_6",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_6")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_7 = SOUNDS.register("cupcakke_7",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_7")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_8 = SOUNDS.register("cupcakke_8",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_8")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_9 = SOUNDS.register("cupcakke_9",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_9")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_10 = SOUNDS.register("cupcakke_10",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_10")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT1 = SOUNDS.register("cupcakke_hurt1",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_hurt1")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT2 = SOUNDS.register("cupcakke_hurt2",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_hurt2")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT3 = SOUNDS.register("cupcakke_hurt3",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_hurt3")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_HURT4 = SOUNDS.register("cupcakke_hurt4",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_hurt4")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_SLURP = SOUNDS.register("cupcakke_slurp",
            () -> new SoundEvent(new ResourceLocation("modussy","cupcakke_slurp")));

    public static final RegistryObject<SoundEvent> YUH = SOUNDS.register("yuh",
            () -> new SoundEvent(new ResourceLocation("modussy","yuh")));


    public static void register(IEventBus eventBus) { SOUNDS.register(eventBus); }
}
