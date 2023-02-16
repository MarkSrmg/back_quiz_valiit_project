package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Resource
    private QuestionRepository questionRepository;

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public Question findQuestion(Integer questionId) {

        return questionRepository.findById(questionId).get();

    }
}
