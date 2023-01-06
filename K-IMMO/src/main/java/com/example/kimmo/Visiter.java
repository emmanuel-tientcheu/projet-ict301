package com.example.kimmo;

//package config;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class Visiter  implements  IVisiter{
    public int idVisiter;
    private int idAppartement;
    private int idClient;
    private Date dateVisite;
    private String remarques;

    public Visiter(int idVisiter ,int idAppartement , int idClient , Date dateVisite , String remarques){
        this.idVisiter = idVisiter;
        this.idAppartement = idAppartement;
        this.idClient = idClient;
        this.dateVisite = dateVisite;
        this.remarques = remarques;
    }



    public int getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public java.sql.Date getDateVisite() {
        java.sql.Date sqlDate = new java.sql.Date(this.dateVisite.getTime());
        return sqlDate;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public int getIdVisiter(){return idVisiter;}
    public void setIdVisiter(int idVisiter){this.idVisiter = idVisiter;}


    @Override
    public Visiter createVisiter(Visiter visiter) {
        return null;
    }

    @Override
    public Visiter updateVisiter(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update visiter set"
                +"`IDAPPARTEMENT`=?,"
                +"`IDCLIENT`=?,"
                +"`DATEVISITE`=? where IDVISITER ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,visiter.getIdAppartement());
            prepare.setInt(2,visiter.getIdClient());
            prepare.setDate(3, (java.sql.Date) visiter.getDateVisite());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Visiter deleteVisiter(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from visiter where IDVISITER = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("la visite "+ "a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Visiter getVisiter(Visiter idVisiter) {
        return null;
    }


    public static ArrayList<Visiter> getVisiterTable(){
        ArrayList<Visiter> visiterTable = new ArrayList<>();
        int compteur = 1;
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from visiter";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                visiterTable.add(new Visiter( resultSet.getInt("IDVISITER"),resultSet.getInt("IDAPPARTEMENT"), resultSet.getInt("IDCLIENT"),resultSet.getDate("DATEVISITE"), resultSet.getString("IDVISITER") ));
                compteur++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(visiterTable.get(0).remarques);
        return visiterTable ;

    }

    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from visiter";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // System.out.print("le directeur selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDVISITER"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDVISITER");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if(verification.length()>0){
            return Integer.parseInt(verification) ;

        }else{
            verification = "0";
            return Integer.parseInt(verification) ;

        }
    }

    public static void creationPromesse(Visiter visiter , int idAvocat,float avance,float prix_vente){
        int id = Promesse.getAll()+1;
        Promesse promesse = new Promesse(id,visiter.getIdAppartement(),visiter.getIdClient(),idAvocat,1,0,0,visiter.getDateVisite(),prix_vente,avance);
        if((promesse.getPrix_vente()*20)/100 < promesse.getAvance()){
            System.out.println("impossible de cree cette promesse car l'avance est insuffisant");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossible de cree cette promesse car l'avance est insuffisant");
            alert.show();
        }else{
            System.out.println("la promesse seras cree");
            promesse.createPromesse(promesse);
        }
    }

    public static Visiter getVisiters(int idVisiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        Visiter vist = null;
        String sql = "select * from visiter where IDVISITER = '"+idVisiter+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la visite conserne le departement ");
            while(resultSet.next()){
                vist = new Visiter( resultSet.getInt("IDVISITER"),resultSet.getInt("IDAPPARTEMENT"), resultSet.getInt("IDCLIENT"),resultSet.getDate("DATEVISITE"), resultSet.getString("IDVISITER"));
                System.out.println(resultSet.getString("IDAPPARTEMENT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vist;
    }

    public static void createVisiterss(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        int id =Visiter.getAll()+1;
        String sql = "insert into visiter (IDAPPARTEMENT,IDCLIENT,DATEVISITE,REMARQUES,IDVISITER)" +
                "values('"+visiter.getIdAppartement()+"','"+visiter.getIdClient()+"','"+visiter.getDateVisite()+"','"+visiter.getRemarques()+"','"+id+"')";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("creation reussie de la visite");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
