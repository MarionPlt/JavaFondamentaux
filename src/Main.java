import java.util.*;

public class Main {
    /*variables
    get set (private)
    constructeur
    Méthodes*/

    //Arraylist filmList;

    static List<Film> filmList = new ArrayList<Film>();
    static List<Client> clientList = new ArrayList<Client>();
    public static String newLine = System.getProperty("line.separator");

    
    
    public static void filmDataBase() {
        Film test = new Film("Die Hard", "Bruce Willis", "1986", "Jean Valjean", "K7", true);
        Film test2 = new Film("Die Hard2", "Bruce Willis", "1994", "Jean Valjean", "K7", true);
        Film test3 = new Film("Die Hard3", "Bruce Willis", "1999", "Jean Valjean", "DVD", true);
        Film test4 = new Film("Die Hard4", "Bruce Willis", "2007", "Jean Valjean", "Blue-ray", false);
        Film test5 = new Film("Die Hard5", "Bruce Willis", "2016", "Jean Valjean", "USB", false);

        filmList.add(test);
        filmList.add(test2);
        filmList.add(test3);
        filmList.add(test4);
        filmList.add(test5);
    }
    
    public static boolean choixRetour(Scanner sc) {
        boolean stop = false;
        while (!stop){
            System.out.println(newLine + "Voulez vous retourner à l'accueil ? (y/n)");
            String retour = sc.nextLine();
            retour = retour.toLowerCase();
            switch(retour) {
                case "y" :
                    return true;
                case "n" :
                    return false;
                default :
                    break;
            }
        }
        return false;
    }

    public static void accueil(Scanner sc) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        boolean connected = true;

        try {
            while(connected) {
                String titre;
                String acteur;
                String annee;
                String realisateur;
                String support;
                System.out.println("Que voulez vous faire ? Saisissez le numéro adéquat" + newLine);
                System.out.println("1 - Ajouter un film");
                System.out.println("2 - Rechercher un film");
                System.out.println("3 - Afficher la liste des films disponibles et des films loués");
                System.out.println("4 - Afficher la liste des films par support");
                System.out.println("5 - Supprimer un film" + newLine);
    
                choix = sc.nextInt();
                sc.nextLine();
                switch (choix) {
                    case 1:
                        System.out.println("Vous ajoutez un film : ");
                        System.out.println("Entrer un titre : ");
                        titre = sc.nextLine();
                        System.out.println(newLine + "Entrer un acteur : ");
                        acteur = sc.nextLine();
                        System.out.println(newLine + "Entrer une année : ");
                        annee = sc.nextLine();
                        System.out.println(newLine + "Entrer un réalisateur : ");
                        realisateur = sc.nextLine();
                        System.out.println(newLine + "Entrer un support de lecture : ");
                        support = sc.nextLine();
                        
                        filmList.add(new Film(titre, acteur, annee, realisateur, support, false));
                        
                        System.out.println(newLine + "--> Votre film a bien été ajouté <--" + newLine);
                        break;
                    case 2:
                        System.out.println("Vous recherchez un film : ");
                        System.out.println("Entrer un titre : ");
                        titre = sc.nextLine();
                        Film.printFilmByName(titre, filmList);
                        break;
                    case 3:
                        Film.printFilmByRent(filmList);
                        break;
                    case 4:
                        Film.printFilmBySupport(filmList);
                        break;
                    case 5:
                        System.out.println("Veuillez saisir le titre du film à supprimer");
                        String filmToRemoved = sc.nextLine();
                        Film.removeFromList(filmToRemoved, filmList);
                        break;
                    default :
                        System.out.println(ConsoleColors.BOLD + "--> Veuillez saisir un nombre valable <--" + ConsoleColors.RESET + newLine);
                        break;
                    
                    
                }
                connected = choixRetour(sc);
            }
        } catch (Exception e) {
            System.out.println("Veuillez saisir un nombre valable");
        }
    }
    

    public static void main(String[] args) {
        System.out.println("Bonjour et bienvenu chez Film Mania !");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        filmDataBase();
        System.out.println("Veuillez créer votre profil utilisateur : ");
        Client.newClient(clientList, sc);
        accueil(sc);
        sc.close();
      
    }
}