package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class controllerMakePromise implements Initializable {

    @FXML
    private TextField advance;

    @FXML
    private Button btnvalidate;

    @FXML
    private Label id;

    @FXML
    private Label idvisite;

    @FXML
    private Label numRoom;

    @FXML
    private Label price;

    @FXML
    private Label superfici;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnvalidate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Visiter vis = Visiter.getVisiters(Integer.parseInt(idvisite.getText()));
                System.out.println(vis.getDateVisite());
                Visiter.creationPromesse(vis,1,Float.parseFloat(advance.getText()));
//                DBUtils.changeover(actionEvent,"accueil.fxml","WELCOME TO MAIN PAGE");
            }
        });
    }
    public  void setinfo(String ids, String supperficie, String numChambre, String prix,String idv)
    {
        numRoom.setText(numChambre);
        id.setText(ids);
        price.setText(prix);
        superfici.setText(supperficie);
        idvisite.setText(idv);
    }
}
