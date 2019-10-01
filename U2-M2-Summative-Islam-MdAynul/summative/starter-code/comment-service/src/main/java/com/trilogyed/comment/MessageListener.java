package com.trilogyed.comment;

import com.trilogyed.comment.service.ServiceLayer;
import com.trilogyed.comment.util.CommentEntry;
import com.trilogyed.comment.viewmodel.CommentViewModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MessageListener {

    @Autowired
    ServiceLayer service;

    @RabbitListener(queues = CommentServiceApplication.QUEUE_NAME)
    public void receiveMessage(CommentEntry msg) {

        CommentViewModel cvm = new CommentViewModel();

        cvm.setPostId(msg.getPostId());
        cvm.setCommenterName(msg.getCommenterName());
        cvm.setCreateDate(msg.getCreateDate());
        cvm.setComment(msg.getComment());


        System.out.println(msg.toString());

        if(msg.getCommentId() == null){

            System.out.println(msg.toString());
            service.createComment(cvm);
        }else{
            cvm.setCommentId(msg.getCommentId());
            service.updateComment(cvm);
        }
    }
}
