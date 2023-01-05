package com.company.model;

public class Pacient extends Persoana {

    public Pacient(){};

    public Pacient(int id, String nume, String prenume, int varsta) {
        super(id, nume, prenume, varsta);
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
