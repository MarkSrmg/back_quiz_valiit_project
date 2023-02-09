package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse {
    private Integer questionId;
    private String questionText;
    private String questionPicture;
    private String questionType;

    private List<AnswerResponse> answers;



}
