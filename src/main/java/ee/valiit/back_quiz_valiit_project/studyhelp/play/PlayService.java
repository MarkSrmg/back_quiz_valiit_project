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
    @Resource
    private AnswerMapper answerMapper;

    public QuestionResponse findQuestion(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> questions = quizQuestionService.findAllQuestions(quiz.getId());
        // TODO: 10.02.2023 Kui 0 anna teade küsimusi pole lisatud 
        List<QuizQuestion> unansweredQuizQuestions = new ArrayList<>();
        for(QuizQuestion question : questions){
           Counter counter = counterService.findQuestionCorrectCount(question.getId());
            if (question.getQuiz().getRequiredCount() > counter.getCorrectCount()){
                unansweredQuizQuestions.add(question);
                // TODO: 10.02.2023 Kui unanswered 0 siis anna teade et kõik on vastatud 
            }
        }
        QuizQuestion randomQuizQuestion = getRandomQuizQuestion(unansweredQuizQuestions);
        QuestionResponse questionResponse = questionMapper.toDto(randomQuizQuestion.getQuestion());
        List<Answer> answers = answerService.findAnswers(randomQuizQuestion.getQuestion().getId());
        // TODO: 10.02.2023 Kui 0 siis anna teade vastuseid pole lisatud 
        List<AnswerResponse> answersResponse = answerMapper.toDtos(answers);
        questionResponse.setAnswers(answersResponse);
        return questionResponse;
    }

    public static QuizQuestion getRandomQuizQuestion(List<QuizQuestion> unansweredQuestions) {
        return unansweredQuestions.get(new Random().nextInt(unansweredQuestions.size()));
    }
}
