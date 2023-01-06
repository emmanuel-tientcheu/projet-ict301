package com.example.kimmo;

import java.sql.*;

public class Promesse implements  IPromesse {
    private int idPromesse;
    private int idAppartement;
    private int idClient;
    private int idAvocat;
    private int idDirecteur;
    private int statut;
    private int isSigner;
    private Date dateSignature;
    private float prix_vente;
    private float avance;

    public Promesse(int idPromesse , int idAppartement , int idClient , int idAvocat , int idDirecteur , int statut , int isSigner ,Date dateSignature,float prix_vente ,float avance){
        this.idPromesse = idPromesse;
        this.idAppartement = idAppartement;
        this.idClient = idClient;
        this.idAvocat = idAvocat;
        this.idDirecteur = idDirecteur;
        this.statut = statut;
        this.isSigner = isSigner;
        this.dateSignature = dateSignature;
        this.prix_vente = prix_vente;
        this.avance = avance;
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

    public int isStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int isSigner() {
        return isSigner;
    }

    public void setSigner(int signer) {
        isSigner = signer;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }
    public float getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    public float getAvance() {
        return avance;
    }

    public void setAvance(float avance) {
        this.avance = avance;
    }

    @Override
    public Promesse createPromesse(Promesse promesse) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into promesse (IDAPPARTEMENT,IDCLIENT,IDAVOCAT,IDDIRECTEUR,STATUT,ISSIGNER,DATESIGNATURE,IDPROMESSE,PRIX_VENTE,AVANCE)" +
                "values('"+promesse.idAppartement+"','"+ promesse.idClient+"','"+ promesse.idAvocat+"','"+ promesse.idDirecteur+"','"+1+"','"+0+"','"+ promesse.dateSignature+"','"+ promesse.idPromesse+"','"+ promesse.prix_vente+"','"+ promesse.avance+"')";
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
                +"`DATESIGNATURE`=?,"
                +"`PRIX_VENTE`=?,"
                +"`AVANCE`=? where IDPROMESSE ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,promesse.getIdAppartement());
            prepare.setInt(2,promesse.getIdClient());
            prepare.setInt(3,promesse.getIdAvocat());
            prepare.setInt(4,promesse.getIdDirecteur());
            prepare.setInt(5,promesse.statut);
            prepare.setInt(6,promesse.isSigner);
            prepare.setDate(7,(java.sql.Date)promesse.dateSignature);
            prepare.setFloat(8,promesse.getPrix_vente());
            prepare.setFloat(9,promesse.getAvance());
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

    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from promesse";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la promesse selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDPROMESSE"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDPROMESSE");

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

    public static void creationDesistement(Promesse promesse,int numero,String cause){
        promesse.isSigner = 0 ;
        promesse.updatePromesse(promesse);
        int id = Desistement.getAll()+1;
        Desistement desistement = new Desistement(id,promesse.getIdAppartement(),promesse.getIdClient(),numero,new Date(2023-01-03),cause,promesse.isSigner,promesse.getIdPromesse(),promesse.getIdDirecteur(),promesse.getIdAvocat());
        desistement.createDesistement(desistement);
    }
}
