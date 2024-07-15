package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED, reason = "Отсутствует один из параметров!")
public class BadParamsException extends RuntimeException {
    public BadParamsException(String message) {
        super(message);
    }

}
