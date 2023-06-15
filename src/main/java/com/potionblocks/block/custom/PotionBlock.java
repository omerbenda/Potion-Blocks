package com.potionblocks.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PotionBlock extends Block {
  private MobEffect effect;

  public PotionBlock(BlockBehaviour.Properties blockProperties, MobEffect effect) {
    super(blockProperties);
    this.effect = effect;
  }
}
