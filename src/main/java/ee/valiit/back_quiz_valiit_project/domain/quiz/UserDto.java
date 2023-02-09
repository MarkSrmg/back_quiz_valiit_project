package ee.valiit.back_quiz_valiit_project.domain.quiz;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_quiz_valiit_project.domain.user.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    @Size(max = 255)
    @NotNull
    private String username;
    @Size(max = 255)
    @NotNull
    private String password;
    @Size(max = 1)
    @NotNull
    private String status;
}