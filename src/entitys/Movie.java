package entitys;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by PloSkiY on 05.04.2017.
 */
public class Movie {
    private String title;
    private List<MovieMember> movieMembers;
    private String genre;
    private LocalDate releaseDate;
    private String manufacturerCountry;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", movieMembers=" + movieMembers +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", manufacturerCountry='" + manufacturerCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!title.equals(movie.title)) return false;
        if (!genre.equals(movie.genre)) return false;
        if (!releaseDate.equals(movie.releaseDate)) return false;
        return manufacturerCountry.equals(movie.manufacturerCountry);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + manufacturerCountry.hashCode();
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieMember> getMovieMembers() {
        return movieMembers;
    }

    public void setMovieMembers(List<MovieMember> movieMembers) {
        this.movieMembers = movieMembers;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }
}
