package TrabalhoED2.testes;
import TrabalhoED2.src.arvorerebronegramodificada.ArvoreRubroNegraModificada;
import java.util.Random;


public class TesteArvoreRubroNegra {
    
    public static void main(String[] args) {
        System.out.println("=====   TESTE ÁRVORE RUBRO-NEGRA MODIFICADA   =====\n");
        
        testeBasico();
        testeInsercoes();
        testeRemocoes();
        testeAleatorio();
        testeSimples();
        testeBusca();
        testeDuplicatas();
    }
    
    public static void testeBasico() {
        System.out.println("\n--- TESTE 1: Inserções simples ---");
        ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();
        
        int[] valores = {15, 10, 20, 5, 12, 17, 25};
        
        System.out.println("Inserindo: " + java.util.Arrays.toString(valores));
        for (int v : valores) {
            arvore.inserir(v);
        }
        
        System.out.println("\nArvore em ordem:");
        arvore.imprimirEmOrdem();
        
        System.out.println("\nEstrutura da arvore:");
        arvore.imprimirArvore();
        
        System.out.println("Tamanho: " + arvore.getTamanho());
    }
    
    public static void testeInsercoes() {
        System.out.println("\n--- TESTE 2: Inserções com balanceamento ---");
        ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();
        
        int[] valores = {7, 3, 18, 10, 22, 8, 11, 26, 2, 6};
        
        System.out.println("Inserindo em sequência: " + java.util.Arrays.toString(valores));
        for (int i = 0; i < valores.length; i++) {
            arvore.inserir(valores[i]);
            System.out.println("Inseriu " + valores[i] + " - Tamanho: " + arvore.getTamanho());
        }
        
        System.out.println("\nArvore final:");
        arvore.imprimirArvore();
    }
    
    public static void testeRemocoes() {
        System.out.println("\n--- TESTE 3: Remoções ---");
        ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();
        
        int[] valores = {15, 10, 20, 5, 12, 17, 25, 1, 7, 16};
        for (int v : valores) {
            arvore.inserir(v);
        }
        
        System.out.println("Arvore inicial:");
        arvore.imprimirEmOrdem();
        
        int[] remover = {1, 15, 25};
        System.out.println("\nRemovendo: " + java.util.Arrays.toString(remover));
        for (int v : remover) {
            arvore.remover(v);
            System.out.println("Removeu " + v + " - Tamanho: " + arvore.getTamanho());
        }
        
        System.out.println("\nArvore após remoções:");
        arvore.imprimirEmOrdem();
        System.out.println("\nEstrutura:");
        arvore.imprimirArvore();
    }
    
    public static void testeAleatorio() {
        System.out.println("\n--- TESTE 4: Inserções aleatórias ---");
        ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();
        
        Random rand = new Random(42);
        int quantidade = 20;
        
        System.out.println("Inserindo " + quantidade + " números aleatórios...");
        for (int i = 0; i < quantidade; i++) {
            int valor = rand.nextInt(100);
            try {
                arvore.inserir(valor);
            } catch (Exception e) {
                // Duplicados são ignorados
            }
        }
        
        System.out.println("Tamanho final: " + arvore.getTamanho());
        System.out.println("\nArvore em ordem:");
        arvore.imprimirEmOrdem();
    }
    public static void testeSimples() {
        System.out.println("\n--- TESTE 5: Inserções simples com 3 elementos ---");
        ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);

        System.out.println("Arvore em ordem:");
        arvore.imprimirEmOrdem();

        System.out.println("\nEstrutura da arvore:");
        arvore.imprimirArvore();
    }

    public static void testeBusca() {
    System.out.println("\n--- TESTE 6: Busca de elementos ---");

    ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();

    int[] valores = {50, 30, 70, 20, 40, 60, 80};

    for (int v : valores) {
        arvore.inserir(v);
    }

    System.out.println("Buscar 40: " + arvore.contem(40));
    System.out.println("Buscar 90: " + arvore.contem(90));
}

public static void testeDuplicatas() {
    System.out.println("\n--- TESTE 7: Chaves duplicadas ---");

    ArvoreRubroNegraModificada<Integer> arvore = new ArvoreRubroNegraModificada<>();

    arvore.inserir(10);
    arvore.inserir(20);
    arvore.inserir(20);
    arvore.inserir(20);

    System.out.println("Tamanho esperado: 2");
    System.out.println("Tamanho atual: " + arvore.getTamanho());

    arvore.imprimirArvore();
}

}
