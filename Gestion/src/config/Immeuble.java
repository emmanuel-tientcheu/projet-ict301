package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Immeuble implements IImmeuble{
    public int idImmeuble;
    private int idSociete;
    public String adresse;
    public String nomImmeuble;

    public  Immeuble(int idImmeuble ,int idSociete ,String adresse , String nomImmeuble){
        this.idImmeuble = idImmeuble;
        this.setIdSociete(idSociete);
        this.adresse = adresse;
        this.nomImmeuble = nomImmeuble;
    }
    public int getIdImmeuble() {
        return idImmeuble;
    }

    public void setIdImmeuble(int idImmeuble) {
        this.idImmeuble = idImmeuble;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomImmeuble() {
        return nomImmeuble;
    }

    public void setNomImmeuble(String nomImmeuble) {
        this.nomImmeuble = nomImmeuble;
    }

    @Override
    public Immeuble creteImmeuble(Immeuble immeuble) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into immeuble (IDSOCIETE,ADRESSE,NOMIMMEUBLE)" +
                "values('"+immeuble.getIdSociete()+"','"+immeuble.getAdresse()+"','"+immeuble.getNomImmeuble()+"')";
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
    public Immeuble updateImmeuble(Immeuble immeuble) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update immeuble set"
                +"`IDSOCIETE`=?,"
                +"`ADRESSE`=?,"
                +"`NOMIMMEUBLE`=? where IDIMMEUBLE ='"+2+"'";
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,1);
            prepare.setString(2,immeuble.getAdresse());
            prepare.setString(3,immeuble.getNomImmeuble());
            prepare.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Immeuble deleteImmeuble(Immeuble immeuble) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from immeuble where IDIMMEUBLE = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("l'immeuble "+immeuble.nomImmeuble+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Immeuble getImmeuble(int idImmeuble) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from immeuble where IDIMMEUBLE = '"+idImmeuble+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("l'immeuble selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOMIMMEUBLE"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }
}
