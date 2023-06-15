package com.potionblocks.block.custom;

import com.potionblocks.PotionBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PotionBlock extends Block {
  private MobEffect effect;
  private int duration;
  private int amplifier;

  public PotionBlock(
      BlockBehaviour.Properties blockProperties, MobEffect effect, int duration, int amplifier) {
    super(blockProperties);
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

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    super.stepOn(level, pos, state, entity);

    if (!(entity instanceof LivingEntity)) {
      return;
    }

    LivingEntity livingEntity = (LivingEntity) entity;

    livingEntity.addEffect(new MobEffectInstance(this.effect, this.duration, this.amplifier));
  }
}
