package com.company.model;

import java.util.Arrays;
import java.util.Objects;

public class Cabinet {

    private int id;
    private int[] doctori;

    public Cabinet(){}

    public Cabinet(int id, int[] doctori) {
        this.id = id;
        this.doctori = doctori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getDoctori() {
        return doctori;
    }

    public void setDoctori(int[] doctori) {
        this.doctori = doctori;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "id=" + id +
                ", doctori=" + Arrays.toString(doctori) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cabinet cabinet = (Cabinet) o;
        return id == cabinet.id && Arrays.equals(doctori, cabinet.doctori);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(doctori);
        return result;
    }
}
