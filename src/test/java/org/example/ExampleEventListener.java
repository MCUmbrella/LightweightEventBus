package org.example;

import org.example.event.Test3Event;
import vip.floatationdevice.lightweighteventbus.EventBus;
import vip.floatationdevice.lightweighteventbus.EventListener;
import vip.floatationdevice.lightweighteventbus.Subscribe;

public class ExampleEventListener implements EventListener
{
    @Override
    public void onRegister(EventBus eventBus)
    {
        System.out.println("ExampleEventListener registered");
    }

    @Override
    public void onUnregister(EventBus eventBus)
    {
        System.out.println("ExampleEventListener unregistered");
    }

    @Subscribe
    public void onEvent(Test3Event e)
    {
        System.out.println("ExampleEventListener received Test3Event");
    }
}
