package ee.valiit.back_quiz_valiit_project.studyhelp.dto;

import lombok.Data;

@Data
public class QuizDto {
    private String quizName;
    private Integer requiredCount;

//    private Integer userId;

    private String quizType;

}
