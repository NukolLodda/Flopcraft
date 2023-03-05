package slay.nukolussy.modussy.particles;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Modussy.MODID);
    public static final RegistryObject<SimpleParticleType> AESTHETIC_1 = REGISTER.register("aesthetic_1", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> AESTHETIC_2 = REGISTER.register("aesthetic_2", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> AESTHETIC_3 = REGISTER.register("aesthetic_3", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> AESTHETIC_4 = REGISTER.register("aesthetic_4", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> AESTHETIC_5 = REGISTER.register("aesthetic_5", () -> new SimpleParticleType(false));
}
