package slay.nukolussy.modussy.compatibility;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.client.gui.CvmInfusionAlterScreen;
import slay.nukolussy.modussy.recipes.CvmInfusionAlterRecipe;
import slay.nukolussy.modussy.recipes.CvmInfusionAlterShapelessRecipe;

import java.util.List;

@JeiPlugin
public class JEIModussyPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Modussy.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CvmInfusionCategory(registration.getJeiHelpers().getGuiHelper()));
        // registration.addRecipeCategories(new CvmInfusionShapelessCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        List<CvmInfusionAlterRecipe> cvmInfusionRecipes = manager.getAllRecipesFor(CvmInfusionAlterRecipe.Type.INSTANCE);
        // List<CvmInfusionAlterShapelessRecipe> cvmInfusionShapelessRecipes = manager.getAllRecipesFor(CvmInfusionAlterShapelessRecipe.Type.INSTANCE);

        registration.addRecipes(CvmInfusionCategory.CVM_INFUSION_TYPE, cvmInfusionRecipes);
        // registration.addRecipes(CvmInfusionShapelessCategory.CVM_INFUSION_TYPE, cvmInfusionShapelessRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CvmInfusionAlterScreen.class, 60, 30, 20, 30,
                CvmInfusionCategory.CVM_INFUSION_TYPE/*, CvmInfusionShapelessCategory.CVM_INFUSION_TYPE*/);
    }
}
