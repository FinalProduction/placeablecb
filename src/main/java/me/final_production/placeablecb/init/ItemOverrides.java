package me.final_production.placeablecb.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.GameMasterBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemOverrides {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Item> commandBlock = Items.register("command_block", () ->
            new GameMasterBlockItem(Blocks.COMMAND_BLOCK, (new Item.Properties()).rarity(Rarity.EPIC).tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
