package models;

/**
 *
 * @author Walter
 */
public class QuestionRightAnswer {
    private Question question;
    private Answer rightAnswer;

    public QuestionRightAnswer() {
    }

    public QuestionRightAnswer(Question question, Answer rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }
    
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Answer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "QuestionRightAnswer{" + "question=" + question + ", rightAnswer=" + rightAnswer + '}';
    }
    
    
}
