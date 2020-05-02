/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author Walter
 */
public class QuestionPossibleAnswers {
    private Question question;
    private List<Answer> answers;

    public QuestionPossibleAnswers() {
    }

    public QuestionPossibleAnswers(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
    
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionPossibleAnswers{" + "question=" + question + ", answers=" + answers + '}';
    }
    
    
}
