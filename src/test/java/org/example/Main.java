package org.example;

import org.example.event.GenericEvent;
import org.example.event.Test1Event;
import org.example.event.Test2Event;
import org.example.event.Test3Event;
import vip.floatationdevice.lightweighteventbus.EventBus;
import vip.floatationdevice.lightweighteventbus.Subscribe;

import java.util.EventObject;

public class Main
{
    public static void main(String[] args)
    {
        EventBus bus = new EventBus();
        Main listener1 = new Main();
        ExampleEventListener listener2 = new ExampleEventListener();
        bus.register(listener1).register(listener2);
        bus.post(new Test1Event(bus))
                .post(new Test2Event(bus))
                .post(new Test3Event(bus, "Hello"));
        bus.unregister(listener1).unregister(listener2);
        bus.post(new Test1Event(bus));

    }

    @Subscribe
    public void onEventTest(Test1Event e)
    {
        System.out.println("===================================\nCONGRATULATIONS, EVENT BUS WORKED!\n===================================");
    }

    @Subscribe
    public void onEvent2(Test2Event e)
    {
        System.out.println("Test2Event received. source: " + e.getSource());
    }

    @Subscribe
    public void onEvent1(Test1Event e)
    {
        System.out.println("Test1Event received");
    }

    @Subscribe
    public void onEvent3(Test3Event e)
    {
        System.out.println("Test3Event received: " + e.getString());
    }

    @Subscribe
    public void onGenericEvent(GenericEvent e)
    {
        System.out.println("onGenericEvent() called");
    }

    @Subscribe
    public void onEventObject(EventObject e)
    {
        System.out.println("onEventObject() called");
    }

    public void onEventWithNoSubscribe(Test1Event e) // no @Subscribe, should not call
    {
        System.err.println("onEventWithNoSubscribe() called");
    }

    @Subscribe
    public void onObject(Object e) // not EventObject, should not call
    {
        System.err.println("onObject() called");
    }

    @Subscribe
    public void on2Events(Test1Event e, Test2Event e2) // too many parameters, should not call
    {
        System.err.println("on2Events() called");
    }

    @Subscribe
    public void on0Event() // no parameters, should not call
    {
        System.err.println("on0Event() called");
    }
}
