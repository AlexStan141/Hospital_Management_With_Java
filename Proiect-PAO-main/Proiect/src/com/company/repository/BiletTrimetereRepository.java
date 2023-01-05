package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.model.Bilet_trimetere;

import java.net.BindException;
import java.sql.*;

public class BiletTrimetereRepository {

    public void insertBilet_trimetere(Bilet_trimetere bilet_trimetere){

        String preparedSql = "{call insertBilet_trimetere(?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setInt(2, bilet_trimetere.getId_pacient());
            cstmt.setString(3,bilet_trimetere.getMotiv());
            cstmt.setString(4,bilet_trimetere.getSpecialitate());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added bilet trimetere with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bilet_trimetere getBilet_trimetereById(int id) {
        String selectSql = "SELECT * FROM bilete_trimetere WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToBilet_trimetere(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBilet_trimetereMotiv(String motiv, int id) {
        String updateNameSql = "UPDATE bilete_trimetere SET motiv=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, motiv);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Bilet_trimetere mapToBilet_trimetere(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Bilet_trimetere(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
        }
        return null;
    }

    public void deleteBilet_trimetere(int id){
        String sql = "DELETE FROM bilete_trimetere WHERE id=" + id;
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
