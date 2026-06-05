package TrabalhoED2.src.utilitarios;


public class FuncaoHash {
    
    private static final double RAZAO_OURO = 0.6180339887;
    
    public static int hashMultiplicacao(int chave, int tamanhoTabela) {
        if (tamanhoTabela <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser positivo");
        }
        
        if (chave < 0) {
            chave = -chave;
        }
        
        double temp = (chave * RAZAO_OURO) % 1.0;
        return (int) (tamanhoTabela * temp);
    }
    
    public static int hashQuadratico(int hashInicial, int tentativa, int tamanhoTabela) {
        int posicao = (hashInicial + tentativa + (tentativa * tentativa)) % tamanhoTabela;
        
        if (posicao < 0) {
            posicao += tamanhoTabela;
        }
        
        return posicao;
    }
    
    public static boolean ehPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int proximoPrimo(int n) {
        if (n <= 2) {
            return 2;
        }
        if (n % 2 == 0) {
            n++;
        }
        
        while (!ehPrimo(n)) {
            n += 2;
        }
        return n;
    }
}