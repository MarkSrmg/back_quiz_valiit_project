package ee.valiit.back_quiz_valiit_project.domain.quiz;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Quiz} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto implements Serializable {
    private Integer id;
    @NotNull
    private UserDto user;
    @Size(max = 255)
    @NotNull
    private String name;
    @Size(max = 1)
    @NotNull
    private String status;
    @NotNull
    private Boolean isPublic = false;
    @Size(max = 1)
    @NotNull
    private String type;
    @NotNull
    private Instant timestamp;
}