package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerAccueil implements Initializable {

    @FXML
    private Button btn_admin;
    @FXML
    private Button btn_service;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"admin.fxml","Admin");
            }
        });

        btn_service.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              //  DBUtils.changeover(actionEvent, "clientLogin.fxml","SERVICES");

                ArrayList<Client> clientTable = new ArrayList<>();
                clientTable=Client.getClientTable();
                System.out.println(clientTable.size());
            }
        });

    }
}
