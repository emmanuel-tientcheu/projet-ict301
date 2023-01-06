package com.example.kimmo;

//package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class ProcesVerbale implements IProcesVerbale {
    private int idProcesVerbale;
    private int idDirecteur;
    private int idClient ;
    private Date dateRemise;

    public ProcesVerbale(int idProcesVerbale , int idDirecteur ,int idClient , Date dateRemise){
        this.idProcesVerbale = idProcesVerbale;
        this.idDirecteur = idDirecteur;
        this.idClient=idClient;
        this.dateRemise=dateRemise;
    }

    public int getIdProcesVerbale() {
        return idProcesVerbale;
    }

    public void setIdProcesVerbale(int idProcesVerbale) {
        this.idProcesVerbale = idProcesVerbale;
    }

    public int getIdDirecteur() {
        return idDirecteur;
    }

    public void setIdDirecteur(int idDirecteur) {
        this.idDirecteur = idDirecteur;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    @Override
    public ProcesVerbale createProcesVerbale(ProcesVerbale procesVerbale) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into procesVerbale (IDDIRECTEUR,IDCLIENT,DATEREMISE)" +
                "values('"+procesVerbale.getIdDirecteur()+"','"+procesVerbale.getIdClient()+"',,'"+procesVerbale.getDateRemise()+"')";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("creation reussie");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProcesVerbale updateProcesVerbale(ProcesVerbale procesVerbale) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update procesVerbale set"
                +"`IDDIRECTEUR`=?,"
                +"`IDCLIENT`=?,"
                +"`DATEREMISE`=? where IDPROCESVERBAL ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,procesVerbale.getIdDirecteur());
            prepare.setInt(2,procesVerbale.getIdClient());
            prepare.setDate(3, (java.sql.Date) procesVerbale.getDateRemise());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProcesVerbale deleteProcesVerbale(ProcesVerbale procesVerbale) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from procesVerbale where IDPROCESVERBAL = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le procesverbale "+procesVerbale.dateRemise+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProcesVerbale getProcesVerbale(int idProcesVerbale) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from procesVerbale where IDPROCESVERBAL = '"+idProcesVerbale+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le procesverbale selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDCLIENT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<ProcesVerbale> getProcessVerbaleTable(){
        ArrayList<ProcesVerbale> processVerbaleTable = new ArrayList<>();
        int compteur = 1;
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from procesVerbale";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                processVerbaleTable.add(new ProcesVerbale(resultSet.getInt("IDPROCESVERBAL"),resultSet.getInt("IDDIRECTEUR"),resultSet.getInt("IDCLIENT"),resultSet.getDate("DATEREMISE")));
                compteur++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(processVerbaleTable.get(0).idProcesVerbale);
        return processVerbaleTable ;

    }

    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from procesVerbale";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // System.out.print("le directeur selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDPROCESVERBAL"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDPROCESVERBAL");

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
}
