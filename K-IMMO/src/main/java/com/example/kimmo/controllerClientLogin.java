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

    @FXML private Button btnadd_admin;

    @FXML private Button btn_reset;

    @FXML private Button btnlogin_admin;

    @FXML private Button btnreturn;

    @FXML private TextField tfadmin_mat;

    @FXML private TextField tfadmin_pwd;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //the button that reset the textfield
        btn_reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfadmin_pwd.clear();
                tfadmin_mat.clear();

            }
        });


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
                DBUtils.changeover(actionEvent,"account.fxml","WELCOME TO MAIN PAGE");
//                DBUtils.changeover(actionEvent,"mainpage2.fxml","WELCOME TO MAIN PAGE");
//                changehigh(actionEvent, "sliderAdmin_Menu.fxml","ADMINISTRATION");

//                if (tfadmin_mat.getText().trim().isEmpty() || tfadmin_pwd.getText().trim().isEmpty()) {
//
//
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setContentText("Please enter the Matricule and password");
//                    alert.show();
//
//                } else {
//
//                    try {
//                        DBUtils.logInUser(actionEvent,tfadmin_mat.getText(),tfadmin_pwd.getText());
//
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
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
