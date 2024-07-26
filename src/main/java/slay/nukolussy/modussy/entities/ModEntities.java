package slay.nukolussy.modussy.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.entities.flops.bosses.GirlbossSivan;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.flops.figures.KamalaHarris;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;
import slay.nukolussy.modussy.entities.flops.bosses.LovelyPeachesBoss;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;
import slay.nukolussy.modussy.entities.flops.traders.CharliXCX;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.traders.NickiMinaj;
import slay.nukolussy.modussy.entities.flops.traders.Ranvision;
import slay.nukolussy.modussy.entities.projectiles.*;
import slay.nukolussy.modussy.entities.twink.Twink;
import slay.nukolussy.modussy.entities.twink.TwinkSivan;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> Entities
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Modussy.MODID);

    public static final RegistryObject<EntityType<CharliXCX>> CHARLI_XCX = register("charlixcx",
            EntityType.Builder.<CharliXCX>of(CharliXCX::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CharliXCX::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<CupcakKe>> CUPCAKKE = register("cupcakke",
            EntityType.Builder.<CupcakKe>of(CupcakKe::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CupcakKe::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<GirlbossSivan>> GIRLBOSS_SIVAN = register("girlboss_sivan",
            EntityType.Builder.<GirlbossSivan>of(GirlbossSivan::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GirlbossSivan::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<Jiafei>> JIAFEI = register("jiafei",
            EntityType.Builder.<Jiafei>of(Jiafei::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Jiafei::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<LovelyPeaches>> LOVELY_PEACHES = register("lovely_peaches",
            EntityType.Builder.<LovelyPeaches>of(LovelyPeaches::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LovelyPeaches::new)
                    .sized(0.5f,0.5f));

    public static final RegistryObject<EntityType<LovelyPeachesBoss>> LOVELY_PEACHES_BOSS = register("lovely_peaches_boss",
            EntityType.Builder.<LovelyPeachesBoss>of(LovelyPeachesBoss::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LovelyPeachesBoss::new)
                    .sized(1.0f,6.0f));

    public static final RegistryObject<EntityType<KamalaHarris>> KAMALA_HARRIS = register("kamala_harris",
            EntityType.Builder.<KamalaHarris>of(KamalaHarris::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KamalaHarris::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<MariahCarey>> MARIAH_CAREY = register("mariah_carey",
            EntityType.Builder.<MariahCarey>of(MariahCarey::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MariahCarey::new)
                    .sized(1f,2f));

    public static final RegistryObject<EntityType<Ranvision>> RANVISION = register("ranvision",
            EntityType.Builder.<Ranvision>of(Ranvision::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Ranvision::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<NickiMinaj>> NICKI_MINAJ = register("nicki_minaj",
            EntityType.Builder.<NickiMinaj>of(NickiMinaj::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NickiMinaj::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<Twink>> TWINK = register("twink",
            EntityType.Builder.<Twink>of(Twink::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Twink::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<TwinkSivan>> TWINK_SIVAN = register("twink_sivan",
            EntityType.Builder.<TwinkSivan>of(TwinkSivan::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TwinkSivan::new)
                    .sized(0.6f,1.8f));



    public static final RegistryObject<EntityType<ChargedLovelyPeach>> LOVELY_PEACH = register("lovely_peach",
            EntityType.Builder.<ChargedLovelyPeach>of(ChargedLovelyPeach::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(ChargedLovelyPeach::new));

    public static final RegistryObject<EntityType<ShotTampon>> TAMPONS = register("tampons",
            EntityType.Builder.<ShotTampon>of(ShotTampon::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(ShotTampon::new));

    public static final RegistryObject<EntityType<ShotBloodyTampon>> BLOODY_TAMPONS = register("bloody_tampons",
            EntityType.Builder.<ShotBloodyTampon>of(ShotBloodyTampon::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(ShotBloodyTampon::new));

    public static final RegistryObject<EntityType<ShotExtraBloodyTampon>> EXTRA_BLOODY_TAMPONS = register("extra_bloody_tampons",
            EntityType.Builder.<ShotExtraBloodyTampon>of(ShotExtraBloodyTampon::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(ShotExtraBloodyTampon::new));

    public static final RegistryObject<EntityType<Kamaloconut>> KAMALOCONUT = register("kamaloconut",
            EntityType.Builder.<Kamaloconut>of(Kamaloconut::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(Kamaloconut::new));

    public static final RegistryObject<EntityType<ThrownTwinkEgg>> TWINK_EGG = register("twink_egg",
            EntityType.Builder.<ThrownTwinkEgg>of(ThrownTwinkEgg::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(ThrownTwinkEgg::new));


    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return Entities.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
         event.enqueueWork(() -> {
             CharliXCX.init();
             CupcakKe.init();
             Jiafei.init();
             LovelyPeaches.init();
             LovelyPeachesBoss.init();
             KamalaHarris.init();
             MariahCarey.init();
             NickiMinaj.init();
             Ranvision.init();
             Twink.init();
             TwinkSivan.init();
             ChargedLovelyPeach.init();
          });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CHARLI_XCX.get(), CharliXCX.createAttributes().build());
        event.put(CUPCAKKE.get(), CupcakKe.createAttributes().build());
        event.put(GIRLBOSS_SIVAN.get(), GirlbossSivan.createAttributes().build());
        event.put(JIAFEI.get(), Jiafei.createAttributes().build());
        event.put(LOVELY_PEACHES.get(), LovelyPeaches.createAttributes().build());
        event.put(LOVELY_PEACHES_BOSS.get(), LovelyPeachesBoss.createAttributes().build());
        event.put(KAMALA_HARRIS.get(), KamalaHarris.createAttributes().build());
        event.put(MARIAH_CAREY.get(), Ranvision.createAttributes().build());
        event.put(NICKI_MINAJ.get(), NickiMinaj.createAttributes().build());
        event.put(RANVISION.get(), Ranvision.createAttributes().build());
        event.put(TWINK.get(), Twink.createAttributes().build());
        event.put(TWINK_SIVAN.get(), Twink.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                CUPCAKKE.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                CupcakKe::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
        event.register(
                MARIAH_CAREY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                MariahCarey::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
        event.register(
                JIAFEI.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Jiafei::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
        event.register(
                RANVISION.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Ranvision::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
        event.register(
                TWINK.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Twink::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }

    public static void register(IEventBus eventBus) {
        Entities.register(eventBus);
    }
}
