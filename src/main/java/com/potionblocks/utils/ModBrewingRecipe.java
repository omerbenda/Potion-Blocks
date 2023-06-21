package com.potionblocks.utils;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;

public class ModBrewingRecipe implements IBrewingRecipe {

  private final Potion inputPotion;
  private final Item inputIngredient;
  private final Potion resultPotion;

  public ModBrewingRecipe(Potion inputPotion, Item inputIngredient, Potion resultPotion) {
    this.inputPotion = inputPotion;
    this.inputIngredient = inputIngredient;
    this.resultPotion = resultPotion;
  }

  @Override
  public boolean isInput(@NotNull ItemStack input) {
    return PotionUtils.getPotion(input).equals(this.inputPotion);
  }

  @Override
  public boolean isIngredient(ItemStack ingredient) {
    return ingredient.getItem().equals(this.inputIngredient);
  }

  @Override
  public @NotNull ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
    if (!this.isInput(input) || !this.isIngredient(ingredient)) {
      return ItemStack.EMPTY;
    }

    ItemStack resultItemStack = new ItemStack(input.getItem());
    PotionUtils.setPotion(resultItemStack, this.resultPotion);

    return resultItemStack;
  }
}
