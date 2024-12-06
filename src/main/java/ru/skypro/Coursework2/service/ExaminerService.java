package ru.skypro.Coursework2.service;

import java.util.Collection;

public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);

    public void add();

    public void remove();

    public void find();

}
