package TrabalhoED2.src.utilitarios;


public class FuncaoHash {
    
    private static final double RAZAO_OURO = 0.6180339887;
    
    /**
     * Hash por multiplicação
     * h(k) = floor(m * (k*A mod 1))
     * onde A = (√5 - 1) / 2 ≈ 0.618...
     */
    public static int hashMultiplicacao(int chave, int tamanhoTabela) {
        if (tamanhoTabela <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser positivo");
        }
        
        if (chave < 0) {
            chave = -chave;
        }
        
        // Fórmula: h(k) = floor(m * (k*A mod 1))
        double temp = (chave * RAZAO_OURO) % 1.0;
        return (int) (tamanhoTabela * temp);
    }
    
    /**
     * Hash quadrático para tratamento de colisão
     * h'(k, i) = (h(k) + c1*i + c2*i²) mod m
     * Usando c1 = 1, c2 = 1
     */
    public static int hashQuadratico(int hashInicial, int tentativa, int tamanhoTabela) {
        // h'(k, i) = (h(k) + i + i²) mod m
        int posicao = (hashInicial + tentativa + (tentativa * tentativa)) % tamanhoTabela;
        
        // Garantir resultado positivo
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