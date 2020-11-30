import java.util.*;

public class Client {

    String nom;
    String prenom;
    String mail;
    int filmLoue;

    Client(String prenom, String nom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }
    public String nameToString() {
        String affichageNom = prenom + " " + nom;
        return affichageNom;
    }
    public String mailToString() {
        String affichageMail = mail ;
        return affichageMail;
    }

    public static void newClient(List<Client> listeClient, Scanner sc) {

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
    }
}