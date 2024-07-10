package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountOfGetQuestionsMoreQuestionListException;
import pro.sky.java.course2.examinerservice.exception.MinusOrZeroAmountException;

import java.util.*;

/*
Реализация ExaminerServiceImpl, который является реализацией интерфейса ExaminerService.
Данный сервис хранит внутри себя поля типа QuestionService.
Его задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами.
 */

@Service
public class ExaminerServiceImpl implements ExaminerService {

    // Инициализация экземпляра интерфейса QuestionService через конструктор
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Реализация метода создания коллекции и заполнение её с помощью вызова
    // getRandomQuestion у QuestionService случайными вопросами
    /*
    Вопросы должны быть уникальные, следовательно, для получения 5 вопросов может потребоваться
    более 5 вызовов метода getRandomQuestion сервиса вопросов.
    Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение.
    Для этого, соответственно, нужно написать свое исключение со статусом BAD_REQUEST.
     */
    @Override
    public Collection<Question> getQuestions(int amount)
            throws AmountOfGetQuestionsMoreQuestionListException, MinusOrZeroAmountException {

        Set<Question> getQuestionsList = new HashSet<>();

        if (amount <= 0) {
            throw new MinusOrZeroAmountException
                    ("Запрос количества вопросов должен быть больше 0");
        }

        if (amount > questionService.getAll().size()) {
            throw new AmountOfGetQuestionsMoreQuestionListException
                    ("Количество запрошенных вопросов больше списка вопросов!");
        }

        while (getQuestionsList.size() + 1 <= amount) {
            getQuestionsList.add(questionService.getRandomQuestion());
        }

        return getQuestionsList;
    }

}
