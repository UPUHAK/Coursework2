package ru.skypro.Coursework2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.Coursework2.exception.ExceedingNumberQuestionsException;
import ru.skypro.Coursework2.model.Question;
import ru.skypro.Coursework2.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void shouldCorrectlyGetRandomQuestions() {

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(new Question("TestQ" + i, "TestA" + i));
        }

        Mockito.when(questionService.getAllQuestions()).thenReturn(questions);

        Mockito.when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0), questions.get(0),
                questions.get(0), questions.get(1),
                questions.get(1), questions.get(1),
                questions.get(2)
        );

        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        assertEquals(randomQuestions.size(), amount);
        assertTrue(randomQuestions.containsAll((questions)));

        Mockito.verify(questionService, times(7)).getRandomQuestion();
    }

    @Test
    void shouldExceedingNumberQuestionsExceptionWhenRequestedTooManyQuestions() {

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount / 2; i++) {
            questions.add(new Question("TestQ" + i, "TestA" + i));
        }

        Mockito.when(questionService.getAllQuestions()).thenReturn(questions);

        assertThrows(
                ExceedingNumberQuestionsException.class,
                ()-> examinerService.getQuestions(amount)
        );
    }
}