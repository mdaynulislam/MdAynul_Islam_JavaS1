package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentFeign;
import com.trilogyed.stwitter.util.feign.PostFeign;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.util.message.CommentEntry;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import com.trilogyed.stwitter.viewModel.PostCommentViewModel;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private PostFeign pClient;
    private CommentFeign cClient;

    //For RarbbitMQ
    public static final String EXCHANGE = "comment-exchange";

    //Routing key in Queue Comment "create.#"
    public static final String ROUTING_KEY = "comment.create.stwitter.service";


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ServiceLayer(PostFeign pClient, CommentFeign cClient, RabbitTemplate rabbitTemplate) {
        this.pClient = pClient;
        this.cClient = cClient;
        this.rabbitTemplate = rabbitTemplate;
    }


    private PostCommentViewModel buildPostViewModel(PostViewModel post) {

        PostCommentViewModel pvm = new PostCommentViewModel();
        pvm.setPostId(post.getPostId());
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());

        return pvm;
    }


    public PostCommentViewModel createPost(PostCommentViewModel pcvm) {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostDate(pcvm.getPostDate());
        pvm.setPosterName(pcvm.getPosterName());
        pvm.setPost(pcvm.getPost());
        pvm = pClient.createPost(pvm);

        PostCommentViewModel pcvm2 = buildPostViewModel(pvm);

        return pcvm2;
    }


    public PostCommentViewModel getPost(int postId) {
        PostViewModel p =  pClient.getPost(postId);
        if(p==null){
            throw new NumberFormatException("Cannot find id " + postId);
        }

        PostCommentViewModel pcvm = buildPostViewModel(p);

        List<CommentViewModel> listComments = cClient.getCommentByPostId(postId);

        List<String> comments = new ArrayList<>();

        for(int i = 0; i < listComments.size(); i++ ){
            comments.add(listComments.get(i).getComment());
        }

        pcvm.setComments(comments);


        return pcvm;
    }

    public List<PostCommentViewModel> getPostByPosterName(String posterName) {
        List<PostViewModel> pList = pClient.getPostByPosterName(posterName);
        List<PostCommentViewModel> pvmList = new ArrayList<>();

        for (PostViewModel p : pList) {
            pvmList.add(buildPostViewModel(p));
        }
        if (pList.size() == 0)
            return null;
        else
            return pvmList;
    }

    public String createComment(CommentViewModel cvm){

        CommentEntry ce = new CommentEntry(cvm.getPostId(), cvm.getCommenterName(), cvm.getCommentDate(), cvm.getComment());

        System.out.println("Sending Message");

        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, ce);

        System.out.println("Sent");

        return "Comment added";

    }
}
