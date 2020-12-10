import java.util.*;

public class Client {

    String nom;
    String prenom;
    String mail;
    static List<Film> listFilmClient;

    Client(String prenom, String nom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.listFilmClient = new ArrayList<Film>();
    }
    public String nameToString() {
        String affichageNom = prenom + " " + nom;
        return affichageNom;
    }
    public String mailToString() {
        String affichageMail = mail ;
        return affichageMail;
    }

    public static Client newClient(List<Client> listeClient, Scanner sc) {

        System.out.println(Main.newLine + "Veuillez saisir votre prénom : ");
        String newPrenom = sc.nextLine();
        System.out.println(Main.newLine + "Veuillez saisir votre nom : ");
        String newNom = sc.nextLine();
        System.out.println(Main.newLine + "Veuillez saisir votre adresse mail : ");
        String newMail = sc.nextLine();
        Client newClient = new Client(newPrenom, newNom, newMail);
        listeClient.add(newClient);
        System.out.println(Main.newLine + ConsoleColors.GREEN + "---> Votre profil a bien été enregistré. <---" + ConsoleColors.RESET);
        System.out.println(Main.newLine + "Bienvenue, " + newClient.nameToString() + ". Vous êtes connecté avec l'adresse mail suivante : " + newClient.mailToString() + ".");
        System.out.println(Main.newLine + "Vous pouvez maintenant accèder à nos services. Bonne visite chez Film Mania !" + Main.newLine);
        return newClient;

    }

    public  void compteClient(List<Film> filmList, Scanner sc) {

        int choix = 0;
        System.out.println("1 - Louer un film" + Main.newLine);
        System.out.println("2 - Affichez vos films loué");
        choix = sc.nextInt();
        sc.nextLine();
        switch (choix) {
            case 1:
                System.out.println(ConsoleColors.RED + "---> Veuillez choisir votre film <---" + ConsoleColors.RESET + Main.newLine);
                Film.printListFilm(filmList, true); // afficher la liste totale des films pour qu'il fasse son choix
                int choixFilm = sc.nextInt();
                sc.nextLine();
                Film film = filmList.get(choixFilm);
                film.isRented= true;
                listFilmClient.add(film);

                System.out.println(Main.newLine + ConsoleColors.GREEN + "---> Vous avez loué " + filmList.get(choixFilm).movieName + " <---" + ConsoleColors.RESET + Main.newLine);

                break;
            case 2:
                System.out.println(ConsoleColors.RED + "---> Voici les films que vous avez loué <---" + ConsoleColors.RESET + Main.newLine);
                Film.printListFilm(listFilmClient);
                break;
            default :
                System.out.println(ConsoleColors.RED + "---> Retour à l'accueil <---" + ConsoleColors.RESET + Main.newLine);
                break;

        }
    }
}