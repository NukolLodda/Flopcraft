package net.nukollodda.flopcraft.datagen;

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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.datagen.tags.FlopTags;
import net.nukollodda.flopcraft.item.FlopItems;

import java.util.function.Consumer;

public class FlopRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public FlopRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, FlopTags.Items.SHENSEIUM_ORE, FlopItems.SHENSEIUM.get());
        oreBlasting(pWriter, FlopTags.Items.BRAT_ORE, FlopItems.BRAT.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_STRAD, FlopItems.DISC_C1.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.DISC_CUPCAKKE3.get(), FlopItems.DISC_C2.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.DISC_C15.get(), FlopItems.DISC_C3.get());
        cupcakkeDiscRecipe(pWriter, Items.ACACIA_LOG, FlopItems.DISC_C4.get());
        cupcakkeDiscRecipe(pWriter, Items.SPORE_BLOSSOM, FlopItems.DISC_C5.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_CAT, FlopItems.DISC_C6.get());
        cupcakkeDiscRecipe(pWriter, Items.ENDER_PEARL, FlopItems.DISC_C7.get());
        cupcakkeDiscRecipe(pWriter, Items.MUSIC_DISC_MELLOHI, FlopItems.DISC_C8.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.INFUSED_SLAGINIUM.get(), FlopItems.DISC_C9.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.WONYOUNG_ESSENCE.get(), FlopItems.DISC_C10.get());
        cupcakkeDiscRecipe(pWriter, Items.PISTON, FlopItems.DISC_C11.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.ARANA_GRANDE.get(), FlopItems.DISC_C12.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.CVMTITPLASM.get(), FlopItems.DISC_C13.get());
        cupcakkeDiscRecipe(pWriter, Items.FERMENTED_SPIDER_EYE, FlopItems.DISC_C14.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.HAIRUSSY.get(), FlopItems.DISC_C15.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.BRA.get(), FlopItems.DISC_C16.get());
        cupcakkeDiscRecipe(pWriter, Items.END_STONE, FlopItems.DISC_C17.get());
        cupcakkeDiscRecipe(pWriter, Items.ALLIUM, FlopItems.DISC_C18.get());
        cupcakkeDiscRecipe(pWriter, Items.IRON_INGOT, FlopItems.DISC_C19.get());
        cupcakkeDiscRecipe(pWriter, Items.GLASS, FlopItems.DISC_C20.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.GAGASTONE.get(), FlopItems.DISC_C21.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.CVM_FLUID_BUCKET.get(), FlopItems.DISC_C22.get());
        cupcakkeDiscRecipe(pWriter, ItemTags.SAND, FlopItems.DISC_C23.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.SCARUSSY.get(), FlopItems.DISC_C24.get());
        cupcakkeDiscRecipe(pWriter, Items.SNOWBALL, FlopItems.DISC_C25.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.SLAGINIUM.get(), FlopItems.DISC_C26.get());
        cupcakkeDiscRecipe(pWriter, FlopBlocks.MARIAH_CAREY_ICE_BLOCK.get(), FlopItems.DISC_C27.get());
        cupcakkeDiscRecipe(pWriter, Items.SPRUCE_LEAVES, FlopItems.DISC_C28.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.TWINK_EGG_SHELLS.get(), FlopItems.DISC_C29.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.KYLIE_JENNER_LIPSTICK.get(), FlopItems.DISC_C30.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.BRAT.get(), FlopItems.DISC_C31.get());
        cupcakkeDiscRecipe(pWriter, FlopItems.LANCVM_CREAM.get(), FlopItems.DISC_C32.get());
        ponmiDiscRecipe(pWriter, Items.OAK_LOG, FlopItems.DISC_PM1.get());
        jiafeiDiscRecipe(pWriter, FlopItems.HAIRUSSY.get(), FlopItems.DISC_J1.get());
        jiafeiDiscRecipe(pWriter, Items.MINECART, FlopItems.DISC_J2.get());
        jiafeiDiscRecipe(pWriter, FlopItems.TWINK_EGG_SHELLS.get(), FlopItems.DISC_J3.get());
        jiafeiDiscRecipe(pWriter, FlopItems.DISC_JIAFEI.get(), FlopItems.DISC_J4.get());
        jiafeiDiscRecipe(pWriter, Items.ENDER_PEARL, FlopItems.DISC_J5.get());
        jiafeiDiscRecipe(pWriter, Items.TINTED_GLASS, FlopItems.DISC_J6.get());
        jiafeiDiscRecipe(pWriter, Blocks.STONE_PRESSURE_PLATE, FlopItems.DISC_J7.get());
        kamalaDiscRecipe(pWriter, FlopItems.BRATIFICATIONER.get(), FlopItems.DISC_K1.get());
        kamalaDiscRecipe(pWriter, Blocks.COBBLESTONE, FlopItems.DISC_K2.get());
        kamalaDiscRecipe(pWriter, FlopItems.DISC_CUPCAKKE3.get(), FlopItems.DISC_K3.get());
        dejeBullyingDiscRecipe(pWriter, Items.MUSIC_DISC_CAT, FlopItems.DISC_DB1.get());

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(Items.LEATHER_CHESTPLATE), FlopItems.DISC_CJ1.get(), Items.LEATHER_CHESTPLATE, 2);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(Items.SPYGLASS), FlopItems.DISC_JC1.get(), Items.SPYGLASS, 2);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(FlopItems.SLAGINIUM.get()), FlopItems.DISC_JC2.get(), FlopItems.SLAGINIUM.get(), 2);

        musicDiscRecipe(pWriter, Ingredient.of(FlopTags.Items.SHENSEIUM), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(FlopItems.DISC_C1.get()), FlopItems.DISC_CPM1.get(), FlopItems.DISC_C1.get(), 1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.MUSIC_DISC_11), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), FlopItems.DISC_RANVISION.get(), Items.MUSIC_DISC_11, 2);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.SCARUSSY.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE1.get(), FlopItems.SCARUSSY.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.HAIRUSSY.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE2.get(), FlopItems.HAIRUSSY.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.POSEI.get()), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE3.get(), FlopItems.POSEI.get(), -1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.WATER_BUCKET), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE4.get(), Items.WATER_BUCKET, -1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.DARK_OAK_LOG), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE5.get(), Items.DARK_OAK_LOG, -1);

        musicDiscRecipe(pWriter, Ingredient.of(Items.GLASS_BOTTLE), Ingredient.of(FlopItems.CUPCAKE.get()),
                FlopItems.DISC_CUPCAKKE6.get(), Items.GLASS_BOTTLE, -1); // todo change this to breeze rods for 1.21

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()),
                FlopItems.DISC_JIAFEI.get(), FlopItems.JIAFEI_PRODUCT.get(), 2);

        musicDiscRecipe(pWriter, Ingredient.of(FlopTags.Items.SHENSEIUM),
                FlopItems.DISC_PONMI.get(), FlopItems.SHENSEIUM.get(), 1);

        jiafeiDiscRecipe(pWriter, FlopItems.DISC_C26.get(), FlopItems.DISC_JC2.get());

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.DISC_CUPCAKKE1.get()),
                FlopItems.DISC_C24.get(), FlopItems.DISC_CUPCAKKE1.get(), 1);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.DISC_CUPCAKKE2.get()),
                FlopItems.DISC_C15.get(), FlopItems.DISC_CUPCAKKE2.get(), 1);

        musicDiscRecipe(pWriter, Ingredient.of(FlopItems.DISC_CUPCAKKE3.get()),
                FlopItems.DISC_C2.get(), FlopItems.DISC_CUPCAKKE3.get(), 1);

        nineBlockStorageRecipes(pWriter, FlopItems.BRAT.get(), FlopTags.Items.BRAT_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.FLOPIUM.get(), FlopTags.Items.FLOPIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.GAGASTONE.get(), FlopTags.Items.GAGASTONE_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.GAGINA.get(), FlopTags.Items.GAGINA_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.INFUSED_SLAGINIUM.get(), FlopTags.Items.INFUSED_SLAGINIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.MYSTICAL_FLOPIUM.get(), FlopTags.Items.MYSTICAL_FLOPIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.SLAGINIUM.get(), FlopTags.Items.SLAGINIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, FlopItems.SHENSEIUM.get(), FlopTags.Items.SHENSEIUM_BLOCK);
        storageBlockRecipe(pWriter, FlopBlocks.BRAT_BLOCK.get(), FlopTags.Items.BRAT);
        storageBlockRecipe(pWriter, FlopBlocks.FLOPIUM_BLOCK.get(), FlopTags.Items.FLOPIUM);
        storageBlockRecipe(pWriter, FlopBlocks.GAGASTONE_BLOCK.get(), FlopItems.GAGASTONE.get());
        storageBlockRecipe(pWriter, FlopBlocks.GAGINA_BLOCK.get(), FlopItems.GAGINA.get());
        storageBlockRecipe(pWriter, FlopBlocks.INFUSED_SLAGINIUM_BLOCK.get(), FlopTags.Items.INFUSED_SLAGINIUM_INGOT);
        storageBlockRecipe(pWriter, FlopBlocks.MYSTICAL_FLOPIUM_BLOCK.get(), FlopTags.Items.MYSTICAL_FLOPIUM);
        storageBlockRecipe(pWriter, FlopBlocks.SLAGINIUM_BLOCK.get(), FlopTags.Items.SLAGINIUM_INGOT);
        storageBlockRecipe(pWriter, FlopBlocks.SHENSEIUM_BLOCK.get(), FlopTags.Items.SHENSEIUM);
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_AXE, FlopItems.JIAFEI_AXE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_PICKAXE, FlopItems.JIAFEI_PICKAXE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_SHOVEL, FlopItems.JIAFEI_SHOVEL.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_SWORD, FlopItems.JIAFEI_SICKLE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_HOE, FlopItems.JIAFEI_SICKLE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_HELMET, FlopItems.JIAFEI_HELMET.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_CHESTPLATE, FlopItems.JIAFEI_CHESTPLATE.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_LEGGINGS, FlopItems.JIAFEI_LEGGINGS.get());
        jiafeiUpgradeSmithing(pWriter, Items.NETHERITE_BOOTS, FlopItems.JIAFEI_BOOTS.get());

        yassifierRecipe(pWriter, Ingredient.of(FlopTags.Items.SLAGINIUM_INGOT), Ingredient.of(FlopItems.CVM.get()),
                FlopItems.SLAGINIUM_YASSIFIER.get(), FlopItems.SLAGINIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(FlopTags.Items.INFUSED_SLAGINIUM_INGOT), Ingredient.of(FlopItems.CVM.get()),
                FlopItems.SLAGINIUM_YASSIFIER_PLUS.get(), FlopItems.INFUSED_SLAGINIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(FlopTags.Items.FLOPIUM), Ingredient.of(FlopItems.GAGASTONE.get()),
                FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get(), FlopItems.FLOPIUM.get());

        yassifierRecipe(pWriter, Ingredient.of(FlopTags.Items.MYSTICAL_FLOPIUM), Ingredient.of(FlopItems.GAGINA.get()),
                FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get(), FlopItems.MYSTICAL_FLOPIUM.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.ARANA_GRANDE.get())
                .pattern("101")
                .pattern("020")
                .pattern("111")
                .define('0', Items.STRING).define('1', Items.SPIDER_EYE).define('2', FlopTags.Items.YASSIFER)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .group("arana_grande").save(pWriter, Flopcraft.MODID + ":arana_grande_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.TWINK_TRANSFORMER.get())
                .pattern(" 0 ")
                .pattern(" 1 ")
                .pattern(" 2 ")
                .define('0', FlopTags.Items.BRAT).define('1', FlopItems.TWINK_EGG_PILE.get())
                .define('2', Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(FlopItems.TWINK_EGG_PILE.get()), has(FlopItems.TWINK_EGG_PILE.get()))
                .group("twink_transformer").save(pWriter, Flopcraft.MODID + ":twink_transformer_from_crafting");

        pickaxolRecipe(pWriter, Ingredient.of(FlopTags.Items.SLAGINIUM_INGOT), Ingredient.of(FlopItems.CUPCAKE.get()),
                Ingredient.of(Items.STICK), FlopItems.SLAGINIUM_PICKAXOL.get(), FlopItems.SLAGINIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(FlopTags.Items.INFUSED_SLAGINIUM_INGOT), Ingredient.of(FlopTags.Items.SHENSEIUM),
                Ingredient.of(Items.BLAZE_ROD), FlopItems.INFUSED_SLAGINIUM_PICKAXOL.get(), FlopItems.INFUSED_SLAGINIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(FlopTags.Items.FLOPIUM), Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()),
                Ingredient.of(FlopItems.GAGASTONE.get()), FlopItems.FLOPIUM_PICKAXOL.get(), FlopItems.FLOPIUM.get());

        pickaxolRecipe(pWriter, Ingredient.of(FlopTags.Items.MYSTICAL_FLOPIUM), Ingredient.of(FlopItems.CVMIUM.get()),
                Ingredient.of(FlopTags.Items.INFUSED_SLAGINIUM_INGOT), FlopItems.MYSTICAL_FLOPIUM_PICKAXOL.get(), FlopItems.MYSTICAL_FLOPIUM.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.CUPCAKKE_SPAWN_EGG.get())
                .pattern("242")
                .pattern("101")
                .pattern("232")
                .define('0', FlopTags.Items.YASSIFER).define('1', FlopItems.CUPCAKE.get())
                .define('2', FlopItems.CVMTITPLASM.get()).define('3', FlopItems.POSEI.get())
                .define('4', FlopItems.CVM.get()).group("cupcakke_spawn")
                .unlockedBy(getHasName(FlopItems.CVMTITPLASM.get()), has(FlopItems.CVMTITPLASM.get()))
                .save(pWriter, Flopcraft.MODID + ":cupcakke_spawn_egg_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.BRAT_APPLE.get())
                .pattern("000")
                .pattern("010")
                .pattern("000")
                .define('0', FlopTags.Items.BRAT).define('1', Items.APPLE)
                .group("brat_apple")
                .unlockedBy(getHasName(FlopItems.BRAT.get()), has(FlopItems.BRAT.get()))
                .save(pWriter, Flopcraft.MODID + ":brat_apple_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.BRATIFICATIONER.get())
                .pattern(" 0 ")
                .pattern("010")
                .pattern("20 ")
                .define('0', FlopTags.Items.BRAT).define('1', FlopItems.DISC_C30.get())
                .define('2', Tags.Items.RODS_WOODEN).group("bratificationer")
                .unlockedBy(getHasName(FlopItems.BRAT.get()), has(FlopItems.BRAT.get()))
                .save(pWriter, Flopcraft.MODID + ":bratificationer_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopBlocks.CVM_INFUSION_ALTER.get())
                .pattern("010")
                .pattern("020")
                .pattern("030")
                .define('0', FlopTags.Items.SLAGINIUM_INGOT).define('1', FlopItems.CVM.get())
                .define('2', Items.CRAFTING_TABLE).define('3', FlopItems.CVMTITPLASM.get())
                .unlockedBy(getHasName(FlopItems.SLAGINIUM.get()), has(FlopItems.SLAGINIUM.get()))
                .group("cvm_infusion").save(pWriter, Flopcraft.MODID + ":cvm_infusion_altar_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopBlocks.HARDENED_PERIOD_CVM.get())
                .pattern("010")
                .pattern("232")
                .pattern("010")
                .define('0', FlopTags.Items.BARBIE_CRYSTALS).define('1', FlopItems.CVM.get())
                    .define('2', FlopItems.BLOOD_CLUMP.get()).define('3', Items.OBSIDIAN)
                .unlockedBy(getHasName(FlopItems.SLAGINIUM.get()), has(FlopItems.SLAGINIUM.get()))
                .group("hardened_period_cvm").save(pWriter, Flopcraft.MODID + ":hardened_period_cvm_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopBlocks.HARDENED_PERIOD_CVM.get())
                .pattern("020")
                .pattern("131")
                .pattern("020")
                .define('0', FlopTags.Items.BARBIE_CRYSTALS).define('1', FlopItems.CVM.get())
                .define('2', FlopItems.BLOOD_CLUMP.get()).define('3', Items.OBSIDIAN)
                .unlockedBy(getHasName(FlopItems.SLAGINIUM.get()), has(FlopItems.SLAGINIUM.get()))
                .group("hardened_period_cvm").save(pWriter, Flopcraft.MODID + ":hardened_period_cvm_from_crafting_sideways");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopItems.TAMPON.get())
                .pattern("020")
                .pattern("010")
                .pattern(" 1 ")
                .define('0', FlopItems.HAIRUSSY.get()).define('1', Items.STRING)
                .define('2', FlopTags.Items.SLAGINIUM_INGOT)
                .unlockedBy(getHasName(FlopItems.SLAGINIUM.get()), has(FlopItems.SLAGINIUM.get()))
                .group("tampon").save(pWriter, Flopcraft.MODID + ":tampon_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopBlocks.BARBIE_LANTERN.get())
                .pattern("010")
                .pattern("111")
                .pattern("010")
                .define('0', FlopTags.Items.SLAGINIUM_INGOT).define('1', FlopTags.Items.BARBIE_CRYSTALS)
                .unlockedBy(getHasName(FlopItems.BARBIE_CRYSTALS.get()), has(FlopItems.BARBIE_CRYSTALS.get()))
                .group("barbie_lantern").save(pWriter, Flopcraft.MODID + ":barbie_lantern_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FlopBlocks.GIRL_YESS_PUMPKIN.get())
                .pattern("202")
                .pattern("010")
                .pattern("020")
                .define('0', FlopItems.LOVELY_PEACH.get()).define('1', FlopItems.SCARUSSY.get())
                .define('2', FlopTags.Items.FLOPIUM)
                .unlockedBy(getHasName(FlopItems.LOVELY_PEACH.get()), has(FlopItems.LOVELY_PEACH.get()))
                .group("girl_yas_pumpkin").save(pWriter, Flopcraft.MODID + ":girl_yas_pumpkin_from_crafting");

        jiafeiSmithingRecipe(pWriter, FlopItems.JIAFEI_TRIM_TEMPLATE.get(), Ingredient.of(FlopItems.JIAFEI_SEED.get()));
        jiafeiSmithingRecipe(pWriter, FlopItems.JIAFEI_UPGRADE_TEMPLATE.get(), Ingredient.of(FlopItems.JIAFEI_PERFUME.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.TWINK_EGG_PILE.get())
                .requires(FlopItems.TWINK_EGG_SHELLS.get()).requires(FlopItems.TWINK_EGG_SHELLS.get())
                .requires(FlopItems.TWINK_EGG_SHELLS.get()).requires(FlopItems.TWINK_EGG_SHELLS.get()).requires(FlopItems.CVM_FLUID_BUCKET.get())
                .unlockedBy(getHasName(FlopItems.TWINK_EGG_SHELLS.get()), has(FlopItems.TWINK_EGG_SHELLS.get()))
                .group("twink_egg_shell")
                .save(pWriter, Flopcraft.MODID + ":twink_egg_shell_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.HAIRUSSY.get())
                .requires(Items.LEATHER).requires(Items.BROWN_WOOL).requires(FlopTags.Items.YASSIFER)
                .unlockedBy(getHasName(FlopItems.SLAGINIUM_YASSIFIER.get()), has(FlopItems.SLAGINIUM_YASSIFIER.get()))
                .group("hairussy")
                .save(pWriter, Flopcraft.MODID + ":hairussy_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopBlocks.KAMALOCONUT_PALM_SAPLING.get())
                .requires(FlopTags.Items.BRAT).requires(FlopItems.KAMALOCONUT.get()).requires(FlopTags.Items.YASSIFER)
                .unlockedBy(getHasName(FlopItems.SLAGINIUM_YASSIFIER.get()), has(FlopItems.SLAGINIUM_YASSIFIER.get()))
                .group("hairussy")
                .save(pWriter, Flopcraft.MODID + ":kamaloconut_sapling_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.SCARUSSY.get())
                .requires(Items.JACK_O_LANTERN).requires(Items.ENDER_PEARL)
                .requires(FlopTags.Items.YASSIFER).requires(FlopItems.HAIRUSSY.get())
                .unlockedBy(getHasName(FlopItems.HAIRUSSY.get()), has(FlopItems.HAIRUSSY.get()))
                .group("scarussy")
                .save(pWriter, Flopcraft.MODID + ":scarussy_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.SLAGINIUM.get())
                .requires(FlopItems.CUPCAKE.get()).requires(Items.GOLD_INGOT, 3)
                .requires(FlopItems.CVM.get(), 3)
                .unlockedBy(getHasName(FlopItems.CUPCAKE.get()), has(FlopItems.CUPCAKE.get()))
                .group("slaginium")
                .save(pWriter, Flopcraft.MODID + ":slaginium_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.INFUSED_SLAGINIUM.get())
                .requires(FlopItems.SLAGINIUM.get()).requires(FlopItems.SHENSEIUM.get())
                .unlockedBy(getHasName(FlopItems.SHENSEIUM.get()), has(FlopItems.SHENSEIUM.get()))
                .group("infused_slaginium")
                .save(pWriter, Flopcraft.MODID + ":infused_slaginium_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.CVM.get(), 3)
                .requires(Items.BLAZE_ROD).requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .group("cvm")
                .save(pWriter, Flopcraft.MODID + ":cvm_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.CVM_FLUID_BUCKET.get())
                .requires(Items.BUCKET).requires(FlopItems.CVM.get(), 8)
                .unlockedBy(getHasName(FlopItems.CVM.get()), has(FlopItems.CVM.get()))
                .group("cvm_fluid")
                .save(pWriter, Flopcraft.MODID + ":cvm_fluid_bucket_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.POOSAY_JUICE_BUCKET.get())
                .requires(FlopItems.POSEI.get(), 4).requires(Items.BUCKET)
                .unlockedBy(getHasName(FlopItems.POSEI.get()), has(FlopItems.POSEI.get()))
                .group("poosay_juice")
                .save(pWriter, Flopcraft.MODID + ":poosay_juice_bucket_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.CVM.get(), 8)
                .requires(FlopItems.CVM_FLUID_BUCKET.get())
                .unlockedBy(getHasName(FlopItems.CVM.get()), has(FlopItems.CVM.get()))
                .group("cvm_fluid")
                .save(pWriter, Flopcraft.MODID + ":cvm_from_fluid_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.POSEI.get(), 4)
                .requires(FlopItems.POOSAY_JUICE_BUCKET.get())
                .unlockedBy(getHasName(FlopItems.POOSAY_JUICE_BUCKET.get()), has(FlopItems.POOSAY_JUICE_BUCKET.get()))
                .group("poosay_juice")
                .save(pWriter, Flopcraft.MODID + ":posei_from_fluid_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FlopItems.CVM_PIE.get(), 1)
                .requires(FlopItems.SCARUSSY.get()).requires(FlopItems.CVM.get())
                .requires(FlopItems.TWINK_EGG.get()).unlockedBy(getHasName(FlopItems.TWINK_EGG.get()), has(FlopItems.TWINK_EGG.get()))
                .group("cvm_pie")
                .save(pWriter, Flopcraft.MODID + ":cvm_pie_from_crafting");

        trimSmithing(pWriter, FlopItems.JIAFEI_TRIM_TEMPLATE.get(),
                ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, getItemName(FlopItems.JIAFEI_TRIM_TEMPLATE.get()) + "_smithing_trim"));

        planksRecipe(pWriter, FlopBlocks.LOVELY_PEACH_PLANKS.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_LOG.get()));
        fenceRecipe(pWriter, FlopBlocks.LOVELY_PEACH_FENCE.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        fenceGateRecipe(pWriter, FlopBlocks.LOVELY_PEACH_FENCE_GATE.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        doorRecipe(pWriter, FlopBlocks.LOVELY_PEACH_DOOR.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        trapdoorRecipe(pWriter, FlopBlocks.LOVELY_PEACH_TRAPDOOR.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        stairRecipe(pWriter, FlopBlocks.LOVELY_PEACH_STAIRS.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        slabRecipe(pWriter, FlopBlocks.LOVELY_PEACH_SLABS.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        pressurePlate(pWriter, FlopBlocks.LOVELY_PEACH_PRESSURE_PLATE.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));
        buttonRecipe(pWriter, FlopBlocks.LOVELY_PEACH_BUTTON.get(), Ingredient.of(FlopBlocks.LOVELY_PEACH_PLANKS.get()));

        planksRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_PLANKS.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_LOG.get()));
        fenceRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_FENCE.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        fenceGateRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_FENCE_GATE.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        doorRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_DOOR.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        trapdoorRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_TRAPDOOR.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        stairRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_STAIRS.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        slabRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_SLABS.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        pressurePlate(pWriter, FlopBlocks.KAMALOCONUT_PALM_PRESSURE_PLATE.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
        buttonRecipe(pWriter, FlopBlocks.KAMALOCONUT_PALM_BUTTON.get(), Ingredient.of(FlopBlocks.KAMALOCONUT_PALM_PLANKS.get()));
    }

    private static TagKey<Item> getYassifierFromComplexity(int pComplexity) {
        return switch (pComplexity) {
            case 0 -> FlopTags.Items.YASSIFER;
            case 1 -> FlopTags.Items.ADVANCED_YASSIFER;
            case 2 -> FlopTags.Items.ELITE_YASSIFER;
            default -> FlopTags.Items.ULTIMATE_YASSIFER;
        };
    }

    protected void jiafeiUpgradeSmithing(Consumer<FinishedRecipe> pWriter, ItemLike pBase, ItemLike pResult) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FlopItems.JIAFEI_UPGRADE_TEMPLATE.get()), Ingredient.of(pBase),
                Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), RecipeCategory.MISC, pResult.asItem())
                .unlocks(getHasName(FlopItems.JIAFEI_PRODUCT.get()), has(FlopItems.JIAFEI_PRODUCT.get()))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID,
                        getItemName(pResult) + "_from_" + getItemName(pBase) + "_smithing"));
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pWriter,
                                      TagKey<Item> pIngredients, ItemLike pResult) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 100, RecipeSerializer.BLASTING_RECIPE)
                .group(getItemName(pResult)).unlockedBy(pIngredients.location().toString(), has(pIngredients))
                .save(pWriter,
                        Flopcraft.MODID + ":" + getItemName(pResult) + "_from_blasting" +
                                pIngredients.location().getPath().replace('/', '_'));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 200, RecipeSerializer.SMELTING_RECIPE)
                .group(getItemName(pResult)).unlockedBy(pIngredients.location().toString(), has(pIngredients))
                .save(pWriter,
                        Flopcraft.MODID + ":" + getItemName(pResult) + "_from_smelting" +
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
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_components");
    }

    protected static void cupcakkeDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.CUPCAKE.get()), pResult, pInput, 0);
    }

    protected static void cupcakkeDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.CUPCAKE.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 0);
    }

    protected static void dejeBullyingDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.DISC_DEJE_BULLYING.get()), pResult, pInput, 3);
    }

    protected static void dejeBullyingDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.DISC_DEJE_BULLYING.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 3);
    }

    protected static void jiafeiDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), pResult, pInput, 2);
    }

    protected static void jiafeiDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.JIAFEI_PRODUCT.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 2);
    }

    protected static void kamalaDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.KAMALOCONUT.get()), pResult, pInput, 1);
    }

    protected static void kamalaDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopItems.KAMALOCONUT.get()), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 1);
    }

    protected static void ponmiDiscRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopTags.Items.SHENSEIUM), pResult, pInput, 1);
    }

    protected static void ponmiDiscRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        musicDiscRecipe(pWriter, Ingredient.of(pInput), Ingredient.of(FlopTags.Items.SHENSEIUM), pResult,
                Ingredient.of(pInput).getItems()[0].getItem(), 1);
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, Ingredient pCatalyst1,
                                          ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(pCatalyst1);

        if (pComplexity >= 0) builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, Ingredient pCatalyst1,
                                          Ingredient pCatalyst2, ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(pCatalyst1).requires(pCatalyst2);

        if (pComplexity > 0)  builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_" +
                        getItemName(pUnlocker) + "_crafting");
    }

    protected static void musicDiscRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput,
                                          ItemLike pResult, ItemLike pUnlocker, int pComplexity) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput);

        if (pComplexity > 0)  builder.requires(getYassifierFromComplexity(pComplexity));

        builder.group(getItemName(pResult)).unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_" +
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
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
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
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("010")
                .pattern(" 20")
                .pattern(" 2 ")
                .define('0', pMaterial).define('1', pHolder).define('2', pStick)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_inverted_from_crafting");
    }

    protected static void jiafeiSmithingRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pTemplate, Ingredient pUpgrade) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pTemplate, 2)
                .pattern("020")
                .pattern("010")
                .pattern("000")
                .define('0', FlopItems.JIAFEI_PRODUCT.get()).define('1', pUpgrade)
                .define('2', pTemplate)
                .unlockedBy(getHasName(pTemplate), has(pTemplate))
                .group(getHasName(pTemplate)).save(pWriter, Flopcraft.MODID + ":" + getHasName(pTemplate) + "_from_crafting");
    }

    protected static void fenceRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 3)
                .pattern("010")
                .pattern("010")
                .define('0', pMaterial).define('1', Items.STICK)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void fenceGateRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("101")
                .pattern("101")
                .define('0', pMaterial).define('1', Items.STICK)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void doorRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 3)
                .pattern("00")
                .pattern("00")
                .pattern("00")
                .define('0', pMaterial)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void trapdoorRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 2)
                .pattern("000")
                .pattern("000")
                .define('0', pMaterial)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void stairRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 4)
                .pattern("0  ")
                .pattern("00 ")
                .pattern("000")
                .define('0', pMaterial)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void slabRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 6)
                .pattern("000")
                .define('0', pMaterial)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void pressurePlate(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("00")
                .define('0', pMaterial)
                .group(getItemName(pResult))
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void planksRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, 4)
                .requires(pMaterial)
                .unlockedBy(getHasName(pResult), has(pResult))
                .group(getItemName(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void buttonRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pMaterial) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pMaterial)
                .unlockedBy(getHasName(pResult), has(pResult))
                .group(getItemName(pResult))
                .save(pWriter, Flopcraft.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }
}
