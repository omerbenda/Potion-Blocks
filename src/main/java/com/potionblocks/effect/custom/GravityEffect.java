package com.potionblocks.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraftforge.common.ForgeMod;

public class GravityEffect extends MobEffect {
  public GravityEffect(MobEffectCategory pCategory, int pColor) {
    super(pCategory, pColor);
  }

  @Override
  public void addAttributeModifiers(
      LivingEntity livingEntity, AttributeMap attributeMap, int amplifier) {
    AttributeInstance gravityInstance =
        livingEntity.getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());

    if (gravityInstance != null && !livingEntity.isNoGravity()) {
      gravityInstance.setBaseValue((gravityInstance.getBaseValue() * 1.5d) * (amplifier + 1));
    }
  }

  @Override
  public void removeAttributeModifiers(
      LivingEntity livingEntity, AttributeMap attributeMap, int amplifier) {
    AttributeInstance gravityInstance =
        livingEntity.getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());

    if (gravityInstance != null && !livingEntity.isNoGravity()) {
      gravityInstance.setBaseValue((gravityInstance.getBaseValue() / 1.5d) / (amplifier + 1));
    }
  }

  @Override
  public boolean isDurationEffectTick(int duration, int amplifier) {
    return true;
  }
}
