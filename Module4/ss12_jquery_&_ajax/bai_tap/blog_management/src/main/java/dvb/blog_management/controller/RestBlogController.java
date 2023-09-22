package dvb.blog_management.controller;

import dvb.blog_management.entity.Blog;
import dvb.blog_management.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Blog>> findByCategory(@RequestParam String head) {
        List<Blog> blogs = (List<Blog>) blogService.findByHead(head);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Page<Blog>> findAllPaging(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Blog> blogs = (Page<Blog>) blogService.findAllPaging(pageable);
        int totalPage = blogs.getTotalPages();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
