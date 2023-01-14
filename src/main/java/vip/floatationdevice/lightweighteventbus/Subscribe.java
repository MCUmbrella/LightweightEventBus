package vip.floatationdevice.lightweighteventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tell the event bus that this function is an event handling function.
 * The event handling function must have this annotation, one parameter,
 * and the parameter's type is EventObject or its child, otherwise it
 * will not be automatically called by the event bus.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe
{
    // nothing
}
