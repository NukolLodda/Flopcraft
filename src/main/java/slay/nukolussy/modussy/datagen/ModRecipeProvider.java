package slay.nukolussy.modussy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.datagen.tags.ModTags;
import slay.nukolussy.modussy.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ModTags.Items.SHENSEIUM_ORE, ModItems.SHENSEIUM.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_STRAD, ModItems.DISC_C1.get());
        cupcakkeDiscRecipe(pWriter, ModItems.DISC_CUPCAKKE3.get(), ModItems.DISC_C2.get());
        cupcakkeDiscRecipe(pWriter, ModItems.DISC_C15.get(), ModItems.DISC_C3.get());
        cupcakkeDiscRecipe(pWriter, Items.ACACIA_LOG, ModItems.DISC_C4.get());
        cupcakkeDiscRecipe(pWriter, Items.SPORE_BLOSSOM, ModItems.DISC_C5.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_CAT, ModItems.DISC_C6.get());
        cupcakkeDiscRecipe(pWriter, Items.ENDER_PEARL, ModItems.DISC_C7.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_MELLOHI, ModItems.DISC_C8.get());
        cupcakkeDiscRecipe(pWriter, ModItems.INFUSED_SLAGINIUM.get(), ModItems.DISC_C9.get());
        cupcakkeDiscRecipe(pWriter, ModItems.WONYOUNG_ESSENCE.get(), ModItems.DISC_C10.get());
        cupcakkeDiscRecipe(pWriter, Items.PISTON, ModItems.DISC_C11.get());
        cupcakkeDiscRecipe(pWriter, ModItems.ARANA_GRANDE.get(), ModItems.DISC_C12.get());
        cupcakkeDiscRecipe(pWriter, ModItems.CVMTITPLASM.get(), ModItems.DISC_C13.get());
        cupcakkeDiscRecipe(pWriter, Items.FERMENTED_SPIDER_EYE, ModItems.DISC_C14.get());
        cupcakkeDiscRecipe(pWriter, ModItems.HAIRUSSY.get(), ModItems.DISC_C15.get());
        cupcakkeDiscRecipe(pWriter, ModItems.BRA.get(), ModItems.DISC_C16.get());
        cupcakkeDiscRecipe(pWriter, Items.END_STONE, ModItems.DISC_C17.get());
        cupcakkeDiscRecipe(pWriter, Items.ALLIUM, ModItems.DISC_C18.get());
        cupcakkeDiscRecipe(pWriter, Items.IRON_INGOT, ModItems.DISC_C19.get());
        cupcakkeDiscRecipe(pWriter, Items.GLASS, ModItems.DISC_C20.get());
        cupcakkeDiscRecipe(pWriter, ModItems.GAGASTONE.get(), ModItems.DISC_C21.get());
        cupcakkeDiscRecipe(pWriter, ItemTags.SAND, ModItems.DISC_C23.get());
        cupcakkeDiscRecipe(pWriter, ModItems.SCARUSSY.get(), ModItems.DISC_C24.get());
        cupcakkeDiscRecipe(pWriter, Items.SNOWBALL, ModItems.DISC_C25.get());
        cupcakkeDiscRecipe(pWriter, ModItems.SLAGINIUM.get(), ModItems.DISC_C26.get());
        ponmiDiscRecipe(pWriter, Items.OAK_LOG, ModItems.DISC_PM1.get());
        jiafeiDiscRecipe(pWriter, ModItems.HAIRUSSY.get() ,ModItems.DISC_J1.get());
        jiafeiDiscRecipe(pWriter, Items.MINECART,ModItems.DISC_J2.get());
        jiafeiDiscRecipe(pWriter, ModItems.DISC_JIAFEI.get(),ModItems.DISC_J4.get());
        jiafeiDiscRecipe(pWriter, Items.ENDER_PEARL,ModItems.DISC_J5.get());
        dejeBullyingDiscRecipe(pWriter, Items.MUSIC_DISC_CAT,ModItems.DISC_DB1.get());

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(Items.LEATHER_CHESTPLATE), ModItems.DISC_CJ1.get(), Items.LEATHER_CHESTPLATE, 2);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(Items.SPYGLASS), ModItems.DISC_JC1.get(), Items.SPYGLASS, 2);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(ModItems.SLAGINIUM.get()), ModItems.DISC_JC2.get(), ModItems.SLAGINIUM.get(), 2);

        musicDiscRecipe(pWriter, Ingredient.of(ModTags.Items.SHENSEIUM), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(ModItems.DISC_C1.get()), ModItems.DISC_CPM1.get(), ModItems.DISC_C1.get(), 1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.MUSIC_DISC_11), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), ModItems.DISC_RANVISION.get(), Items.MUSIC_DISC_11, 2);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.SCARUSSY.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                ModItems.DISC_CUPCAKKE1.get(), ModItems.SCARUSSY.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.HAIRUSSY.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                ModItems.DISC_CUPCAKKE2.get(), ModItems.HAIRUSSY.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.POSEI.get()), Ingredient.of(ModItems.CUPCAKE.get()),
                ModItems.DISC_CUPCAKKE3.get(), ModItems.POSEI.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.WATER_BUCKET), Ingredient.of(ModItems.CUPCAKE.get()),
                ModItems.DISC_CUPCAKKE4.get(), Items.WATER_BUCKET, -1);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.JIAFEI_PRODUCT.get()),
                ModItems.DISC_JIAFEI.get(), ModItems.JIAFEI_PRODUCT.get(), 2);

        musicDiscRecipe(pWriter, Ingredient.of(ModTags.Items.SHENSEIUM),
                ModItems.DISC_PONMI.get(), ModItems.SHENSEIUM.get(), 1);

        jiafeiDiscRecipe(pWriter, ModItems.DISC_C26.get(), ModItems.DISC_JC2.get());

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.DISC_CUPCAKKE1.get()),
                ModItems.DISC_C24.get(), ModItems.DISC_CUPCAKKE1.get(), 0);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.DISC_CUPCAKKE2.get()),
                ModItems.DISC_C15.get(), ModItems.DISC_CUPCAKKE2.get(), 0);

        musicDiscRecipe(pWriter, Ingredient.of(ModItems.DISC_CUPCAKKE3.get()),
                ModItems.DISC_C2.get(), ModItems.DISC_CUPCAKKE3.get(), 0);

        nineBlockStorageRecipes(pWriter, ModItems.FLOPIUM.get(), ModTags.Items.FLOPIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.GAGASTONE.get(), ModTags.Items.GAGASTONE_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.GAGINA.get(), ModTags.Items.GAGINA_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.INFUSED_SLAGINIUM.get(), ModTags.Items.INFUSED_SLAGINIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.MYSTICAL_FLOPIUM.get(), ModTags.Items.MYSTICAL_FLOPIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.SLAGINIUM.get(), ModTags.Items.SLAGINIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, ModItems.SHENSEIUM.get(), ModTags.Items.SHENSEIUM_BLOCK);
        storageBlockRecipe(pWriter, ModBlocks.FLOPIUM_BLOCK.get(), ModTags.Items.FLOPIUM);
        storageBlockRecipe(pWriter, ModBlocks.GAGASTONE_BLOCK.get(), ModItems.GAGASTONE.get());
        storageBlockRecipe(pWriter, ModBlocks.GAGINA_BLOCK.get(), ModItems.GAGINA.get());
        storageBlockRecipe(pWriter, ModBlocks.INFUSED_SLAGINIUM_BLOCK.get(), ModTags.Items.INFUSED_SLAGINIUM_INGOT);
        storageBlockRecipe(pWriter, ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get(), ModTags.Items.MYSTICAL_FLOPIUM);
        storageBlockRecipe(pWriter, ModBlocks.SLAGINIUM_BLOCK.get(), ModTags.Items.SLAGINIUM_INGOT);
        storageBlockRecipe(pWriter, ModBlocks.SHENSEIUM_BLOCK.get(), ModTags.Items.SHENSEIUM);
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_AXE, ModItems.JIAFEI_AXE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_PICKAXE, ModItems.JIAFEI_PICKAXE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_SHOVEL, ModItems.JIAFEI_SHOVEL.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_SWORD, ModItems.JIAFEI_SICKLE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_HOE, ModItems.JIAFEI_SICKLE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_HELMET, ModItems.JIAFEI_HELMET.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_CHESTPLATE, ModItems.JIAFEI_CHESTPLATE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_LEGGINGS, ModItems.JIAFEI_LEGGINGS.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_BOOTS, ModItems.JIAFEI_BOOTS.get());

        yassifierRecipe(pWriter, Ingredient.of(ModTags.Items.SLAGINIUM_INGOT), Ingredient.of(ModItems.CVM.get()),
                ModItems.SLAGINIUM_YASSIFIER.get(), ModItems.SLAGINIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(ModTags.Items.INFUSED_SLAGINIUM_INGOT), Ingredient.of(ModItems.CVM.get()),
                ModItems.SLAGINIUM_YASSIFIER_PLUS.get(), ModItems.INFUSED_SLAGINIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(ModTags.Items.FLOPIUM), Ingredient.of(ModItems.GAGASTONE.get()),
                ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get(), ModItems.FLOPIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(ModTags.Items.MYSTICAL_FLOPIUM), Ingredient.of(ModItems.GAGINA.get()),
                ModItems.SLAGINIUM_YASSIFIER_DELUXE.get(), ModItems.MYSTICAL_FLOPIUM.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ARANA_GRANDE.get())
                .pattern("101")
                .pattern("020")
                .pattern("111")
                .define('0', Items.STRING).define('1', Items.SPIDER_EYE).define('2', ModTags.Items.YASSIFER)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .group("arana_grande").save(pWriter, Modussy.MODID + ":arana_grande_from_crafting");

        pickaxolRecipe(pWriter, Ingredient.of(ModTags.Items.SLAGINIUM_INGOT), Ingredient.of(ModItems.CUPCAKE.get()),
                Ingredient.of(Items.STICK), ModItems.SLAGINIUM_PICKAXOL.get(), ModItems.SLAGINIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(ModTags.Items.INFUSED_SLAGINIUM_INGOT), Ingredient.of(ModTags.Items.SHENSEIUM),
                Ingredient.of(Items.BLAZE_ROD), ModItems.INFUSED_SLAGINIUM_PICKAXOL.get(), ModItems.INFUSED_SLAGINIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(ModTags.Items.FLOPIUM), Ingredient.of(ModItems.JIAFEI_PRODUCT.get()),
                Ingredient.of(ModItems.GAGASTONE.get()), ModItems.FLOPIUM_PICKAXOL.get(), ModItems.FLOPIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(ModTags.Items.MYSTICAL_FLOPIUM), Ingredient.of(ModItems.CVMIUM.get()),
                Ingredient.of(ModTags.Items.INFUSED_SLAGINIUM_INGOT), ModItems.MYSTICAL_FLOPIUM_PICKAXOL.get(), ModItems.MYSTICAL_FLOPIUM.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUPCAKKE_SPAWN_EGG.get())
                .pattern("242")
                .pattern("101")
                .pattern("232")
                .define('0', ModTags.Items.YASSIFER).define('1', ModItems.CUPCAKE.get())
                .define('2', ModItems.CVMTITPLASM.get()).define('3', ModItems.POSEI.get())
                .define('4', ModItems.CVM.get()).group("cupcakke_spawn")
                .unlockedBy(getHasName(ModItems.CVMTITPLASM.get()), has(ModItems.CVMTITPLASM.get()))
                .save(pWriter, Modussy.MODID + ":cupcakke_spawn_egg_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CVM_INFUSION_ALTER.get())
                .pattern("010")
                .pattern("020")
                .pattern("030")
                .define('0', ModTags.Items.SLAGINIUM_INGOT).define('1', ModItems.CVM.get())
                .define('2', Items.CRAFTING_TABLE).define('3', ModItems.CVMTITPLASM.get())
                .unlockedBy(getHasName(ModItems.SLAGINIUM.get()), has(ModItems.SLAGINIUM.get()))
                .group("cvm_infusion").save(pWriter, Modussy.MODID + ":cvm_infusion_altar_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TAMPON.get())
                .pattern("020")
                .pattern("010")
                .pattern(" 1 ")
                .define('0', ModItems.HAIRUSSY.get()).define('1', Items.STRING)
                .define('2', ModTags.Items.SLAGINIUM_INGOT)
                .unlockedBy(getHasName(ModItems.SLAGINIUM.get()), has(ModItems.SLAGINIUM.get()))
                .group("tampon").save(pWriter, Modussy.MODID + ":tampon_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BARBIE_LANTERN.get())
                .pattern("010")
                .pattern("111")
                .pattern("010")
                .define('0', ModTags.Items.SLAGINIUM_INGOT).define('1', ModTags.Items.BARBIE_CRYSTALS)
                .unlockedBy(getHasName(ModItems.BARBIE_CRYSTALS.get()), has(ModItems.BARBIE_CRYSTALS.get()))
                .group("barbie_lantern").save(pWriter, Modussy.MODID + ":barbie_lantern_from_crafting");

        jiafeiSmithingRecipe(pWriter, ModItems.JIAFEI_TRIM_TEMPLATE.get(), Ingredient.of(ModItems.JIAFEI_SEED.get()));
        jiafeiSmithingRecipe(pWriter, ModItems.JIAFEI_UPGRADE_TEMPLATE.get(), Ingredient.of(ModItems.JIAFEI_PERFUME.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HAIRUSSY.get())
                .requires(Items.LEATHER).requires(Items.BROWN_WOOL).requires(ModTags.Items.YASSIFER)
                .unlockedBy(getHasName(ModItems.SLAGINIUM_YASSIFIER.get()), has(ModItems.SLAGINIUM_YASSIFIER.get()))
                .group("hairussy")
                .save(pWriter, Modussy.MODID + ":hairussy_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SCARUSSY.get())
                .requires(Items.JACK_O_LANTERN).requires(Items.ENDER_PEARL)
                .requires(ModTags.Items.YASSIFER).requires(ModItems.HAIRUSSY.get())
                .unlockedBy(getHasName(ModItems.HAIRUSSY.get()), has(ModItems.HAIRUSSY.get()))
                .group("scarussy")
                .save(pWriter, Modussy.MODID + ":scarussy_from_crafting");

        trimSmithing(pWriter, ModItems.JIAFEI_TRIM_TEMPLATE.get(),
                new ResourceLocation(Modussy.MODID, getItemName(ModItems.JIAFEI_TRIM_TEMPLATE.get()) + "_smithing_trim"));
    }

    private static TagKey<Item> getYassifierFromComplexity(int pComplexity) {
        return switch (pComplexity) {
            case 0 -> ModTags.Items.YASSIFER;
            case 1 -> ModTags.Items.ADVANCED_YASSIFER;
            case 2 -> ModTags.Items.ELITE_YASSIFER;
            default -> ModTags.Items.ULTIMATE_YASSIFER;
        };
    }

    protected void jiafeiUpgradeSmithing(Consumer<FinishedRecipe> pWriter, ItemLike pBase, ItemLike pResult) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.JIAFEI_UPGRADE_TEMPLATE.get()), Ingredient.of(pBase),
                Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), RecipeCategory.MISC, pResult.asItem())
                .unlocks(getHasName(ModItems.JIAFEI_PRODUCT.get()), has(ModItems.JIAFEI_PRODUCT.get()))
                .save(pWriter, new ResourceLocation(Modussy.MODID,
                        getItemName(pResult) + "_from_" + getItemName(pBase) + "_smithing"));
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pWriter,
                                      TagKey<Item> pIngredients, ItemLike pResult) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 100, RecipeSerializer.BLASTING_RECIPE)
                .group(getItemName(pResult)).unlockedBy(pIngredients.location().toString(), has(pIngredients))
                .save(pWriter,
                        Modussy.MODID + ":" + getItemName(pResult) + "_from_blasting" +
                                pIngredients.location().getPath().replace('/', '_'));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 200, RecipeSerializer.SMELTING_RECIPE)
                .group(getItemName(pResult)).unlockedBy(pIngredients.location().toString(), has(pIngredients))
                .save(pWriter,
                        Modussy.MODID + ":" + getItemName(pResult) + "_from_smelting" +
                                pIngredients.location().getPath().replace('/', '_'));
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter, ItemLike pResult, TagKey<Item> pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter, ItemLike pResult, ItemLike pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), pInput);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pInput,
                                                  ItemLike pUnlocker) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, 9)
                .requires(pInput).group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter);
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, TagKey<Item> pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem());
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, ItemLike pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), pInput);
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter,
                                             ItemLike pResult, Ingredient pInput, ItemLike pUnlocker) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput, 9).group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_components");
    }

    protected static void cupcakkeDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.CUPCAKE.get()), pResult, pInput, 0);
    }

    protected static void cupcakkeDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.CUPCAKE.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 0);
    }

    protected static void dejeBullyingDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.DISC_DEJE_BULLYING.get()), pResult, pInput, 3);
    }

    protected static void dejeBullyingDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.DISC_DEJE_BULLYING.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 3);
    }

    protected static void jiafeiDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), pResult, pInput, 2);
    }

    protected static void jiafeiDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModItems.JIAFEI_PRODUCT.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 2);
    }

    protected static void ponmiDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModTags.Items.SHENSEIUM), pResult, pInput, 1);
    }

    protected static void ponmiDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(ModTags.Items.SHENSEIUM), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 1);
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, Ingredient pCatalyst1,
                                          ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(pCatalyst1);

        if (pComplexity >= 0) builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, Ingredient pCatalyst1,
                                          Ingredient pCatalyst2, ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(pCatalyst1).requires(pCatalyst2);

        if (pComplexity > 0)  builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_" +
                        getItemName(pUnlocker) + "_crafting");
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput,
                                          ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput);

        if (pComplexity > 0)  builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_" +
                        getItemName(pUnlocker) + "_crafting");
    }

    protected static void yassifierRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pOutliner, Ingredient pCatalyst,
                                          ItemLike pResult, ItemLike pUnlocker) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("101")
                .pattern("1 1")
                .pattern(" 1 ")
                .define('1', pOutliner).define('0', pCatalyst)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void pickaxolRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, Ingredient pHolder,
                                          Ingredient pStick, ItemLike pResult, ItemLike pUnlocker) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("010")
                .pattern("02 ")
                .pattern(" 2 ")
                .define('0', pMaterial).define('1', pHolder).define('2', pStick)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("010")
                .pattern(" 20")
                .pattern(" 2 ")
                .define('0', pMaterial).define('1', pHolder).define('2', pStick)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Modussy.MODID + ":" + getItemName(pResult) + "_inverted_from_crafting");
    }

    protected static void jiafeiSmithingRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pTemplate, Ingredient pUpgrade) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pTemplate, 2)
                .pattern("020")
                .pattern("010")
                .pattern("000")
                .define('0', ModItems.JIAFEI_PRODUCT.get()).define('1', pUpgrade)
                .define('2', pTemplate)
                .unlockedBy(getHasName(pTemplate), has(pTemplate))
                .group(getHasName(pTemplate)).save(pWriter, Modussy.MODID + ":" + getHasName(pTemplate) + "_from_crafting");
    }
}
