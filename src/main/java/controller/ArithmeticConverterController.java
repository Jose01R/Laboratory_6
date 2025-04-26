package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class ArithmeticConverterController {

    @FXML
    private RadioButton infixRadioButton;

    @FXML
    private RadioButton postfixRadioButton;

    @FXML
    private RadioButton prefixRadioButton;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextField textField;
    @FXML
    private Label labelPrefix;

    @FXML
    private  Label labelPostfix;

    private Alert alert;
    @FXML
    private ToggleGroup arithmeticConverterTypes;
    @FXML
    public void initialize() {
            alert = util.FXUtility.alert("Base Converter", "Information");

            //Configurar el ToggleGroup
            arithmeticConverterTypes = new ToggleGroup();
            prefixRadioButton.setToggleGroup(arithmeticConverterTypes);
            infixRadioButton.setToggleGroup(arithmeticConverterTypes);
            postfixRadioButton.setToggleGroup(arithmeticConverterTypes);

            //Escuchar los cambios para cambiar los label dependiendo del radioButton seleccionado
            arithmeticConverterTypes.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    RadioButton selected = (RadioButton) newValue;
                    if (selected == infixRadioButton) {
                        labelPrefix.setText("Prefix:");
                        labelPostfix.setText("Postfix:");
                    } else if (selected == postfixRadioButton) {
                        labelPrefix.setText("Prefix:");
                        labelPostfix.setText("Infix:");
                    } else if (selected == prefixRadioButton) {
                        labelPrefix.setText("Infix:");
                        labelPostfix.setText("Postfix:");
                    }
                }
            });

            //Para que al arrancar ya estén bien los labels
            if (arithmeticConverterTypes.getSelectedToggle() != null) {
                RadioButton selected = (RadioButton) arithmeticConverterTypes.getSelectedToggle();
                selected.fire();
            }


        }

    @FXML
    void cleanOnAction(ActionEvent event) {
        textField.clear();
        textArea1.clear();
        textArea2.clear();
    }

    @FXML
    void convertOnAction(ActionEvent event) {
        try {

            if (infixRadioButton.isSelected()) {
                String resultPost = util.Utility.infixToPostfixConverter(textField.getText());
                String resultPre = util.Utility.infixToPrefix(textField.getText());
                textArea1.setText(resultPre);
                textArea2.setText(resultPost);
            }else if(postfixRadioButton.isSelected()){
                String resultPre = util.Utility.posFixToPrefix(textField.getText());
                String resultInfix = util.Utility.postfixToInfixConverter(textField.getText());
                textArea1.setText(resultPre);
                textArea2.setText(resultInfix);
            }else if(prefixRadioButton.isSelected()){

                String resultPost = util.Utility.prefixToPosFix(textField.getText());
                String resultInfix = util.Utility.prefixToInfix(textField.getText());
                textArea1.setText(resultInfix);
                textArea2.setText(resultPost);
            }
        }catch (StackException e){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("Error"+ e.getMessage());
            alert.show();
        }
    }

}

