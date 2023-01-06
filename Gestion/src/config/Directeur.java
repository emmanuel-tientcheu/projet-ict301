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
        String sql = "insert into directeur (IDDIRECTEUR,IDSOCIETE,NOMDIRECTEUR)" +
                     "values('"+directeur.getIdDirecteur()+"','"+directeur.getIdSociete()+"','"+directeur.getNomDirecteur()+"')";
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
    public Directeur updateDirecteur(Directeur directeur) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update directeur set"
                +"`IDSOCIETE`=?,"
                +"`NOMDIRECTEUR`=? where IDDIRECTEUR ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,1);
            prepare.setString(2,directeur.getNomDirecteur());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Directeur deleteDirecteur(Directeur directeur) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from directeur where IDDIRECTEUR = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
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
            System.out.print("le directeur selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOMDIRECTEUR"));
            }
        }catch (Exception e){
           e.printStackTrace();
        }

        return null;
    }
    public static int getAll(){
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from directeur";
        String verification = "";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le directeur selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("IDDIRECTEUR"));
               // System.out.println(resultSet.getString("NOMDIRECTEUR").getClass().getSimpleName());
                verification = resultSet.getString("IDDIRECTEUR");

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
