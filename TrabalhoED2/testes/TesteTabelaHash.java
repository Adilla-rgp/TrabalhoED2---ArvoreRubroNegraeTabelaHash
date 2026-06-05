package TrabalhoED2.testes;
import TrabalhoED2.src.tabelahash.TabelaHash;
import java.util.Random;

public class TesteTabelaHash {
    
    public static void main(String[] args) {
        System.out.println("=====   TESTE TABELA HASH COM ENDEREÇAMENTO ABERTO  =====\n");
        
        testeBasico();
        testeColisoes();
        testeRedimensionamento();
        testeBuscasRemocoes();
        testeAleatorio();
        testeAtualizacao();
    }
    
    public static void testeBasico() {
        System.out.println("\n--- TESTE 1: Inserção simples ---");
        TabelaHash<String, Integer> tabela = new TabelaHash<>(5);
        
        System.out.println("Inserindo dados...");
        tabela.inserir("João", 25);
        tabela.inserir("Maria", 30);
        tabela.inserir("Pedro", 28);
        
        tabela.imprimir();
        
        System.out.println("Buscando 'Maria': " + tabela.buscar("Maria"));
        System.out.println("Buscando 'Ana': " + tabela.buscar("Ana"));
    }
    
    public static void testeColisoes() {
        System.out.println("\n--- TESTE 2: TRATAMENTO DE COLISÕES ---");
        TabelaHash<String, String> tabela = new TabelaHash<>(7);
        
        System.out.println("Inserindo valores que podem gerar colisões...");
        String[] nomes = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank"};
        
        for (int i = 0; i < nomes.length; i++) {
            tabela.inserir(nomes[i], "Pessoa " + (i + 1));
            System.out.println("Inseriu " + nomes[i] + " - Ocupação: " + 
            String.format("%.1f%%", tabela.getOcupacao() * 100));
        }
        
        tabela.imprimir();
        
        System.out.println("Verificando dados inseridos:");
        for (String nome : nomes) {
            System.out.println(nome + " -> " + tabela.buscar(nome));
        }
    }
    
    public static void testeRedimensionamento() {
        System.out.println("\n--- TESTE 3: Redimensionamento ---");
        TabelaHash<Integer, String> tabela = new TabelaHash<>(5);
        
        System.out.println("Tabela inicial - Capacidade: " + tabela.getCapacidade());
        
        System.out.println("\nInserindo elementos até atingir 70% de ocupação...");
        for (int i = 1; i <= 10; i++) {
            tabela.inserir(i, "Valor " + i);
            
            double ocupacao = tabela.getOcupacao();
            System.out.printf("Elemento %2d - Ocupação: %5.1f%% - Capacidade: %d\n", 
            i, ocupacao * 100, tabela.getCapacidade());
        }
    }
    
    public static void testeBuscasRemocoes() {
        System.out.println("\n--- TESTE 4: Buscas e Remoções ---");
        TabelaHash<String, Double> tabela = new TabelaHash<>(7);
        
        System.out.println("Inserindo dados de produtos...");
        tabela.inserir("Notebook", 2500.00);
        tabela.inserir("Mouse", 50.00);
        tabela.inserir("Teclado", 150.00);
        tabela.inserir("Monitor", 800.00);
        
        tabela.imprimir();
        
        System.out.println("Removendo 'Mouse'...");
        boolean removido = tabela.remover("Mouse");
        System.out.println("Removido: " + removido);
        
        tabela.imprimir();
        
        System.out.println("Buscando 'Mouse' novamente: " + tabela.buscar("Mouse"));
        System.out.println("Buscando 'Notebook': " + tabela.buscar("Notebook"));
    }
    
    public static void testeAleatorio() {
        System.out.println("\n--- TESTE 5: Inserções Aleatórias ---");
        TabelaHash<Integer, String> tabela = new TabelaHash<>(11);
        
        Random rand = new Random(42);
        int quantidade = 15;
        
        System.out.println("Inserindo " + quantidade + " pares aleatórios...\n");
        for (int i = 0; i < quantidade; i++) {
            int chave = rand.nextInt(100);
            String valor = "Dados_" + chave;
            
            tabela.inserir(chave, valor);
            System.out.printf("Inseriu chave %3d - Ocupação: %5.1f%%\n", 
            chave, tabela.getOcupacao() * 100);
        }
        
        tabela.imprimir();
        
        System.out.println("Total de elementos: " + tabela.getTamanho());
        System.out.println("Capacidade final: " + tabela.getCapacidade());
    }

    public static void testeAtualizacao() {

    System.out.println("\n--- TESTE 6: Atualização de valores ---");

    TabelaHash<String, Integer> tabela =
            new TabelaHash<>();

    tabela.inserir("João", 20);

    System.out.println("Antes: " + tabela.buscar("João"));

    tabela.inserir("João", 35);

    System.out.println("Depois: " + tabela.buscar("João"));
    }
}
