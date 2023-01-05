package com.example.kimmo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
}
