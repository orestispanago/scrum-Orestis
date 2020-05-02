/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DummyData;

import java.util.ArrayList;
import java.util.List;
import models.Answer;
import models.Question;
import models.QuestionPossibleAnswers;
import models.QuestionRightAnswer;
import models.QuestionSelectedAnswer;
import models.Result;
import models.User;

/**
 *
 * @author Walter
 */
public class DummyData {
    public static List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers(){
        // Return dummy data for testing
        // Question 1 with Possible Answers
        Question q1 = new Question("Question 1");
        Answer aq1 = new Answer("Answer 1");
        Answer bq1 = new Answer("Answer 2");
        Answer cq1 = new Answer("Answer 3");
        Answer dq1 = new Answer("Answer 4");
        List<Answer> q1PossibleAnswers = new ArrayList();
        q1PossibleAnswers.add(aq1);
        q1PossibleAnswers.add(bq1);
        q1PossibleAnswers.add(cq1);
        q1PossibleAnswers.add(dq1);
        QuestionPossibleAnswers question1WithPossibleAnswers = new QuestionPossibleAnswers(q1, q1PossibleAnswers);
        
        // Question 2 with Possible Answers
        Question q2 = new Question("Question 2");
        Answer aq2 = new Answer("Answer 1");
        Answer bq2 = new Answer("Answer 2");
        Answer cq2 = new Answer("Answer 3");
        Answer dq2 = new Answer("Answer 4");
        List<Answer> q2PossibleAnswers = new ArrayList();
        q2PossibleAnswers.add(aq2);
        q2PossibleAnswers.add(bq2);
        q2PossibleAnswers.add(cq2);
        q2PossibleAnswers.add(dq2);
        QuestionPossibleAnswers question2WithPossibleAnswers = new QuestionPossibleAnswers(q2, q2PossibleAnswers);
        
        // Create list with the 2 questions and their answers and return it
        List<QuestionPossibleAnswers> questionsWithPossibleAnswers = new ArrayList();
        questionsWithPossibleAnswers.add(question1WithPossibleAnswers);
        questionsWithPossibleAnswers.add(question2WithPossibleAnswers);
        return questionsWithPossibleAnswers;
    }
    
    public static List<QuestionSelectedAnswer> getQuestionsWithSelectedAnswers(){
        Question q1 = new Question("Question 1");
        Question q2 = new Question("Question 2");
        Answer selectedAnswerForQ1 = new Answer("Answer 1");
        Answer selectedAnswerForQ2 = new Answer("Answer 2");
        
        QuestionSelectedAnswer q1SelectedAnswer = new QuestionSelectedAnswer(q1, selectedAnswerForQ1);
        QuestionSelectedAnswer q2SelectedAnswer = new QuestionSelectedAnswer(q2, selectedAnswerForQ2);
        List<QuestionSelectedAnswer> selectedAnswers = new ArrayList();
        selectedAnswers.add(q1SelectedAnswer);
        selectedAnswers.add(q2SelectedAnswer);
        return selectedAnswers;
    }
    
    
    public static List<QuestionRightAnswer> getQuestionsWithRightAnswers(){
        Question q1 = new Question("Question 1");
        Question q2 = new Question("Question 2");
        Answer rightAnswerForQ1 = new Answer("Answer 1");
        Answer rightAnswerForQ2 = new Answer("Answer 3");
        
        QuestionRightAnswer q1SelectedAnswer = new QuestionRightAnswer(q1, rightAnswerForQ1);
        QuestionRightAnswer q2SelectedAnswer = new QuestionRightAnswer(q2, rightAnswerForQ2);
        List<QuestionRightAnswer> rightAnswers = new ArrayList();
        rightAnswers.add(q1SelectedAnswer);
        rightAnswers.add(q2SelectedAnswer);
        return rightAnswers;
    }
    
    public static Result getResult(User user){
        // Create dummy data
        List<QuestionPossibleAnswers> questionsPossibleAnswers = getQuestionsWithPossibleAnswers();
        List<QuestionSelectedAnswer> selectedAnswers = getQuestionsWithSelectedAnswers();
        List<QuestionRightAnswer> rightAnswers = getQuestionsWithRightAnswers();
        
        Result result = new Result(user, questionsPossibleAnswers, selectedAnswers, rightAnswers);
        return result;
    }
}
