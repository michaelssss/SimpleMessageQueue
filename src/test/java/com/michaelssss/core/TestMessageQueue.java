package com.michaelssss.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.NoSuchElementException;

public class TestMessageQueue {
    @Test
    public void testAddOne() {
        MessageQueue queue = new MessageQueue();
        Date date = new Date();
        Message message = new Message(date.getTime(), "simplePrivoder", new Object());
        queue.add(message);
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(message, queue.poll());
    }

    @Test
    public void testAddOverCapacity() {
        MessageQueue queue = new MessageQueue();
        for (int i = 0; i < 10000; i++) {
            Message message = new Message(System.currentTimeMillis(), "simplePrivoder", new Object());
            queue.add(message);
        }
    }

    @Test
    public void testSize() {
        MessageQueue queue = new MessageQueue();
        Assert.assertEquals(0, queue.size());
        queue.add(new Message(System.currentTimeMillis(), "simplePrivoder", new Object()));
        Assert.assertEquals(1, queue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPoll() {
        MessageQueue queue = new MessageQueue();
        queue.poll();
    }
}
