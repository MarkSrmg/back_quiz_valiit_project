package ee.valiit.back_quiz_valiit_project;

import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.EmailSenderService;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BackQuizValiitProjectApplication {

	//Eitea

	public static void main(String[] args) {
		SpringApplication.run(BackQuizValiitProjectApplication.class, args);
	}

}
