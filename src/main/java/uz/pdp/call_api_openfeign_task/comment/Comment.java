package uz.pdp.call_api_openfeign_task.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String body;
    private Integer postId;

    public Comment(CommentCreateDTO commentCreateDTO) {
        this.name = commentCreateDTO.getName();
        this.postId = commentCreateDTO.getPostId();
        this.body = commentCreateDTO.getBody();
    }
}