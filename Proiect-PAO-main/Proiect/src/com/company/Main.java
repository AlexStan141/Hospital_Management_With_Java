package com.company;

import com.company.model.Programare;
import com.company.model.Bilet_trimetere;
import com.company.model.Pacient;
import com.company.model.Doctor;
import com.company.config.DataSetup;
import com.company.repository.BiletTrimetereRepository;
import com.company.repository.PacientRepository;
import com.company.repository.DoctorRepository;
import com.company.repository.ProgramareRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        DataSetup setUpData = new DataSetup();

        setUpData.setUp();

        System.out.println("0.Iesire");
        System.out.println("1.Afiseaza pacientii");
        System.out.println("2.Adauga pacient");
        System.out.println("3.Actualizeaza nume pacient");
        System.out.println("4.Sterge pacient");
        System.out.println("5.Afiseaza doctorii");
        System.out.println("6.Adauga doctor");
        System.out.println("7.Actualizeaza nume doctor");
        System.out.println("8.Sterge doctor");
        System.out.println("9.Afiseaza biletele de trimetere");
        System.out.println("10.Adauga bilet trimetere");
        System.out.println("11.Actualizeaza motiv bilet trimetere");
        System.out.println("12.Sterge bilet trimetere");
        System.out.println("13.Afiseaza programarile");
        System.out.println("14.Adauga programare");
        System.out.println("15.Actualizeaza data programare");
        System.out.println("16.Sterge programare");
        System.out.println("");
        System.out.println("");
        System.out.println("Introduceti numarul optiunii dorite:");
        Scanner scanner=new Scanner(System.in);
        int optiune=scanner.nextInt();
        while(optiune!=0){
            if(optiune==1){
                setUpData.displayPacient();
            }
            if(optiune==2){
                setUpData.addPacient();
            }
            if(optiune==3){
                System.out.println("Introduceti id-ul pacientului pe care vreti sa il actualizati:");
                int id=scanner.nextInt();
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                System.out.println("Introduceti noul nume");
                String name=br.readLine();

                PacientRepository pacientRepository = new PacientRepository();

                pacientRepository.updatePacientName(name, id);
            }
            if(optiune==4){
                System.out.println("Introduceti id-ul pacientului pe care vreti sa il stergeti:");
                int id=scanner.nextInt();
                PacientRepository pacientRepository = new PacientRepository();
                pacientRepository.deletePacient(id);
            }
            if(optiune==5){
                setUpData.displayDoctor();
            }
            if(optiune==6){
                setUpData.addDoctor();
            }
            if(optiune==7){
                System.out.println("Introduceti id-ul doctorului pe care vreti sa il actualizati:");
                int id=scanner.nextInt();
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                System.out.println("Introduceti noul nume");
                String name=br.readLine();
                DoctorRepository doctorRepository = new DoctorRepository();
                doctorRepository.updateDoctorName(name, id);
            }
            if(optiune==8){
                System.out.println("Introduceti id-ul doctorului pe care vreti sa il stergeti:");
                int id=scanner.nextInt();
                DoctorRepository doctorRepository = new DoctorRepository();
                doctorRepository.deleteDoctor(id);
            }
            if(optiune==9){
                setUpData.displayBilet_trimetere();
            }
            if(optiune==10){
                setUpData.addBilet_trimetere();
            }
            if(optiune==11){
                System.out.println("Introduceti id-ul biletului de trimetere pe care vreti sa il actualizati:");
                int id=scanner.nextInt();
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                System.out.println("Introduceti noul motiv");
                String reason=br.readLine();
                BiletTrimetereRepository biletTrimetereRepository = new BiletTrimetereRepository();
                biletTrimetereRepository.updateBilet_trimetereMotiv(reason, id);
            }
            if(optiune==12){
                System.out.println("Introduceti id-ul biletului de trimetere pe care vreti sa il stergeti:");
                int id=scanner.nextInt();
                BiletTrimetereRepository biletTrimetereRepository = new BiletTrimetereRepository();
                biletTrimetereRepository.deleteBilet_trimetere(id);
            }
            if(optiune==13){
                setUpData.displayProgramare();
            }
            if(optiune==14){
                setUpData.addProgramare();
            }
            if(optiune==15){
                System.out.println("Introduceti id-ul programarii pe care vreti sa o actualizati:");
                int id=scanner.nextInt();
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                System.out.println("Introduceti noua data");
                String date=br.readLine();
                ProgramareRepository programareRepository = new ProgramareRepository();
                programareRepository.updateProgramareData(date, id);
            }
            if(optiune==16){
                System.out.println("Introduceti id-ul programarii pe care vreti sa o stergeti:");
                int id=scanner.nextInt();
                ProgramareRepository programareRepository = new ProgramareRepository();
                programareRepository.deleteProgramare(id);
            }
            if(optiune<0 || optiune>16){
                System.out.println("Optiune invalida.");
            }
            System.out.println("Introduceti numarul optiunii dorite:");
            optiune=scanner.nextInt();
        }
    }
}



