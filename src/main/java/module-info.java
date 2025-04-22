module ucr.stacks {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.stacks to javafx.fxml;
    exports ucr.stacks;
}