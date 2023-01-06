package com.example.kimmo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Appartement implements IAppartement{
    public int idAppartement;
    public int idImmeuble;
    public int numero;
    public float superficie;
    public float prix_previsionnel;
    public int nombre_chambre;

    public Appartement(int idAppartement , int idImmeuble , int numero , float superficie , float prix_previsionnel , int nombre_chambre){
        this.idAppartement = idAppartement;
        this.idImmeuble = idImmeuble;
        this.numero = numero;
        this.superficie = superficie;
        this.prix_previsionnel = prix_previsionnel;
        this.nombre_chambre = nombre_chambre;
    }

    public int getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    public int getIdImmeuble() {
        return idImmeuble;
    }

    public void setIdImmeuble(int idImmeuble) {
        this.idImmeuble = idImmeuble;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public float getPrix_previsionnel() {
        return prix_previsionnel;
    }

    public void setPrix_previsionnel(float prix_previsionnel) {
        this.prix_previsionnel = prix_previsionnel;
    }

    public int getNombre_chambre() {
        return nombre_chambre;
    }

    public void setNombre_chambre(int nombre_chambre) {
        this.nombre_chambre = nombre_chambre;
    }

    @Override
    public Appartement createAppartement(Appartement appartement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into appartement (IDIMMEUBLE,NUMERO,SUPERFICIE,PRIX_PREVISIONNEL,NBRE_CHAMBRE)" +
                "values('"+appartement.getIdImmeuble()+"','"+appartement.getNumero()+"','"+appartement.getSuperficie()+"','"+appartement.getPrix_previsionnel()+"','"+appartement.getNombre_chambre()+"')";
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
    public Appartement updateAppartement(Appartement appartement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update appartement set"
                +"`IDIMMEUBLE`=?,"
                +"`NUMERO`=?,"
                +"`SUPERFICIE`=?,"
                +"`PRIX_PREVISIONNEL`=?,"
                +"`NBRE_CHAMBRE`=? where IDAPPARTEMENT ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,appartement.getIdImmeuble());
            prepare.setInt(2,appartement.getNumero());
            prepare.setFloat(3,appartement.getSuperficie());
            prepare.setFloat(4,appartement.getPrix_previsionnel());
            prepare.setInt(5,appartement.getNombre_chambre());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Appartement deleteAppartement(Appartement appartement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from appartement where IDAPPARTEMENT = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("l'appartement "+appartement.numero+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Appartement getAppartement(int idAppartement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from appartement where IDAPPARTEMENT = '"+idAppartement+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("l'appartement selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NUMERO"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Appartement> getAppartementTable(){
        ArrayList<Appartement> appartementTable = new ArrayList<>();
        int compteur = 1;
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from appartement";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                appartementTable.add( new Appartement(resultSet.getInt("IDAPPARTEMENT"), resultSet.getInt("IDIMMEUBLE"), resultSet.getInt("NUMERO"), resultSet.getFloat("SUPERFICIE"),resultSet.getFloat("PRIX_PREVISIONNEL"), resultSet.getInt("NBRE_CHAMBRE") ));
                compteur++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(appartementTable.get(0).prix_previsionnel);
        return appartementTable ;

    }
}
