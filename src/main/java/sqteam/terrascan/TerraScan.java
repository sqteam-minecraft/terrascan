package sqteam.terrascan;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
    }
}
