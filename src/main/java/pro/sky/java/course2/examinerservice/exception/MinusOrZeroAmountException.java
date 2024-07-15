package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Запрос количества вопросов должен быть больше 0")
public class MinusOrZeroAmountException extends RuntimeException {
    public MinusOrZeroAmountException(String message) {
        super(message);
    }

}
