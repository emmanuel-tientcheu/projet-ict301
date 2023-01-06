package com.example.kimmo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class controllerAllApart implements Initializable {

    @FXML
    private HBox appartLayout;
    private List<Appartement> allapart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allapart = new ArrayList<>(getList());

        try {
            for (Appartement apart:
                    allapart) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader. setLocation(getClass().getResource( "card.fxml"));
                HBox cardBox = null;
                cardBox = fxmlLoader.load();
                controllerCard cardController = fxmlLoader.getController();
                cardController.setData(apart); appartLayout.getChildren().add(cardBox);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private List<Appartement> getList(){

         List<Appartement> ls = new ArrayList<>();

        ArrayList<Appartement> getpromiselist = new ArrayList<>();
        getpromiselist=Appartement.getAppartementTable();

        for (Appartement appartement : getpromiselist) {
            ls.add(appartement);
        }

        return ls;
    }
}