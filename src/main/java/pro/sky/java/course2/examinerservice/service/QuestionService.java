package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

/*
Реализация интерфейса QuestionService,
который содержит в себе все методы по работе с вопросами определенного предмета Java
*/

public interface QuestionService {

    // Добавление вопроса в коллекцию с помощью двух параметров
    Question add(String question, String answer);

    // Добавление вопроса в коллекцию с одним входным параметром
    Question add(Question question);

    // Удаление вопроса из коллекции
    Question remove(Question question);

    // Возврат всей коллекции и приведение ее к другому формату коллекции
    Collection<Question> getAll();

    // Возврат одного случайного вопроса из коллекции
    Question getRandomQuestion();

}
