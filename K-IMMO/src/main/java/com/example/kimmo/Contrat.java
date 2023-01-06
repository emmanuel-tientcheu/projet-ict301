package com.example.kimmo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Contrat implements IContrat{
    private int idContrat;
    private int idDirecteur;
    private int idClient;
    private int idAppartement;
    private String typePaiement;
    private Date dateSignature;
    public int idAvocat;

    public Contrat(int idContrat , int idDirecteur,int idClient,int idAppartement , String typePaiement,Date dateSignature,int idAvocat){
        this.idContrat = idContrat;
        this.idDirecteur = idDirecteur;
        this.idClient = idClient;
        this.idAppartement = idAppartement;
        this.typePaiement = typePaiement;
        this.dateSignature = dateSignature;
        this.idAvocat = idAvocat;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
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

    public int getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }
    public int getIdAvocat(){return  idAvocat;}
    public void setIdAvocat(int idAvocat){ this.idAvocat = idAvocat; };

    @Override
    public Contrat createContrat(Contrat contrat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into contrat (IDDIRECTEUR,IDCLIENT,IDAPPARTEMENT,TYPEPAIEMENT,DATESIGNATURE,IDAVOCAT)" +
                "values('"+contrat.getIdDirecteur()+"','"+contrat.getIdClient()+"','"+contrat.getIdAppartement()+"','"+contrat.getTypePaiement()+"','"+contrat.getDateSignature()+"','"+contrat.getIdAvocat()+"')";
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
    public Contrat updateContrat(Contrat contrat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update contrat set"
                +"`IDDIRECTEUR`=?,"
                +"`IDCLIENT`=?,"
                +"`IDAPPARTEMENT`=?,"
                +"`TYPEPAIEMENT`=?,"
                +"`DATESIGNATURE`=?,"
                +"`IDAVOCAT`=? where IDCONTRAT ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,contrat.getIdDirecteur());
            prepare.setInt(2,contrat.getIdClient());
            prepare.setInt(3,contrat.getIdAppartement());
            prepare.setString(4,contrat.getTypePaiement());
            prepare.setDate(5,(java.sql.Date) contrat.getDateSignature());
            prepare.setInt(6,contrat.getIdAvocat());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contrat deleteContrat(Contrat contrat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from contrat where IDCONTRAT = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le directeur "+contrat.idDirecteur+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contrat getContrat(int idContrat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from contrat where IDCONTRAT = '"+idContrat+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le contrat selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("TYPEPAIEMENT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Contrat> getContratTable(){
        ArrayList<Contrat> contratTable = new ArrayList<>();
        int compteur = 1;
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from contrat";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                contratTable.add( new Contrat(resultSet.getInt("IDCONTRAT"), resultSet.getInt("IDDIRECTEUR"), resultSet.getInt("IDCLIENT"), resultSet.getInt("IDAPPARTEMENT"),resultSet.getString("TYPEPAIEMENT"),resultSet.getDate("DATESIGNATURE"),resultSet.getInt("IDAVOCAT")));
                compteur++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(contratTable.get(0).typePaiement);
        return contratTable ;

    }
}
