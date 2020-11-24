import java.util.*;

public class Main {
    public static void accueil() {
        Scanner sc = new Scanner (System.in);
        int choix = 0;

        try {
            System.out.println("Que voulez vous faire ? Saisissez le numéro adéquat");
            System.out.println("1 - Ajouter un film");
            System.out.println("2 - Rechercher un film");
            System.out.println("3 - Afficher la liste des films disponibles et des films loués");
            System.out.println("4 - Afficher la liste des films par support");
            System.out.println("5 - Supprimer un film");

            choix = sc.nextInt();

            switch(choix) {
                case 1 :
                    // fonction ajout
                    break;
                case 2 :
                    // fonction recherche
                    break;
                case 3 :
                    // fonction aficha
                    break;
                case 4 :
                    // fonction aficha
                    break;
                case 5 :
                    // fonction suppresio
                    break;
                default :
                    System.out.println("Veuillez saisir un nombre valable");
                    accueil();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Veuillez saisir un nombre valable");
            accueil();
        }
    }

    public static void main(String[] arg) {
        System.out.println("Bonjour et bienvenu chez Film Mania !");
        System.out.println();
       // accueil();
        List<Film> filmList = new ArrayList<Film>();
        Film test = new Film("Die Hard", "Bruce Willis", "1986", "Jean Valjean", "K7");
        Film test2 = new Film("Die Hard 2", "Bruce Willis", "?", "Jean Valjean", "K7");
        filmList.add(test);
        Film.printListFilm(filmList);
        filmList.add(test2);
        Film.printListFilm(filmList);

    }
}
