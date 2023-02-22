package ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto;

import lombok.Data;

@Data
public class EditQuiz {
    private String quizName;
    private Integer requiredCount;
    private Boolean isPublic;
}
