package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerDetailApart implements Initializable {
    @FXML
    private Button btndopromise;

    @FXML
    private Button btnexit;

    @FXML
    private Label txtid;

    @FXML
    private TextArea txtremark;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btndopromise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Appartement appartInfo =Appartement.getAppartId(Integer.parseInt(txtid.getText()));
                System.out.println(appartInfo);
                DBUtils.changeOvercard(actionEvent,"makePromise.fxml","WELCOME",Integer.toString(appartInfo.getIdAppartement()) ,Float.toString(appartInfo.getSuperficie()) ,Integer.toString(appartInfo.getNombre_chambre()) ,Float.toString(appartInfo.getPrix_previsionnel()) );
            }
        });
    }
    public void setId(String id){
        txtid.setText(id);
    }
}
