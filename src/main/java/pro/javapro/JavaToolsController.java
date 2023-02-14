package pro.javapro;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class JavaToolsController {
    private String[] list;
    @FXML
    ListView listView;
    @FXML
    AnchorPane contentAnchorPane;
    public void initialize(){
        list = new String[]{"mlem","blep"};
        listView.getItems().addAll(list);

    }
}
