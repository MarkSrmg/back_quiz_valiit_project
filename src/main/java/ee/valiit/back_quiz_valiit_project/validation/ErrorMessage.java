package ee.valiit.back_quiz_valiit_project.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Wrong username or password", "666"),
    NO_QUESTIONS_TO_ANSWER("All questions are answered", "404"),
    NO_QUESTIONS_ADDED("There are no questions added to this quiz", "400"),
    NO_ANSWERS_ADDED("There are no answers added to this question", "400"),
    USERNAME_TAKEN("This username is already taken", "888"),
    INCORRECT_ID ("Id not found", "777");

    private String message;
    private String code;


    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
