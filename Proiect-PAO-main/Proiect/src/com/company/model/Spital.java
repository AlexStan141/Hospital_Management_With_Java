package com.company.model;

import java.util.Arrays;
import java.util.Objects;

public class Spital {

    private int id;
    private String judet;
    private String oras;
    private String adresa;
    private int[] id_cabinete;

    public Spital(){}

    public Spital(int id, String judet, String oras, String adresa, int[] id_cabinete) {
        this.id = id;
        this.judet = judet;
        this.oras = oras;
        this.adresa = adresa;
        this.id_cabinete = id_cabinete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int[] getId_cabinete() {
        return id_cabinete;
    }

    public void setId_cabinete(int[] id_cabinete) {
        this.id_cabinete = id_cabinete;
    }

    @Override
    public String toString() {
        return "Spital{" +
                "id=" + id +
                ", judet='" + judet + '\'' +
                ", oras='" + oras + '\'' +
                ", adresa='" + adresa + '\'' +
                ", id_cabinete=" + Arrays.toString(id_cabinete) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spital spital = (Spital) o;
        return id == spital.id && judet.equals(spital.judet) && oras.equals(spital.oras) && adresa.equals(spital.adresa) && Arrays.equals(id_cabinete, spital.id_cabinete);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, judet, oras, adresa);
        result = 31 * result + Arrays.hashCode(id_cabinete);
        return result;
    }
}
