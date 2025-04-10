package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE,
                ModBlocks.DEEPSLATE_TIN_ORE);

        offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 200, "tin");
        offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 100, "tin");

        //Tool
        //Copper Tool
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" I ")
                .input('R', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.COPPER_SWORD), conditionsFromItem(ModItems.COPPER_SWORD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .pattern("RRR")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.COPPER_PICKAXE), conditionsFromItem(ModItems.COPPER_PICKAXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .pattern("RR ")
                .pattern("RI ")
                .pattern(" I ")
                .input('R', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.COPPER_AXE), conditionsFromItem(ModItems.COPPER_AXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .pattern("RR ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.COPPER_HOE), conditionsFromItem(ModItems.COPPER_HOE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .pattern(" R ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.COPPER_SHOVEL), conditionsFromItem(ModItems.COPPER_SHOVEL))
                .offerTo(exporter);

        //Bronze Tool
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" I ")
                .input('R', ModItems.BRONZE_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_SWORD), conditionsFromItem(ModItems.BRONZE_SWORD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern("RRR")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.BRONZE_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_PICKAXE), conditionsFromItem(ModItems.BRONZE_PICKAXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern("RR ")
                .pattern("RI ")
                .pattern(" I ")
                .input('R', ModItems.BRONZE_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_AXE), conditionsFromItem(ModItems.BRONZE_AXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern("RR ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.BRONZE_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_HOE), conditionsFromItem(ModItems.BRONZE_HOE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern(" R ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.BRONZE_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_SHOVEL), conditionsFromItem(ModItems.BRONZE_SHOVEL))
                .offerTo(exporter);

        //Tin Tool
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" I ")
                .input('R', ModItems.TIN_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.TIN_SWORD), conditionsFromItem(ModItems.TIN_SWORD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_PICKAXE)
                .pattern("RRR")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.TIN_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.TIN_PICKAXE), conditionsFromItem(ModItems.TIN_PICKAXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_AXE)
                .pattern("RR ")
                .pattern("RI ")
                .pattern(" I ")
                .input('R', ModItems.TIN_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.TIN_AXE), conditionsFromItem(ModItems.TIN_AXE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_HOE)
                .pattern("RR ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.TIN_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.TIN_HOE), conditionsFromItem(ModItems.TIN_HOE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SHOVEL)
                .pattern(" R ")
                .pattern(" I ")
                .pattern(" I ")
                .input('R', ModItems.TIN_INGOT)
                .input('I', Items.STICK)
                .criterion(hasItem(ModItems.TIN_SHOVEL), conditionsFromItem(ModItems.TIN_SHOVEL))
                .offerTo(exporter);

        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));

        offerSmithingTrimRecipe(exporter, ModItems.KAUPEN_SMITHING_TEMPLATE, Identifier.of(TutorialMod.MOD_ID, "kaupen"));


    }

}
