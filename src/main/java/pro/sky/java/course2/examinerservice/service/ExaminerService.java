package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

/*
Создание интерфейса ExaminerService с одним методом getQuestions.
Данный интерфейс должен содержать один метод, который вернет список вопросов.
*/

public interface ExaminerService {

    // Метод для возврата списка вопросов
    Collection<Question> getQuestions(int amount);

}
