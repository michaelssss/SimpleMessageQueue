package com.michaelssss.server;

import com.michaelssss.core.Message;
import com.michaelssss.core.MessageQueueFactory;
import com.michaelssss.core.Queue;

class Producer {
    static void produceMessage(String queueName, Message message) {
        Queue<Message> queue = MessageQueueFactory.getMessageQueue(queueName);
        queue.add(message);
    }

    static void produceMessages(String queueName, Message[] messages) {
        Queue<Message> queue = MessageQueueFactory.getMessageQueue(queueName);
        for (Message message : messages) {
            queue.add(message);
        }
    }
}
