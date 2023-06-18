package com.potionblocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class EmptyPotionBlock extends Block {

  public EmptyPotionBlock() {
    super(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops());
  }

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    super.stepOn(level, pos, state, entity);

    if (level.isClientSide() || !(entity instanceof LivingEntity livingEntity)) {
      return;
    }

    livingEntity.removeAllEffects();
  }
}
