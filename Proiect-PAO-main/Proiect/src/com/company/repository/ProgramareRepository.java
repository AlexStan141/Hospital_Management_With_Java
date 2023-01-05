package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.model.Programare;

import java.sql.*;

public class ProgramareRepository {

    public void insertProgramare(Programare programare){

        String preparedSql = "{call insertProgramare(?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, programare.getData());
            cstmt.setInt(3,programare.getId_pacient());
            cstmt.setInt(4,programare.getId_doctor());
            cstmt.setInt(5,programare.getId_bilet_trimetere());


            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added programare with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Programare getProgramareById(int id) {
        String selectSql = "SELECT * FROM programari WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToProgramare(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProgramareData(String data, int id) {
        String updateNameSql = "UPDATE programari SET data=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, data);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Programare mapToProgramare(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Programare(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),resultSet.getInt(5));
        }
        return null;
    }

    public void deleteProgramare(int id){
        String sql = "DELETE FROM programari WHERE id=" + id;
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = databaseConnection.createStatement();

            int rows = statement.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
