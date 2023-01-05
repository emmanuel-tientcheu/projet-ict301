package com.example.kimmo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerPromise implements Initializable {


    @FXML
    private Button btnrefresh;

    @FXML
    private Button btnprint;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnsearch;


    @FXML private TableView<Client> clientTable;

    @FXML private TableColumn<Client, Integer> nicCol;

    @FXML private TableColumn<Client, String> nameCol;

    @FXML private TableColumn<Client, String> nationalityCol;

    @FXML private TableColumn<Client, Integer> phoneCol;

    @FXML private TableColumn<Client, String> proffesionCol;

    @FXML private TableColumn<Client, Integer> ageCol;

    @FXML private TableColumn<Client, Date> dateCol;

    Date date=new Date();

    /**String query=null;
     Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );;
     PreparedStatement preparedStatement =null;
     ResultSet resultSet =null;
     Client client =null;
     */
    /**
     * the client list hold the data from the client class to the
     * */
    ObservableList<Client> clientlist= FXCollections.observableArrayList();


    public void updateclientcontroller() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




//        refreshTable(); // this function help us to refreash the table


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
//                    DBUtils.deleteDB_client(clientTable);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }

            }
        });

        btnrefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                refreshTable();
            }
        });

//        btnprint.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////                DBUtils.printTastecard(actionEvent,clientTable);
//            }
//        });


    }
    /**
     * this are the function that will be use in the progra we have the
     * REFRESHTABLE: It permit use to refresh the table view of our program
     * */


    //refresh tab

//    @FXML private void refreshTable(){
//
//        try {
//            String query=null;
//            Connection connection =  DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "1234" );;
//            PreparedStatement preparedStatement =null;
//            ResultSet resultSet =null;
//            Client client =null;
//
//            clientlist.clear();
//            query = "SELECT * FROM client_vaccine";
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()){
//                clientlist.add(new Client(
//                        resultSet.getInt("NIC"),
//                        resultSet.getString("name"),
//                        resultSet.getString("nationality"),
//                        resultSet.getInt("phone"),
//                        resultSet.getInt("age"),
//                        resultSet.getString("proffesion"),
//                        resultSet.getDate("vac_date")
//                ));
//                clientTable.setItems(clientlist);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        nicCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Integer>("nicCol"));
//        nameCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("nameCol"));
//        nationalityCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("nationalityCol"));
//        phoneCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Integer>("phoneCol"));
//        ageCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Integer>("ageCol"));
//        proffesionCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,String>("proffesionCol"));
//        dateCol.setCellValueFactory(new PropertyValueFactory<com.example.frontend_javaproject.Client,Date>("dateCol"));
//
//        //initialise listenner for filtered the list
//        FilteredList<Client> filteredData =new FilteredList<>(clientlist, b ->true);
//
//        tfsearch.textProperty().addListener((observable,oldValue,newValue)->{
//            filteredData.setPredicate(client -> {
//                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
//                    return true;
//                }
//                String searchKeyword = newValue.toLowerCase();
//
//                if(client.getNicCol().toString().indexOf(searchKeyword)> -1){
//                    return true;//mean we found id
//
//                }else if(client.getNameCol().toLowerCase().indexOf(searchKeyword) > -1){
//                    return true;//mean we found name
//                }else if(client.getNationalityCol().toLowerCase().indexOf(searchKeyword) > -1){
//                    return true;//mean we found name
//                }
//                else if(client.getProffesionCol().toLowerCase().indexOf(searchKeyword) > -1){
//                    return true;//mean we found name
//                }
//                else if(client.getPhoneCol().toString().indexOf(searchKeyword) > -1){
//                    return true;//mean we found name
//                }
//                else
//                    return false;//no match found
//            });
//        });
//
//        SortedList<Client> sortData=new SortedList<>(filteredData);
//
//        //bind sorted result with table
//        sortData.comparatorProperty().bind(clientTable.comparatorProperty());
//
//        //apply filtered and sorted data to Table view
//        clientTable.setItems(sortData);
//    }

}
