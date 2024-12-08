package ru.skypro.Coursework2.service;

import ru.skypro.Coursework2.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}
