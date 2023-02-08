package ee.valiit.back_quiz_valiit_project.validation;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

import static ee.valiit.back_quiz_valiit_project.validation.ErrorMessage.INCORRECT_CREDENTIALS;
import static ee.valiit.back_quiz_valiit_project.validation.ErrorMessage.INCORRECT_ID;

public class Validator {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }
}
