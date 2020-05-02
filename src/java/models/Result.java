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
public class Result {
    private User user;
    private List<QuestionPossibleAnswers> questionsPossibleAnswers;
    private List<QuestionSelectedAnswer> selectedAnswers;
    private List<QuestionRightAnswer> questionsRightAnswers;

    public Result(User user, List<QuestionPossibleAnswers> questionsPossibleAnswers, List<QuestionSelectedAnswer> selectedAnswers, List<QuestionRightAnswer> questionsRightAnswers) {
        this.user = user;
        this.questionsPossibleAnswers = questionsPossibleAnswers;
        this.selectedAnswers = selectedAnswers;
        this.questionsRightAnswers = questionsRightAnswers;
    }

    public Result() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionPossibleAnswers> getQuestionsPossibleAnswers() {
        return questionsPossibleAnswers;
    }

    public void setQuestionsPossibleAnswers(List<QuestionPossibleAnswers> questionsPossibleAnswers) {
        this.questionsPossibleAnswers = questionsPossibleAnswers;
    }

    public List<QuestionSelectedAnswer> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<QuestionSelectedAnswer> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    public List<QuestionRightAnswer> getQuestionsRightAnswers() {
        return questionsRightAnswers;
    }

    public void setQuestionsRightAnswers(List<QuestionRightAnswer> questionsRightAnswers) {
        this.questionsRightAnswers = questionsRightAnswers;
    }

    @Override
    public String toString() {
        return "Result{" + "user=" + user + ", questionsPossibleAnswers=" + questionsPossibleAnswers + ", selectedAnswers=" + selectedAnswers + ", questionsRightAnswers=" + questionsRightAnswers + '}';
    }
    
    
}

