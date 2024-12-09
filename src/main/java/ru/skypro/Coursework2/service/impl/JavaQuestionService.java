package ru.skypro.Coursework2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.Coursework2.model.Question;
import ru.skypro.Coursework2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    @PostConstruct
    public void initQuestions() {
        add("Q1", "A1");
        add("Q2", "A2");
        add("Q3", "A3");
        add("Q4", "A4");
    }

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

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
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
