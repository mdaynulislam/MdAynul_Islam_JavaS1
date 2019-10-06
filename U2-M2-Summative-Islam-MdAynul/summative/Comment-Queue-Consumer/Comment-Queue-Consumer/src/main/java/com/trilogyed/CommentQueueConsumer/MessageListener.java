package com.trilogyed.CommentQueueConsumer;

import com.trilogyed.CommentQueueConsumer.model.Comment;
import com.trilogyed.CommentQueueConsumer.util.feign.CommentClient;
import com.trilogyed.CommentQueueConsumer.util.message.CommentEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentClient commentClient; //Auto wired the feign to get save and update method

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveComment(CommentEntry commentEntry) {System.out.println("Incoming message: " + commentEntry.toString());

        try {
            if (commentEntry.getCommentId() == 0) {
                Comment comment = new Comment();
                comment.setPostId(commentEntry.getPostId());
                comment.setCreateDate(commentEntry.getCreateDate());
                comment.setCommenterName(commentEntry.getCommenterName());
                comment.setComment(commentEntry.getComment());

                commentClient.saveComment(comment);
                System.out.println("Saved comment: " + comment.toString());
            } else {
                Comment comment = new Comment();
                comment.setCommentId(commentEntry.getCommentId());
                comment.setPostId(commentEntry.getPostId());
                comment.setCreateDate(commentEntry.getCreateDate());
                comment.setCommenterName(commentEntry.getCommenterName());
                comment.setComment(commentEntry.getComment());

                commentClient.updateComment(commentEntry.getCommentId(),comment);
                System.out.println("Updated Comment: " + comment.toString());
            }
        } catch (Exception e) {
            System.out.println("There is an exception: " + e.getMessage());
        }
    }
}
