package com.company.repository;

import com.company.model.Doctor;
import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class DoctorRepository {

    public void insertDoctor(Doctor doctor){

        String preparedSql = "{call insertDoctor(?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, doctor.getNume());
            cstmt.setString(3, doctor.getPrenume());
            cstmt.setDouble(4,doctor.getVarsta());
            cstmt.setString(5,doctor.getSpecializare());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added doctor with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor getDoctorById(int id) {
        String selectSql = "SELECT * FROM doctori WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDoctor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDoctorName(String name, int id) {
        String updateNameSql = "UPDATE doctori SET nume=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Doctor mapToDoctor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Doctor(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),resultSet.getString(5));
        }
        return null;
    }

    public void deleteDoctor(int id){
        String sql = "DELETE FROM doctori WHERE id=" + id;
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = databaseConnection.createStatement();

            int rows = statement.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
