package ru.skypro.Coursework2.service;

import ru.skypro.Coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
