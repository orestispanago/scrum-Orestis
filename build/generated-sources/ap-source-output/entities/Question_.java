package entities;

import entities.Answer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-03T03:23:18")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile ListAttribute<Question, Answer> possibleAnswers;
    public static volatile SingularAttribute<Question, String> questionText;

}