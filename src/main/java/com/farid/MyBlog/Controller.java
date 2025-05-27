package com.farid.MyBlog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final BlogRepository blogRepository;

    public Controller(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blogs")
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }

    @PostMapping("/blogs/search")
    public List<BlogDTO> searchBlogs(@RequestParam String search) {
        return blogRepository.searchBlogs(search);
    }

    @PostMapping("/blogs/comments")
    public List<CommentDTO> getCommentsBlogs(@RequestParam String ID) {
        return blogRepository.findCommentsBlogs(ID);
    }
    @PostMapping("/blogs/")
    public BlogDTO getBlogById(@RequestParam int ID) {
        return blogRepository.getBlogById(ID);
    }
    @PostMapping("/blogs/categroy")
    public List<BlogDTO> getcategoryBlog(@RequestParam String category) {
        return blogRepository.fetchCategoryBlogs(category);
    }
}
