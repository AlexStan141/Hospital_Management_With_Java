package com.company.repository;

import com.company.model.Pacient;
import com.company.config.DatabaseConfiguration;

import java.sql.*;

public class PacientRepository {

    public void insertPacient(Pacient pacient){

        String preparedSql = "{call insertPacient(?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, pacient.getNume());
            cstmt.setString(3, pacient.getPrenume());
            cstmt.setDouble(4,pacient.getVarsta());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added pacient with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pacient getPacientById(int id) {
        String selectSql = "SELECT * FROM pacienti WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToPacient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePacientName(String name, int id) {
        String updateNameSql = "UPDATE pacienti SET nume=? WHERE id=?";

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

    private Pacient mapToPacient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Pacient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
        }
        return null;
    }
    public void deletePacient(int id){
        String sql = "DELETE FROM pacienti WHERE id=" + id;
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
