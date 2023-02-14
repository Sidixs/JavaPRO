package pro.javapro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SlideViewerMenuController {
    @FXML
    AnchorPane anchorPaneSlider;
    @FXML
    private void ButonClicked(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
//        Image image = new Image(getClass().getResourceAsStream("/SlideViewerDirectory/"+button.getText()+ "/image.jpg"));
//        myimageview.setImage(image);
        String path = "/SlideViewerDirectory/"+button.getText();//+"/";



        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("slide-viewer.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();

        SlideViewerController slideViewerController = fxmlLoader.getController();
        slideViewerController.setPath(path);
        slideViewerController.setName(button.getText());
        slideViewerController.setImageView();
        try {


            anchorPaneSlider.getChildren().clear();
            anchorPaneSlider.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
