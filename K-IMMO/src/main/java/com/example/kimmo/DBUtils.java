package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class DBUtils {

    public static void exit() {
        System.exit(0);
    }


    public static void changeover(ActionEvent actionevent, String fxml, String title){
        Parent root=null;
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);
        try{
            FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxml));
            root =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Stage stage =(Stage)((Node) actionevent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,800,550));
        stage.show();

    }

    public static void logInUser(ActionEvent actionEvent,String NUMERO_CNI) throws SQLException, IOException {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:330/sanka", "root", "1234");
            checkUserExist = connection.prepareStatement("SELECT * FROM administrator WHERE NUMERO_CNI =?");
            checkUserExist.setString(1, NUMERO_CNI);
            resultSet = checkUserExist.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentialse are incorrect \n User not Found in program");
                alert.show();
            } else {
                    String retrivename = resultSet.getString("NOM");
                        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("log in successfull Mr " +retrivename+".");
                        alert.show();
//                        changehigh(actionEvent, "sliderAdmin_Menu.fxml","ADMINISTRATION");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null /* || psInsert != null*/ || checkUserExist != null) {
                    resultSet.close();
                    //psInsert.close();
                    checkUserExist.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
