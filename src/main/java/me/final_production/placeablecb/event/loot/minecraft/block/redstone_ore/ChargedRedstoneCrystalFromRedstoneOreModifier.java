package me.final_production.placeablecb.event.loot.minecraft.block.redstone_ore;

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

public class ChargedRedstoneCrystalFromRedstoneOreModifier extends LootModifier
{
    private final Item addition;

    protected ChargedRedstoneCrystalFromRedstoneOreModifier(final LootItemCondition[] conditionsIn, final Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }
    
    @Nonnull
    protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
        if (context.getRandom().nextFloat() > 0.965) {
            generatedLoot.add(new ItemStack(this.addition, context.getRandom().nextInt(2)));
        }
        return generatedLoot;
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<ChargedRedstoneCrystalFromRedstoneOreModifier>
    {
        public ChargedRedstoneCrystalFromRedstoneOreModifier read(final ResourceLocation name, final JsonObject object, final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new ChargedRedstoneCrystalFromRedstoneOreModifier(conditionsIn, addition);
        }
        
        public JsonObject write(final ChargedRedstoneCrystalFromRedstoneOreModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
