package me.final_production.placeablecb.init;

import me.final_production.placeablecb.Main;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> commandCore = Items.register("command_core",
            () -> new SimpleFoiledItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(1)));

    public static final RegistryObject<Item> commandChunk = Items.register("command_chunk",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(16)));

    public static final RegistryObject<Item> commandPanel = Items.register("command_panel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(4)));

    public static final RegistryObject<Item> activatedQuartz = Items.register("activated_quartz",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE).stacksTo(64)));

    public static final RegistryObject<Item> commandPanelActive = Items.register("command_panel_active",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(4)));

    public static final RegistryObject<Item> redstoneCrystal = Items.register("redstone_crystal",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(64)));

    public static final RegistryObject<Item> chargedRedstoneCrystal = Items.register("charged_redstone_crystal",
            () -> new SimpleFoiledItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).rarity(Rarity.EPIC).stacksTo(64).fireResistant()));
    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
