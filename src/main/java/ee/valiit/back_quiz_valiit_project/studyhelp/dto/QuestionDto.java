package ee.valiit.back_quiz_valiit_project.studyhelp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question} entity
 */
@Data
public class QuestionDto implements Serializable {
    private Integer id;
    @Size(max = 500)
    @NotNull
    private String text;
    private String picture;
    @Size(max = 1)
    @NotNull
    private String type;
}