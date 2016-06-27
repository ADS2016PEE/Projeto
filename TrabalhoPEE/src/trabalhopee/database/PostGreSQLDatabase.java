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
public class PostGreSQLDatabase implements Database{

    private final String username = "postgres";
    private final String password = "123456";
    private final String database = "pee";
    private final String host = "localhost";
    private final String port = "5432";
    private Connection connection; 

    public boolean connect() {

        boolean result = true;

        try {

            Class.forName("org.postgresql.Driver");

            if (connection != null) {
                connection.close();
            }

            this.connection
                    = DriverManager.getConnection(
                            "jdbc:postgresql://" + this.host + ":" + port + "/" + this.database,
                            this.username, this.password);

        } catch (Exception e) {
            System.out.println("Erro de conexão");
            result = false;
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ResultSet query(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean disconnect() {

        boolean result = false;

        try {

            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                result = true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String sql) {
        return false;
    }
}