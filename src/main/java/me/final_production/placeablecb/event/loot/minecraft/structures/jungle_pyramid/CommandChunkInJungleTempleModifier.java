package me.final_production.placeablecb.event.loot.minecraft.structures.jungle_pyramid;

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

public class CommandChunkInJungleTempleModifier extends LootModifier
{
    private final Item addition;
    
    protected CommandChunkInJungleTempleModifier(final LootItemCondition[] conditionsIn, final Item addition) {
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
    
    public static class Serializer extends GlobalLootModifierSerializer<CommandChunkInJungleTempleModifier>
    {
        public CommandChunkInJungleTempleModifier read(final ResourceLocation name, final JsonObject object, final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new CommandChunkInJungleTempleModifier(conditionsIn, addition);
        }
        
        public JsonObject write(final CommandChunkInJungleTempleModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
