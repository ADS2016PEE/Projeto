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
import org.neo4j.driver.v1.*;

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
    private Session session;
    private Driver driver;
    

    public boolean connect() {

        boolean result = true;
        
        driver = GraphDatabase.driver( "bolt://" + host, AuthTokens.basic( username, password ) );
        session = driver.session();


        return result;
    }

    public ResultSet query(String sql) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean disconnect() {

        boolean result = false;

        try {

            if (this.driver != null) {
                this.session.close();
                this.driver.close();
                result = true;
            }

        } catch (Exception e) {

        }

        return result;
    }

    @Override
    public boolean insert(String sql) {
        
        boolean result = true;

        session.run(sql);

        return result;
        
        
    }

    @Override
    public boolean update(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}