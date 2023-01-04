package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Promesse implements  IPromesse{
    private int idPromesse;
    private int idAppartement;
    private int idClient;
    private int idAvocat;
    private int idDirecteur;
    private boolean statut;
    private boolean isSigner;
    private Date dateSignature;

    public Promesse(int idPromesse , int idAppartement , int idClient , int idAvocat , int idDirecteur , boolean statut , boolean isSigner ,Date dateSignature){
        this.setIdPromesse(idPromesse);
        this.setIdAppartement(idAppartement);
        this.setIdClient(idClient);
        this.setIdAvocat(idAvocat);
        this.setIdDirecteur(idDirecteur);
        this.setStatut(statut);
        this.setSigner(isSigner);
        this.setDateSignature(dateSignature);
    }

    public int getIdPromesse() {
        return idPromesse;
    }

    public void setIdPromesse(int idPromesse) {
        this.idPromesse = idPromesse;
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

    public int getIdAvocat() {
        return idAvocat;
    }

    public void setIdAvocat(int idAvocat) {
        this.idAvocat = idAvocat;
    }

    public int getIdDirecteur() {
        return idDirecteur;
    }

    public void setIdDirecteur(int idDirecteur) {
        this.idDirecteur = idDirecteur;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public boolean isSigner() {
        return isSigner;
    }

    public void setSigner(boolean signer) {
        isSigner = signer;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    @Override
    public Promesse createPromesse(Promesse promesse) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into promesse (IDAPPARTEMENT,IDCLIENT,IDAVOCAT,IDDIRECTEUR,STATUT,ISSIGNER,DATESIGNATURE)" +
                "values('"+promesse.idAppartement+"','"+ promesse.idClient+"','"+ promesse.idAvocat+"','"+ promesse.idDirecteur+"',,'"+ promesse.statut+"','\"+ promesse.idClient+\"')";
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
    public Promesse updatePromesse(Promesse promesse) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update promesse set"
                +"`IDAPPARTEMENT`=?,"
                +"`IDCLIENT`=?,"
                +"`IDAVOCAT`=?,"
                +"`IDDIRECTEUR`=?,"
                +"`STATUT`=?,"
                +"`ISSIGNER`=?,"
                +"`DATESIGNATURE`=? where IDPROMESSE ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,promesse.getIdAppartement());
            prepare.setInt(2,promesse.getIdClient());
            prepare.setInt(3,promesse.getIdAvocat());
            prepare.setBoolean(4,promesse.statut);
            prepare.setBoolean(5,promesse.isSigner);
            prepare.setDate(6,(java.sql.Date)promesse.dateSignature);

            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Promesse deletePromesse(Promesse promesse) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from promesse where IDPROMESSE = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("la promesse "+promesse.statut+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Promesse getPromesse(int idPromesse) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from promesse where IDPROMESSE = '"+idPromesse+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la promesse selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("STATUT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
