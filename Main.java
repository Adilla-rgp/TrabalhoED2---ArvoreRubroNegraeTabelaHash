import TrabalhoED2.testes.TesteArvoreRubroNegra;
import TrabalhoED2.testes.TesteTabelaHash;
/**
 * Classe principal para executar todos os testes
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ESTRUTURAS DE DADOS II - ATIVIDADE PRÁTICA UNIDADE 2   ║");
        System.out.println("║               Árvore Rubro-Negra + Tabela Hash             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Executar testes da Árvore Rubro-Negra
        TesteArvoreRubroNegra.main(null);
        
        // Executar testes da Tabela Hash
        TesteTabelaHash.main(null);
        
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                 TESTES CONCLUÍDOS COM SUCESSO!             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
    }
}