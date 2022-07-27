package me.final_production.placeablecb.event.loot;

import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaceablecbLootModifier extends LootModifier {

	private final Item addition;
	private final int maxItemCount;
	private final float chance;
	
	protected PlaceablecbLootModifier(LootItemCondition[] conditionsIn, final Item addition, final int maxItemCount, final float chance) {
		super(conditionsIn);
		this.addition = addition;
		this.maxItemCount = maxItemCount;
		this.chance = chance;
	}

	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		if (context.getRandom().nextFloat() < chance) {
			generatedLoot.add(new ItemStack(addition, context.getRandom().nextInt(maxItemCount+1)));
	    }
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<PlaceablecbLootModifier>
    {
        public PlaceablecbLootModifier read(final ResourceLocation name, final JsonObject object, final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            final int maxItemCount = GsonHelper.getAsInt(object, "maxItemCount");
            final float chance = GsonHelper.getAsFloat(object, "chance");
            return new PlaceablecbLootModifier(conditionsIn, addition, maxItemCount, chance);
        }
        
        public JsonObject write(final PlaceablecbLootModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            json.addProperty("maxItemCount", instance.maxItemCount);
            json.addProperty("chance", instance.chance);
            return json;
        }
    }
}
