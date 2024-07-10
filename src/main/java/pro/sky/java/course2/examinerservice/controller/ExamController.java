package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountOfGetQuestionsMoreQuestionListException;
import pro.sky.java.course2.examinerservice.exception.MinusOrZeroAmountException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.ArrayList;
import java.util.Collection;

/*
Реализация контроллера ExamController с одним методом getQuestions(int amount).
Контроллер должен обратиться к ExaminerService, получить от сервиса коллекцию вопросов и вернуть пользователю.
 */

@RestController
@RequestMapping(path = "/get")
public class ExamController {

    // Создание экземпляра класса через конструктор
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    // Метод приветствия)
    @GetMapping()
    public String printHello() {
        return "Для получения списка вопросов нужно вместо "
                + String.format("<b>%s</b>", "{?}")
                + " в строке /get/"
                + String.format("<b>%s</b>", "{?}")
                + " написать цифрой количество желаемых вопросов";
    }

    // Метод возврата коллекции (ArrayList) со случайными вопросами из коллекции вопросов
    /*
    Метод должен обращаться к некому эндпоинту по адресу /exam/get/{amount}
    для получения ответа в виде списка случайных вопросов-ответов,
    количество которых равно amount из прошлого шага
    */
    @GetMapping(path = "/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount)
            throws AmountOfGetQuestionsMoreQuestionListException, MinusOrZeroAmountException {
        return new ArrayList<>(examinerService.getQuestions(amount));
    }

}
