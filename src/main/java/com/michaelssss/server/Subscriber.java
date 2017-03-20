package com.michaelssss.server;

public interface Subscriber {
    /**
     * add subscriber
     *
     * @param user user
     */
    void subscriber(String topic, User user);

    User[] getSubscriber(String topic);
}
