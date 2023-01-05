package com.example.kimmo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Contrat implements IContrat{
    private int idContrat;
    private int idDirecteur;
    private int idClient;
    private int idAppartement;
    private String typePaiement;
    private Date dateSignature;

    public Contrat(int idContrat , int idDirecteur,int idClient,int idAppartement , String typePaiement,Date dateSignature){
        this.setIdContrat(idContrat);
        this.setIdDirecteur(idDirecteur);
        this.setIdClient(idClient);
        this.setIdAppartement(idAppartement);
        this.setTypePaiement(typePaiement);
        this.setDateSignature(dateSignature);
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

    @Override
    public Contrat createContrat(Contrat contrat) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into contrat (IDDIRECTEUR,IDCLIENT,IDAPPARTEMENT,TYPEPAIEMENT,DATESIGNATURE)" +
                "values('"+contrat.getIdDirecteur()+"','"+contrat.getIdClient()+"','"+contrat.getIdAppartement()+"','"+contrat.getTypePaiement()+"','"+contrat.getDateSignature()+"')";
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
                +"`DATESIGNATURE`=? where IDCONTRAT ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,contrat.getIdDirecteur());
            prepare.setInt(2,contrat.getIdClient());
            prepare.setInt(3,contrat.getIdAppartement());
            prepare.setString(4,contrat.getTypePaiement());
            prepare.setDate(5,(java.sql.Date) contrat.getDateSignature());
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
}
