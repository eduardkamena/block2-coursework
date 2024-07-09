package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountOfGetQuestionsMoreQuestionListException;
import pro.sky.java.course2.examinerservice.exception.MinusOrZeroAmountException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/get")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public String printHello() {
        return "Для получения списка вопросов нужно вместо "
                + String.format("<b>%s</b>", "{?}")
                + " в строке /get/"
                + String.format("<b>%s</b>", "{?}")
                + " написать цифрой количество желаемых вопросов";
    }

    @GetMapping(path = "/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount)
            throws AmountOfGetQuestionsMoreQuestionListException, MinusOrZeroAmountException {
        return new ArrayList<>(examinerService.getQuestions(amount));
    }

}
