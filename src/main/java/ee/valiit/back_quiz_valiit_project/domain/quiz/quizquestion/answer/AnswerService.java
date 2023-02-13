package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

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

    public Answer findAnswer(Integer answerId) {
        return answerRepository.findById(answerId).get();
    }
}
