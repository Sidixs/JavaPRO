package pro.javapro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class SlideViewerController {
    private String path;
    private String name;
    private Integer currentImage;
    private Image[] images;
    private File folder;
    private Integer maxImages;
    @FXML
    AnchorPane anchorPaneSlider;
    @FXML
    ImageView myimageview;
    @FXML
    Label labelField;
    @FXML
    public void setImageView() throws IOException{
        currentImage = 0;
        try {
            folder = new File(getClass().getResource(path).toURI());
        } catch (Exception e) {
            labelField.setText("Brak zawartości");
            return;
        }
        maxImages = folder.listFiles().length-1;
        images = new Image[maxImages+1];
        for (int i = 0; i<=folder.listFiles().length-1; i++){
            images[i] = new Image(getClass().getResourceAsStream(path+"/"+folder.listFiles()[i].getName()));
        }
        labelField.setText(name+" - slajd "+(currentImage+1)+" z "+(maxImages+1));
        myimageview.setImage(images[currentImage]);
    }
    public void setPath(String path) {
        this.path = path;
    }

    @FXML
    private void NextBtnClicked(){
        currentImage = currentImage+1;
        if (currentImage>maxImages){
            currentImage=maxImages;
            return;
        }
        labelField.setText(name+" - slajd "+(currentImage+1)+" z "+(maxImages+1));
        myimageview.setImage(images[currentImage]);
    }
    @FXML
    private void PreviousBtnClicked(){
        currentImage = currentImage-1;
        if (currentImage<0){
            currentImage=0;
            return;
        }
        labelField.setText(name+" - slajd "+(currentImage+1)+" z "+(maxImages+1));
        myimageview.setImage(images[currentImage]);
    }

    @FXML
    private void FirstBtnClicked(){
        if (currentImage == 0){
            return;
        }
        currentImage = 0;
        labelField.setText(name+" - slajd "+(currentImage+1)+" z "+(maxImages+1));
        myimageview.setImage(images[currentImage]);
    }
    @FXML
    private void LastBtnClicked(){
        if (currentImage == maxImages){
            return;
        }
        currentImage = maxImages;
        labelField.setText(name+" - slajd "+(currentImage+1)+" z "+(maxImages+1));
        myimageview.setImage(images[currentImage]);
    }
    @FXML
    private void BackBtnClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("slide-viewer-menu.fxml"));
        Pane slideViewerPane = (Pane) fxmlLoader.load();
        try {
            anchorPaneSlider.getChildren().clear();
            anchorPaneSlider.getChildren().add(slideViewerPane);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
