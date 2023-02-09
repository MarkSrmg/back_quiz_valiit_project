package ee.valiit.back_quiz_valiit_project.domain.quiz;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class QuizService {

    @Resource
    private QuizRepository quizRepository;

    public void addNewQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }
    public Quiz findQuiz(Integer quizId){
        return quizRepository.findById(quizId).get();
    }

}
