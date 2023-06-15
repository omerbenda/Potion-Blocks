package com.potionblocks.item;

import com.potionblocks.PotionBlocks;
import com.potionblocks.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PotionBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
  public static CreativeModeTab POTION_BLOCKS_TAB;

  @SubscribeEvent
  public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
    POTION_BLOCKS_TAB =
        event.registerCreativeModeTab(
            new ResourceLocation(PotionBlocks.MOD_ID, "potion_blocks_tab"),
            builder ->
                builder
                    .icon(() -> new ItemStack(ModBlocks.SPEED_POTION_BLOCK.get()))
                    .title(Component.translatable("creativemodetab.potion_blocks_tab")));
  }
}
