module pro.javapro {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens pro.javapro to javafx.fxml;
    exports pro.javapro;
}