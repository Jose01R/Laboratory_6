package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BaseConverterController {

    @FXML
    private RadioButton binaryRadioButton;

    @FXML
    private RadioButton hexaRadioButton;

    @FXML
    private RadioButton octalRadioButton;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    public void initialize(){


    }
    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void convertOnAction(ActionEvent event) {

    }

}
