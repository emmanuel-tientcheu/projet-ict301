package config;

public interface ISociete {
    public Societe createSociete( Societe societe) ;
    public Societe updateSociete( Societe societe) ;

    public Societe deleteSociete( Societe societe) ;

    public Societe getSocieteById(int idSociete) ;


}
