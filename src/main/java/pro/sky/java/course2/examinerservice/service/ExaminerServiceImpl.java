package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountOfGetQuestionsMoreQuestionListException;
import pro.sky.java.course2.examinerservice.exception.MinusOrZeroAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

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
