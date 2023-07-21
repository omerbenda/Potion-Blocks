package com.potionblocks.potion;

import com.potionblocks.PotionBlocks;
import com.potionblocks.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

  public static final DeferredRegister<Potion> POTIONS =
      DeferredRegister.create(ForgeRegistries.POTIONS, PotionBlocks.MOD_ID);

  public static final RegistryObject<Potion> BLINDNESS_POTION =
      POTIONS.register(
          "blindness_potion",
          () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0)));

  public static final RegistryObject<Potion> GRAVITY_POTION =
      POTIONS.register(
          "gravity_potion",
          () -> new Potion(new MobEffectInstance(ModEffects.GRAVITY.get(), 600, 0)));

  public static void register(IEventBus eventBus) {
    POTIONS.register(eventBus);
  }
}
