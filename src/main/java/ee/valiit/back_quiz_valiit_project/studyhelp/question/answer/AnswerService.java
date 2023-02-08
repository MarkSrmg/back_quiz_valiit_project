package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Resource
    private AnswerRepository answerRepository;
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
