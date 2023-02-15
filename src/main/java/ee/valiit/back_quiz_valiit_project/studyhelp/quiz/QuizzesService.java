package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizRepository;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestion;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestionService;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
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
        // TODO: kasutades "publicQuiz" objekti leiame andmebaasist "publicQuizQuestions" listi (quizQuestionService-> quizQuestionRepository)

        // TODO: teeme publicu "publicQuizQuestions" listist for tsykkli - ja nimetame tsykli yksik objekti nimeks "publicQuizQuestion"
        // TODO: tsykkli sees teeme:

                // TODO: publicQuizQuestion.getQuestoniga() saame kätte Question tüüpi objekti "publicQuestion"


                // TODO: teeme juurde yhe uue (new Question) tüüpi objekti "userQuestion" (uus rida)

                // TODO:  täidame setteritega ära "userQuestion" andmed (info saab "publicQuestion" objektist getteritega)

                // TODO: salvestame andmebaasi "userQuestion" rea (questionService-> questionRepository)


                // TODO: teeme juurde yhe uue (new QuizQuestion) tüüpi objekti "userQuizQuestion" (uus rida)

                // TODO:  täidame setteritega ära "userQuizQuestion" andmed (info saab "publicQuizQuestion" objektist getteritega)

                // TODO: salvestame andmebaasi "userQuizQuestion" rea (quizQuestionService-> quizQuestionRepository)

                // TODO: kasutades "publicQuestion" objekti leiame andmebaasist "publicAnswers" listi (answerService-> answerRepository)

                // TODO: teeme publicu "publicAnswers" listist for tsykkli - ja nimetame tsykli yksik objekti nimeks "publicAnswer"
                // TODO: tsykkli sees teeme:

                        // TODO: teeme juurde yhe uue (new Answer) tüüpi objekti "userAnswer" (uus rida)

                        // TODO:  täidame setteritega ära "userAnswer" andmed (info saab "publicAnswer" objektist getteritega)

                        // TODO: salvestame andmebaasi "userAnswer" rea (answerService-> answerRepository)

        // TODO: THE END - JUHUUUUUU!!! :)




    }

    private Quiz createAndSaveUserQuiz(Integer userId, Quiz publicQuiz) {
        User user = userService.findUser(userId);
        Quiz userQuiz = createUserQuiz(publicQuiz, user);
        quizService.saveQuiz(userQuiz);
        return userQuiz;
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
}
