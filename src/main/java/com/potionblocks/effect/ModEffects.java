package com.potionblocks.effect;

import com.potionblocks.PotionBlocks;
import com.potionblocks.effect.custom.GravityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
  public static final DeferredRegister<MobEffect> MOB_EFFECTS =
      DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotionBlocks.MOD_ID);

  public static final RegistryObject<MobEffect> GRAVITY =
      MOB_EFFECTS.register("gravity", () -> new GravityEffect(MobEffectCategory.HARMFUL, 14716172));

  public static void register(IEventBus eventBus) {
    MOB_EFFECTS.register(eventBus);
  }
}
