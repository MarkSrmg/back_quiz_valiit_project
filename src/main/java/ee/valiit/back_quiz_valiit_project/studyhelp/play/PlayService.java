package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerService;
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

    private AnswerMapper answerMapper;

    public QuestionResponse findQuestion(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> questions = quizQuestionService.findAllQuestions(quiz);
        List<QuizQuestion> unansweredQuizQuestions = new ArrayList<>();
        for(QuizQuestion question : questions){
           Counter counter = counterService.finfQuestionCount(question);
            if (question.getQuiz().getRequiredCount() > counter.getCorrectCount()){
                unansweredQuizQuestions.add(question);
            }
        }

        QuizQuestion randomQuizQuestion = getRandomQuizQuestion(unansweredQuizQuestions);
        QuestionResponse questionResponse = questionMapper.toDto(randomQuizQuestion.getQuestion());
        // TODO: 10.02.2023 Hetkel questionId tuleb null
        List<Answer> answers = answerService.findAnswers(randomQuizQuestion.getQuestion().getId());
        List<AnswerResponse> answersResponse = answerMapper.toDtos(answers);
        questionResponse.setAnswers(answersResponse);
        return questionResponse;
    }

    public static QuizQuestion getRandomQuizQuestion(List<QuizQuestion> unansweredQuestions) {
        return unansweredQuestions.get(new Random().nextInt(unansweredQuestions.size()));
    }
}
