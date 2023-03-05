package slay.nukolussy.modussy.particles;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.client.particle.Aesthetic;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticles {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.register(ModParticleTypes.AESTHETIC_1.get(), Aesthetic::provider);
        event.register(ModParticleTypes.AESTHETIC_2.get(), Aesthetic::provider);
        event.register(ModParticleTypes.AESTHETIC_3.get(), Aesthetic::provider);
        event.register(ModParticleTypes.AESTHETIC_4.get(), Aesthetic::provider);
        event.register(ModParticleTypes.AESTHETIC_5.get(), Aesthetic::provider);
    }
}
