package trabalhopee;

public class Main {

    public static void main(String[] args){
        
        Produtos produto = new Produtos();
//        System.out.println("Tempo do MySQL: " + produto.inserirMySQL());
//        System.out.println("Tempo do PostgreSQL: " + produto.inserirPostGreSQL());
//        System.out.println("Tempo do Neo4J: " + produto.inserirNeo4J());
        System.out.println("Tempo do SQL Server: " + produto.inserirSQLServer());
        
    }
    
}
