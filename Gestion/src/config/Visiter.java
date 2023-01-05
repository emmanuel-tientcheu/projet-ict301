package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class Visiter  implements  IVisiter{
    private int idAppartement;
    private int idClient;
    private Date dateVisite;
    private String remarques;
    private int idVisiter;

    public Visiter(int idAppartement , int idClient , Date dateVisite , String remarques, int idVisiter){
        this.idAppartement = idAppartement;
        this.idClient = idClient;
        this.dateVisite = dateVisite;
        this.remarques = remarques;
        this.idVisiter=idVisiter;
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

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Override
    public Visiter createVisiter(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into visiter (IDVISITER,IDAPPARTEMENT,IDCLIENT,DATEVISITE,REMARQUES)" +
                "values('"+visiter.getIdVisiter()+"','"+visiter.getIdAppartement()+"','"+visiter.getIdClient()+"','"+(java.sql.Date)visiter.getDateVisite()+"','"+visiter.getRemarques()+"')";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("creation reussie de la visite");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Visiter updateVisiter(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update visiter set"
                +"`IDAPPARTEMENT`=?,"
                +"`IDCLIENT`=?,"
                +"`DATEVISITE`=?,"
                +"`REMARQUES`=? where IDVISITER ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,visiter.getIdAppartement());
            prepare.setInt(2,visiter.getIdClient());
            prepare.setDate(3, (java.sql.Date) visiter.getDateVisite());
            prepare.setString(4,visiter.getRemarques());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Visiter deleteVisiter(Visiter visiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from visiter where IDVISITER = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("la visite "+ "a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Visiter getVisiter(Visiter idVisiter) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from visiter where IDVISITER = '"+idVisiter+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la visite conserne le departement ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDAPPARTEMENT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from visiter";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("la visite selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDVISITER"));
                // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDVISITER");

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

    public int getIdVisiter() {
        return idVisiter;
    }

    public void setIdVisiter(int idVisiter) {
        this.idVisiter = idVisiter;
    }

    public static void creationPromesse(Visiter visiter , int idAvocat){
        Promesse promesse = new Promesse(1,visiter.getIdAppartement(),visiter.getIdClient(),idAvocat,1,0,0,visiter.getDateVisite(),200,25);
        if((promesse.getPrix_vente()*20)/100 < promesse.getAvance()){
            System.out.println("impossible de cree cette promesse car l'avance est insuffisant");
        }else{
            System.out.println("la promesse seras cree");
            promesse.createPromesse(promesse);
        }
    }
}
