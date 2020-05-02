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
public class Answer {
    /* Fields */
    String text;
    
    /* Constructors */
    public Answer() {
    }
    public Answer(String text) {
        this.text = text;
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
        return "Answer{" + "text=" + text + '}';
    }
    
    
    
}
