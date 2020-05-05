package models;

/**
 *
 * @author Walter
 */
public class Answer {
    /* Fields */
    String text;
    int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /* Methods */
    @Override
    public String toString() {
        return "Answer{" + "text=" + text + ", id=" + id + '}';
    }
    
    
    
    
}
