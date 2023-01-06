package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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

    @FXML
    private Label txtuser;

    Date date = new Date(2323352);

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btndopromise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Appartement appartInfo =Appartement.getAppartId(Integer.parseInt(txtid.getText()));
                ArrayList<Visiter> visiteTable = new ArrayList<>();
                visiteTable=Visiter.getVisiterTable();
                System.out.println(visiteTable.size());
                System.out.println(txtremark.getText());
                Visiter newvisite = new Visiter(visiteTable.size(),Integer.parseInt(txtid.getText()) ,Integer.parseInt(txtuser.getText()),date,txtremark.getText());
                Visiter.createVisiterss(newvisite);
//                System.out.println(appartInfo);
                DBUtils.changeOvercard(actionEvent,"makePromise.fxml","WELCOME",Integer.toString(appartInfo.getIdAppartement()) ,Float.toString(appartInfo.getSuperficie()) ,Integer.toString(appartInfo.getNombre_chambre()) ,Float.toString(appartInfo.getPrix_previsionnel()),Integer.toString(newvisite.getIdVisiter())  );
            }
        });
    }

    public void setId(String id,String idU){
        txtid.setText(id);
        txtuser.setText(idU);
    }
}
