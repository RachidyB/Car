module ma.emsi.Car {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires json.simple;
    requires com.google.gson;
    opens ma.emsi.classe to javafx.base;


    opens ma.emsi to javafx.fxml;
    exports ma.emsi;
    exports ma.emsi.Controllers;
    opens ma.emsi.Controllers to javafx.fxml;
}