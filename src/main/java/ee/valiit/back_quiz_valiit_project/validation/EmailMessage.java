package ee.valiit.back_quiz_valiit_project.validation;

import lombok.Getter;

@Getter
public enum EmailMessage {

    EMAIL_TO_ADMIN("Studyhelp uus kasutaja!!!", "Uus kasutaja vajab valideerimist.\n http://localhost:8081/#/"),
    EMAIL_TO_USER_APPROVED("Studyhelp kasutaja aktiveeritud", "Teie õpetaja konto on aktiveeritud. \n http://localhost:8081/#/"),
    EMAIL_TO_USER_PENDING("Studyhelp vajab faile", "Teie Studyhelp konto aktiveerimiseks palun saada koopia oma Id-kaardist aadressile noreplymailtestservice@gmail.com");


    private String subject;
    private String body;

    EmailMessage(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
