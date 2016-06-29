package trabalhopee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    private static long tempo[][] = new long[30][4];

    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando análise...");
        
        Produtos produto = new Produtos();
        
        for (int i = 0; i < 30; i++){
            System.out.println("Teste " + (i+1));
            tempo[i][0] = produto.inserirMySQL();
            tempo[i][1] = produto.inserirPostGreSQL();
            tempo[i][2] = produto.inserirNeo4J();
            tempo[i][3] = produto.inserirSQLServer();
        }
        
        gerarAnalise();
        
        System.out.println("Termino análise...!");
    }

    private static void gerarAnalise() throws IOException {
        FileWriter arq = new FileWriter("analise.csv");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.println("Execução;MySQL;PostGreSQL;Neo4J;SQL Server");
        
        for (int i = 0; i < 30; i++) {
            gravarArq.println((i + 1) + ";" + tempo[i][0] + ";" + tempo[i][1] + ";" + tempo[i][2] + ";"
                    + +tempo[i][3] + ";");
        }

        arq.close();

        System.out.println("Arquivo analise.csv, criado com sucesso.");
        System.out.println("");
        System.out.println("");
    }
}
