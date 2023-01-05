package com.company.model;

import java.util.Objects;

public class Feedback {

    private int id;
    private int rating;
    private String comentariu;
    private int id_programare;

    public Feedback(){}

    public Feedback(int id, int rating, String comentariu, int id_programare) {
        this.id = id;
        this.rating = rating;
        this.comentariu = comentariu;
        this.id_programare = id_programare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public int getId_programare() {
        return id_programare;
    }

    public void setId_programare(int id_programare) {
        this.id_programare = id_programare;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", rating=" + rating +
                ", comentariu='" + comentariu + '\'' +
                ", id_programare=" + id_programare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id == feedback.id && rating == feedback.rating && id_programare == feedback.id_programare && comentariu.equals(feedback.comentariu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, comentariu, id_programare);
    }
}
