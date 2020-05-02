/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author Walter
 */
public class QuestionSelectedAnswer {
    private Question question;
    private Answer selectedAnswer;

    public QuestionSelectedAnswer(Question question, Answer selectedAnswer) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
    }

    public QuestionSelectedAnswer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.question);
        hash = 29 * hash + Objects.hashCode(this.selectedAnswer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionSelectedAnswer other = (QuestionSelectedAnswer) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.selectedAnswer, other.selectedAnswer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QuestionSelectedAnswer{" + "question=" + question + ", selectedAnswer=" + selectedAnswer + '}';
    }
    
    
}
