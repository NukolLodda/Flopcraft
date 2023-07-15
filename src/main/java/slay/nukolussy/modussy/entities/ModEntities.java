package slay.nukolussy.modussy.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.entities.flops.CupcakKe;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.twink.Twink;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> Entities
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Modussy.MODID);
        public static final RegistryObject<EntityType<CupcakKe>> CUPCAKKE = register("cupcakke",
                EntityType.Builder.<CupcakKe>of(CupcakKe::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                                .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CupcakKe::new)
                        .sized(0.6f,1.8f));

        public static final RegistryObject<EntityType<Twink>> TWINK = register("twink",
                EntityType.Builder.<Twink>of(Twink::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Twink::new)
                .sized(0.6f,1.8f));

        public static final RegistryObject<EntityType<Jiafei>> JIAFEI = register("jiafei",
                EntityType.Builder.<Jiafei>of(Jiafei::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Jiafei::new)
                        .sized(0.6f,1.8f));
        private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
            return Entities.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
         event.enqueueWork(() -> {
            CupcakKe.init();
            Twink.init();
            Jiafei.init();
          });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CUPCAKKE.get(), CupcakKe.createAttributes().build());
        event.put(TWINK.get(), Twink.createAttributes().build());
        event.put(JIAFEI.get(), Jiafei.createAttributes().build());
    }

    public static void register(IEventBus eventBus) { Entities.register(eventBus); }
}
