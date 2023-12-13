package slay.nukolussy.modussy.block.fluids;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;

public class ModFluidTypes {
     public static final DeferredRegister<FluidType> FLUID_TYPES =
             DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Modussy.MODID);

     public static final RegistryObject<FluidType> CVM_FLUID = register("cvm_fluid",
             FluidType.Properties.create().temperature(315).viscosity(6900).density(1000), 0xAAAAAAAA);

     public static final RegistryObject<FluidType> POOSAY_JUICE = register("poosay_juice",
             FluidType.Properties.create().temperature(315).viscosity(710).density(1000), 0xAA9C6C43);

     private static RegistryObject<FluidType> register(String pName, FluidType.Properties pProperties, int pColor) {
         return FLUID_TYPES.register(pName, () -> new ModFluidType(pColor, pProperties));
     }

     public static void register(IEventBus eventBus) {
         FLUID_TYPES.register(eventBus);
     }
}
