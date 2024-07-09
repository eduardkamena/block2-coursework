package pro.sky.java.course2.examinerservice.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.EmptyCollectionException;
import pro.sky.java.course2.examinerservice.exception.NotFoundQuestionException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random r = new Random();
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) throws NotFoundQuestionException {
        if (!questions.contains(question)) {
            throw new NotFoundQuestionException("Нет такого вопроса!");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() throws EmptyCollectionException {
        boolean isValid = CollectionUtils.isNotEmpty(questions);
        if (!isValid) {
            throw new EmptyCollectionException("Нет ни одного вопрос-ответа!");
        }
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestionList = new ArrayList<>(questions);
        int randomNumber = r.nextInt(getAll().size());
        return randomQuestionList.get(randomNumber);
    }

}
