package uz.pdp.call_api_openfeign_task.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import uz.pdp.call_api_openfeign_task.comment.CommentDTO;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class PostDTO implements Serializable {
    private Integer id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
}