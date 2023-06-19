package com.potionblocks.block;

import com.potionblocks.PotionBlocks;
import com.potionblocks.block.custom.EmptyPotionBlock;
import com.potionblocks.block.custom.PotionBlock;
import com.potionblocks.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, PotionBlocks.MOD_ID);

  public static final RegistryObject<EmptyPotionBlock> EMPTY_POTION_BLOCK =
      registerBlock("empty_potion_block", EmptyPotionBlock::new);

  public static final RegistryObject<PotionBlock> SPEED_POTION_BLOCK =
      registerBlock(
          "speed_potion_block", () -> new PotionBlock(MobEffects.MOVEMENT_SPEED, 3000, 0));

  public static final RegistryObject<PotionBlock> SLOWNESS_POTION_BLOCK =
      registerBlock(
          "slowness_potion_block", () -> new PotionBlock(MobEffects.MOVEMENT_SLOWDOWN, 1600, 0));

  public static final RegistryObject<PotionBlock> POISON_POTION_BLOCK =
      registerBlock("poison_potion_block", () -> new PotionBlock(MobEffects.POISON, 600, 0));

  public static final RegistryObject<PotionBlock> REGEN_POTION_BLOCK =
      registerBlock("regen_potion_block", () -> new PotionBlock(MobEffects.REGENERATION, 900, 0));

  public static final RegistryObject<PotionBlock> BLINDNESS_POTION_BLOCK =
      registerBlock("blindness_potion_block", () -> new PotionBlock(MobEffects.BLINDNESS, 450, 0));

  public static final RegistryObject<PotionBlock> JUMP_POTION_BLOCK =
      registerBlock("jump_potion_block", () -> new PotionBlock(MobEffects.JUMP, 600, 0));

  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);

    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(
      String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
