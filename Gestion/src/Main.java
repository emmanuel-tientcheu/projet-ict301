import config.*;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        /*System.out.println("Hello world!");
        Directeur directeur = new Directeur(Directeur.getAll()+1,1,"emmanuel21v");
        directeur.createDirecteur(directeur);
        directeur.deleteDirecteur(directeur);
        directeur.getDirecteur(3);*/
        /*Visiter visiter = new Visiter(1,1,new Date(2023-01-03),"tres propre",Visiter.getAll()+1);
        visiter.creationPromesse();*/
        Promesse promesse = new Promesse(Promesse.getAll()+1,1,1,1,1,0,0,new Date(2023-01-03),300,35);
      //  promesse.createPromesse(promesse);
        promesse.updatePromesse(promesse);
        Visiter visite = null;
       // System.out.println("id"+Visiter.getAll());
    }
}