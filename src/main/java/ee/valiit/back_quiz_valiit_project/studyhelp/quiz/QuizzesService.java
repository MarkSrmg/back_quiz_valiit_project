package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionRepository;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionService;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.EditQuiz;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import static ee.valiit.back_quiz_valiit_project.studyhelp.Status.ACTIVE;
import static ee.valiit.back_quiz_valiit_project.studyhelp.Status.DEACTIVATED;

@Service
public class QuizzesService {
    public static final int DEFAULT_REQUIRED_COUNT = 1;
    public static final int DEFAULT_CORRECT_COUNT = 0;
    @Resource
    private QuizService quizService;
    @Resource
    private UserService userService;
    @Resource
    private QuizMapper quizMapper;
    @Resource
    private CounterService counterService;
    @Resource
    private QuizQuestionService quizQuestionService;
    @Resource
    private QuestionService questionService;
    @Resource
    private AnswerService answerService;
    private final QuestionRepository questionRepository;


    public QuizzesService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public QuizResponse addNewQuiz(Integer userId, QuizRequest quizRequest) {
        User user = userService.findUser(userId);
        Quiz quiz = quizMapper.toEntity(quizRequest);
        quiz.setUser(user);
        quizService.addNewQuiz(quiz);
        return new QuizResponse(quiz.getId());
    }

    public List<QuizDto> getUserLast5Quizzes(Integer userId) {
        List<Quiz> quizzes = quizService.getUserLast5Quizzes(userId);
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getUserQuizzes(Integer userId) {
        List<Quiz> quizzes = quizService.getUserQuizzes(userId);
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getPublicLast5Quizzes() {
        List<Quiz> quizzes = quizService.getPublicLast5Quizzes();
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getPublicQuizzes() {
        List<Quiz> quizzes = quizService.getPublicQuizzes();
        return quizMapper.toDtos(quizzes);
    }

    public void resetCounter(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> quizQuestions = quizQuestionService.findAllQuestions(quiz.getId());
        for (QuizQuestion quizQuestion : quizQuestions) {
            Counter count = counterService.findQuestionCorrectCount(quizQuestion.getId());
            count.setCorrectCount(0);
            counterService.saveCounter(count);
        }
    }

    public void deleteQuiz(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        String currentName = quiz.getName();
        String newName = currentName + " (Deactivated: " + LocalDateTime.now() + ") ";
        quiz.setName(newName);
        quiz.setStatus(DEACTIVATED);
        quizService.saveQuiz(quiz);
    }

    public void copyPublicQuizToUser(Integer quizId, Integer userId) {
        Quiz publicQuiz = quizService.findQuiz(quizId);
        Quiz userQuiz = createAndSaveUserQuiz(userId, publicQuiz);
        List<QuizQuestion> publicQuizQuestions = quizQuestionService.findAllQuestions(publicQuiz.getId());
        for (QuizQuestion publicQuizQuestion : publicQuizQuestions) {
            Question publicQuestion = publicQuizQuestion.getQuestion();
            Question userQuestion = createUserQuestion(publicQuestion);
            questionService.saveQuestion(userQuestion);
            QuizQuestion userQuizQuestion = createAndSaveUserQuizQuestion(userQuiz, userQuestion);
            createAndSaveUserCounter(userQuizQuestion);
            createAndSaveUserAnswers(publicQuestion, userQuestion);
        }
    }

    private static Quiz createUserQuiz(Quiz publicQuiz, User user) {
        Quiz userQuiz = new Quiz();
        userQuiz.setUser(user);
        userQuiz.setName(publicQuiz.getName());
        userQuiz.setType(publicQuiz.getType());
        userQuiz.setTimestamp(Instant.now());
        userQuiz.setIsPublic(false);
        userQuiz.setStatus(ACTIVE);
        userQuiz.setRequiredCount(DEFAULT_REQUIRED_COUNT);
        return userQuiz;
    }

    private Quiz createAndSaveUserQuiz(Integer userId, Quiz publicQuiz) {
        User user = userService.findUser(userId);
        Quiz userQuiz = createUserQuiz(publicQuiz, user);
        quizService.saveQuiz(userQuiz);
        return userQuiz;
    }

    private static Question createUserQuestion(Question publicQuestion) {
        Question userQuestion = new Question();
        userQuestion.setText(publicQuestion.getText());
        userQuestion.setPicture(publicQuestion.getPicture());
        userQuestion.setType(publicQuestion.getType());
        return userQuestion;
    }

    private void createAndSaveUserCounter(QuizQuestion userQuizQuestion) {
        Counter userCounter = new Counter();
        userCounter.setCorrectCount(DEFAULT_CORRECT_COUNT);
        userCounter.setQuizQuestion(userQuizQuestion);
        counterService.saveCounter(userCounter);
    }

    private static QuizQuestion createQuizQuestion(Quiz userQuiz, Question userQuestion) {
        QuizQuestion userQuizQuestion = new QuizQuestion();
        userQuizQuestion.setQuiz(userQuiz);
        userQuizQuestion.setQuestion(userQuestion);
        userQuizQuestion.setStatus(ACTIVE);
        userQuizQuestion.setTimestamp(Instant.now());
        return userQuizQuestion;
    }

    private QuizQuestion createAndSaveUserQuizQuestion(Quiz userQuiz, Question userQuestion) {
        QuizQuestion userQuizQuestion = createQuizQuestion(userQuiz, userQuestion);
        quizQuestionService.saveQuizQuestion(userQuizQuestion);
        return userQuizQuestion;
    }

    private void createAndSaveUserAnswers(Question publicQuestion, Question userQuestion) {
        List<Answer> publicAnswers = answerService.findAnswers(publicQuestion.getId());
        for (Answer publicAnswer : publicAnswers) {
            Answer userAnswer = new Answer();
            userAnswer.setText(publicAnswer.getText());
            userAnswer.setPicture(publicAnswer.getPicture());
            userAnswer.setQuestion(userQuestion);
            userAnswer.setIsCorrect(publicAnswer.getIsCorrect());
            answerService.saveAnswer(userAnswer);
        }
    }

    public void editQuiz(Integer quizId, EditQuiz editQuiz) {
        Quiz quiz = quizService.findQuiz(quizId);
        quiz.setName(editQuiz.getQuizName());
        quiz.setIsPublic(editQuiz.getIsPublic());
        quiz.setRequiredCount(editQuiz.getRequiredCount());
        quizService.saveQuiz(quiz);
    }
}
