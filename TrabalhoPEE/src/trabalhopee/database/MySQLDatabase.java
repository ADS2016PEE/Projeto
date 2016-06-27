/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Cleyton
 */
public class MySQLDatabase implements Database{

    private final String username = "root";
    private final String password = "123456";
    private final String database = "pee";
    private final String host = "localhost";
    private final String port = "3306";
    private Connection connection;

    public boolean connect() {

        boolean result = true;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            if (connection != null) {
                connection.close();
            }

            this.connection
                    = DriverManager.getConnection(
                            "jdbc:mysql://" + this.host + ":" + port + "/" + this.database,
                            this.username, this.password);

        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ResultSet query(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(String sql) {
        boolean result = true;

        try {

            if (connection != null && !connection.isClosed()) {

                PreparedStatement statement = this.connection.prepareStatement(sql);

                statement.executeUpdate();

            } else {
                throw new Exception("Database não conectado.");
            }

        } catch (Exception e) {
            System.out.println("Erro na execução da inserção");
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    @Override
    public boolean update(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String sql) {
        boolean result = true;

        try {

            if (connection != null && !connection.isClosed()) {

                PreparedStatement statement = this.connection.prepareStatement(sql);

                statement.executeUpdate();

            } else {
                throw new Exception("Database não conectado.");
            }

        } catch (Exception e) {
            System.out.println("Erro na execução da exclusão");
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    @Override
    public boolean disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}