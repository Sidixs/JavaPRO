package pro.javapro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {
    @FXML
    public AnchorPane mainAnchor;

    @FXML
    public void initialize() throws IOException {
        ChangeToSlideViewer();
    }
    @FXML
    public void ChangeToSlideViewer() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("slide-viewer-menu.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();
        try {
            mainAnchor.getChildren().clear();
            mainAnchor.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void ChangeToCodeViewer() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("code-viewer.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();
        try {
            mainAnchor.getChildren().clear();
            mainAnchor.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ChangeToJavaQuiz() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("java-quiz.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();
        try {
            mainAnchor.getChildren().clear();
            mainAnchor.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ChangeToJavaTools() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("java-tools.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();
        try {
            mainAnchor.getChildren().clear();
            mainAnchor.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
