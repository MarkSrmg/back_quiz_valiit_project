package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Answer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerInfo implements Serializable {
    private Integer answerId;
    @Size(max = 500)
    private String answerText;
    private String answerPicture;
    @NotNull
    private Boolean answerIsCorrect = false;
}