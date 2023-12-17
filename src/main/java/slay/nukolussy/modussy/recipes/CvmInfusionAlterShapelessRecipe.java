package slay.nukolussy.modussy.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.Modussy;

import java.util.ArrayList;
import java.util.List;

public class CvmInfusionAlterShapelessRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CvmInfusionAlterShapelessRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer container, Level lvl) {
        if (lvl.isClientSide()) {
            return false;
        }

        boolean hasIng = recipeItems.size() > 0;
        int nullCounter = 0, ingNum = 0, itemNum = 0;
        for (Ingredient item : recipeItems) {
            if (!item.isEmpty()) {
                ingNum++;
            }
        }

        ItemStack curItem;
        Ingredient ing;
        List<Integer> skippedVals = new ArrayList<>(List.of());
        for (int i = 0; i < recipeItems.size(); i++) {
            ing = recipeItems.get(i);
            if (!hasIng) break;
            for (int j = 1; j < 8; j++) {
                curItem = container.getItem(j);
                if (skippedVals.contains(j)) continue;
                if (curItem.isEmpty()) {
                    if (i == 0) nullCounter++;
                    continue;
                }
                if (isInvalidItem(curItem)) {
                    hasIng = false;
                    break;
                }
                if (ing.test(curItem)) {
                    hasIng = ing.test(curItem);
                    skippedVals.add(j);
                    itemNum++;
                    break;
                }
            }
        }
        return hasIng && nullCounter < 7 && ingNum == itemNum;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    protected boolean isInvalidItem(ItemStack pItem) {
        boolean isCor = false;
        for (Ingredient ing : recipeItems) {
            isCor = ing.test(pItem);
            if (isCor) break;
        }
        return !isCor;
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess access) {
        return this.output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CvmInfusionAlterShapelessRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
        public static final String ID = "cvm_infusion_shapeless";
    }

    public static class Serializer implements RecipeSerializer<CvmInfusionAlterShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Modussy.MODID, "cvm_infusion_shapeless");

        @Override
        public CvmInfusionAlterShapelessRecipe fromJson(ResourceLocation id, JsonObject serializedRecipe) {
            // below creates the JSON object output
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(serializedRecipe, "output"));

            // below creates the JSON object ingredients
            JsonArray ingredients = GsonHelper.getAsJsonArray(serializedRecipe, "ingredients");

            // param 1 determines number of ingredients/slot
            NonNullList<Ingredient> inputs = NonNullList.withSize(7, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                if (i < ingredients.size())
                    inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new CvmInfusionAlterShapelessRecipe(id, output, inputs);
        }

        @Override
        public @Nullable CvmInfusionAlterShapelessRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new CvmInfusionAlterShapelessRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CvmInfusionAlterShapelessRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            // buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
