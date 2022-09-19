package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class Controller {
    @FXML
    private Button btnQuit;
    @FXML
    private Button btnSend;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtTo;
    @FXML
    private TextField txtFrom;
    @FXML
    private TextField txtBCCEmail;
    @FXML
    private TextField txtCCEmail;
    @FXML
    private HTMLEditor htmlContent;

    @FXML
    void checkEmailTo() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!(txtTo.getText().contains("@")) || !(txtTo.getText().contains("."))) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Email to is wrong format (doesnt contains @ of domain)");
            alert.show();
        }
        if (txtTo.getText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Email to is empty");
            alert.show();
        }
    }

    @FXML
    void checkEmailFrom() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!(txtFrom.getText().contains("@")) || !(txtFrom.getText().contains("."))) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Email from is wrong format (doesnt contains @ of domain)");
            alert.show();
        }
        if (txtFrom.getText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Email from is empty");
            alert.show();
        }
    }

    @FXML
    void checkCCEmail() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!(txtCCEmail.getText().isEmpty())) {
            if (!(txtCCEmail.getText().contains("@")) || !(txtCCEmail.getText().contains("."))) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Email CC is wrong format (doesnt contains @ of domain)");
                alert.show();
            }
        }
    }

    @FXML
    void checkBCCEmail() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!(txtBCCEmail.getText().isEmpty())) {
            if (!(txtBCCEmail.getText().contains("@")) || !(txtBCCEmail.getText().contains("."))) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Email BCC is wrong format (doesnt contains @ of domain)");
                alert.show();
            }
        }
    }

    @FXML
    void checkHTMLContent() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (htmlContent.getHtmlText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("The content is empty");
            alert.show();
        }
    }

    @FXML
    public String report() {
        String report = "Email from: " + txtFrom.getText() + '\n' +
                "Email to: " + txtTo.getText() + '\n' +
                "CC: " + txtCCEmail.getText() + '\n' +
                "BCC:" + txtBCCEmail.getText() + '\n' +
                "Content" ;
        return report;
    }
    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void btnClearOnAction(ActionEvent event){
        htmlContent.setHtmlText(" ");
    }
    @FXML
    void btnSendOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        checkBCCEmail();
        checkCCEmail();
        checkEmailFrom();
        checkEmailTo();
        checkHTMLContent();
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText(report());
        alert.show();

    }


}
