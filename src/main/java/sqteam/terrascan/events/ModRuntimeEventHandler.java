package sqteam.terrascan.events;

import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.IModBusEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModRuntimeEventHandler
{
    private final List<ModEventSubscription<?>> subscriptions = new ArrayList<>();
    private final IEventBus eventBus;

    public ModRuntimeEventHandler(IEventBus eventBus)
    {
        this.eventBus = eventBus;
    }

    public <T extends Event> void register(Class<T> type, Consumer<T> listener)
    {
        if (IModBusEvent.class.isAssignableFrom(type))
            throw new IllegalArgumentException(String.format("Event %s has to be registered on the mod EventBus", type));
        ModEventSubscription<T> subscription = ModEventSubscription.register(eventBus, type, listener);
        this.subscriptions.add(subscription);
    }

    public void clear()
    {
        subscriptions.forEach(ModEventSubscription::unsubscribe);
        subscriptions.clear();
    }
}
