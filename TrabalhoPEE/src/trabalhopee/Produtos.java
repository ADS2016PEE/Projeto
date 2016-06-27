/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopee;

import java.sql.Connection;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import trabalhopee.database.MySQLDatabase;
import trabalhopee.database.Neo4JDatabase;
import trabalhopee.database.PostGreSQLDatabase;
import trabalhopee.database.SQLServerDatabase;

/**
 *
 * @author Cleyton
 */
public class Produtos {

    private MySQLDatabase mysql;
    private Neo4JDatabase neo4j;
    private PostGreSQLDatabase postgre;
    private SQLServerDatabase sqlserver;

    public Produtos() {
        mysql = new MySQLDatabase();
        neo4j = new Neo4JDatabase();
        postgre = new PostGreSQLDatabase();
        sqlserver = new SQLServerDatabase();
    }

    public long inserirMySQL() {

        long total = 0;

        mysql.connect();
        for (int i = 1; i < 5000; i++) {
            long start = System.currentTimeMillis();
            mysql.insert("INSERT INTO produtos (nome, descricao, valor) "
                    + "VALUES ('PRODUTO 1','AQUI VAI A DESCRIÇÃO DO PRODUTO','10.00')");
            total += System.currentTimeMillis() - start;
        }

        return total / 1000;
    }

    public long inserirPostGreSQL() {
        long total = 0;

        postgre.connect();
        for (int i = 1; i < 5000; i++) {
            long start = System.currentTimeMillis();
            postgre.insert("INSERT INTO produtos (nome, descricao, valor) "
                    + "VALUES ('PRODUTO 1','AQUI VAI A DESCRIÇÃO DO PRODUTO','10.00')");
            total += System.currentTimeMillis() - start;
        }

        return total / 1000;
    }

    public long inserirNeo4J() {
        long total = 0;

        Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "123456"));
        Session session = driver.session();

        for (int i = 1; i < 5000; i++) {
            long start = System.currentTimeMillis();
            session.run("CREATE (a:produtos {nome:'PRODUTO 1', "
                    + "descricao:'AQUI VAI A DESCRIÇÃO DO PRODUTO', valor:'10.00'})");
            total += System.currentTimeMillis() - start;
        }

        session.close();
        driver.close();
        
        return total / 1000;
    }
}
