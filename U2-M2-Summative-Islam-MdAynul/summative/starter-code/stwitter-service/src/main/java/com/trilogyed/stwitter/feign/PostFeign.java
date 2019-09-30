package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
@RequestMapping("/posts")
public interface PostFeign {

    @PostMapping
    public PostViewModel addPost(@RequestBody PostViewModel pvm);

    @GetMapping("/{id}")
    public PostViewModel getPost(@PathVariable("id") int id);

    @GetMapping("/user/{posterName}")
    public List<PostViewModel> getPost(@PathVariable("posterName") String posterName);

}
