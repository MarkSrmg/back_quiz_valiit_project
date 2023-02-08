package ee.valiit.back_quiz_valiit_project.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Wrong username or password", "666"),
    INCORRECT_ID ("Id not found", "777");

    private String message;
    private String code;


    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
