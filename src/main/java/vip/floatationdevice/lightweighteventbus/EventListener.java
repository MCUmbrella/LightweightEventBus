package vip.floatationdevice.lightweighteventbus;

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
