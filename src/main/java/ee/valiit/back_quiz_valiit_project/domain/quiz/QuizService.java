package ee.valiit.back_quiz_valiit_project.domain.quiz;

import jakarta.annotation.Resource;
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


    public List<Quiz> getUserLast5Quizzes(Integer userId) {
        return quizRepository.findUserQuizzesLast5(userId, ACTIVE);
    }

    public List<Quiz> getUserQuizzes(Integer userId) {
        return quizRepository.findUserQuizzes(userId, ACTIVE);
    }

    public List<Quiz> getPublicLast5Quizzes() {
        return quizRepository.findPublicQuizzesLast5(ACTIVE, true);
    }
    public List<Quiz> getPublicQuizzes() {
        return quizRepository.findPublicQuizzes(ACTIVE, true);
    }

    public void saveQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }
}
