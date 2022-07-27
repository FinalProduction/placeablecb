package me.final_production.placeablecb;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class PlaceablecbCommonConfig {

	final static ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	final static ForgeConfigSpec SPEC;

	public static final BooleanValue WHITELIST;
	public static final ConfigValue<List<String>> DIMIDS;
	
	static {
		BUILDER.push("dimension_configs");
		WHITELIST = BUILDER
				.comment("Whether if the dimension list should be a whitelist or a blacklist; Default: true")
				.define("whitelist", true);
		DIMIDS = BUILDER
				.comment("The list of dimension ids; Default: [\"minecraft:overworld\"]")
				.define("dimension_ids", Arrays.asList("minecraft:overworld"));
		BUILDER.pop();
		
		SPEC = BUILDER.build();
	}
	
	
}
