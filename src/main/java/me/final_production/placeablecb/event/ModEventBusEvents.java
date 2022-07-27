package me.final_production.placeablecb.event;

import me.final_production.placeablecb.Main;
import me.final_production.placeablecb.event.loot.PlaceablecbLootModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.stream.Stream;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = "placeablecb", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		Stream<String> names = Stream.of(
				"command_core_in_end_city", "command_panel_in_bastion_treasure", "command_panel_in_bastion_stable",
				"command_panel_in_bastion_bridge", "command_panel_in_bastion_other", "command_chunk_in_jungle_temple",
				"command_chunk_in_desert_temple", "command_chunk_in_woodland_mansion", "command_chunk_in_pillager_outpost",
				"command_chunk_in_shipwreck_supply", "command_chunk_in_nether_bridge", "command_chunk_in_abandoned_mineshaft",
				"command_chunk_in_igloo", "command_chunk_in_dungeon", "command_chunk_in_buried_treasure", 
				"command_chunk_in_ruined_portal", "command_chunk_in_ruin_big", "command_chunk_in_ruin_small", 
				"redstone_crystal_from_redstone_ore", "charged_redstone_crystal_from_redstone_ore");
        event.getRegistry().registerAll(
                names.map(name -> new PlaceablecbLootModifier.Serializer().setRegistryName(
                		new ResourceLocation(Main.MODID, name))).toArray(GlobalLootModifierSerializer<?>[]::new));
    }
}
