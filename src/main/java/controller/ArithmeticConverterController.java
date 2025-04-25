package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ArithmeticConverterController {

    @FXML
    private RadioButton infixRadioButton;

    @FXML
    private RadioButton postfixRadioButton;

    @FXML
    private RadioButton prefixRadioButton;

    @FXML
    private TextArea textAreaPostfix;

    @FXML
    private TextArea textAreaPrefix;

    @FXML
    private TextField textField;
    @FXML
    private Label labelPrefix;

    @FXML
    private Label labelPostfix;

    @FXML
    private ToggleGroup arithmeticConverterTypes;
    @FXML
    public void initialize(){
        arithmeticConverterTypes= new ToggleGroup();
        prefixRadioButton.setToggleGroup(arithmeticConverterTypes);
        infixRadioButton.setToggleGroup(arithmeticConverterTypes);
        postfixRadioButton.setToggleGroup(arithmeticConverterTypes);
    }
    @FXML
    void cleanOnAction(ActionEvent event) {
        textField.clear();
        textAreaPostfix.clear();
        textAreaPrefix.clear();
    }

    @FXML
    void convertOnAction(ActionEvent event) {
        try {
            if (infixRadioButton.isSelected()) {
                String resultPost = util.Utility.infixToPostfixConverter(textField.getText());
                String resultPre = util.Utility.infixToPrefix(textField.getText());
                textAreaPrefix.setText(resultPre);
                textAreaPostfix.setText(resultPost);
            }else if(postfixRadioButton.isSelected()){
                String resultPre = util.Utility.posFixToPrefix(textField.getText());
                String resultInfix = util.Utility.postfixToInfixConverter(textField.getText());
                textAreaPrefix.setText(resultPre);
                textAreaPostfix.setText(resultInfix);
            }
        }catch (StackException e){
            throw new RuntimeException(e);
        }
    }

}

