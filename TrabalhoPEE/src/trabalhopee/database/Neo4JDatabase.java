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
public class Neo4JDatabase implements Database{

    private final String username = "neo4j";
    private final String password = "neo4j";
    private final String database = "default.graphdb";
    private final String host = "localhost";
    private final String port = "7474";
    private Connection connection;
    

    public boolean connect() {

        boolean result = true;
        
        

        try {

            Class.forName("org.neo4j.jdbc.Driver");


            if (connection != null) {
                connection.close();
            }

            this.connection
                    = DriverManager.getConnection(
                            "jdbc:neo4j://" + this.host + ":" + port + "/" + this.database,
                            this.username, this.password);

        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet query(String sql) {

        ResultSet result = null;

        try {

            if (connection != null && !connection.isClosed()) {

                PreparedStatement statement = this.connection.prepareStatement(sql);

                result = statement.executeQuery();

            } else {
                throw new Exception("Database is not connected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
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
        // TODO Auto-generated method stub
        return false;
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