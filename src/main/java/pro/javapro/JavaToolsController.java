package pro.javapro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JavaToolsController {
    private String[] list;
    @FXML
    ListView listView;
    @FXML
    AnchorPane contentAnchorPane;
    @FXML
    WebView contentWebView;
    private WebEngine webEngine;
    private JSONArray jsonArrayFile;
    private JSONObject jsonObject;
    private JSONArray urlsArray;
    private Integer index;
    public void initialize() throws FileNotFoundException {
        String content = null;
        Scanner scanner;
        scanner = new Scanner(new FileReader("src/main/resources/JavaTools/JavaTools.json"));
        int x = 1;
        while (scanner.hasNextLine()){
            content+=scanner.nextLine();
            if (x==1){
                content="";
                x++;
            }
        }

        jsonArrayFile = new JSONArray(content);
        jsonObject = (JSONObject) jsonArrayFile.get(0);
        JSONArray names = (JSONArray) jsonObject.get("names");

        list = new String[names.length()];
        for (int i = 0; i<names.length(); i++){
            list[i] = names.get(i).toString();
        }
        listView.getItems().addAll(list);

        urlsArray = new JSONArray((JSONArray)jsonObject.get("urls"));

        webEngine = contentWebView.getEngine();
        webEngine.load(urlsArray.get(0).toString());
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                index = listView.getSelectionModel().getSelectedIndex();
                webEngine.load(urlsArray.get(index).toString());
            }
        });
    }
}
