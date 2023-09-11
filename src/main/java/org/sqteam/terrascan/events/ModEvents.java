package org.sqteam.terrascan.events;

import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ModEvents
{
    public static void registerEvents(ModPermanentEventHandler permanentEventHandler, ModRuntimeEventHandler runtimeEventHandler)
    {
        registerPermanentEvents(permanentEventHandler);
        registerRuntimeEvents(runtimeEventHandler);
    }

    private static void registerPermanentEvents(ModPermanentEventHandler handler)
    {
        handler.register(PlayerInteractEvent.RightClickItem.class, event ->
                event.getPlayer().sendMessage(new TextComponent("Ahoy debugger!"), Util.NIL_UUID));
    }

    @SuppressWarnings({"unused", "EmptyMethod"})
    private static void registerRuntimeEvents(ModRuntimeEventHandler handler)
    {

    }
}
