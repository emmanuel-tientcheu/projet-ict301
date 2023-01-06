package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerCard implements Initializable {
    @FXML
    private HBox apart;

    @FXML
    private Button btnBuy;

    @FXML
    private Label idApart;


    @FXML
    private ImageView image;

    @FXML
    private Label numRoom;

    @FXML
    private Label superfie;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnBuy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root=null;
                try {
//                    Parent parent = FXMLLoader.load(getClass().getResource("detailApart.fxml"));
//                    Scene scene=new Scene(parent);
//                    Stage stage=new Stage();
//                    stage.setScene(scene);
//                    stage.initStyle(StageStyle.UTILITY);
//                    stage.setTitle("Detail Appartment");
//                    stage.show();

                    FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource("detailApart.fxml"));
                    root =loader.load();
                    controllerDetailApart CD=loader.getController();
                    CD.setId(idApart.getText());
                    Scene scene=new Scene(root,600,400);
                    Stage stage =new Stage();
                    stage.setScene(scene);


                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }
    void setData(Appartement apartement){
//        Image myImage= new Image(getClass().getResourceAsStream("image1"));
//        image.setImage(myImage);
        idApart.setText(String.valueOf(apartement.getIdAppartement()));
        superfie.setText(String.valueOf(apartement.getSuperficie()));
        numRoom.setText(String.valueOf(apartement.getNombre_chambre()));

    }

}
