package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionService;
import ee.valiit.back_quiz_valiit_project.studyhelp.Status;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionShort;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


@Service
public class QuestionsService {
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
        quizQuestion.setStatus(Status.ACTIVE);
        quizQuestion.setTimestamp(Instant.now());
        quizQuestionService.saveQuizQuestion(quizQuestion);
        Counter counter = new Counter();
        counter.setQuizQuestion(quizQuestion);
        counter.setCorrectCount(0);
        counterService.saveCounter(counter);
    }

    public void editQuestion(Integer questionId, QuestionDto questionDto) {
        Question question = questionService.findQuestion(questionId);
        questionMapper.updateQuestion(questionDto, question);
        questionService.saveQuestion(question);
    }

    public List<QuestionShort> getQuestions(Integer quizId) {
        List<QuizQuestion> quizQuestions = quizQuestionService.findAllQuestions(quizId);
        return null;
    }
}
