package com.michaelssss.core;

import java.util.HashMap;
import java.util.Map;

public class MessageQueueFactory {
    private final static Map<String, Queue<Message>> queueMap = new HashMap<>();
    private final static String DEFAULT = "default";

    static {
        queueMap.put(DEFAULT, new MessageQueue());
    }

    public static boolean buildNewQueue(String queueName) {
        if (!queueMap.containsKey(queueName)) {
            queueMap.put(queueName, new MessageQueue());
            return true;
        }
        System.out.println("queue " + queueName + " already exist");
        return false;
    }

    public static Queue<Message> getMessageQueue(String queueName) {
        if (queueMap.containsKey(queueName)) {
            return queueMap.get(queueName);
        }
        return null;
    }
}
