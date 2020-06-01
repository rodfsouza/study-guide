package problem;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MovieRecommendation {

    static PriorityQueue<Movie> movieFrequency = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.frequency, o1.frequency));
    static Set<Movie> seemMovies = new HashSet<>();

    public static void add(Movie movie) {
        movieFrequency.offer(movie);
        seemMovies.add(movie);
    }

    static class Movie {
        String movieName;
        int frequency;
    }

    public static void main(String... args) {
        Movie movie = new Movie();
        movie.movieName  = "Name";
        movie.frequency++;

        MovieRecommendation.add(movie);
        movie.frequency++;
    }
}
