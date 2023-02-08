package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }
}
