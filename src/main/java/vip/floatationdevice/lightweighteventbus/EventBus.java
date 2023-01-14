package vip.floatationdevice.lightweighteventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EventObject;
import java.util.HashSet;

/**
 * The event bus.
 */
public class EventBus
{
    private final HashSet<Object> listeners = new HashSet<Object>();

    /**
     * Register an event listener object to the event bus.
     * @throws IllegalArgumentException if the object is already registered.
     */
    public EventBus register(Object listener)
    {
        if(listener == null) throw new IllegalArgumentException("Listener can't be null");
        synchronized(listeners)
        {
            if(!listeners.add(listener))
                throw new IllegalArgumentException("Event listener already registered");
            if(listener instanceof EventListener) ((EventListener) listener).onRegister(this);
        }
        return this;
    }

    /**
     * Unregister an event listener object from the event bus.
     * @throws IllegalArgumentException if the object is not registered.
     */
    public EventBus unregister(Object listener)
    {
        if(listener == null) throw new IllegalArgumentException("Listener can't be null");
        synchronized(listeners)
        {
            if(!listeners.remove(listener))
                throw new IllegalArgumentException("Event listener not registered");
            if(listener instanceof EventListener) ((EventListener) listener).onUnregister(this);
        }
        return this;
    }

    /**
     * Post an event object.
     * @param event The event object to post.
     */
    public EventBus post(EventObject event)
    {
        if(event == null) throw new IllegalArgumentException("Event can't be null");
        /*
         * for all registered event listeners,
         * for all public methods of it,
         * if the method:
         *   - has @Subscribe annotated
         *   - has only 1 parameter
         *   - the parameter's type is EventObject or child of EventObject
         *   - the parameter's type is same as or super of the event object's type
         * then call this method
         */
        synchronized(listeners)
        {
            for(Object listener : listeners)
                for(Method method : listener.getClass().getDeclaredMethods())
                    if(method.isAnnotationPresent(Subscribe.class) &&
                            method.getParameterCount() == 1 &&
                            EventObject.class.isAssignableFrom(method.getParameterTypes()[0]) &&
                            method.getParameterTypes()[0].isAssignableFrom(event.getClass())
                    )
                        try
                        {
                            method.invoke(listener, event);
                        }
                        catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                        {
                            e.printStackTrace();
                        }
        }
        return this;
    }
}
