package ee.valiit.back_quiz_valiit_project.studyhelp.dto;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.Question;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Question} entity
 */
@Data
public class QuestionDto implements Serializable {

    @Size(max = 500)
    @NotNull
    private String questionText;
    private String questionPicture;
    @Size(max = 1)
    @NotNull
    private String questionType;
}