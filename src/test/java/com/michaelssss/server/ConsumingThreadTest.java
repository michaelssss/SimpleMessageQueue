package com.michaelssss.server;

import com.michaelssss.core.Message;
import com.michaelssss.core.MessageQueueFactory;
import com.michaelssss.core.Queue;
import org.junit.Assert;
import org.junit.Test;

public class ConsumingThreadTest {
    @Test
    public void testRun() {
        String topic = "default";
        Subscriber subscriber = SubscriberList.getInstance();
        subscriber.subscriber(topic, new User("testUser", new Role()));
        Queue<Message> queue = MessageQueueFactory.getMessageQueue(topic);
        if (null == queue) {
            Assert.fail();
        }
        for (int i = 0; i < 17; i++) {
            Message message = new Message(System.currentTimeMillis(), "simplePrivoder", new Object());
            queue.add(message);
        }
        ConsumingThread thread = new ConsumingThread(topic);
        thread.run();
    }
}
