package io.github.xathech.leatherbundle.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static io.github.xathech.leatherbundle.LeatherBundleRecipe.MOD_ID;

public class LeatherBundleRecipeProvider extends FabricRecipeProvider {

    public LeatherBundleRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){

        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter){

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.BUNDLE)
                .input(Items.STRING)
                .input(Items.LEATHER)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(recipeExporter, Identifier.of(MOD_ID, "bundle"));
    }
}
