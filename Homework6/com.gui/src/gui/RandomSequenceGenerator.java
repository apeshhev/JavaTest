package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import providers.CipherGenerator;
import providers.Wrapper;
import services.Cipherable;

public class RandomSequenceGenerator extends Application {

    private TextField txtInputSeedField;
    private TextField txtInputSizeField;
    private Button btn1;
    private Button btn2;
    private Button btnQuit;
    private Alert messageBox;

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane(14, 14);
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        txtInputSeedField = new TextField("Enter the seed");
        txtInputSizeField = new TextField("Enter the size");
        VBox vBox = new VBox(5);
        btn1 = new Button("Generate random A-Z");
        btn2 = new Button("Random subset of A-Z");
        btnQuit = new Button("Quit");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction(event);
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction(event);
            }
        });

        btnQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAction(event);
            }
        });

        txtInputSeedField.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                onAction(event);
            }
        });
        txtInputSizeField.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                onAction(event);
            }
        });

        txtInputSizeField.setPrefWidth(270);
        txtInputSeedField.setPrefWidth(270);
        btn1.setPrefWidth(150);
        btn2.setPrefWidth(150);
        btnQuit.setPrefWidth(150);
        vBox.getChildren().addAll(txtInputSeedField, txtInputSizeField);
        pane.getChildren().add(vBox);
        pane.getChildren().addAll(btn1, btn2, btnQuit);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 400, 150);

        primaryStage.setTitle("Generate random sequence");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void onAction(ActionEvent event) {
        String string;

        if (event.getSource() == btn1) {
            Wrapper wrapper = new Wrapper(Integer.parseInt(txtInputSizeField.getText()));
            Cipherable c = wrapper.makeFixedRandom();
            string = "Chars: " + (CipherGenerator.countDistinct(c, Integer.parseInt(txtInputSeedField.getText()))).toString() + "\n" +
                    "Result: " + CipherGenerator.countDistinct(c, Integer.parseInt(txtInputSeedField.getText())).getData();

            messageBox.setTitle("Random subsequence of letters A-Z");
            messageBox.setHeaderText("Count distinct characters out of " + txtInputSizeField.getText());
            messageBox.setContentText(string);
            messageBox.showAndWait();
        } else if (event.getSource() == btn2) {
            Wrapper wrapper = new Wrapper(Integer.parseInt(txtInputSizeField.getText()));
            Cipherable c = wrapper.makeFixedSelection();
            string = "Chars: " + (CipherGenerator.countDistinct(c, Integer.parseInt(txtInputSeedField.getText()))).toString() + "\n" +
                    "Result: " + CipherGenerator.countDistinct(c, Integer.parseInt(txtInputSeedField.getText())).getData();

            messageBox.setTitle("Generate random subset A-Z");
            messageBox.setHeaderText("Count distinct characters out of " + txtInputSizeField.getText());
            messageBox.setContentText(string);
            messageBox.showAndWait();
        }else if(event.getSource() == btnQuit) {
            Stage stage = (Stage) btnQuit.getScene().getWindow();
            stage.close();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
