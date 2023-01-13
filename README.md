```java
import vip.floatationdevice.lightweighteventbus.EventBus;
import vip.floatationdevice.lightweighteventbus.Subscribe;
import java.util.EventObject;

public class Example{
    static class ExampleEvent extends EventObject{
        public String msg;
        public ExampleEvent(Object o, String msg){
            super(o);
            this.msg = msg;
        }
    }

    final static EventBus eventBus = new EventBus();

    @Subscribe
    public void onExampleEvent(ExampleEvent event){
        System.out.println("ExampleEvent received\nMessage: " + event.msg);
    }

    public static void main(String[] args){
        eventBus.register(new Example());
        eventBus.post(new ExampleEvent(eventBus, "Hello world!"));
    }
}
```
