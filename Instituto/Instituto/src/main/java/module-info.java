module com.sujey.instituto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sujey.instituto to javafx.fxml;
    exports com.sujey.instituto;
    exports com.sujey.instituto.Controllers;
    opens com.sujey.instituto.Controllers to javafx.fxml;
}