package com.michaelssss.server;

import com.michaelssss.core.Message;
import org.junit.Test;

import java.util.Date;

public class PushTest {
    @Test
    public void testPush() {
        Push push = new SimplePushImpl();
        User user = new User("testUser", new Role());
        Message message = new Message(new Date().getTime(), "simplePrivoder", new Object());
        push.push(user, message);
    }
}
