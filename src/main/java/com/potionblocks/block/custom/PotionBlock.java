package com.potionblocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class PotionBlock extends Block {
  private MobEffect effect;
  private int duration;
  private int amplifier;

  public PotionBlock(MobEffect effect, int duration, int amplifier) {
    super(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops());
    this.effect = effect;
    this.duration = duration;
    this.amplifier = amplifier;
  }

  public PotionBlock(BlockBehaviour.Properties blockProperties, MobEffect effect, int duration) {
    super(blockProperties);
    this.effect = effect;
    this.duration = duration;
    this.amplifier = 0;
  }

  public PotionBlock(
      BlockBehaviour.Properties blockProperties, MobEffect effect, int duration, int amplifier) {
    super(blockProperties);
    this.effect = effect;
    this.duration = duration;
    this.amplifier = amplifier;
  }

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    super.stepOn(level, pos, state, entity);

    if (level.isClientSide() || !(entity instanceof LivingEntity livingEntity)) {
      return;
    }

    livingEntity.addEffect(new MobEffectInstance(this.effect, this.duration, this.amplifier));
  }
}
