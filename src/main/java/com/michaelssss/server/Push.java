package com.michaelssss.server;

import com.michaelssss.core.Message;

public interface Push {
    void push(User user, Message message);
}
