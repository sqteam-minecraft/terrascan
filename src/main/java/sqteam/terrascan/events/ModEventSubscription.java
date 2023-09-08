package sqteam.terrascan.events;

import sqteam.terrascan.util.WeakConsumer;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.function.Consumer;

public class ModEventSubscription<T extends Event>
{
    public static <T extends Event> ModEventSubscription<T> register(IEventBus bus, Class<T> type, Consumer<T> listener)
    {
        return new ModEventSubscription<>(bus, type, listener);
    }

    private final IEventBus eventBus;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Consumer<T> listener;
    private final WeakConsumer<T> registeredListener;

    private ModEventSubscription(IEventBus bus, Class<T> type, Consumer<T> listener)
    {
        this.eventBus = bus;
        this.listener = listener;

        WeakConsumer<T> weakListener = new WeakConsumer<>(listener);
        eventBus.addListener(EventPriority.NORMAL, false, type, weakListener);
        this.registeredListener = weakListener;
    }

    public void unsubscribe()
    {
        this.eventBus.unregister(this.registeredListener);
    }
}
