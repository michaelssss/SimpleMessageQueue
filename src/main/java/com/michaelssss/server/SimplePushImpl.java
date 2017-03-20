package com.michaelssss.server;

import com.michaelssss.core.Message;

class SimplePushImpl implements Push {
    @Override
    public void push(User user, Message message) {
        System.out.println("user =" + user);
        System.out.println("message = " + message);
    }
}
