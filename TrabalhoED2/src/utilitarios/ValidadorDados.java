package TrabalhoED2.src.utilitarios;

public class ValidadorDados {
    
    /** Valida se um inteiro é positivo*/
    public static boolean ehPositivo(int numero) {
        return numero > 0;
    }
    
    /** Valida se uma string é válida*/
    public static boolean ehValidaString(String str) {
        return str != null && !str.trim().isEmpty();
    }
    
    /** Valida se um objeto é nulo*/
    public static <T> boolean naoEhNulo(T objeto) {
        return objeto != null;
    }
}
