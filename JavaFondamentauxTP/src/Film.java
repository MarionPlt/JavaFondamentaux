import java.util.ArrayList;
import java.util.List;

public class Film {
    String movieName;
    String firstActor;
    String movieYear;
    String movieRealisator;
    String movieSupport;

    Film(String movieName, String firstActor, String movieYear, String movieRealisator, String movieSupport) {

        this.movieName = movieName;
        this.firstActor = firstActor;
        this.movieYear = movieYear;
        this.movieRealisator = movieRealisator;
        this.movieSupport = movieSupport;
    }

    public String toString() {
        String nom = movieName + "," + firstActor + "," + movieYear + "," + movieRealisator + "," + movieSupport;
        return nom;
    }

    public void searchFilm(String filmToSearch, List<Film> filmList){
        List<Film> resList = new ArrayList<Film>();
        for (int i = 0; i < filmList.size(); i++){
            if (filmList.get(i).movieName.contains(filmToSearch)){
                resList.add(filmList.get(i));
            }
        }
        printListFilm(resList);
    }


    public static void printListFilm(List<Film> filmList) {
        for (int i = 0; i < filmList.size(); i++) {
            System.out.println(filmList.get(i).toString() + "\n");
        }
    }

}