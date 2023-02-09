package ee.valiit.back_quiz_valiit_project.domain.quiz;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizService {

    @Resource
    private QuizRepository quizRepository;

    public void addNewQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }


}
