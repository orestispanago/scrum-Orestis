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
public class UserAnswers {
    User user;
    //Map<Question, Answer> selectedAnswersMap;
    List<QuestionSelectedAnswer> selectedAnswers;

    public UserAnswers() {
    }

    public UserAnswers(User user, List<QuestionSelectedAnswer> selectedAnswers) {
        this.user = user;
        this.selectedAnswers = selectedAnswers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionSelectedAnswer> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<QuestionSelectedAnswer> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    @Override
    public String toString() {
        return "UserAnswers{" + "user=" + user + ", selectedAnswers=" + selectedAnswers + '}';
    }
    
    
}

