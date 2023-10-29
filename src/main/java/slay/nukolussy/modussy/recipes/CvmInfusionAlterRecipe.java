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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.Modussy;

public class CvmInfusionAlterRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CvmInfusionAlterRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer container, Level lvl) {
        if(lvl.isClientSide()) {
            return false;
        }
        return recipeItems.get(0).test(container.getItem(1)) &&
                recipeItems.get(1).test(container.getItem(2)) &&
                recipeItems.get(2).test(container.getItem(3)) &&
                recipeItems.get(3).test(container.getItem(4)) &&
                recipeItems.get(4).test(container.getItem(5)) &&
                recipeItems.get(5).test(container.getItem(6)) &&
                recipeItems.get(6).test(container.getItem(7)); // brain of the recipe
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
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

    public static class Type implements RecipeType<CvmInfusionAlterRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
        public static final String ID = "cvm_infusion";
    }

    public static class Serializer implements RecipeSerializer<CvmInfusionAlterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Modussy.MODID, "cvm_infusion");

        @Override
        public CvmInfusionAlterRecipe fromJson(ResourceLocation id, JsonObject serializedRecipe) {
            // below creates the JSON object output
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(serializedRecipe, "output"));

            // below creates the JSON object ingredients
            JsonArray ingredients = GsonHelper.getAsJsonArray(serializedRecipe, "ingredients");

            // param 1 determines number of ingredients/slot
            NonNullList<Ingredient> inputs = NonNullList.withSize(7, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                if (i >= ingredients.size()) break;
                if (!Ingredient.fromJson(ingredients.get(i)).test(new ItemStack(Items.BARRIER)))
                        inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new CvmInfusionAlterRecipe(id, output, inputs);
        }

        @Override
        public @Nullable CvmInfusionAlterRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new CvmInfusionAlterRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CvmInfusionAlterRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            // buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
