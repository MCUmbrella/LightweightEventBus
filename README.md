# Event bus
An event bus is a type of software architecture that allows different components of an application to communicate with each other by sending and receiving events.
It acts as a mediator between the components, allowing them to communicate without having direct dependencies on each other.
This makes it easier to maintain and extend the application, as well as making it more scalable.
# Event listener
Event listeners has one or more functions that waits for an event to occur and then triggers a response when it does.
Event listeners are used in many different types of applications, such as web browsers, mobile apps, and desktop applications.
# Event
An event is an action or occurrence that can be detected by the program.
Events are typically triggered by user interactions such as mouse clicks, key presses, or a touch on a mobile device.
When an event occurs, the program can respond by executing code to handle the event.
# Example
```java
import vip.floatationdevice.lightweighteventbus.EventBus;
import vip.floatationdevice.lightweighteventbus.Subscribe;
import java.util.EventObject;
import java.util.Scanner;

public class Example{
    static class HelloEvent extends EventObject{
        public HelloEvent(Object o){
            super(o);
        }
    }

    final static EventBus eventBus = new EventBus();

    @Subscribe
    public void onHello(HelloEvent e){
        System.out.println("Hi!");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        eventBus.register(new Example());
        while(true)
            if(sc.nextLine().equalsIgnoreCase("hello"))
                eventBus.post(new HelloEvent(eventBus));
    }
}
```
