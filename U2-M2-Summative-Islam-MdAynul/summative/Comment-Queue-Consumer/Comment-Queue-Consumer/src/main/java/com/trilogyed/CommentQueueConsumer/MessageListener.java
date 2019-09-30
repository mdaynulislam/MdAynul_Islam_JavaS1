package com.trilogyed.CommentQueueConsumer;

import com.trilogyed.CommentQueueConsumer.util.message.CommentEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(CommentEntry msg) {

        System.out.println(msg.toString());
    }
}
