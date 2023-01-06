package com.example.kimmo;

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
    private Label numRoom;

    @FXML
    private Label price;

    @FXML
    private Label superfici;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public  void setinfo(String ids, String supperficie, String numChambre, String prix)
    {
        numRoom.setText(numChambre);
        id.setText(ids);
        price.setText(prix);
        superfici.setText(supperficie);
    }
}
