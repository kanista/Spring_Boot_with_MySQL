package com.example.example.post;

import com.example.example.location.Location;
import com.example.example.student.Student;
import com.example.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
        private PostRepository postrepository;
    public List<Post> getAllPosts() {
        List<Post> posts=new ArrayList<>();
        postrepository.findAll().forEach(posts::add);
        return posts;
    }
    public Optional<Post> getPost(Long id){
        return postrepository.findById(id);
    }
    public void addPost(Post post) {

        postrepository.save(post);
    }
    public void updatePost(Long id, Post post) {
        Post pt=postrepository.findById(id).orElseThrow(()->new IllegalStateException("Post id not found"));
        pt.setPostdate(post.getPostdate());
        pt.setDetails(post.getDetails());
        pt.setUser(post.getUser());
        postrepository.save(pt);
    }

    public void deletePost(Long id) {
        postrepository.deleteById(id);
    }
}
