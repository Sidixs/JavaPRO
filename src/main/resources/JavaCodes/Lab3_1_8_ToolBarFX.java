import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Separator;
import javafx.stage.Stage;
public class ToolBarFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button bt1 = new Button("Button 1");
        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Button 1 clicked!");
            }
        });
        Button bt2 = new Button("Button 2");
        bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Button 2 clicked!");
            }
        });
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().add(bt1);
        toolBar.getItems().add(new Separator());
        toolBar.getItems().add(bt2);
        toolBar.setPrefWidth(600);
        Group root = new Group();
        root.getChildren().add(toolBar);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("ToolBar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}