package com.example.kimmo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client implements IClient {
    private int idClient;
    private String numero_cni;
    private String nom;
    private String prenom;
    private String adresseC;
    private String telephone;
    private String profession;

    public Client(int idClient , String numero_cni , String nom , String prenom , String adresseC , String telephone ,String profession){
        this.idClient = idClient;
        this.numero_cni = numero_cni;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseC = adresseC;
        this.telephone = telephone;
        this.profession = profession;
    }
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumero_cni() {
        return numero_cni;
    }

    public void setNumero_cni(String numero_cni) {
        this.numero_cni = numero_cni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseC() {
        return adresseC;
    }

    public void setAdresseC(String adresseC) {
        this.adresseC = adresseC;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public Client createClient(Client client) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into client (IDCLIENT,NUMERO_CNI,NOM,PRENOM,ADRESSEC,TELEPHONE,PROFESSION)" +
                "values('"+client.getIdClient()+"','"+client.getNumero_cni()+"','"+client.getNom()+"',,'"+client.getPrenom()+"','"+client.getAdresseC()+"',,'"+client.getTelephone()+"','"+client.getProfession()+"')";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("client cree avec sucess");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update client set"
                +"`NUMERO_CNI`=?,"
                +"`NOM`=?,"
                +"`PRENOM`=?,"
                +"`ADRESSEC`=?,"
                +"`TELEPHONE`=?,"
                +"`PROFESSION`=? IDCLIENT ='"+2+"'";
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setString(1, client.getNumero_cni());
            prepare.setString(2,client.getNom());
            prepare.setString(3,client.getPrenom());
            prepare.setString(4,client.getAdresseC());
            prepare.setString(5,client.getTelephone());
            prepare.setString(6,client.getProfession());

            prepare.executeUpdate();
            System.out.println("mise a jour reussi");

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Client deleteClient(Client client) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from client where IDCLIENT = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le client "+client.getNom()+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client getClient(int idClient) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from client where IDDIRECTEUR = '"+idClient+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le client selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOM"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
