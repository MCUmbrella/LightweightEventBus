package org.example.event;

public class Test3Event extends GenericEvent
{
    private final String s;
    public Test3Event(Object o, String s)
    {
        super(o);
        this.s = s;
    }

    public String getString()
    {
        return s;
    }
}
