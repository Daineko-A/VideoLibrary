package entitys;

import java.time.LocalDate;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class Review {
    private long id;
    private String text;
    private LocalDate date;
    private long stars;
    private User user;
    private Movie movie;

    public Review(long id, String text, LocalDate date, long stars, User user, Movie movie) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.stars = stars;
        this.user = user;
        this.movie = movie;
    }

    public Review(String text, LocalDate date, long stars, User user, Movie movie) {
        this.text = text;
        this.date = date;
        this.stars = stars;
        this.user = user;
        this.movie = movie;
    }

    public Review(String text, long stars, User user, Movie movie) {
        this.text = text;
        this.stars = stars;
        this.user = user;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", stars=" + stars +
                ", user=" + user +
                ", movie=" + movie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (stars != review.stars) return false;
        if (!text.equals(review.text)) return false;
        return date.equals(review.date);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (int) (stars ^ (stars >>> 32));
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
