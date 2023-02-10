package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestion;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Resource
    private AnswerRepository answerRepository;
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> findAnswers(Integer id) {
        return answerRepository.findByQuestion_Id(id);
    }
}
