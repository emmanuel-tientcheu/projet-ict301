package com.example.kimmo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Avocat implements IAvocat {
    private int idAvocat;
    private String nomA;
    private String prenomA;
    private String adresseA;
    private String telephoneA;
    private String numeroAutorisation;

    public Avocat(int idAvocat , String nomA , String prenomA , String adresseA ,String telephoneA , String numeroAutorisation){
        this.idAvocat = idAvocat;
        this.nomA = nomA;
        this.prenomA = prenomA;
        this.adresseA = adresseA;
        this.telephoneA = telephoneA;
        this.numeroAutorisation = numeroAutorisation;
    }

    public int getIdAvocat() {
        return idAvocat;
    }

    public void setIdAvocat(int idAvocat) {
        this.idAvocat = idAvocat;
    }

    public String getNomA() {
        return nomA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public String getPrenomA() {
        return prenomA;
    }

    public void setPrenomA(String prenomA) {
        this.prenomA = prenomA;
    }

    public String getAdresseA() {
        return adresseA;
    }

    public void setAdresseA(String adresseA) {
        this.adresseA = adresseA;
    }

    public String getTelephoneA() {
        return telephoneA;
    }

    public void setTelephoneA(String telephoneA) {
        this.telephoneA = telephoneA;
    }

    public String getNumeroAutorisation() {
        return numeroAutorisation;
    }

    public void setNumeroAutorisation(String numeroAutorisation) {
        this.numeroAutorisation = numeroAutorisation;
    }

    @Override
    public Avocat createAvocat(Avocat avocat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into avocat (NOMA,PRENOMA,ADRESSAA,TELEPHONEA,NUMEROAUTORISATION)" +
                "values('"+avocat.getNomA()+"','"+avocat.getPrenomA()+"','"+avocat.getAdresseA()+"',,'"+avocat.getTelephoneA()+"',,'"+avocat.getNumeroAutorisation()+"')";
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
    public Avocat updateteAvocat(Avocat avocat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update avocat set"
                +"`NOMA`=?,"
                +"`PRENOMA`=?,"
                +"`ADRESSAA`=?,"
                +"`TELEPHONEA`=?,"
                +"`NUMEROAUTORISATION`=? where IDAVOCAT ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setString(1,avocat.getNomA());
            prepare.setString(2,avocat.getPrenomA());
            prepare.setString(3,avocat.getAdresseA());
            prepare.setString(4,avocat.getTelephoneA());
            prepare.setString(5,avocat.getNumeroAutorisation());

            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Avocat deleteAvocat(Avocat avocat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from avocat where IDAVOCAT = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("l'avocat "+avocat.nomA+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Avocat getAvocat(int idAvocat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from avocat where IDAVOCAT = '"+idAvocat+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("l'avocat selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOMA"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Avocat> getAvocatTable(){
        ArrayList<Avocat> avocatTable = new ArrayList<>();
        int compteur = 1;
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from avocat";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                avocatTable.add(new Avocat(resultSet.getInt("IDAVOCAT"),resultSet.getString("NOMA"), resultSet.getString("PRENOMA"), resultSet.getString("ADRESSAA"), resultSet.getString("TELEPHONEA"), resultSet.getString("NUMEROAUTORISATION") ));
                compteur++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(avocatTable.get(0).nomA);
        return avocatTable ;

    }

    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from avocat";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // System.out.print("la desistement selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDAVOCAT"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDAVOCAT");

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
