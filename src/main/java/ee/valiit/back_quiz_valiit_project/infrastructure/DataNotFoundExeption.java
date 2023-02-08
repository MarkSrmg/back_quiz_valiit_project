package ee.valiit.back_quiz_valiit_project.infrastructure;

import lombok.Data;

@Data
public class DataNotFoundExeption extends RuntimeException {

    private final String message;

    private final String errorCode;

    public DataNotFoundExeption(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}


