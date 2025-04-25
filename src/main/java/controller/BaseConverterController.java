package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private ToggleGroup numberType;

    @FXML
    public void initialize(){
        numberType = new ToggleGroup();
        binaryRadioButton.setToggleGroup(numberType);
        octalRadioButton.setToggleGroup(numberType);
        hexaRadioButton.setToggleGroup(numberType);

    }
    @FXML
    void clearOnAction(ActionEvent event) {
        textField.clear();
        textArea.clear();
    }

    @FXML
    void convertOnAction(ActionEvent event) {
        try {
            if (binaryRadioButton.isSelected()) {
                String result = util.Utility.decimalToBinary(Integer.parseInt(textField.getText()));
                textArea.setText(result);
            } else if (octalRadioButton.isSelected()) {
                String result = util.Utility.decimalToOctal(Integer.parseInt(textField.getText()));
                textArea.setText(result);
            } else if (hexaRadioButton.isSelected()) {
                String result = util.Utility.decimalToHexaDecimal(Integer.parseInt(textField.getText()));
                textArea.setText(result);
            }
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }
}
