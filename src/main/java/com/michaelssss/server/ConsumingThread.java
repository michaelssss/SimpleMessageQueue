package com.michaelssss.server;

import com.michaelssss.core.Message;
import com.michaelssss.core.MessageQueueFactory;
import com.michaelssss.core.Queue;

class ConsumingThread implements Runnable {
    private final static Push pusher = new SimplePushImpl();
    private Queue<Message> queue;
    private String topic;

    public ConsumingThread(String topic) {
        this.topic = topic;
        this.queue = MessageQueueFactory.getMessageQueue(this.topic);
    }

    @Override
    public void run() {
        while (queue.size() != 0) {
            Subscriber subscriber = SubscriberList.getInstance();
            User[] users = subscriber.getSubscriber(this.topic);
            Message message = queue.poll();
            for (User user : users) {
                pusher.push(user, message);
            }
        }
    }
}
