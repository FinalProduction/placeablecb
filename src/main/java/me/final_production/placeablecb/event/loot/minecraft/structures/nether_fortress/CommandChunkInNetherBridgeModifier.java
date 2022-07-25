package me.final_production.placeablecb.event.loot.minecraft.structures.nether_fortress;

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

import javax.annotation.Nonnull;
import java.util.List;

public class CommandChunkInNetherBridgeModifier extends LootModifier
{
    private final Item addition;

    protected CommandChunkInNetherBridgeModifier(final LootItemCondition[] conditionsIn, final Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }
    
    @Nonnull
    protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
        if (context.getRandom().nextFloat() > 0.88) {
            generatedLoot.add(new ItemStack(this.addition, context.getRandom().nextInt(4)));
        }
        return generatedLoot;
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<CommandChunkInNetherBridgeModifier>
    {
        public CommandChunkInNetherBridgeModifier read(final ResourceLocation name, final JsonObject object, final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new CommandChunkInNetherBridgeModifier(conditionsIn, addition);
        }
        
        public JsonObject write(final CommandChunkInNetherBridgeModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
