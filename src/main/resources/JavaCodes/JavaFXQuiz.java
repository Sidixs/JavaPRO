import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXQuiz extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label question = new Label("Java GUI library ?");
        Label response = new Label();
        Button button = new Button("Submit");
        button.setDisable(true);
        CheckBox cb1, cb2, cb3, cb4;
        cb1 = new CheckBox("Swing");
        cb2 = new CheckBox("AWT");
        cb3 = new CheckBox("JavaFX");
        cb4 = new CheckBox("Servlet");
        cb1.setOnAction(e -> button.setDisable(false));
        cb2.setOnAction(e -> button.setDisable(false));
        cb3.setOnAction(e -> button.setDisable(false));
        cb4.setOnAction(e -> button.setDisable(false));
        button.setOnAction(e -> {
                    if (cb4.isSelected()) {
                        response.setText("Wrong answer");
                        button.setDisable(true);
                    } else if ((cb1.isSelected()) && (cb2.isSelected()) &&
                            (cb3.isSelected())) {
                        response.setText("Correct answer");
                        button.setDisable(true);
                    } else {
                        response.setText("Wrong answer");
                        button.setDisable(true);
                    }
                }
        );
        VBox root = new VBox();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(10);
        root.getChildren().addAll(question, cb1, cb2, cb3, cb4, button, response);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("JavaFXQuiz");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}