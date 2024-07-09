package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Нет такого вопроса!")
public class NotFoundQuestionException extends RuntimeException {
    public NotFoundQuestionException(String message) {
        super(message);
    }

}
