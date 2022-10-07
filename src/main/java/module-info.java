module com.stanrehor.oop {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.stanrehor.oop.model;
    opens com.stanrehor.oop.model to javafx.fxml;
    exports com.stanrehor.oop.model.items;
    opens com.stanrehor.oop.model.items to javafx.fxml;
    exports com.stanrehor.oop.controller;
    opens com.stanrehor.oop.controller to javafx.fxml;
    exports com.stanrehor.oop;
    opens com.stanrehor.oop to javafx.fxml;
}