import TrabalhoED2.testes.TesteArvoreRubroNegra;
import TrabalhoED2.testes.TesteTabelaHash;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("Estruturas de Dados II - Trabalho Unidade 2");
        System.out.println("Aluna: Àdilla Roberta Gomes Pereira");
        System.out.println("====================================================");

        System.out.println("\n===== Testes Disponíveis =====\n");
        System.out.println("--------------------------------------------");

        System.out.println("\nÁRVORE RUBRO-NEGRA MODIFICADA");
        System.out.println("1. Inserções simples");
        System.out.println("2. Inserções com balanceamento");
        System.out.println("3. Remoções");
        System.out.println("4. Inserções aleatórias");
        System.out.println("5. Inserção simples com 3 elementos");
        System.out.println("6. Busca de elementos");
        System.out.println("7. Chaves duplicadas");

        System.out.println("\nTABELA HASH COM ENDEREÇAMENTO ABERTO");
        System.out.println("1. Inserção simples");
        System.out.println("2. Tratamento de colisões");
        System.out.println("3. Redimensionamento dinâmico");
        System.out.println("4. Buscas e remoções");
        System.out.println("5. Inserções aleatórias");
        System.out.println("6. Atualização de valores");

        System.out.println("\n===== Executando Testes =====\n");

        TesteArvoreRubroNegra.main(null);

        System.out.println("\n\n============================================\n");

        TesteTabelaHash.main(null);

        System.out.println("\n===== Testes Concluídos com Sucesso =====");
    }
}