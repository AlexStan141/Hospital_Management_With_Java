package com.company.config;

import com.company.repository.RepositoryHelper;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSetup {

    public void setUp() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS pacienti" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                "prenume varchar(30),varsta double)";
        String createTableSql2="CREATE TABLE IF NOT EXISTS doctori" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                "prenume varchar(30),varsta double,specializare varchar(30))";
        String createTableSql3="CREATE TABLE IF NOT EXISTS bilete_trimetere"+
                "(id int PRIMARY KEY AUTO_INCREMENT,id_pacient int,motiv varchar(30),specializare varchar(30))";
        String createTableSql4="CREATE TABLE IF NOT EXISTS programari"+
                "(id int PRIMARY KEY AUTO_INCREMENT,data varchar(30),id_pacient int,id_doctor int,id_bilet_trimetere int)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
            repositoryHelper.executeSql(databaseConnection, createTableSql2);
            repositoryHelper.executeSql(databaseConnection, createTableSql3);
            repositoryHelper.executeSql(databaseConnection, createTableSql4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPacient() {
        String insertPersonSql = "INSERT INTO pacienti(nume,prenume,varsta) VALUES('Ana','Ion',20)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPacient() {
        String selectSql = "SELECT * FROM pacienti";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Prenume:" + resultSet.getString(3));
                System.out.println("Varsta:" + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDoctor(){
        String insertPersonSql = "INSERT INTO doctori(nume,prenume,varsta,specializare) VALUES('john','arthur',21,'cardiologie')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayDoctor() {
        String selectSql = "SELECT * FROM doctori";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Prenume:" + resultSet.getString(3));
                System.out.println("Varsta:" + resultSet.getDouble(4));
                System.out.println("Specializare:"+ resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBilet_trimetere(){
        String insertBilet_trimetereSql = "INSERT INTO bilete_trimetere(id_pacient,motiv,specializare) VALUES(2,'e nebun','psihiatrie')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertBilet_trimetereSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayBilet_trimetere() {
        String selectSql = "SELECT * FROM bilete_trimetere";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Id_pacient:" + resultSet.getString(2));
                System.out.println("Motiv:" + resultSet.getString(3));
                System.out.println("Specializare:"+ resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProgramare(){
        String insertProgramareSql = "INSERT INTO programari(data,id_pacient,id_doctor,id_bilet_trimetere) VALUES('2.12.2000',1,1,1)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertProgramareSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayProgramare() {
        String selectSql = "SELECT * FROM programari";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Data:" + resultSet.getString(2));
                System.out.println("Id_Pacient:" + resultSet.getString(3));
                System.out.println("Id_Doctor:" + resultSet.getDouble(4));
                System.out.println("Id_Bilet_Trimetere:"+ resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
