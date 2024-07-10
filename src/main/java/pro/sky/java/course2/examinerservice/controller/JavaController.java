package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.BadParamsException;
import pro.sky.java.course2.examinerservice.exception.EmptyCollectionException;
import pro.sky.java.course2.examinerservice.exception.NotFoundQuestionException;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaController {

    /*
    Реализация контроллер JavaQuestionController,
    который будет предоставлять возможность пользователю добавлять,
    просматривать и удалять вопросы по Java в соответствующем QuestionService.

    Контроллер должен иметь три метода: добавить, удалить и получить все вопросы.
    Эти методы должны висеть на следующих эндпоинтах:
    Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    Получить все вопросы: “/exam/java”
     */

    // Внедрение через конструктор экземпляра сервиса
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Метод добавления в коллекцию вопрос-ответа с выбросом исключения в случае отсутствия одного из параметров
    @GetMapping(path = "/add")
    public Question add(@RequestParam(value = "question", required = false) String question,
                        @RequestParam(value = "answer", required = false) String answer) {

        if (question == null || answer == null) {
            throw new BadParamsException("Отсутствует один из параметров!");
        }
        return questionService.add(question, answer);
    }

    // Метод удаления из коллекции вопрос-ответа с выбросом исключения в случае отсутствия одного из параметров
    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(value = "question", required = false) String question,
                           @RequestParam(value = "answer", required = false) String answer)
            throws NotFoundQuestionException {

        if (question == null || answer == null) {
            throw new BadParamsException("Отсутствует один из параметров!");
        }
        return questionService.remove(new Question(question, answer));
    }

    // Метод получения всех вопросов в виде коллекции (Лист)
    @GetMapping()
    public Collection<Question> getAll() throws EmptyCollectionException {
        return questionService.getAll();
    }

}
