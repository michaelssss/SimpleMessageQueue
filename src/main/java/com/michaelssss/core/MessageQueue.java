package com.michaelssss.core;


import java.util.Arrays;
import java.util.NoSuchElementException;

class MessageQueue implements Queue<Message> {

    private final static int defaultCapacity = 16;
    private volatile Message[] messages;
    private volatile int head;
    private volatile int last;
    private volatile int size;
    private volatile int capacity;

    public MessageQueue() {
        resize();
    }

    private void resize() {
        this.messages = new Message[defaultCapacity];
        capacity = defaultCapacity;
        size = head = last = 0;
    }

    private boolean isQueueFull() {
        return capacity == size;
    }

    private void ensureCapcity() {
        Message[] messages = new Message[capacity * 2];
        capacity = messages.length;
        System.arraycopy(this.messages, 0, messages, 0, last - head);
        this.messages = messages;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Message message) {
        if (isQueueFull()) {
            ensureCapcity();
        }
        messages[last] = message;
        last++;
        size++;
        return true;
    }


    @Override
    public Message poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is Empty");
        }
        Message message = messages[head];
        head++;
        if (head > last) {
            resize();
        }
        size--;
        return message;
    }

    @Override
    public String toString() {
        return "MessageQueue{" +
                "messages=" + Arrays.toString(messages) +
                ", head=" + head +
                ", last=" + last +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
