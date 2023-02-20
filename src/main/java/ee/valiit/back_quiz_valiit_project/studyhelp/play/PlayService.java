package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.CounterRepository;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.counter.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionMapper;
import ee.valiit.back_quiz_valiit_project.studyhelp.Status;
import ee.valiit.back_quiz_valiit_project.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayService {
    @Resource
    private QuizService quizService;
    @Resource
    private QuizQuestionService quizQuestionService;
    @Resource
    private CounterService counterService;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private AnswerService answerService;
    @Resource
    private AnswerMapper answerMapper;
    private final CounterRepository counterRepository;

    public PlayService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public QuestionResponse findPublicQuestion(Integer quizId) {
        List<QuizQuestion> validQuestions = findAllActiveQuizQuestions(quizId);
        QuizQuestion randomQuizQuestion = getRandomQuizQuestion(validQuestions);
        QuestionResponse questionResponse = questionMapper.toResponse(randomQuizQuestion.getQuestion());
        findAnswers(randomQuizQuestion, questionResponse);
        return questionResponse;
    }
    public QuestionResponse findQuestion(Integer quizId) {
        List<QuizQuestion> validQuestions = findAllActiveQuizQuestions(quizId);
        List<QuizQuestion> validUnasnweredQuizQuestions = findAllUnansweredQuizQuestions(validQuestions);
        QuizQuestion randomQuizQuestion = getRandomQuizQuestion(validUnasnweredQuizQuestions);
        QuestionResponse questionResponse = questionMapper.toResponse(randomQuizQuestion.getQuestion());
        findAnswers(randomQuizQuestion, questionResponse);
        return questionResponse;
    }

    private List<QuizQuestion> findAllUnansweredQuizQuestions(List<QuizQuestion> validQuestions) {
        List<QuizQuestion> unansweredQuizQuestions = new ArrayList<>();
        for(QuizQuestion question : validQuestions){
           Counter counter = counterService.findQuestionCorrectCount(question.getId());
            if (question.getQuiz().getRequiredCount() > counter.getCorrectCount()){
                unansweredQuizQuestions.add(question);
            }
        }
        List<QuizQuestion> validUnansweredQuizQuestions = Validator.getValidUnasnweredQuizQuestions(unansweredQuizQuestions);
        return validUnansweredQuizQuestions;
    }

    private List<QuizQuestion> findAllActiveQuizQuestions(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> questions = quizQuestionService.findAllActiveQuizQuestions(quiz.getId(), Status.ACTIVE);
        List<QuizQuestion>validQuestions = Validator.getValidQuestions(questions);
        return validQuestions;
    }

    private void findAnswers(QuizQuestion randomQuizQuestion, QuestionResponse questionResponse) {
        List<Answer> answers = answerService.findAnswers(randomQuizQuestion.getQuestion().getId());
        List<Answer> validAnswers = Validator.getValidAnswers(answers);
        List<AnswerResponse> answersResponse = answerMapper.toResponses(validAnswers);
        questionResponse.setAnswers(answersResponse);
    }

    public static QuizQuestion getRandomQuizQuestion(List<QuizQuestion> unansweredQuestions) {
        return unansweredQuestions.get(new Random().nextInt(unansweredQuestions.size()));
    }

    public void increaseQuestionCorrectCount(Integer quizId, Integer questionId) {
       QuizQuestion quizQuestion = quizQuestionService.findQuizQuestion(quizId, questionId);
        Counter counter = counterService.findQuestionCorrectCount(quizQuestion.getId());
        counter.setCorrectCount(counter.getCorrectCount()+1);
        counterService.saveCorrectCount(counter);
    }
}
