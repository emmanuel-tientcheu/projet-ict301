package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class controllerClientLogin implements Initializable {

    @FXML
    private Button btnadd_admin;

    @FXML
    private Button btnlogin_admin;

    @FXML
    private Button btnreturn;

    @FXML
    private TextField tfCNI;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //the button that reset the textfield
//<<<<<<< HEAD
//
//=======
//>>>>>>> 83c3549ce86c03ec854c3df7ebc8fa9609c41983


        //return to the mainpage2
        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"accueil.fxml","WELCOME TO MAIN PAGE");
            }
        });

        //permit us to login
        btnlogin_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (tfCNI.getText().trim().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please enter A CNI");
                    alert.show();

                } else {
                    

                    DBUtils.changeover(actionEvent,"account.fxml","WELCOME TO MAIN PAGE");
                }
            }
        });

        //goes to the page that permit us to add admin
//        btnadd_admin.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setContentText("You Be directed to Creat Admin");
//                alert.show();
//
//                DBUtils.changeover(actionEvent,"signup_admin.fxml","SIGN UP PAGE");
//            }
//        });
//
    }
}
