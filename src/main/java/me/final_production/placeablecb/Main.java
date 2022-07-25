package me.final_production.placeablecb;

import me.final_production.placeablecb.init.ItemOverrides;
import me.final_production.placeablecb.init.ModBlocks;
import me.final_production.placeablecb.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(Main.MODID)
public class Main {
    public static final String MODID = "placeablecb";

    public Main() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ItemOverrides.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::Setup);

        MinecraftForge.EVENT_BUS.register(this);

    }
    private void Setup(final FMLCommonSetupEvent event) {
    }
}
