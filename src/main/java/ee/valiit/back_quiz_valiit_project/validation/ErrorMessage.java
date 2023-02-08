package ee.valiit.back_quiz_valiit_project.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Wrong username or password", "666");

    private String message;
    private String code;

    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
