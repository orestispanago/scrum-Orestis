package models;

/**
 *
 * @author Walter
 */
public class Question {
    /* Fields */
    String text;
    int id;
    /* Constructors */
    public Question() {
    }
    public Question(String question) {
        this.text = question;
    }

    
    public int getId() {
        return id;
    }

    /* Getters Setters */
    public void setId(int id) {
        this.id = id;
    }

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
