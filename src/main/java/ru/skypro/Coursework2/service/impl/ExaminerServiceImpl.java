package ru.skypro.Coursework2.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.Coursework2.exception.ExceedingNumberQuestionsException;
import ru.skypro.Coursework2.service.ExaminerService;
import ru.skypro.Coursework2.model.Question;
import ru.skypro.Coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        int maxNumberOfQuestions = questionService.getAllQuestions().size();

        if (amount > maxNumberOfQuestions) {
            throw new ExceedingNumberQuestionsException("Максимальное количество вопросов: " + maxNumberOfQuestions);
        }

        Set<Question> questionSet = new HashSet<>();

        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }

        return questionSet;
    }

}
