import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class JavaFXCheckBoxDemo extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }
    public void start(Stage primaryStage) {

        primaryStage.setTitle("CheckBox");

        Group root = new Group();
        Scene scene = new Scene(root, 700, 200);

        Label lab = new Label("CheckBox Unselected");
        lab.setLayoutX(200);
        lab.setLayoutY(100);
        lab.setFont(Font.font("Bell Gothic Std", FontWeight.EXTRA_BOLD, 15));

        CheckBox cb = new CheckBox("CheckBox");
        cb.setIndeterminate(false);
        cb.setLayoutX(100);
        cb.setLayoutY(100);
        cb.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                if(cb.isSelected())
                    lab.setText("CheckBox Selected");
                else
                    lab.setText("CheckBox Unselected");
            }
        });

        root.getChildren().add(lab);
        root.getChildren().add(cb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}