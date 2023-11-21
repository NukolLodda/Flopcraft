package slay.nukolussy.modussy.sound;

import ca.weblite.objc.Proxy;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
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

    public static final RegistryObject<SoundEvent> DISC_C1 = SOUNDS.register("music_disc_c1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c1")));

    public static final RegistryObject<SoundEvent> DISC_C2 = SOUNDS.register("music_disc_c2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c2")));

    public static final RegistryObject<SoundEvent> DISC_C3 = SOUNDS.register("music_disc_c3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c3")));

    public static final RegistryObject<SoundEvent> DISC_C4 = SOUNDS.register("music_disc_c4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c4")));

    public static final RegistryObject<SoundEvent> DISC_C5 = SOUNDS.register("music_disc_c5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c5")));

    public static final RegistryObject<SoundEvent> DISC_C6 = SOUNDS.register("music_disc_c6",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c6")));

    public static final RegistryObject<SoundEvent> DISC_C7 = SOUNDS.register("music_disc_c7",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c7")));

    public static final RegistryObject<SoundEvent> DISC_C8 = SOUNDS.register("music_disc_c8",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c8")));

    public static final RegistryObject<SoundEvent> DISC_C9 = SOUNDS.register("music_disc_c9",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c9")));

    public static final RegistryObject<SoundEvent> DISC_C10 = SOUNDS.register("music_disc_c10",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c10")));

    public static final RegistryObject<SoundEvent> DISC_C11 = SOUNDS.register("music_disc_c11",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c11")));

    public static final RegistryObject<SoundEvent> DISC_C12 = SOUNDS.register("music_disc_c12",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c12")));

    public static final RegistryObject<SoundEvent> DISC_C13 = SOUNDS.register("music_disc_c13",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c13")));

    public static final RegistryObject<SoundEvent> DISC_CJ1 = SOUNDS.register("music_disc_cj1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cj1")));

    public static final RegistryObject<SoundEvent> DISC_C14 = SOUNDS.register("music_disc_c14",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c14")));

    public static final RegistryObject<SoundEvent> DISC_C15 = SOUNDS.register("music_disc_c15",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c15")));

    public static final RegistryObject<SoundEvent> DISC_C16 = SOUNDS.register("music_disc_c16",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c16")));

    public static final RegistryObject<SoundEvent> DISC_C17 = SOUNDS.register("music_disc_c17",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c17")));

    public static final RegistryObject<SoundEvent> DISC_C18 = SOUNDS.register("music_disc_c18",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c18")));

    public static final RegistryObject<SoundEvent> DISC_C19 = SOUNDS.register("music_disc_c19",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "music_disc_c19")));

    public static final RegistryObject<SoundEvent> DISC_C20 = SOUNDS.register("music_disc_c20",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "music_disc_c20")));

    public static final RegistryObject<SoundEvent> DISC_C21 = SOUNDS.register("music_disc_c21",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c21")));

    public static final RegistryObject<SoundEvent> DISC_C22 = SOUNDS.register("music_disc_c22",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c22")));

    public static final RegistryObject<SoundEvent> DISC_C23 = SOUNDS.register("music_disc_c23",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c23")));

    public static final RegistryObject<SoundEvent> DISC_C24 = SOUNDS.register("music_disc_c24",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c24")));

    public static final RegistryObject<SoundEvent> DISC_C25 = SOUNDS.register("music_disc_c25",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c25")));
    public static final RegistryObject<SoundEvent> DISC_C26 = SOUNDS.register("music_disc_c26",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c26")));
    public static final RegistryObject<SoundEvent> DISC_C27 = SOUNDS.register("music_disc_c27",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_c27")));

    public static final RegistryObject<SoundEvent> DISC_CPM1 = SOUNDS.register("music_disc_cpm1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cpm1")));

    public static final RegistryObject<SoundEvent> DISC_CUPCAKKE1 = SOUNDS.register("music_disc_cupcakke1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cupcakke1")));

    public static final RegistryObject<SoundEvent> DISC_CUPCAKKE2 = SOUNDS.register("music_disc_cupcakke2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cupcakke2")));

    public static final RegistryObject<SoundEvent> DISC_CUPCAKKE3 = SOUNDS.register("music_disc_cupcakke3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cupcakke3")));

    public static final RegistryObject<SoundEvent> DISC_CUPCAKKE4 = SOUNDS.register("music_disc_cupcakke4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_cupcakke4")));

    public static final RegistryObject<SoundEvent> DISC_DB1 = SOUNDS.register("music_disc_db1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_db1")));

    public static final RegistryObject<SoundEvent> DISC_DEJE_BULLYING = SOUNDS.register("music_disc_deje_bullying",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_deje_bullying")));

    public static final RegistryObject<SoundEvent> DISC_J1 = SOUNDS.register("music_disc_j1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_j1")));

    public static final RegistryObject<SoundEvent> DISC_J2 = SOUNDS.register("music_disc_j2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_j2")));

    public static final RegistryObject<SoundEvent> DISC_J3 = SOUNDS.register("music_disc_j3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_j3")));

    public static final RegistryObject<SoundEvent> DISC_J4 = SOUNDS.register("music_disc_j4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_j4")));

    public static final RegistryObject<SoundEvent> DISC_J5 = SOUNDS.register("music_disc_j5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_j5")));

    public static final RegistryObject<SoundEvent> DISC_JC1 = SOUNDS.register("music_disc_jc1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_jc1")));

    public static final RegistryObject<SoundEvent> DISC_JC2 = SOUNDS.register("music_disc_jc2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_jc2")));

    public static final RegistryObject<SoundEvent> DISC_JC3 = SOUNDS.register("music_disc_jc3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_jc3")));

    public static final RegistryObject<SoundEvent> DISC_JIAFEI = SOUNDS.register("music_disc_jiafei",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_jiafei")));

    public static final RegistryObject<SoundEvent> DISC_PM1 = SOUNDS.register("music_disc_pm1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_pm1")));

    public static final RegistryObject<SoundEvent> DISC_PONMI = SOUNDS.register("music_disc_ponmi",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_ponmi")));

    public static final RegistryObject<SoundEvent> DISC_RANVISION = SOUNDS.register("music_disc_ranvision",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"music_disc_ranvision")));



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

    public static final RegistryObject<SoundEvent> ROSETOY_1 = SOUNDS.register("rosetoy_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"rosetoy_1")));

    public static final RegistryObject<SoundEvent> ROSETOY_2 = SOUNDS.register("rosetoy_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"rosetoy_2")));

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

    public static final RegistryObject<SoundEvent> CUPCAkKE_NEW_YEARS_1 = SOUNDS.register("cupcakke_new_years_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_new_years_1")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_NEW_YEARS_2 = SOUNDS.register("cupcakke_new_years_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_new_years_2")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_NEW_YEARS_3 = SOUNDS.register("cupcakke_new_years_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_new_years_3")));

    public static final RegistryObject<SoundEvent> CUPCAkKE_NEW_YEARS_4 = SOUNDS.register("cupcakke_new_years_4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cupcakke_new_years_4")));

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

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_1 = SOUNDS.register("jiafei_eat_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_2 = SOUNDS.register("jiafei_eat_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_EAT_3 = SOUNDS.register("jiafei_eat_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_eat_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_HURT = SOUNDS.register("jiafei_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_hurt")));

    public static final RegistryObject<SoundEvent> JIAFEI_NEW_YEARS = SOUNDS.register("jiafei_new_years",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_new_years")));

    public static final RegistryObject<SoundEvent> JIAFEI_NEW_YEARS_TRADE = SOUNDS.register("jiafei_new_years_trade",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_new_years_trade")));

    public static final RegistryObject<SoundEvent> JIAFEI_PRODUCTLESS = SOUNDS.register("jiafei_productless",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_productless")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_1 = SOUNDS.register("jiafei_trade_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_1")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_2 = SOUNDS.register("jiafei_trade_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_2")));

    public static final RegistryObject<SoundEvent> JIAFEI_TRADE_3 = SOUNDS.register("jiafei_trade_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"jiafei_trade_3")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_1 = SOUNDS.register("lovely_peaches_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_1")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_2 = SOUNDS.register("lovely_peaches_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_2")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_3 = SOUNDS.register("lovely_peaches_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_3")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_4 = SOUNDS.register("lovely_peaches_4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_4")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_5 = SOUNDS.register("lovely_peaches_5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_5")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_6 = SOUNDS.register("lovely_peaches_6",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_6")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_7 = SOUNDS.register("lovely_peaches_7",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_7")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_HURT1 = SOUNDS.register("lovely_peaches_hurt1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_hurt1")));

    public static final RegistryObject<SoundEvent> LOVELY_PEACHES_HURT2 = SOUNDS.register("lovely_peaches_hurt2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"lovely_peaches_hurt2")));
    public static final RegistryObject<SoundEvent> MARIAH_CAREY_DEFROSTING = SOUNDS.register("mariah_carey_defrosting",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"mariah_carey_defrosting")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_1 = SOUNDS.register("nicki_minaj_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_1")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_2 = SOUNDS.register("nicki_minaj_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_2")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_3 = SOUNDS.register("nicki_minaj_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_3")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_DEATH = SOUNDS.register("nicki_minaj_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_death")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_EAT = SOUNDS.register("nicki_minaj_eat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_eat")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_HURT1 = SOUNDS.register("nicki_minaj_hurt1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_hurt1")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_HURT2 = SOUNDS.register("nicki_minaj_hurt2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_hurt2")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_SUMMON = SOUNDS.register("nicki_minaj_summon",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_summon")));

    public static final RegistryObject<SoundEvent> NICKI_MINAJ_TRADE = SOUNDS.register("nicki_minaj_trade",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"nicki_minaj_trade")));
    public static final RegistryObject<SoundEvent> RANVISION_1 = SOUNDS.register("ranvision_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_1")));
    public static final RegistryObject<SoundEvent> RANVISION_2 = SOUNDS.register("ranvision_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_2")));
    public static final RegistryObject<SoundEvent> RANVISION_3 = SOUNDS.register("ranvision_3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_3")));
    public static final RegistryObject<SoundEvent> RANVISION_4 = SOUNDS.register("ranvision_4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_4")));
    public static final RegistryObject<SoundEvent> RANVISION_5 = SOUNDS.register("ranvision_5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_5")));
    public static final RegistryObject<SoundEvent> RANVISION_BOUGHT_1 = SOUNDS.register("ranvision_bought_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_bought_1")));
    public static final RegistryObject<SoundEvent> RANVISION_BOUGHT_2 = SOUNDS.register("ranvision_bought_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_bought_2")));
    public static final RegistryObject<SoundEvent> RANVISION_EAT = SOUNDS.register("ranvision_eat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_eat")));
    public static final RegistryObject<SoundEvent> RANVISION_TRADE_1 = SOUNDS.register("ranvision_trade_1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_trade_1")));
    public static final RegistryObject<SoundEvent> RANVISION_TRADE_2 = SOUNDS.register("ranvision_trade_2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_trade_2")));
    public static final RegistryObject<SoundEvent> RANVISION_TRADELESS = SOUNDS.register("ranvision_tradeless",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID, "ranvision_tradeless")));

    public static final RegistryObject<SoundEvent> SQUIRT = SOUNDS.register("squirt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"squirt")));
    public static final RegistryObject<SoundEvent> CVM = SOUNDS.register("cvm",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Modussy.MODID,"cvm")));

    public static void register(IEventBus eventBus) { SOUNDS.register(eventBus); }
}
