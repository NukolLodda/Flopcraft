package slay.nukolussy.modussy.block.fluids;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Modussy.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_CVM_FLUID = FLUIDS.register("cvm_fluid",
            () ->  new ForgeFlowingFluid.Source(ModFluids.CVM_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_POOSAY_JUICE = FLUIDS.register("poosay_juice",
            () ->  new ForgeFlowingFluid.Source(ModFluids.POOSAY_JUICE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_CVM_FLUID = FLUIDS.register("flowing_cvm_fluid",
            () ->  new ForgeFlowingFluid.Flowing(ModFluids.CVM_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_POOSAY_JUICE = FLUIDS.register("flowing_poosay_juice",
            () ->  new ForgeFlowingFluid.Flowing(ModFluids.POOSAY_JUICE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties CVM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CVM_FLUID, SOURCE_CVM_FLUID, FLOWING_CVM_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.CVM_FLUID).bucket(ModItems.CVM_FLUID_BUCKET);

    public static final ForgeFlowingFluid.Properties POOSAY_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.POOSAY_JUICE, SOURCE_POOSAY_JUICE, FLOWING_POOSAY_JUICE)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.POOSAY_JUICE).bucket(ModItems.POOSAY_JUICE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
