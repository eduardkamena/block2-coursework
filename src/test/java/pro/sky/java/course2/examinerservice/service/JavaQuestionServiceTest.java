package pro.sky.java.course2.examinerservice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.EmptyCollectionException;
import pro.sky.java.course2.examinerservice.exception.NotFoundQuestionException;

import java.util.*;

public class JavaQuestionServiceTest {

    private QuestionService questionService;

    @BeforeEach
    public void clearQuestionService() {
        questionService = new JavaQuestionService();
    }

    @Test
    public void shouldCorrectlyAddQuestionWithParamsStringQuestionAndStringAnswer() {
        // given
        Question actual = new Question("QuestionTest", "AnswerTest");

        // when
        Question expected = questionService.add(actual.getQuestion(), actual.getAnswer());

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldCorrectlyAddQuestionWithParamQuestion() {
        // given
        Question actual = new Question("QuestionTest", "AnswerTest");

        // when
        Question expected = questionService.add(actual);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldCorrectlyRemoveQuestion() {
        // given
        Question actual = questionService.add("QuestionTest", "AnswerTest");

        // when
        Question expected = questionService.remove(actual);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldThrowExceptionWhenRemovingQuestionNotFound() {
        // given
        Question actual = questionService.add("QuestionTest", "AnswerTest");

        // when
        questionService.remove(actual);

        // then
        Assertions.assertThatExceptionOfType(NotFoundQuestionException.class)
                .isThrownBy(() -> questionService.remove(actual));
    }

    @Test
    public void shouldCorrectlyGetAllQuestions() {
        // given
        Set<Question> actual = Set.of(
                questionService.add("QuestionTest", "AnswerTest"),
                questionService.add("QuestionTest1", "AnswerTest1"),
                questionService.add("QuestionTest2", "AnswerTest2")
        );

        // when
        Collection<Question> expected = new ArrayList<>(questionService.getAll());

        // then
        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void shouldThrowExceptionWhenMethodGetAllQuestionsCollectEmptyCollection() {
        // given
        Set<Question> actual = null;

        // when
        // then
        Assertions.assertThatExceptionOfType(EmptyCollectionException.class)
                .isThrownBy(() -> new ArrayList<>(questionService.getAll()));
    }

    @Test
    public void shouldCorrectlyGetRandomQuestions() {
        // given
        List<Question> actual = new ArrayList<>(List.of(
                questionService.add("QuestionTest", "AnswerTest"),
                questionService.add("QuestionTest1", "AnswerTest1"),
                questionService.add("QuestionTest2", "AnswerTest2")
        ));

        // when
        Question expected = questionService.getRandomQuestion();

        // then
        Assertions.assertThat(actual).contains(expected);
    }

}
