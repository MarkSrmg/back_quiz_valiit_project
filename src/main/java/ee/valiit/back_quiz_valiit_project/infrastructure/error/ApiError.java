package ee.valiit.back_quiz_valiit_project.infrastructure.error;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private String errorCode;
}
