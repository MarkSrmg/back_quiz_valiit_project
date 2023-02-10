package ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
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
    private Integer quizId;
    @Size(max = 255)
    @NotNull
    private String quizName;
    @Size(max = 1)
    @NotNull
    private String quizType;
}