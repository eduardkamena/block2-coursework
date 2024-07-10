package pro.sky.java.course2.examinerservice.domain;

import java.util.Objects;

/*
Реализация сущности Question с двумя полями: question и answer.
Данная сущность будет использоваться в качестве хранителя данных по вопросу.

В данном случае оставил как есть, но IDEA очень хочет преобразовать данный класс в record
*/

public class Question {

    // Переменная-строка вопроса
    private final String question;

    // Переменная-строка ответа
    private final String answer;

    // Конструктор
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Геттеры
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    // equals, hashCode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
