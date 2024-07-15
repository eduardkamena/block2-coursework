package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.java.course2.examinerservice.exception.*;

/*
Отдельный класс Контроллера для отлова всех ошибок при работе приложения
 */

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BadParamsException.class)
    public String handlerExBadParamsException(BadParamsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(EmptyCollectionException.class)
    public String handlerExEmptyCollectionException(EmptyCollectionException e) {
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundQuestionException.class)
    public String handlerExNotFoundQuestionException(NotFoundQuestionException e) {
        return e.getMessage();
    }

    @ExceptionHandler(AmountOfGetQuestionsMoreQuestionListException.class)
    public String handlerExAmountOfGetQuestionsMoreQuestionListException(AmountOfGetQuestionsMoreQuestionListException e) {
        return e.getMessage();
    }

    @ExceptionHandler(MinusOrZeroAmountException.class)
    public String handlerExMinusOrZeroAmountException(MinusOrZeroAmountException e) {
        return e.getMessage();
    }

}
