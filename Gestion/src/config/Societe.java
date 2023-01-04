package config;
import java.sql.*;
public class Societe implements  ISociete{
    private int idSociete;
    private String nomSociete;

    public Societe(String nomSociete,int idSociete) {
        this.nomSociete = nomSociete;
        this.idSociete = idSociete;

    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    @Override
    public Societe createSociete(Societe societe) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into societe (NOMSOCIETE)" +
                "values('"+societe.getNomSociete()+"')";
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
    public Societe updateSociete(Societe societe) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update societe set"
                +"`NOMSOCIETE`=? where IDSOCIETE ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setString(1,societe.getNomSociete());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Societe deleteSociete(Societe societe) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from societe where IDSOCIETE = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le directeur "+societe.nomSociete+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Societe getSocieteById(int idSociete) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from societe where IDSOCIETE = '"+idSociete+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le directeur selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOMSOCIETE"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
