package pro.javapro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CodeViewerController implements Initializable {
    private String[] list;
    private File folder;
    private String path = "/JavaCodes";
    public String currentFromList;
    @FXML
    ListView listViewMenu;
    @FXML
    TextArea contentContainer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FillList();
        listViewMenu.getItems().addAll(list);
        contentContainer.setText("Wybierz plik z listy po lewej stronie");
        listViewMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentFromList = (String) listViewMenu.getSelectionModel().getSelectedItem();
//                System.out.println(listViewMenu.getSelectionModel().getSelectedIndex());
//                String content = getClass().getResourceAsStream(path+"/"+currentFromList);
                String content = null;
                Scanner scanner;
                scanner = new Scanner(getClass().getResourceAsStream(path+"/"+currentFromList));
                while (scanner.hasNextLine()){
                    content+=scanner.nextLine()+"\n";
                }
                content = content.substring(4,content.length());
                contentContainer.setText(content);
            }
        });
    }

    private void FillList(){
        try {
            folder = new File(getClass().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        list = new String[folder.listFiles().length];
        for (int i = 0; i<=folder.listFiles().length-1; i++){
            list[i] = new String(folder.listFiles()[i].getName());
        }
    }

    @FXML
    private void copyBtnClicked(){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(contentContainer.getText());
        clipboard.setContent(content);
    }
}
