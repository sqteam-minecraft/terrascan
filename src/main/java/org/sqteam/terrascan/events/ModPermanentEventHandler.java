package org.sqteam.terrascan.events;

import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.IModBusEvent;

import java.util.function.Consumer;

public record ModPermanentEventHandler(IEventBus forgeEventBus, IEventBus modEventBus)
{
    public <T extends Event> void register(Class<T> type, Consumer<T> listener)
    {
        if (IModBusEvent.class.isAssignableFrom(type))
            modEventBus.addListener(EventPriority.NORMAL, false, type, listener);
        else
            forgeEventBus.addListener(EventPriority.NORMAL, false, type, listener);
    }
}
