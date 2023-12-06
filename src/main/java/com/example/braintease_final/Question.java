package com.example.braintease_final;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

public class Question {
    public String name;
    public String difficulty;
    public String theme;
    public List<String> answers;

    public Question(String name, String difficulty, String theme, String... answers){
        this.name = name;
        this.difficulty = difficulty;
        this.theme = theme;
        this.answers = Arrays.asList(answers);
    }

    public String getCorrectAnswer(){
        return answers.get(0);
    }

    public String getTheme() {
        return theme;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
