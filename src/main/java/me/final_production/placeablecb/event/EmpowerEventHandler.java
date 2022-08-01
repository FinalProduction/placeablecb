package me.final_production.placeablecb.event;

import me.final_production.placeablecb.init.ModItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EmpowerEventHandler {
    @SubscribeEvent
    public void empowerItem(EntityStruckByLightningEvent event) {
            if (event.getEntity() instanceof ItemEntity entity) {
                if(entity.getItem().getItem() == ModItems.redstoneCrystal.get()) {
                    entity.setItem(new ItemStack(ModItems.chargedRedstoneCrystal.get(), entity.getItem().getCount()));
                    event.setCanceled(true);
                    event.getLightning().discard();
                }
            }
        }
    }
