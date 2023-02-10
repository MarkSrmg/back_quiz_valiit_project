package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
public class AllQuestionService {
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionService questionService;
    @Resource
    private QuizQuestionService quizQuestionService;
    @Resource
    private QuizService quizService;
    @Resource
    private CounterService counterService;

    @Transactional
    public QuestionResponse addQuestion(Integer quizId, QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        questionService.saveQuestion(question);
        setNewQuizQuestionAndCounter(quizId, question);
        return new QuestionResponse(question.getId());
    }

    private void setNewQuizQuestionAndCounter(Integer quizId, Question question) {
        Quiz quiz = quizService.findQuiz(quizId);
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuiz(quiz);
        quizQuestion.setQuestion(question);
        quizQuestion.setStatus("A");
        quizQuestion.setTimestamp(Instant.now());
        quizQuestionService.saveQuizQuestion(quizQuestion);
        Counter counter = new Counter();
        counter.setQuizQuestion(quizQuestion);
        counter.setCorrectCount(0);
        counterService.saveCounter(counter);
    }
}
