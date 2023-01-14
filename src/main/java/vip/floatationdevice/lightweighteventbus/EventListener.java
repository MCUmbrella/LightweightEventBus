package vip.floatationdevice.lightweighteventbus;

/**
 * Implementing this allows the event listener to automatically perform specific
 * actions when it is registered to the event bus or unregistered by the event bus.
 */
public interface EventListener
{
    /**
     * Automatically called when the listener is registered to an event bus.
     * @param eventBus The event bus who registered this listener.
     */
    void onRegister(final EventBus eventBus);

    /**
     * Automatically called when the listener is unregistered from an event bus.
     * @param eventBus The event bus who unregistered this listener.
     */
    void onUnregister(final EventBus eventBus);
}
