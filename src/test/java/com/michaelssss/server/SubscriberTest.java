package com.michaelssss.server;

import org.junit.Assert;
import org.junit.Test;

public class SubscriberTest {
    @Test
    public void testSubscriber() {
        String topic = "default";
        Subscriber subscriber = SubscriberList.getInstance();
        subscriber.subscriber(topic, new User("testUser", new Role()));
        Assert.assertTrue(subscriber.getSubscriber(topic).length > 0);
    }
}
