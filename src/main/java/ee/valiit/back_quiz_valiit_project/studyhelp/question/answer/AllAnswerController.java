package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllAnswerController {
    @Resource
    private AllAnswerService allAnswerService;

    @PostMapping("/questions/answer")
    @Operation(summary = "adds new answer to question", description = "gets questionId and adds the answer to the question to database")
    public AnswerResponse addAnswer(@RequestParam Integer questionId, @RequestBody AnswerDto answerDto) {
        return allAnswerService.addAnswer(questionId, answerDto);
    }
}
