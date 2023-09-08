package sqteam.terrascan.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import sqteam.terrascan.TerraScan;

public class MasterRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TerraScan.MODID);

    public static void register(IEventBus bus)
    {
        ItemRegistry.initialize();

        ITEMS.register(bus);
    }
}
