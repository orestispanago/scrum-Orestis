<%@page import="models.QuestionPossibleAnswers"%>
<%@page import="models.Result"%>
<%@page import="models.UserAnswers"%>
<%@page import="models.QuestionSelectedAnswer"%>
<%@page import="models.User"%>
<%@page import="models.Answer"%>
<%@page import="models.Question"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Page</title>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exam</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    </head>

    <body>

        <%
            Result result = (Result) (session.getAttribute("result"));
            //ArrayList<QuestionPossibleAnswers> questionPossibleAnswers = (ArrayList<QuestionPossibleAnswers>) (request.getAttribute("questionPossibleAnswers"));
        %>
        <div class="container">
            <h1>Exam</h1>

            <form action="index.jsp" method="POST">
                <div class="form-group">
                    <label for="firstName">Username</label>
                    <input type="text" class="form-control" id="firstName" placeholder="Enter a Username" name="firstName" required>                    
                </div>



                <%  ArrayList<QuestionPossibleAnswers> questionPossibleAnswers = (ArrayList<QuestionPossibleAnswers>) (session.getAttribute("questionsWithPossibleAnswers"));
                    for (int i = 1; i <= questionPossibleAnswers.size(); i++) {
                        Question question = questionPossibleAnswers.get(i - 1).getQuestion();
                        List<Answer> answers = questionPossibleAnswers.get(i - 1).getAnswers();
                %>
                <div class="form-group align-center tp-5" name='<%= i%>'>
                    <div> <p> <%=i%>. <%= question.getText()%> </p></div>

                    <% for (int j = 1; j <= answers.size(); j++) {%>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios<%=i%>" id="exampleRadios<%=i%>" value="<%=answers.get(j - 1).getText()%>">
                        <label class="form-check-label" for="exampleRadios<%=i%>">

                            <%=j%>. <%= answers.get(j - 1).getText()%>
                        </label>
                    </div>
                    <% } %>
                </div>
                <% } %>

                <button type="submit" class="btn btn-primary">Save and Continue</button>
            </form>

            <%if (request.getMethod().equals("POST") && result == null) {
                System.out.println("siZZZZZZZZZZZZZZZZZZe of questionspossibleanswers");
                System.out.println(questionPossibleAnswers);
                    User user = new User(request.getParameter("firstName"));
                    List<QuestionSelectedAnswer> questionSelectedAnswers = new ArrayList();
                    Answer selectedAnswer = new Answer();
                    for (int z = 1; z <= questionPossibleAnswers.size(); z++) {
                        QuestionPossibleAnswers qpa = questionPossibleAnswers.get(z - 1);
                        Question question = qpa.getQuestion();
                        List<Answer> answers = qpa.getAnswers();
                        System.out.println("SSSSSSSSSSSSSize of answers");
                        System.out.println(answers.size());
                        for (int v = 0; v < answers.size(); v++) {
                            System.out.println("&&&&&&&&&&&&&&&&_______________");
                            System.out.println(answers.get(v).getText());
                            System.out.println(request.getParameter("exampleRadios" + z));
                            if (answers.get(v).getText().equals(request.getParameter("exampleRadios" + z))) {
                                selectedAnswer.setText(request.getParameter("exampleRadios" + z));
                                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                                System.out.println("selected answerrrrr"+selectedAnswer.toString());
                                selectedAnswer.setId(questionPossibleAnswers.get(z - 1).getAnswers().get(v).getId());
                                System.out.println("selected answer with iddd"+selectedAnswer.toString());
                            }
                        }
//                        Question question = questionPossibleAnswers.get(z - 1).getQuestion();
//                        for (int q = 0; q < questionPossibleAnswers.get(z-1).getAnswers().size(); q++){
//                            if (questionPossibleAnswers.get(z-1).getAnswers().get(q).getText().equals(request.getParameter("exampleRadios" + z))){
//                                 selectedAnswer.setText(request.getParameter("exampleRadios" + z));
//                                 selectedAnswer.setId(questionPossibleAnswers.get(z-1).getAnswers().get(q).getId());
//                            }
//                        }

                        QuestionSelectedAnswer questionSelectedAnswer = new QuestionSelectedAnswer(question, selectedAnswer);
                        questionSelectedAnswers.add(questionSelectedAnswer);
                    }

                    UserAnswers userAnswers = new UserAnswers(user, questionSelectedAnswers);
                    session.setAttribute("userAnswers", userAnswers);
                    String path = "Exam";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);
                }
            %>

            <% if (result != null) {
                    int counter = 0;

                    //     for (int x = 0; x < questionPossibleAnswers.size(); x++) {
//                        String selected = result.getSelectedAnswers().get(x).getSelectedAnswer().getText();
//                        String right = result.getQuestionsRightAnswers().get(x).getRightAnswer().getText();
//                        if (selected.equals(right)) {
//                            counter++;
//                        }
//                    }
//                    out.println("<h1>Your score is: " + counter + " out of " + questionPossibleAnswers.size() + "</h1>");
                    out.println("<h1>Your score is: " + result.getNumberOfUserRightAnswers() + " out of " + result.getTotalNumberOfQuestions() + "</h1>");

                }
            %>






        </div>



    </body>

</html>