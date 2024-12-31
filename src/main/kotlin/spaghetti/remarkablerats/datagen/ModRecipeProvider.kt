package spaghetti.remarkablerats.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import spaghetti.remarkablerats.block.ModBlocks
import spaghetti.remarkablerats.item.ModItems
import java.util.concurrent.CompletableFuture

class ModRecipeProvider
    (output: FabricDataOutput, registriesFuture: CompletableFuture<WrapperLookup>) :
    FabricRecipeProvider(output, registriesFuture) {

    override fun generate(exporter: RecipeExporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ratatouille, 1)
            .input(Items.BOWL)
            .input(ModBlocks.morton_pink_granite)
            .criterion(hasItem(ModBlocks.morton_pink_granite), conditionsFromItem(ModBlocks.morton_pink_granite))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.morton_pink_granite, 1)
            .input(Items.GRANITE)
            .criterion(hasItem(Items.GRANITE), conditionsFromItem(Items.GRANITE))
            .offerTo(exporter);
    }
}