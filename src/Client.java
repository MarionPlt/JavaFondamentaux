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
    public String toString() {
        String affichage = prenom + " " + nom + " : " + mail ;
        return affichage;
    }

    public static void newClient(List<Client> listeClient, Scanner sc) {

        System.out.println("Veuillez saisir votre prénom : ");
        String newPrenom = sc.nextLine();
        System.out.println("Veuillez saisir votre nom : ");
        String newNom = sc.nextLine();
        System.out.println("Veuillez saisir votre adresse mail : ");
        String newMail = sc.nextLine();
        Client newClient = new Client(newPrenom, newNom, newMail);
        listeClient.add(newClient);
        System.out.println("Votre profil :"+ newClient.toString() +" a bien été enregistré. Vous pouvez maintenant louer un film. Bonne visite!");
    }
}