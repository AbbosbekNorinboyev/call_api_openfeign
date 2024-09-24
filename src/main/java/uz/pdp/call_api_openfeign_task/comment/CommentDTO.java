package uz.pdp.call_api_openfeign_task.comment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {
    private Integer id;
    private String name;
    private String body;
    private Integer postId;
}