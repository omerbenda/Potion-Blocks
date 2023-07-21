package com.potionblocks;

import com.mojang.logging.LogUtils;
import com.potionblocks.block.ModBlocks;
import com.potionblocks.effect.ModEffects;
import com.potionblocks.item.ModCreativeModeTabs;
import com.potionblocks.item.ModItems;
import com.potionblocks.potion.ModPotionRecipes;
import com.potionblocks.potion.ModPotions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PotionBlocks.MOD_ID)
public class PotionBlocks {
  public static final String MOD_ID = "potionblocks";
  public static final Logger LOGGER = LogUtils.getLogger();

  public PotionBlocks() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);
    ModEffects.register(modEventBus);
    ModPotions.register(modEventBus);

    modEventBus.addListener(this::commonSetup);
    MinecraftForge.EVENT_BUS.register(this);

    modEventBus.addListener(this::addCreative);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    ModPotionRecipes.registerRecipes();
  }

  private void addCreative(CreativeModeTabEvent.BuildContents event) {
    if (event.getTab() == ModCreativeModeTabs.POTION_BLOCKS_TAB) {
      event.accept(ModBlocks.EMPTY_POTION_BLOCK);
      event.accept(ModBlocks.MILK_POTION_BLOCK);
      event.accept(ModBlocks.SPEED_POTION_BLOCK);
      event.accept(ModBlocks.SLOWNESS_POTION_BLOCK);
      event.accept(ModBlocks.POISON_POTION_BLOCK);
      event.accept(ModBlocks.REGEN_POTION_BLOCK);
      event.accept(ModBlocks.BLINDNESS_POTION_BLOCK);
      event.accept(ModBlocks.JUMP_POTION_BLOCK);
    }
  }

  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}
  }
}
