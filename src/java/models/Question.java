/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Walter
 */
public class Question {
    /* Fields */
    String text;

    /* Constructors */
    public Question() {
    }
    public Question(String question) {
        this.text = question;
    }

    /* Getters Setters */
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /* Methods */
    @Override
    public String toString() {
        return "Question{" + "text=" + text + '}';
    }
}
