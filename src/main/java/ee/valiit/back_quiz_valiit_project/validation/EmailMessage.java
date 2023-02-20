package ee.valiit.back_quiz_valiit_project.validation;

import lombok.Getter;

@Getter
public enum EmailMessage {

    EMAIL_TO_ADMIN("Studyhelp uus kasutaja!!!", "Uus kasutaja vajab valideerimist.\n http://localhost:8081/#/login"),
    EMAIL_TO_USER("Studyhelp kasutaja aktiveeritud", "Teie õpetaja konto on aktiveeritud. \n http://localhost:8081/#/login");


    private String subject;
    private String body;

    EmailMessage(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
