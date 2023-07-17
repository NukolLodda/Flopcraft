package slay.nukolussy.modussy.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Modussy.MODID);

    public static final RegistryObject<RecipeSerializer<CvmInfusionAlterRecipe>> CVM_INFUSION_SERIALIZER =
            SERIALIZERS.register("cvm_infusion", () -> CvmInfusionAlterRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CvmInfusionAlterShapelessRecipe>> CVM_INFUSION_SHAPELESS_SERIALIZER =
            SERIALIZERS.register("cvm_infusion_shapeless", () -> CvmInfusionAlterShapelessRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
