package uz.pdp.call_api_openfeign_task.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.call_api_openfeign_task.comment.CommentCreateDTO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody PostCreateDTO postCreateDTO) {
        return ResponseEntity.ok(postService.createPost(postCreateDTO));
    }

    @PostMapping("/comments")
    public ResponseEntity<Post> saveAllComments(@RequestBody List<CommentCreateDTO> commentCreateDTOS) {
         postService.createAllComments(commentCreateDTOS);
         return ResponseEntity.noContent().build();
    }
}
