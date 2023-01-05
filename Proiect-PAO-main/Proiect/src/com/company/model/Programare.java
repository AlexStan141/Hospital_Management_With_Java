package com.company.model;

import java.util.Objects;

public class Programare {

    private int id;
    private String data;
    private int id_pacient;
    private int id_doctor;
    private int id_bilet_trimetere;

    public Programare(){}

    public Programare(int id, String data, int id_pacient, int id_doctor, int id_bilet_trimetere) {
        this.id = id;
        this.data = data;
        this.id_pacient = id_pacient;
        this.id_doctor = id_doctor;
        this.id_bilet_trimetere = id_bilet_trimetere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(int id_pacient) {
        this.id_pacient = id_pacient;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_bilet_trimetere() {
        return id_bilet_trimetere;
    }

    public void setId_bilet_trimetere(int id_bilet_trimetere) {
        this.id_bilet_trimetere = id_bilet_trimetere;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", id_pacient=" + id_pacient +
                ", id_doctor=" + id_doctor +
                ", id_bilet_trimetere=" + id_bilet_trimetere +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programare that = (Programare) o;
        return id == that.id && id_pacient == that.id_pacient && id_doctor == that.id_doctor && id_bilet_trimetere == that.id_bilet_trimetere && data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, id_pacient, id_doctor, id_bilet_trimetere);
    }
}
