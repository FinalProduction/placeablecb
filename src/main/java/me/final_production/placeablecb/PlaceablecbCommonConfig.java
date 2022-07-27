package me.final_production.placeablecb;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class PlaceablecbCommonConfig {

	public static ForgeConfigSpec SPEC;

	public static ConfigValue<List<? extends String>> DIMIDS;
	public static BooleanValue WHITELIST;
	
	public static void init(){
		ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
		BUILDER.comment("Configuration related to placeability per dimension");
		BUILDER.push("dimension_configs");
		DIMIDS = BUILDER
				.comment("The list of dimension ids where the player can/can't place Command Blocks; Default: [\"minecraft:overworld\"]")
				.defineListAllowEmpty(Arrays.asList("dimension_ids"), () -> Arrays.asList("minecraft:overworld"), o -> true);
		WHITELIST = BUILDER
				.comment("Whether the dimension list should be a whitelist (true) or a blacklist (false); Default: true")
				.define("whitelist", true);
		BUILDER.pop();
		
		BUILDER.push("loot_config");

		SPEC = BUILDER.build();
		
		ModLoadingContext.get().registerConfig(Type.COMMON, SPEC);
	}
	
	
}
