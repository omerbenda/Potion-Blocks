package com.potionblocks.potion;

import com.potionblocks.utils.ModBrewingRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModPotionRecipes {

  public static void registerRecipes() {
    BrewingRecipeRegistry.addRecipe(
        new ModBrewingRecipe(Potions.AWKWARD, Items.ENDER_EYE, ModPotions.BLINDNESS_POTION.get()));

    BrewingRecipeRegistry.addRecipe(
        new ModBrewingRecipe(
            Potions.SLOW_FALLING, Items.FERMENTED_SPIDER_EYE, ModPotions.GRAVITY_POTION.get()));
  }
}
