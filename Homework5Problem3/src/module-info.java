module sample {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    opens sample to javafx.fxml;
    exports sample to javafx.graphics;
}