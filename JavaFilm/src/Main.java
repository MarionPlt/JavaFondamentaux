// EPSI B3 Groupe 1 : Eric ENIONA, Michel GUERIN, Marion PLAYOUT, Gabriel QUESNOT

import java.util.*;

public class Main {


    static List<Film> filmList = new ArrayList<Film>();
    static List<Client> clientList = new ArrayList<Client>();
    public static String newLine = System.getProperty("line.separator");



    public static void filmDataBase() {
        Film film1 = new Film("Die Hard", "Bruce Willis", "1986", "Jean Valjean", "K7", false);
        Film film2 = new Film("Die Hard2", "Bruce Willis", "1994", "Jean Valjean", "K7", false);
        Film film3 = new Film("Die Hard3", "Bruce Willis", "1999", "Jean Valjean", "DVD", false);
        Film film4 = new Film("Die Hard4", "Bruce Willis", "2007", "Jean Valjean", "Blue-ray", false);
        Film film5 = new Film("Die Hard5", "Bruce Willis", "2016", "Jean Valjean", "USB", false);

        filmList.add(film1);
        filmList.add(film2);
        filmList.add(film3);
        filmList.add(film4);
        filmList.add(film5);
    }

    public static boolean choixRetour(Scanner sc) {
        boolean stop = false;
        while (!stop){
            System.out.println(newLine + "Voulez vous retourner à l'accueil ? (y/n)");
            String retour = sc.nextLine();
            retour = retour.toLowerCase();
            switch(retour) {
                case "y" :
                case "yes" :
                case "o" :
                case "oui" :
                    return true;
                case "n" :
                case "no" :
                case "non" :
                    return false;
                default :
                    break;
            }
        }
        return false;
    }

    public static void accueil(Scanner sc, Client client1) {
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
                System.out.println("5 - Supprimer un film");
                System.out.println("6 - Accéder au compte client" + newLine);

                choix = sc.nextInt();
                sc.nextLine();
                switch (choix) {
                    case 1:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Veuillez ajouter un film en remplissant les champs suivants <---" + ConsoleColors.RESET);
                        System.out.println(newLine + "Entrer un titre : ");
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

                        System.out.println(newLine + ConsoleColors.GREEN + "---> Votre film a bien été ajouté <---" + ConsoleColors.RESET + newLine);
                        break;
                    case 2:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Veuillez saisir le titre du film recherché <---" + ConsoleColors.RESET);
                        System.out.println(newLine + "Entrer un titre : ");
                        Film.printFilmByName(filmList, sc);
                        break;
                    case 3:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Voici la liste des films présent dans notre vidéothèque <---" + ConsoleColors.RESET + newLine);
                        Film.printFilmByRent(filmList);
                        break;
                    case 4:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Voici la liste des films triés par support <---" + ConsoleColors.RESET + newLine);
                        Film.printFilmBySupport(filmList);
                        break;
                    case 5:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Veuillez supprimer un film en remplissant le champs suivant <---" + ConsoleColors.RESET + newLine);
                        System.out.println(newLine + "Entrer un titre : ");
                        String filmToRemoved = sc.nextLine();
                        Film.removeFromList(filmToRemoved, filmList);
                        break;
                    case 6:
                        System.out.println(newLine + ConsoleColors.BOLD + "---> Voici les options concernant votre compte client <---" + ConsoleColors.RESET + newLine);

                        client1.compteClient(Film.getFilmNotRented(filmList), sc);
                        break;
                    default :
                        System.out.println(ConsoleColors.RED + "---> Veuillez saisir un nombre valable <---" + ConsoleColors.RESET + newLine);
                        break;


                }
                connected = choixRetour(sc);
            }
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "---> Veuillez saisir un nombre valable <---" + ConsoleColors.RESET + newLine);
        }
    }


    public static void main(String[] args) {
        System.out.println("################################################################################################");
        System.out.println("     ___       ___       ___       ___            ___       ___       ___       ___       ___   ");
        System.out.println("    /\\  \\     /\\  \\     /\\__\\     /\\__\\          /\\__\\     /\\  \\     /\\__\\     /\\  \\     /\\  \\  ");
        System.out.println("   /::\\  \\   _\\:\\  \\   /:/  /    /::L_L_        /::L_L_   /::\\  \\   /:| _|_   _\\:\\  \\   /::\\  \\ ");
        System.out.println("  /::\\:\\__\\ /\\/::\\__\\ /:/__/    /:/L:\\__\\      /:/L:\\__\\ /::\\:\\__\\ /::|/\\__\\ /\\/::\\__\\ /::\\:\\__\\");
        System.out.println("  \\/\\:\\/__/ \\::/\\/__/ \\:\\  \\    \\/_/:/  /      \\/_/:/  / \\/\\::/  / \\/|::/  / \\::/\\/__/ \\/\\::/  /");
        System.out.println("     \\/__/   \\:\\__\\    \\:\\__\\     /:/  /         /:/  /    /:/  /    |:/  /   \\:\\__\\     /:/  / ");
        System.out.println("              \\/__/     \\/__/     \\/__/          \\/__/     \\/__/     \\/__/     \\/__/     \\/__/  ");
        System.out.println(newLine + "################################################################################################");
        System.out.println(newLine + ConsoleColors.BOLD + "------------------------> FILM MANIA | Bienvenue dans votre vidéothèque <-----------------------" + ConsoleColors.RESET);
        Scanner sc = new Scanner(System.in);
        filmDataBase();
        System.out.println(newLine + ConsoleColors.BOLD + "---> Veuillez créer votre profil utilisateur <---" + ConsoleColors.RESET);
        Client client1 = Client.newClient(clientList, sc);
        accueil(sc, client1);
        sc.close();

    }
}