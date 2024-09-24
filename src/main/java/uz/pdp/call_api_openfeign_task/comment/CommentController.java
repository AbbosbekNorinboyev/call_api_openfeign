package uz.pdp.call_api_openfeign_task.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentRepository.findAll());
    }

    @GetMapping("/{id}/post")
    public ResponseEntity<List<Comment>> getAllByPostId(@PathVariable Integer id) throws InterruptedException {
        log.info("Comments requested for POST ID : {}", id);
        TimeUnit.SECONDS.sleep(1L);
        return ResponseEntity.ok(commentRepository.findAllByPostId(id));
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Void> createList(@RequestBody List<CommentCreateDTO> commentCreateDTOList) {
        log.info("Creating List Of Comments : {}", commentCreateDTOList);
        List<Comment> comments = commentCreateDTOList.stream()
                .map(Comment::new)
                .toList();
        commentRepository.saveAll(comments);
        return ResponseEntity.ok(null);
    }
}