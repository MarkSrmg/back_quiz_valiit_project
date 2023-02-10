package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
@Resource
    private CounterRepository counterRepository;
    public Counter finfQuestionCount(QuizQuestion nextQuestion) {
        return counterRepository.findQuestionCount(nextQuestion.getId()).get();
    }
}
