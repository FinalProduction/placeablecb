package me.final_production.placeablecb.init;

import me.final_production.placeablecb.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> commandHusk = registerBlock("command_husk",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5.0f, 1200.0f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> redstoneCrystalBlock = registerBlock("block_redstone_crystal",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(6.5f, 7.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), CreativeModeTab.TAB_MISC);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.Items.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        Blocks.register(eventBus);
    }
}
