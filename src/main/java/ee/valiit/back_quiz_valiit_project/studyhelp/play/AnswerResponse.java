package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import lombok.Data;

@Data
public class AnswerResponse {
    private Integer answerId;
    private String answerText;
    private String answerPicture;
    private Boolean isSelected;


}
