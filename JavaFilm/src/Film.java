import java.util.*;

public class Film {

    String movieName;
    String firstActor;
    String movieYear;
    String movieRealisator;
    String movieSupport;
    Boolean isRented;

    Film(String movieName, String firstActor, String movieYear, String movieRealisator, String movieSupport, Boolean isRented) {

        this.movieName = movieName;
        this.firstActor = firstActor;
        this.movieYear = movieYear;
        this.movieRealisator = movieRealisator;
        this.movieSupport = movieSupport;
        this.isRented = isRented;
    }

    public String toString() {
        String nom = movieName + ", " + firstActor + ", " + movieYear + ", " + movieRealisator + ", " + movieSupport + ", " + (isRented ? "Loué" : "Disponible");
        return nom;
    }

    public static void printFilmByName(List<Film> filmList, Scanner sc) {
        List<Film> resList = new ArrayList<Film>();

        String filmToSearch = sc.nextLine();

        for (int i = 0; i < filmList.size() - 1; i++){
            if (filmList.get(i).movieName.contains(filmToSearch)){
                resList.add(filmList.get(i));
            }
        }
        if (resList.size() > 0) {
            System.out.println(Main.newLine + ConsoleColors.GREEN + "---> Une correspondance a été trouvé pour la recherche \"" + filmToSearch + "\" <---" + ConsoleColors.RESET + Main.newLine);
            printListFilm(resList);
        } else {
            System.out.println(Main.newLine + ConsoleColors.RED + "---> Aucune correspondance n'a été trouvé pour la recherche \"" + filmToSearch + "\" <---" + ConsoleColors.RESET + Main.newLine);
        }

    }

    public static void printFilmBySupport(List<Film> filmList){
        List<Film> kSevenList = new ArrayList<Film>();
        List<Film> usbList = new ArrayList<Film>();
        List<Film> blueRayList = new ArrayList<Film>();
        List<Film> dvdList = new ArrayList<Film>();

        for (int i = 0; i < filmList.size() - 1; i++){
            switch(filmList.get(i).movieSupport) {
                case "K7":
                    kSevenList.add(filmList.get(i));
                    break;
                case "clé USB":
                    usbList.add(filmList.get(i));
                    break;
                case "Blue-ray":
                    blueRayList.add(filmList.get(i));
                    break;
                case "DVD":
                    dvdList.add(filmList.get(i));
                    break;
            }
        }
        System.out.println(ConsoleColors.BOLD + "K7" + ConsoleColors.RESET);
        printListFilm(kSevenList, "   ");
        System.out.println(ConsoleColors.BOLD + "\nclé USB" + ConsoleColors.RESET);
        printListFilm(usbList, "   ");
        System.out.println(ConsoleColors.BOLD + "\nBlue-ray" + ConsoleColors.RESET);
        printListFilm(blueRayList, "   ");
        System.out.println(ConsoleColors.BOLD + "\nDVD" + ConsoleColors.RESET);
        printListFilm(dvdList, "   ");
    }

    public static void printFilmByRent(List<Film> filmList){
        List<Film> rented = new ArrayList<Film>();
        List<Film> notRented = new ArrayList<Film>();

        for (int i = 0; i < filmList.size() - 1; i++){
            if(filmList.get(i).isRented){
                rented.add(filmList.get(i));
            } else {
                notRented.add(filmList.get(i));
            }
        }
        printListFilm(rented, "   ");
        printListFilm(notRented, "   ");
    }


    public static void printListFilm(List<Film> filmList, String before) {
        for (int i = 0; i < filmList.size(); i++) {
            System.out.println(before + filmList.get(i).toString() + "\n");
        }
    }

    public static void printListFilm(List<Film> filmList) {
        for (int i = 0; i < filmList.size(); i++) {
            System.out.println(filmList.get(i).toString() + "\n");
        }
    }


    public static void printListFilm(List<Film> filmList, Boolean showIndex) {
        if (showIndex == true){
            for (int i = 0; i < filmList.size(); i++) {
                System.out.println(i +") " +  filmList.get(i).toString() + "\n");
            }
        }

    }


    public static List<Film> getFilmNotRented(List<Film> filmList){
        List<Film> notRented = new ArrayList<Film>();

        for (int i = 0; i < filmList.size() - 1; i++){
            if(filmList.get(i).isRented == false){
                notRented.add(filmList.get(i));
            }
        }
        return notRented;
    }

    public static void removeFromList(String movieName, List<Film> filmList) {

        Boolean isMovieBeenDeleted = false;

        for (Iterator<Film> iterator = filmList.iterator(); iterator.hasNext(); ) {
            Film nextMovieName = iterator.next();
            if (movieName.equals(nextMovieName.movieName)) {
                iterator.remove();
                isMovieBeenDeleted = true;
            }
        }

        if (isMovieBeenDeleted) {
            System.out.println(Main.newLine + ConsoleColors.GREEN + "---> Le film a bien été supprimé. <---" + ConsoleColors.RESET + Main.newLine);
        } else {
            System.out.println(Main.newLine + ConsoleColors.RED + "---> Ce titre n'existe pas dans notre base de donnée. <---" + ConsoleColors.RESET + Main.newLine);
        }

    }

    public static void rentedByClient(Film filmLoue, Client client) {
        List<Film> clientRentFile = new ArrayList<Film>();
        clientRentFile.add(filmLoue);
        filmLoue.isRented = true;
    }
}