package sqteam.terrascan;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import sqteam.terrascan.events.ModEvents;
import sqteam.terrascan.events.ModPermanentEventHandler;
import sqteam.terrascan.events.ModRuntimeEventHandler;
import sqteam.terrascan.registries.MasterRegistry;

@Mod(TerraScan.MODID)
public class TerraScan
{
    public static final String MODID = "terrascan";

    public TerraScan()
    {
        registerEvents();
    }

    private static void registerEvents()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        MasterRegistry.register(modEventBus);

        ModPermanentEventHandler permanent_events = new ModPermanentEventHandler(forgeEventBus, modEventBus);
        ModRuntimeEventHandler runtime_events = new ModRuntimeEventHandler(forgeEventBus);

        ModEvents.registerEvents(permanent_events, runtime_events);
    }
}
