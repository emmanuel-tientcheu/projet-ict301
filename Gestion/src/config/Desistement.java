package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Desistement implements IDesistement {
    private int idDesistement;
    private int idAppartement;
    private int idClient;
    private int numero;
    private Date date;
    private String causes;
    private boolean isValider;

    public Desistement(int idDesistement , int idAppartement, int idClient , int numero , Date date,String causes, boolean isValider){
        this.setIdDesistement(idDesistement);
        this.setIdAppartement(idAppartement);
        this.setIdClient(idClient);
        this.setNumero(numero);
        this.setDate(date);
        this.setCauses(causes);
        this.setValider(isValider);
    }

    public int getIdDesistement() {
        return idDesistement;
    }

    public void setIdDesistement(int idDesistement) {
        this.idDesistement = idDesistement;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public boolean isValider() {
        return isValider;
    }

    public void setValider(boolean valider) {
        isValider = valider;
    }

    @Override
    public Desistement createDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into desistement (IDAPPARTEMENT,IDCLIENT,NUMERO,DATE)" +
                "values('"+desistement.getIdAppartement()+"','"+desistement.getIdClient()+"','"+desistement.getNumero()+"','"+desistement.getDate()+"')";
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
    public Desistement updateDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql1 = "update desistement set"
                +"`IDAPPARTEMENT`=?,"
                +"`IDCLIENT`=?,"
                +"`NUMERO`=?,"
                +"`DATE`=? where IDDESISTEMENT ='"+2+"'";
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql1);
            prepare.setInt(1,desistement.getIdAppartement());
            prepare.setInt(2,desistement.getIdClient());
            prepare.setInt(3,desistement.getNumero());
            prepare.setDate(4,(java.sql.Date)desistement.getDate());
            prepare.executeUpdate();
            System.out.println("mise a jour reussi");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Desistement deleteDesistement(Desistement desistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql ="delete from desistement where IDDESISTEMENT = '"+2+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            System.out.println("le desistement "+desistement.numero+" a ete supprime avec success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Desistement getDesistement(int idDesistement) {
        MyJDBC connectNow = new MyJDBC();
        Connection connectDB = connectNow.getConnection();
        String sql = "select * from desistement where IDDESISTEMENT = '"+idDesistement+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("le desistement selectionne est ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("NUMERO"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
