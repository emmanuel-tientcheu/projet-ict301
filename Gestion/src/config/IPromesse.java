package config;

public interface IPromesse {
    public Promesse createPromesse(Promesse promesse);
    public Promesse updatePromesse(Promesse promesse);
    public Promesse deletePromesse(Promesse promesse);
    public Promesse getPromesse(int idPromesse);
}
