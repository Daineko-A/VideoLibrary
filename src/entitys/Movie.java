package entitys;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by PloSkiY on 05.04.2017.
 */
public class Movie {
    private long id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String country;
    private String description;
    private List<MovieMember> movieMembers;

    public Movie(long id, String title, LocalDate releaseDate, String description, String genre, String country) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
        this.description = description;
    }

    public Movie(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie(long id, String title, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Movie(long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Movie(long id, String title, LocalDate releaseDate, String genre, String country) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
    }

    public Movie(long id, String title, String genre, String country) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.country = country;
    }

    public Movie(String title, String genre, LocalDate releaseDate, String country, String description) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
        this.description = description;
    }

    public Movie(String title, LocalDate releaseDate, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", movieMembers=" + movieMembers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!title.equals(movie.title)) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (!releaseDate.equals(movie.releaseDate)) return false;
        return country != null ? country.equals(movie.country) : movie.country == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieMember> getMovieMembers() {
        return movieMembers;
    }

    public void setMovieMembers(List<MovieMember> movieMembers) {
        this.movieMembers = movieMembers;
    }
}
