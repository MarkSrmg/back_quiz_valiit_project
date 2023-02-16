package ee.valiit.back_quiz_valiit_project.validation;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestion;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_quiz_valiit_project.validation.ErrorMessage.*;

public class Validator {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }

    public static List <QuizQuestion> getValidUnasnweredQuizQuestions(List<QuizQuestion> unansweredQuizQuestions) {
        if(unansweredQuizQuestions.isEmpty()){
            throw new DataNotFoundException(NO_QUESTIONS_TO_ANSWER.getMessage(), NO_QUESTIONS_TO_ANSWER.getCode());
        }
        return unansweredQuizQuestions;
    }

    public static List<QuizQuestion> getValidQuestions(List<QuizQuestion> questions) {
        if(questions.isEmpty()){
            throw new DataNotFoundException(NO_QUESTIONS_ADDED.getMessage(), NO_QUESTIONS_ADDED.getCode());
        }
        return questions;
    }

    public static List<Answer> getValidAnswers(List<Answer> answers) {
        if(answers.isEmpty()){
            throw new DataNotFoundException(NO_ANSWERS_ADDED.getMessage(), NO_ANSWERS_ADDED.getCode());
        }
        return answers;
    }
}
