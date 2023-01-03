package config;

public interface IDirecteur {
    public Directeur createDirecteur(Directeur directeur);
    public Directeur updateDirecteur(Directeur directeur);
    public Directeur deleteDirecteur(Directeur directeur);
    public Directeur getDirecteur(int idDirecteur);
}
