package pro.sky.java.course2.examinerservice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountOfGetQuestionsMoreQuestionListException;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Set<Question> question = Set.of(
            new Question("QuestionTest", "AnswerTest"),
            new Question("QuestionTest1", "AnswerTest1"),
            new Question("QuestionTest2", "AnswerTest2"),
            new Question("QuestionTest3", "AnswerTest3"),
            new Question("QuestionTest4", "AnswerTest4")
    );

    @Test
    public void shouldCorrectlyFillCollectionWithMethodGetRandomQuestion() {
        // givenActual
        Mockito.when(questionService.getAll()).thenReturn(question);
        // whenExpected
        Mockito.when(questionService.getRandomQuestion()).thenReturn(
                new Question("QuestionTest", "AnswerTest"),
                new Question("QuestionTest1", "AnswerTest1"),
                new Question("QuestionTest1", "AnswerTest1"),
                new Question("QuestionTest2", "AnswerTest2"),
                new Question("QuestionTest3", "AnswerTest3"),
                new Question("QuestionTest3", "AnswerTest3"),
                new Question("QuestionTest4", "AnswerTest4")
        );
        // then
        Assertions.assertThat(examinerService.getQuestions(5))
                .hasSize(5)
                .containsExactlyInAnyOrder(
                        new Question("QuestionTest", "AnswerTest"),
                        new Question("QuestionTest1", "AnswerTest1"),
                        new Question("QuestionTest2", "AnswerTest2"),
                        new Question("QuestionTest3", "AnswerTest3"),
                        new Question("QuestionTest4", "AnswerTest4")
                );
    }

    @Test
    public void shouldThrowAmountOfGetQuestionsMoreQuestionListException() {
        // given
        int amount = 7;
        Mockito.when(questionService.getAll()).thenReturn(question);

        // when
        // then
        Assertions.assertThatExceptionOfType(AmountOfGetQuestionsMoreQuestionListException.class)
                .isThrownBy(() -> examinerService.getQuestions(amount));
    }

    @Test
    public void shouldThrowAmountOfGetQuestionsMoreQuestionListExceptionWhenSetIsEmpty() {
        // given
        int amount = 1;
        Mockito.when(questionService.getAll()).thenThrow(AmountOfGetQuestionsMoreQuestionListException.class);

        // when
        // then
        Assertions.assertThatExceptionOfType(AmountOfGetQuestionsMoreQuestionListException.class)
                .isThrownBy(() -> examinerService.getQuestions(amount));
    }

    /* Не получается настроить тест с отрицательным или нулевым входным параметром
    в методе getQuestions класса ExaminerServiceImpl.
    Там должно выбрасываться исключение MinusOrZeroAmountException.
    Возможно ли его настроить? Или так как параметр отрицательный или нулевой,
    а список изначально не может быть null или отрицательным, то этот тест не имеет смысла?
    Если все же возможно настроить - прошу помощи)


    @Test
    public void shouldThrowMinusOrZeroAmountException() {
        // given
        int amount = 0;
        Mockito.when(questionService.getAll()).thenThrow(MinusOrZeroAmountException.class);

        // when
        // then
        Assertions.assertThatExceptionOfType(MinusOrZeroAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(amount));
    }

    */

}

