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
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;
import slay.nukolussy.modussy.entities.flops.bosses.LovelyPeachesBoss;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.traders.NickiMinaj;
import slay.nukolussy.modussy.entities.flops.twink.Twink;
import slay.nukolussy.modussy.entities.projectiles.BloodyTampons;
import slay.nukolussy.modussy.entities.projectiles.LovelyPeach;
import slay.nukolussy.modussy.entities.projectiles.Tampons;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> Entities
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Modussy.MODID);
    public static final RegistryObject<EntityType<CupcakKe>> CUPCAKKE = register("cupcakke",
            EntityType.Builder.<CupcakKe>of(CupcakKe::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CupcakKe::new)
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

    public static final RegistryObject<EntityType<NickiMinaj>> NICKI_MINAJ = register("nicki_minaj",
            EntityType.Builder.<NickiMinaj>of(NickiMinaj::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NickiMinaj::new)
                    .sized(0.6f,1.8f));

    public static final RegistryObject<EntityType<Twink>> TWINK = register("twink",
            EntityType.Builder.<Twink>of(Twink::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Twink::new)
                    .sized(0.6f,1.8f));



    public static final RegistryObject<EntityType<LovelyPeach>> LOVELY_PEACH = register("lovely_peach",
            EntityType.Builder.<LovelyPeach>of(LovelyPeach::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(LovelyPeach::new));

    public static final RegistryObject<EntityType<Tampons>> TAMPONS = register("tampons",
            EntityType.Builder.<Tampons>of(Tampons::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(Tampons::new));

    public static final RegistryObject<EntityType<BloodyTampons>> BLOODY_TAMPONS = register("bloody_tampons",
            EntityType.Builder.<BloodyTampons>of(BloodyTampons::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(4).updateInterval(10).setCustomClientFactory(BloodyTampons::new));


    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return Entities.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
         event.enqueueWork(() -> {
            CupcakKe.init();
            Jiafei.init();
            LovelyPeaches.init();
            LovelyPeachesBoss.init();
            NickiMinaj.init();
            Twink.init();
            LovelyPeach.init();
          });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CUPCAKKE.get(), CupcakKe.createAttributes().build());
        event.put(JIAFEI.get(), Jiafei.createAttributes().build());
        event.put(LOVELY_PEACHES.get(), LovelyPeaches.createAttributes().build());
        event.put(LOVELY_PEACHES_BOSS.get(), LovelyPeachesBoss.createAttributes().build());
        event.put(NICKI_MINAJ.get(), NickiMinaj.createAttributes().build());
        event.put(TWINK.get(), Twink.createAttributes().build());
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
                JIAFEI.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Jiafei::canSpawn,
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

    public static void register(IEventBus eventBus) {Entities.register(eventBus); }
}
