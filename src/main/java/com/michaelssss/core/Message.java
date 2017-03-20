package com.michaelssss.core;

public class Message implements Cloneable {
    private long time;
    private String privoder;
    private Object message;

    public Message(long time, String privoder, Object message) {
        this.time = time;
        this.privoder = privoder;
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getPrivoder() {
        return privoder;
    }

    public void setPrivoder(String privoder) {
        this.privoder = privoder;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", privoder='" + privoder + '\'' +
                ", message=" + message +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        if (time != message1.time) return false;
        if (privoder != null ? !privoder.equals(message1.privoder) : message1.privoder != null) return false;
        return message != null ? message.equals(message1.message) : message1.message == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (time ^ (time >>> 32));
        result = 31 * result + (privoder != null ? privoder.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Message(this.time, this.privoder, this.message);
    }
}
