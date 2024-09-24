package uz.pdp.call_api_openfeign_task.post;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.call_api_openfeign_task.comment.CommentCreateDTO;
import uz.pdp.call_api_openfeign_task.resource.CommentClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentClient commentClient;

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found: " + id));
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentClient.getAllCommentsByPostId(post.getId()))
                .build();
    }

    @Override
    public PostDTO createPost(@NonNull PostCreateDTO postCreateDTO) {
        Post post = Post.builder()
                .title(postCreateDTO.getTitle())
                .body(postCreateDTO.getBody())
                .build();
        postRepository.save(post);
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    @Override
    public void createAllComments(@NonNull List<CommentCreateDTO> commentCreateDTOList) {
        commentClient.saveAllComments(commentCreateDTOList);
    }
}
