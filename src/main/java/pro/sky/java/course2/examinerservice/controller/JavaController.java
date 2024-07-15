package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.BadParamsException;
import pro.sky.java.course2.examinerservice.exception.EmptyCollectionException;
import pro.sky.java.course2.examinerservice.exception.NotFoundQuestionException;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

/*
Реализация контроллера JavaQuestionController, который имеет возможность
добавлять, удалять и просматривать вопросы по Java в соответствующем QuestionService.
 */

@RestController
@RequestMapping(path = "/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(value = "question", required = false) String question,
                        @RequestParam(value = "answer", required = false) String answer) {

        if (question == null || answer == null) {
            throw new BadParamsException("Отсутствует один из параметров!");
        }
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(value = "question", required = false) String question,
                           @RequestParam(value = "answer", required = false) String answer)
            throws NotFoundQuestionException {

        if (question == null || answer == null) {
            throw new BadParamsException("Отсутствует один из параметров!");
        }
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    public Collection<Question> getAll() throws EmptyCollectionException {
        return questionService.getAll();
    }

}
