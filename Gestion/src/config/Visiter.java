package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Visiter  implements  IVisiter{
    private int idAppartement;
    private int idClient;
    private Date dateVisite;
    private String remarques;

    public Visiter(int idAppartement , int idClient , Date dateVisite , String remarques){
        this.idAppartement = idAppartement;
        this.idClient = idClient;
        this.dateVisite = dateVisite;
        this.remarques = remarques;
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
        String sql = "insert into visiter (IDAPPARTEMENT,IDCLIENT,DATEVISITE)" +
                "values('"+visiter.getIdAppartement()+"','"+visiter.getIdClient()+"',,'"+visiter.getDateVisite()+"')";
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
                +"`DATEVISITE`=? where IDVISITER ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,visiter.getIdAppartement());
            prepare.setInt(2,visiter.getIdClient());
            prepare.setDate(3, (java.sql.Date) visiter.getDateVisite());
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
}
