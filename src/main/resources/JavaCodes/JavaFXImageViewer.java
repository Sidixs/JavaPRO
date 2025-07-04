import java.io.*;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class JavaFXTextViewer extends Application {
    BorderPane root = new BorderPane();
    MenuBar mb = new MenuBar();
    VBox top = new VBox();
    VBox center = new VBox();
    TextArea textArea = new TextArea();

    public void createTop(Stage primaryStage) {
        final Stage stage = primaryStage;
        top.setSpacing(20);
        Menu menu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem exit = new MenuItem("Exit");
        menu.getItems().addAll(open, close, exit);
        open.setOnAction((ActionEvent e) -> {
            String currentDir = System.getProperty("user.dir") + File.separator;
            FileChooser fcb = new FileChooser();
            fcb.setTitle("Open Dialog");
            File selectedFile = fcb.showOpenDialog(stage);
            StringBuilder sb = readFile(selectedFile);
            textArea.setText(sb.toString());
        });
        close.setOnAction((ActionEvent e) -> {
            textArea.setText("");
        });
        exit.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        mb.getMenus().addAll(menu);
        top.getChildren().add(mb);
    }

    public void createCenter() {
        center.setPadding(new Insets(10, 10, 10, 10));
        Label label = new Label("File Contents");
        textArea.setWrapText(true);
        textArea.setPrefSize(800, 600);
        center.getChildren().add(label);
        center.getChildren().add(textArea);
    }

    public StringBuilder readFile(File selectedFile) {
        StringBuilder sb = new StringBuilder(1024);
        String curLine = "";
        try {
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            while (curLine != null) {
                curLine = br.readLine();
                sb.append(curLine).append("\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return sb;
    }

    @Override
    public void start(Stage primaryStage) {
        createTop(primaryStage);
        createCenter();
        root.setTop(top);
        root.setCenter(center);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
