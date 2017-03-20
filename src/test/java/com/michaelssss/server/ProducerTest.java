package com.michaelssss.server;

import com.michaelssss.core.Message;
import org.junit.Test;

import java.util.Date;

public class ProducerTest {
    @Test
    public void testProduceMessage() {
        String topic = "default";
        Message message = new Message(new Date().getTime(), "simpleProvoder", new Object());
        Subscriber subscriber = SubscriberList.getInstance();
        subscriber.subscriber(topic, new User("testUser", new Role()));
        Producer.produceMessage(topic, message);
        ConsumingThread consumingThread = new ConsumingThread(topic);
        consumingThread.run();
    }
}
