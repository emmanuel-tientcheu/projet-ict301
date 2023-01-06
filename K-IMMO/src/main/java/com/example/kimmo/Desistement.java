package com.example.kimmo;

//package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class Desistement implements IDesistement {
    private int idDesistement;
    private int idAppartement;
    private int idClient;
    private int numero;
    private Date date;
    private String causes;
    private int isValider;
    private int idPromesse;
    private int idDirecteur;
    private int idAvocat;

    public Desistement(int idDesistement, int idAppartement, int idClient, int numero, Date date, String causes, int isValider, int idPromesse, int idDirecteur, int idAvocat) {
        this.idDesistement = idDesistement;
        this.idAppartement = idAppartement;
        this.idClient = idClient;
        this.numero = numero;
        this.date = date;
        this.causes = causes;
        this.isValider = isValider;
        this.idPromesse = idPromesse;
        this.idDirecteur = idDirecteur;
        this.idAvocat = idAvocat;
    }

    public int getIdDesistement() {
        return idDesistement;
    }

    public void setIdDesistement(int idDesistement) {
        this.idDesistement = idDesistement;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public int isValider() {
        return isValider;
    }

    public void setValider(int valider) {
        isValider = valider;
    }

    @Override
    public Desistement createDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into desistement (IDDESISTEMENT,IDPROMESSE,IDDIRECTEUR,IDCLIENT,IDAVOCAT,NUMERO,DATE,CAUSES,ISVALIDER,IDAPPARTEMENT)" +
                "values('" + desistement.getIdDesistement() + "','" + desistement.getIdPromesse() + "','" + desistement.getIdDirecteur() + "','" + desistement.getIdClient() + "','" + desistement.getIdAvocat() + "','" + desistement.getNumero() + "','" + desistement.getDate() + "','" + desistement.getCauses() + "','" + desistement.isValider + "','" + desistement.getIdAppartement() + "')";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("creation reussie");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Desistement updateDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update desistement set"
                + "`IDPROMESSE`=?,"
                + "`IDDIRECTEUR`=?,"
                + "`IDCLIENT`=?,"
                + "`IDAVOCAT`=?,"
                + "`NUMERO`=?,"
                + "`DATE`=?,"
                + "`CAUSES`=?,"
                + "`ISVALIDER`=?,"
                + "`IDAPPARTEMENT`=? where IDDESISTEMENT ='" + 2 + "'";
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1, desistement.getIdPromesse());
            prepare.setInt(2, desistement.getIdDirecteur());
            prepare.setInt(3, desistement.getIdClient());
            prepare.setInt(4, desistement.getIdAvocat());
            prepare.setInt(5, desistement.getNumero());
            prepare.setDate(6, desistement.getDate());
            prepare.setString(7, desistement.getCauses());
            prepare.setInt(8, desistement.isValider);
            prepare.setInt(9, desistement.getIdAppartement());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Desistement deleteDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "delete from desistement where IDDESISTEMENT = '" + 2 + "'";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le desistement " + desistement.numero + " a ete supprime avec success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Desistement getDesistement(int idDesistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from desistement where IDDESISTEMENT = '" + idDesistement + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le desistement selectionne est ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("NUMERO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from desistement";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la desistement selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDDESISTEMENT"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDDESISTEMENT");

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

    public int getIdPromesse() {
        return idPromesse;
    }

    public void setIdPromesse(int idPromesse) {
        this.idPromesse = idPromesse;
    }

    public int getIdDirecteur() {
        return idDirecteur;
    }

    public void setIdDirecteur(int idDirecteur) {
        this.idDirecteur = idDirecteur;
    }

    public int getIdAvocat() {
        return idAvocat;
    }

    public void setIdAvocat(int idAvocat) {
        this.idAvocat = idAvocat;
    }

    public static void validationDesistement(Desistement desistement){
        desistement.isValider = 1;
        desistement.updateDesistement(desistement);

        System.out.print("redaction d'une lettre de desistement ");
        System.out.println("une avance vous seras restituer");

        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from promesse where IDPROMESSE = '"+desistement.idPromesse+"' AND IDCLIENT = '"+desistement.idClient+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("l'anvance restituer est de ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("AVANCE"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
