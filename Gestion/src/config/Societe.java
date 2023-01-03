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
        return null;
    }

    @Override
    public Societe updateSociete(Societe societe) {
        return null;
    }

    @Override
    public Societe deleteSociete(Societe societe) {
        return null;
    }

    @Override
    public Societe getSocieteById(int idSociete) {
        return null;
    }

}
