package com.michaelssss.server;

import com.michaelssss.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
class SubscriberList implements Subscriber {

    private Map<String, List<User>> users;

    private static class instance {
        static SubscriberList instance = new SubscriberList();
    }

    private SubscriberList() {
        users = new HashMap<>();
    }

    public static SubscriberList getInstance() {
        return instance.instance;
    }

    /**
     * add subscriber
     *
     * @param user user
     */
    @Override
    public void subscriber(String topic, User user) {
        if (users.containsKey(topic)) {
            users.get(topic).add(user);
        } else {
            List<User> list = new ArrayList<>();
            list.add(user);
            users.put(topic, list);
        }
    }

    @Override
    public User[] getSubscriber(String topic) {
        if (users.containsKey(topic)) {
            return users.get(topic).toArray(new User[users.size()]);
        } else {
            System.out.println("there no such topic: " + topic);
            return null;
        }
    }
}
