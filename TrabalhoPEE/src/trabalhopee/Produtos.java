/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopee;

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
        for (int i = 1; i < 50000; i++) {
            long start = System.currentTimeMillis();
            postgre.insert("INSERT INTO produtos (nome, descricao, valor) "
                    + "VALUES ('PRODUTO 1','AQUI VAI A DESCRIÇÃO DO PRODUTO','10.00')");
            total += System.currentTimeMillis() - start;
        }

        return total / 1000;
    }

    public long inserirNeo4J() {
        long total = 0;

        neo4j.connect();
//        for (int i = 1; i < 50000; i++) {
//            long start = System.currentTimeMillis();
//            postgre.insert("INSERT INTO produtos (nome, descricao, valor) "
//                    + "VALUES ('PRODUTO 1','AQUI VAI A DESCRIÇÃO DO PRODUTO','10.00')");
//            total += System.currentTimeMillis() - start;
//        }

        return total / 1000;
    }
}
