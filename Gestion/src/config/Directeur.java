package config;
import java.sql.*;
public class Directeur implements IDirecteur {
    public int idDirecteur;
    private int idSociete;
    public String nomDirecteur;

    public Directeur(int idDirecteur , int idSociete , String nomDirecteur){
        this.idDirecteur = idDirecteur ;
        this.idSociete = idSociete;
        this.nomDirecteur = nomDirecteur ;
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public int getIdDirecteur(){
        return this.idDirecteur;
    }

    public void setIdDirecteur(int idDirecteur){
        this.idDirecteur = idDirecteur ;
    }

    public String getNomDirecteur(){
        return this.nomDirecteur;
    }

    public void setNomDirecteur(String nomDirecteur){
        this.nomDirecteur = nomDirecteur ;
    }

    @Override
    public Directeur createDirecteur(Directeur directeur) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into directeur (IDSOCIETE,NOMDIRECTEUR)" +
                     "values('"+directeur.getIdSociete()+"','"+directeur.getNomDirecteur()+"')";
        /*String sql1 = "INSERT INTO directeur"
                      +"`IDDIRECTEUR`=?,"
                      +"`IDSOCIETE`=?,"
                      +"`NOMDIRECTEUR`=?";*/
        try {
            Statement statement = connectDB.createStatement();
             statement.executeUpdate(sql);
            /*PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,1);
            prepare.setInt(2,1);
            prepare.setString(3,"emmanuel");
            prepare.execute();*/
            
            System.out.println("creation reussie");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Directeur updateDirecteur(Directeur directeur) {
        return null;
    }

    @Override
    public Directeur deleteDirecteur(Directeur directeur) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from directeur where IDDIRECTEUR = '"+directeur.idDirecteur+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("le directeur "+directeur.nomDirecteur+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Directeur getDirecteur(int idDirecteur) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from directeur where IDDIRECTEUR = '"+idDirecteur+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet.getString("NOMDIRECTEUR"));
        }catch (Exception e){
           e.printStackTrace();
        }

        return null;
    }
}
