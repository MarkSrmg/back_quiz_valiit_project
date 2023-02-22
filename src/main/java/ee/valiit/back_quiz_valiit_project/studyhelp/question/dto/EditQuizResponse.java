package ee.valiit.back_quiz_valiit_project.studyhelp.question.dto;

import lombok.Data;

import java.util.List;

@Data
public class EditQuizResponse {
    private String quizName;
    private Integer requiredCount;
    private Boolean isPublic;
    private List<QuestionShort> questionShort;


}
