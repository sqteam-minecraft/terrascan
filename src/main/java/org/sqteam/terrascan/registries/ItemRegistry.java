package org.sqteam.terrascan.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import org.sqteam.terrascan.items.DebugItem;

@SuppressWarnings("unused")
public class ItemRegistry
{
    public static final RegistryObject<Item> DEBUG_ITEM = MasterRegistry.ITEMS.register("debug_item", DebugItem::new);

    public static void initialize() {}
}
