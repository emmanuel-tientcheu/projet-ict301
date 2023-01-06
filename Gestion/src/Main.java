import config.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        /*System.out.println("Hello world!");
        Directeur directeur = new Directeur(Directeur.getAll()+1,1,"emmanuel21v");
        directeur.createDirecteur(directeur);
        directeur.deleteDirecteur(directeur);
        directeur.getDirecteur(3);*/
        /*Visiter visiter = new Visiter(1,1,new Date(2023-01-03),"tres propre",Visiter.getAll()+1);
        visiter.creationPromesse();*/
      //  Promesse promesse = new Promesse(Promesse.getAll()+1,1,1,1,1,0,0,new Date(2023-01-03),300,35);
      //  promesse.createPromesse(promesse);
      /*  promesse.updatePromesse(promesse);
        Visiter visite = null;*/
       // System.out.println("id"+Visiter.getAll());
     /*   Desistement desistement = new Desistement(Desistement.getAll()+1,1,1,23,new Date(23-01-03),"tres propre",0,1,1,1);
        desistement.updateDesistement(desistement);*/
       // Desistement.getAll();
      //  DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        //obtenir la date courante
       /* Date date = new Date();
        System.out.println(format.format(date));*/

        //obtenir l'heure courante
       /* Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));*/

        LocalDate todaysDate = LocalDate.now();
        System.out.println(todaysDate);

    }
}