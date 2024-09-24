package uz.pdp.call_api_openfeign_task.post;

import org.springframework.lang.NonNull;
import uz.pdp.call_api_openfeign_task.comment.CommentCreateDTO;

import java.util.List;

public interface PostService {
    PostDTO getPost(@NonNull Integer id);
    PostDTO createPost(@NonNull PostCreateDTO postCreateDTO);
    void createAllComments(@NonNull List<CommentCreateDTO> commentCreateDTOList);
}
