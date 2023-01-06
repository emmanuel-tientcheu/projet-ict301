package com.example.kimmo;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerAccount implements Initializable {
    // @FXML private ImageView exit;


    @FXML
    private AnchorPane anchorleft;

    @FXML
    private AnchorPane anchortop;

    @FXML
    private Button btnappart;

    @FXML
    private Button btnclose;

    @FXML
    private Button btndiscrimate;

    @FXML
    private Button btnexit;

    @FXML
    private Button btnpromise;

    @FXML
    private StackPane contentArea;

    @FXML
    private AnchorPane slider;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"accueil.fxml","WELCOME");
            }
        });

        try{
            Parent root= FXMLLoader.load(getClass().getResource("allApart.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exit (ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }

    public void apart (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("allApart.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void promise (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("promiseClient.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void disclaimer (ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("disclaimer.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

}
