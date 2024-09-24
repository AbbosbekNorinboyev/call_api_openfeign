package uz.pdp.call_api_openfeign_task.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.call_api_openfeign_task.comment.CommentCreateDTO;
import uz.pdp.call_api_openfeign_task.comment.CommentDTO;

import java.util.List;

@FeignClient(value = "CommentClient", url = "${comments.url.base}")
public interface CommentClient {
    @GetMapping("/{id}/post")
    List<CommentDTO> getAllCommentsByPostId(@PathVariable Integer id);

    @PostMapping("/saveAll")
    Void saveAllComments(@RequestBody List<CommentCreateDTO> dtoList);
}
