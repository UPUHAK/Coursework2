package ru.skypro.Coursework2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.Coursework2.model.Question;
import ru.skypro.Coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private QuestionService questionService;

    @BeforeEach
    public void clear() {
        questionService = new JavaQuestionService();
    }

    @Test
    void shouldCorrectlyAddQuestions() {

        Question expectedQuestion = new Question("TestQ1", "TestA1");

        Question actualQuestion = questionService.add(expectedQuestion);

        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldNotAddSameQuestions() {

        Question question1 = new Question("TestQ1", "TestA1");
        Question question2 = new Question("TestQ1", "TestA1");

        questionService.add(question1);
        questionService.add(question2);

        Set<Question> allQuestions = new HashSet<>(questionService.getAllQuestions());

        Assertions.assertEquals(1, allQuestions.size());
        Assertions.assertTrue(allQuestions.contains(question1));
    }

    @Test
    void shouldCorrectlyRemoveQuestions() {

        Question expectedQuestion = questionService.add("TestQ2", "TestA2");

        Question actualQuestion = questionService.remove(expectedQuestion);

        Assertions.assertEquals(expectedQuestion, actualQuestion);

    }

    @Test
    void shouldCorrectlyGetAllQuestions() {

        Question question1 = new Question("TestQ1", "TestA1");
        Question question2 = new Question("TestQ2", "TestA2");
        Question question3 = new Question("TestQ3", "TestA3");

        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        Set<Question> expectedQuestion = new HashSet<>() {{
            add(question1);
            add(question2);
            add(question3);
        }};

        Collection<Question> actualQuestion = questionService.getAllQuestions();

        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldCorrectlyGetRandomQuestion() {

        Question question1 = new Question("TestQ1", "TestA1");
        Question question2 = new Question("TestQ2", "TestA2");
        Question question3 = new Question("TestQ3", "TestA3");

        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        Set<Question> questions = new HashSet<>() {{
            add(question1);
            add(question2);
            add(question3);
        }};

        Question randomQuestion = questionService.getRandomQuestion();

        assertTrue(questions.contains(randomQuestion));

    }
}