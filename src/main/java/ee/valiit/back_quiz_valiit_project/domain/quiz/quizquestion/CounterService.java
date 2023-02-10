package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
@Resource
    private CounterRepository counterRepository;
    public Counter findQuestionCorrectCount(Integer quizQuestionId) {
        return counterRepository.findQuestionCount(quizQuestionId).get();
    }

    public void saveCorrectCount(Counter counter) {
        counterRepository.save(counter);
    }

    public void saveCounter(Counter counter) {
        counterRepository.save(counter);
    }
}
