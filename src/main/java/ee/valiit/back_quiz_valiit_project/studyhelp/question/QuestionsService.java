package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionService;
import ee.valiit.back_quiz_valiit_project.studyhelp.Status;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.EditQuizResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionShort;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static ee.valiit.back_quiz_valiit_project.domain.user.Status.ACTIVE;


@Service
public class QuestionsService {


    @Resource
    private QuestionService questionService;
    @Resource
    private QuizQuestionService quizQuestionService;
    @Resource
    private QuizMapper quizMapper;
    @Resource
    private QuizService quizService;
    @Resource
    private CounterService counterService;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private QuizQuestionMapper quizQuestionMapper;

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

    public EditQuizResponse getQuestions(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        EditQuizResponse editQuizResponse = quizMapper.toEditQuestionResponse(quiz);
        List<QuizQuestion> quizQuestions = quizQuestionService.findAllActiveQuizQuestions(quiz.getId(), ACTIVE);
        List<QuestionShort> questionShorts = quizQuestionMapper.toQuestionShorts(quizQuestions);
        addQuestionNumber(questionShorts);
        editQuizResponse.setQuestionShort(questionShorts);
        return editQuizResponse;
    }

    private static void addQuestionNumber(List<QuestionShort> questionShorts) {
        int counter = 1;
        for (QuestionShort questionShort : questionShorts) {
            questionShort.setQuestionNumber(counter);
            counter++;
        }
    }

    public void deleteQuestion(Integer questionId) {
        QuizQuestion quizQuestion = quizQuestionService.findQuizQuestion(questionId);
        quizQuestionService.deleteQuestion(quizQuestion);
    }

    public QuestionDto getQuestion(Integer questionId) {
        Question question = questionService.findQuestion(questionId);
        return questionMapper.toDto(question);
    }
}
