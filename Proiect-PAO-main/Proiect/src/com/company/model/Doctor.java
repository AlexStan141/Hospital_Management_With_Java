package com.company.model;

import java.util.Objects;

public class Doctor extends Persoana implements Comparable<Doctor>{

    private String specializare;

    public Doctor(){};

    public Doctor(int id, String nume, String prenume, int varsta, String specializare) {
        super(id, nume, prenume, varsta);
        this.specializare = specializare;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(specializare, doctor.specializare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specializare);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specializare='" + specializare + '\'' +
                ", id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    public int compareTo(Doctor doctor){
        return this.nume.compareTo(doctor.nume);
    }

}
