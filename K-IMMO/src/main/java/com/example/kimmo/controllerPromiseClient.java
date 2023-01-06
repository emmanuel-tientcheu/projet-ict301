package com.example.kimmo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class controllerPromiseClient implements Initializable {


    @FXML
    private Button btnrefresh;

    @FXML
    private Button btnprint;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnsearch;


    @FXML
    private TableColumn<Promesse, Date> datecol;

    @FXML
    private TableColumn<Promesse, Integer> idAppart;

    @FXML
    private TableColumn<Promesse, Integer> idavocat;

    @FXML
    private TableColumn<Promesse, Integer> idclient;

    @FXML
    private TableColumn<Promesse, Integer> iddirecteur;

    @FXML
    private TableColumn<Promesse, Integer> issign;
    @FXML
    private TableColumn<Promesse, Float> prix_vente;

    @FXML
    private TableColumn<Promesse, Float> avance;

    @FXML
    private TableColumn<Promesse, Integer> status;

    @FXML
    private TableView<Promesse> promiseAdminTable;


    @FXML
    private TextField tfsearch;

    Date date=new Date();

    /**String query=null;
     Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
     PreparedStatement preparedStatement =null;
     ResultSet resultSet =null;
     Promesse client =null;
     */
    /**
     * the client list hold the data from the client class to the
     * */
    ObservableList<Promesse> promiselist= FXCollections.observableArrayList();


    public void updateclientcontroller() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refreshTable(); // this function help us to refreash the table


        /**
         * btnadd permit use to open the vaccination winddow inorder to
         * re_vacciante some one back if his info was not found in the database
         * */
//        btnadd.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////                try {
////                    Parent parent = FXMLLoader.load(getClass().getResource("vaccination.fxml"));
////                    Scene scene=new Scene(parent);
////                    Stage stage=new Stage();
////                    stage.setScene(scene);
////                    stage.initStyle(StageStyle.UTILITY);
////                    stage.setTitle("Vaccination");
////                    stage.show();
////
////                } catch (IOException e) {
////                    e.printStackTrace();
//////                }
//            }
//        });

        btndelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

//                try {
//                    DBUtils.deleteDB_client(promiseAdminTable);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }

            }
        });

        btnrefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                refreshTable();
            }
        });

//        btnprint.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////                DBUtils.printTastecard(actionEvent,promiseAdminTable);
//            }
//        });


    }
    /**
     * this are the function that will be use in the progra we have the
     * REFRESHTABLE: It permit use to refresh the table view of our program
     * */


    //refresh tab

    @FXML private void refreshTable(){

        try {

            promiselist.clear();

                ArrayList<Promesse> getpromiselist = new ArrayList<>();
                getpromiselist=Promesse.getPromesseTable();

            for (Promesse promesse : getpromiselist) {
                promiselist.add(promesse);
                System.out.println(promiselist);
            }

            promiseAdminTable.setItems(promiselist);
            System.out.println(promiseAdminTable);
            } catch (Exception exception) {
            exception.printStackTrace();
        }



        idclient.setCellValueFactory(new PropertyValueFactory<Promesse,Integer>("idClient"));
        idAppart.setCellValueFactory(new PropertyValueFactory<Promesse,Integer>("idAppartement"));
        idavocat.setCellValueFactory(new PropertyValueFactory<Promesse,Integer>("idAvocat"));
        issign.setCellValueFactory(new PropertyValueFactory<Promesse,Integer>("isSign"));
        prix_vente.setCellValueFactory(new PropertyValueFactory<Promesse,Float>("prix_ventel"));
        avance.setCellValueFactory(new PropertyValueFactory<Promesse,Float>("avance"));


    }



}
