package com.company.model;

import java.util.Objects;

public class Bilet_trimetere {

    private int id;
    private int id_pacient;
    private String motiv;
    private String specialitate;

    public Bilet_trimetere(){}

    public Bilet_trimetere(int id, int id_pacient, String motiv, String specialitate) {
        this.id = id;
        this.id_pacient = id_pacient;
        this.motiv = motiv;
        this.specialitate = specialitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(int id_pacient) {
        this.id_pacient = id_pacient;
    }

    public String getMotiv() {
        return motiv;
    }

    public void setMotiv(String motiv) {
        this.motiv = motiv;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    @Override
    public String toString() {
        return "Bilet_trimetere{" +
                "id=" + id +
                ", id_pacient=" + id_pacient +
                ", motiv='" + motiv + '\'' +
                ", specialitate='" + specialitate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilet_trimetere that = (Bilet_trimetere) o;
        return id == that.id && id_pacient == that.id_pacient && motiv.equals(that.motiv) && specialitate.equals(that.specialitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_pacient, motiv, specialitate);
    }
}
