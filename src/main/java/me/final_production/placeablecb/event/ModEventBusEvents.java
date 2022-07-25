package me.final_production.placeablecb.event;

import me.final_production.placeablecb.event.loot.minecraft.block.redstone_ore.ChargedRedstoneCrystalFromRedstoneOreModifier;
import me.final_production.placeablecb.event.loot.minecraft.block.redstone_ore.RedstoneCrystalFromRedstoneOreModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.abandoned_mineshaft.CommandChunkInAbandonedMineshaftModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.bastion_remnant.CommandPanelInBastionBridgeModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.bastion_remnant.CommandPanelInBastionOtherModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.bastion_remnant.CommandPanelInBastionStableModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.bastion_remnant.CommandPanelInBastionTreasureModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.buried_treasure.CommandChunkInBuriedTreasureModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.desert_pyramid.CommandChunkInDesertTempleModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.dungeon.CommandChunkInDungeonModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.end_city.CommandCoreInEndCityModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.igloo.CommandChunkInIglooModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.jungle_pyramid.CommandChunkInJungleTempleModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.nether_fortress.CommandChunkInNetherBridgeModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.pillager_outpost.CommandChunkInPillagerOutpostModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.ruined_portal.CommandChunkInRuinedPortalModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.shipwreck.CommandChunkInShipwreckSupplyModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.underwater_ruins.CommandChunkInRuinBigModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.underwater_ruins.CommandChunkInRuinSmallModifier;
import me.final_production.placeablecb.event.loot.minecraft.structures.woodland_mansion.CommandChunkInWoodlandMansionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = "placeablecb", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new CommandCoreInEndCityModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_core_in_end_city")),
                new CommandPanelInBastionTreasureModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_panel_in_bastion_treasure")),
                new CommandPanelInBastionStableModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_panel_in_bastion_stable")),
                new CommandPanelInBastionBridgeModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_panel_in_bastion_bridge")),
                new CommandPanelInBastionOtherModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_panel_in_bastion_other")),
                new CommandChunkInJungleTempleModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_jungle_temple")),
                new CommandChunkInDesertTempleModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_desert_temple")),
                new CommandChunkInWoodlandMansionModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_woodland_mansion")),
                new CommandChunkInPillagerOutpostModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_pillager_outpost")),
                new CommandChunkInShipwreckSupplyModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_shipwreck_supply")),
                new CommandChunkInNetherBridgeModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_nether_bridge")),
                new CommandChunkInAbandonedMineshaftModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_abandoned_mineshaft")),
                new CommandChunkInIglooModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_igloo")),
                new CommandChunkInDungeonModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_dungeon")),
                new CommandChunkInBuriedTreasureModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_buried_treasure")),
                new CommandChunkInRuinedPortalModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_ruined_portal")),
                new CommandChunkInRuinBigModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_ruin_big")),
                new CommandChunkInRuinSmallModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "command_chunk_in_ruin_small")),
                new RedstoneCrystalFromRedstoneOreModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "redstone_crystal_from_redstone_ore")),
                new ChargedRedstoneCrystalFromRedstoneOreModifier.Serializer().setRegistryName(
                        new ResourceLocation("placeablecb", "charged_redstone_crystal_from_redstone_ore"))
        );
    }
}
