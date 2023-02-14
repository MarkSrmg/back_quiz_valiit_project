package ee.valiit.back_quiz_valiit_project.domain.quiz;

import ee.valiit.back_quiz_valiit_project.domain.user.Status;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.valiit.back_quiz_valiit_project.domain.user.Status.ACTIVE;


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


    public List<Quiz> getUserQuizzes(Integer userId) {
        List<Quiz> userQuizzes = quizRepository.findQuizzes(userId, ACTIVE);
        return userQuizzes;
    }

    public List<Quiz> getPublicQuizzes() {
        List<Quiz> publicQuizzes = quizRepository.findQuizzes(ACTIVE, true);
        return publicQuizzes;
    }

    public void saveQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }
}
