package pro.sky.java.course2.examinerservice.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.EmptyCollectionException;
import pro.sky.java.course2.examinerservice.exception.NotFoundQuestionException;

import java.util.*;

/*
Реализация сервиса JavaQuestionService, который реализовывает QuestionService
и хранит в себе список вопросов по Java, а также осуществляет всю работу с этим списком
*/

@Service
public class JavaQuestionService implements QuestionService {

    // Экземпляр класса Random для метода getRandomQuestion
    private final Random r = new Random();

    // Создание сущности для хранения списка вопросов-ответов
    private final Set<Question> questions = new HashSet<>();

    // Метод добавления вопроса в коллекцию с помощью двух параметров через метод-близнеца add с одним параметром
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    // Метод добавления вопроса в коллекцию с одним входным параметром-сущностью
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    // Метод удаления вопроса из коллекции с выбросом возможного исключения
    @Override
    public Question remove(Question question) throws NotFoundQuestionException {
        if (!questions.contains(question)) {
            throw new NotFoundQuestionException("Нет такого вопроса!");
        }
        questions.remove(question);
        return question;
    }

    // Метод возврат всей коллекции и приведение ее к другому формату
    // с проверкой на null и выбросов исключения в случае null==true
    @Override
    public Collection<Question> getAll() throws EmptyCollectionException {
        boolean isValid = CollectionUtils.isNotEmpty(questions);
        if (!isValid) {
            throw new EmptyCollectionException("Нет ни одного вопрос-ответа!");
        }
        return new ArrayList<>(questions);
    }

    // Метод возврата одного случайного вопроса из коллекции
    /*
    Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt,
    который в качестве параметра принимает максимальное число,
    а затем возвращает вам результат в виде случайного числа от 0
    до максимального числа из параметров (не включительно).
    */
    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestionList = new ArrayList<>(questions);
        int randomNumber = r.nextInt(getAll().size());
        return randomQuestionList.get(randomNumber);
    }

}
