package pro.javapro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class JavaQuizController {
    @FXML
    CheckBox[] answers;
    @FXML
    AnchorPane questionAchorPane;
    @FXML
    VBox questionVBox;
    @FXML
    Button confirmBtn;
    private String path = "JavaQuiz";
    private JSONArray jsonArrayFile;
    private Integer questionIndex;
    private Integer points;
    private Integer maxPoints;
    public void initialize() throws FileNotFoundException {
//        JSONArray jsonObject = new JSONArray(new FileReader("src/main/resources/JavaQuiz/Quiz.json"));
        questionIndex = 0;
        points = 0;
        String content = null;
        Scanner scanner;
        scanner = new Scanner(new FileReader("src/main/resources/JavaQuiz/Quiz.json"));
        int x = 1;
        while (scanner.hasNextLine()){
            content+=scanner.nextLine();
            if (x==1){
                content="";
                x++;
            }
        }
        System.out.println(content);

        //Json ArrayFile
        jsonArrayFile = new JSONArray(content);
        maxPoints = jsonArrayFile.length();
        System.out.println("maxPoints "+maxPoints);


        System.out.println(((JSONObject) jsonArrayFile.get(1)).get("question"));
        System.out.println(jsonArrayFile);
//        JSONObject array = new JSONObject(((JSONObject)obj.get(1)).get("answers"));
        JSONObject tempobj = (JSONObject) jsonArrayFile.get(1);
        JSONArray array = (JSONArray)tempobj.get("answers");
        System.out.println(array);
        JSONArray arrayright = (JSONArray)tempobj.get("rightAnswers");
        System.out.println(arrayright.get(1).equals(1));

        //Question
        JSONObject first = (JSONObject) jsonArrayFile.get(0);//main object
        Label question = new Label(first.getString("question"));
        questionVBox.getChildren().add(question);

        //Answers
        JSONArray answersArray = (JSONArray)first.get("answers");
        System.out.println(answersArray.length());

        answers = new CheckBox[answersArray.length()];
        for (int i = 0; i<answersArray.length();i++){
            answers[i] = new CheckBox(answersArray.get(i).toString());
//            answers[i].setStyle("-fx-padding: "+(50+30*i)+" 0 0 0;");
//            CheckBox checkBox = new CheckBox(answersArray.get(i).toString());
//            checkBox.setStyle("-fx-padding: "+(50+30*i)+" 0 0 0;");
//            questionPane.getChildren().add(checkBox);
        }
//        answers[1].selectedProperty().set(true);
        questionVBox.getChildren().addAll(answers);
        System.out.println(answers.length);
//        for (int i = 0; i<answersArray.length();i++){
//            questionPane.getChildren().add(answers[i]);
//        }
    }
    @FXML
    public void confirmBtnClicked() {
        JSONObject jsonObject = (JSONObject) jsonArrayFile.get(questionIndex);//main object
        JSONArray rightAnswersArray = (JSONArray)jsonObject.get("rightAnswers");
        Integer flag = 0;
        for (int i = 0; i<answers.length;i++){
            if(!answers[i].isSelected()==rightAnswersArray.get(i).equals(1)){
                flag = 1;
            }
        }
        if (flag==0){
            points++;
        }
        System.out.println("Punkty: "+points);
        questionIndex++;
        System.out.println("questionIndex "+questionIndex);
        if (questionIndex<maxPoints){
            NextQuestion();
            return;
        }
        ScorePanel();
    }

    public void NextQuestion(){
        JSONObject jsonObject = (JSONObject) jsonArrayFile.get(questionIndex);//main object
        Label question = new Label(jsonObject.getString("question"));
        JSONArray answersArray = (JSONArray)jsonObject.get("answers");
        answers = new CheckBox[answersArray.length()];
        for (int i = 0; i<answersArray.length();i++){
            answers[i] = new CheckBox(answersArray.get(i).toString());
        }

        questionVBox.getChildren().clear();
        questionVBox.getChildren().add(question);
        questionVBox.getChildren().addAll(answers);
    }

    public void ScorePanel(){
        Label score = new Label("Wynik: "+points+"/"+maxPoints);
        confirmBtn.setVisible(false);
        questionVBox.getChildren().clear();
        questionVBox.getChildren().add(score);
    }
}
