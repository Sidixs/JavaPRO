package pro.javapro;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    private String path = "/JavaQuiz";
    private JSONArray jsonArrayFile;
    private Integer questionIndex;
    private Integer points;
    private Integer maxPoints;
    public void initialize() throws FileNotFoundException {
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

        //Json ArrayFile
        jsonArrayFile = new JSONArray(content);
        maxPoints = jsonArrayFile.length();

        JSONObject first = (JSONObject) jsonArrayFile.get(0);//main object

        if (first.get("hasImage").equals(1)){
            AddImage(first.get("imageName").toString());
        }
        if (first.get("hasCode").equals(1)){
            AddCode(first.get("codeName").toString());
        }

        //Question
        Label question = new Label(first.getString("question"));
        questionVBox.getChildren().add(question);

        //Answers
        JSONArray answersArray = (JSONArray)first.get("answers");

        answers = new CheckBox[answersArray.length()];
        for (int i = 0; i<answersArray.length();i++){
            answers[i] = new CheckBox(answersArray.get(i).toString());
        }
        questionVBox.getChildren().addAll(answers);
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
        questionIndex++;
        if (questionIndex<maxPoints){
            NextQuestion();
            return;
        }
        ScorePanel();
    }

    public void AddImage(String name){
        ImageView imageView = new ImageView();
        Image image = new Image(getClass().getResourceAsStream(path+"/"+name));
        imageView.setImage(image);
        questionVBox.getChildren().add(imageView);
    }

    public void AddCode(String name){
        Label textArea = new Label();
        textArea.setStyle("-fx-background-color: rgb(217, 218, 219); -fx-padding: 10 0 10 0;" +
                "    -fx-border-insets: 10 0 10 0;" +
                "    -fx-background-insets: 10 0 10 0;");
        String content = null;
        Scanner scanner;
        scanner = new Scanner(getClass().getResourceAsStream(path+"/"+name));
        while (scanner.hasNextLine()){
            content+=scanner.nextLine()+"\n";
        }
        content = content.substring(4,content.length());
        textArea.setText(content);
        questionVBox.getChildren().add(textArea);
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
        if (jsonObject.get("hasImage").equals(1)){
            AddImage(jsonObject.get("imageName").toString());
        }
        if (jsonObject.get("hasCode").equals(1)){
            AddCode(jsonObject.get("codeName").toString());
        }
        questionVBox.getChildren().add(question);
        questionVBox.getChildren().addAll(answers);
    }

    public void ScorePanel(){
        Label score = new Label("Wynik: "+points+"/"+maxPoints);
        confirmBtn.setVisible(false);
        questionVBox.getChildren().clear();
        questionVBox.setStyle("-fx-alignment: CENTER");
        questionVBox.getChildren().add(score);
    }
}
