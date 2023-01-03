package config;

public class Directeur implements IDirecteur {
    public int idDirecteur;
    private int idSociete;
    public String nomDirecteur;

    Directeur(int idDirecteur , int idSociete , String nomDirecteur){
        this.idDirecteur = idDirecteur ;
        this.setIdSociete(idDirecteur);
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
        return null;
    }

    @Override
    public Directeur updateDirecteur(Directeur directeur) {
        return null;
    }

    @Override
    public Directeur deleteDirecteur(Directeur directeur) {
        return null;
    }

    @Override
    public Directeur getDirecteur(int idDirecteur) {
        return null;
    }
}
