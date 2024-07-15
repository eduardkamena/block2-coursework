package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Количество запрошенных вопросов больше списка вопросов!")
public class AmountOfGetQuestionsMoreQuestionListException extends RuntimeException {
    public AmountOfGetQuestionsMoreQuestionListException(String message) {
        super(message);
    }

}
