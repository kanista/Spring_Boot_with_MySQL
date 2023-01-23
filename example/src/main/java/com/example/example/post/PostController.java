package com.example.example.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
@Autowired
    private PostService postservice;
    @RequestMapping(value="/posts",method = RequestMethod.GET)
    public List<Post> getAllPosts(){
        return postservice.getAllPosts();
    }
    @RequestMapping(value="/posts/{id}",method = RequestMethod.GET)
    public Optional<Post> getPost(@PathVariable Long id){
        return postservice.getPost(id);
    }
    @RequestMapping(value = "/posts",method = RequestMethod.POST)
    public void addPost(@RequestBody Post post){
        postservice.addPost(post);
    }
    @RequestMapping(value = "/posts/{id}",method = RequestMethod.PUT)
    public void updatePost(@PathVariable Long id,@RequestBody Post post){
        postservice.updatePost(id,post);
    }
    @RequestMapping(value = "/posts/{id}",method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id){
        postservice.deletePost(id);
    }

}
