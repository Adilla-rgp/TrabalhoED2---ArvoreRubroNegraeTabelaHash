package TrabalhoED2.src.tabelahash;

import TrabalhoED2.src.utilitarios.FuncaoHash;

/**
 * Implementação genérica de Tabela Hash com:
 * - Endereçamento aberto
 * - Hash quadrático para colisões
 * - Redimensionamento dinâmico (70% → 3x)
 * - Suporte a Generics <K, V>
 */
@SuppressWarnings("unchecked")
public class TabelaHash<K, V> {
    
    private EntradaTabela<K, V>[] tabela;
    private int tamanho;           // Quantidade de elementos
    private int capacidade;         // Tamanho da tabela
    private static final double LIMITE_OCUPACAO = 0.70;
    private static final int FATOR_CRESCIMENTO = 3;
    private static final int TAMANHO_INICIAL = 11;
    
    /**
     * Construtor com tamanho fixo inicial
     */
    public TabelaHash(int tamanhoInicial) {
        if (tamanhoInicial <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser positivo");
        }
        
        // Usar próximo primo para melhor distribuição
        this.capacidade = FuncaoHash.proximoPrimo(tamanhoInicial);
        this.tabela = new EntradaTabela[capacidade];
        this.tamanho = 0;
        
        // Inicializar todas as posições
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new EntradaTabela<>();
        }
    }
    
    /**
     * Construtor padrão
     */
    public TabelaHash() {
        this(TAMANHO_INICIAL);
    }
    
    /**
     * Insere um par chave-valor
     */
    public void inserir(K chave, V valor) {
        if (chave == null) {
            throw new IllegalArgumentException("Chave não pode ser nula");
        }
        
        // Verificar se precisa redimensionar
        if (getOcupacao() >= LIMITE_OCUPACAO) {
            redimensionar();
        }
        
        int hashInicial = FuncaoHash.hashMultiplicacao(
            chave.hashCode(), capacidade
        );
        
        int tentativa = 0;
        int posicao;
        
        // Hash quadrático para encontrar posição
        do {
            posicao = FuncaoHash.hashQuadratico(
                hashInicial, tentativa, capacidade
            );
            
            // Se encontrou posição vazia ou deletada
            if (tabela[posicao].estaLivre()) {
                tabela[posicao].setChave(chave);
                tabela[posicao].setValor(valor);
                tabela[posicao].setStatus(StatusEntrada.OCUPADA);
                tamanho++;
                return;
            }
            
            // Se a chave já existe, atualizar valor
            if (tabela[posicao].getChave().equals(chave)) {
                tabela[posicao].setValor(valor);
                return;
            }
            
            tentativa++;
            
        } while (tentativa < capacidade);
        
        throw new RuntimeException("Tabela cheia - hash quadrático não encontrou posição");
    }
    
    /**
     * Busca um valor pela chave
     */
    public V buscar(K chave) {
        if (chave == null) {
            return null;
        }
        
        int hashInicial = FuncaoHash.hashMultiplicacao(
            chave.hashCode(), capacidade
        );
        
        int tentativa = 0;
        int posicao;
        
        do {
            posicao = FuncaoHash.hashQuadratico(
                hashInicial, tentativa, capacidade
            );
            
            // Se encontrou uma posição vazia, chave não existe
            if (tabela[posicao].estaVazia()) {
                return null;
            }
            
            // Se encontrou a chave
            if (tabela[posicao].estaBuscavel() && 
                tabela[posicao].getChave().equals(chave)) {
                return tabela[posicao].getValor();
            }
            
            tentativa++;
            
        } while (tentativa < capacidade);
        
        return null;
    }
    
    /**
     * Remove uma entrada pela chave
     */
    public boolean remover(K chave) {
        if (chave == null) {
            return false;
        }
        
        int hashInicial = FuncaoHash.hashMultiplicacao(
            chave.hashCode(), capacidade
        );
        
        int tentativa = 0;
        int posicao;
        
        do {
            posicao = FuncaoHash.hashQuadratico(
                hashInicial, tentativa, capacidade
            );
            
            // Se encontrou uma posição vazia, chave não existe
            if (tabela[posicao].estaVazia()) {
                return false;
            }
            
            // Se encontrou a chave
            if (tabela[posicao].estaBuscavel() && 
                tabela[posicao].getChave().equals(chave)) {
                tabela[posicao].setStatus(StatusEntrada.DELETADA);
                tamanho--;
                return true;
            }
            
            tentativa++;
            
        } while (tentativa < capacidade);
        
        return false;
    }
    
    /**
     * Redimensiona a tabela quando ocupa >= 70%
     * Novo tamanho = tamanho anterior * 3
     */
    private void redimensionar() {
        System.out.println("\n>>> Redimensionando tabela...");
        System.out.println("    Ocupação atual: " + String.format("%.1f%%", getOcupacao() * 100));
        
        EntradaTabela<K, V>[] tabelaAntiga = tabela;
        int capacidadeAntiga = capacidade;
        
        // Novo tamanho
        this.capacidade = FuncaoHash.proximoPrimo(capacidadeAntiga * FATOR_CRESCIMENTO);
        this.tabela = new EntradaTabela[capacidade];
        this.tamanho = 0;
        
        // Inicializar
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new EntradaTabela<>();
        }
        
        // Reinsert all old entries
        System.out.println("    Nova capacidade: " + capacidade);
        for (int i = 0; i < capacidadeAntiga; i++) {
            if (tabelaAntiga[i].estaBuscavel()) {
                inserir(tabelaAntiga[i].getChave(), tabelaAntiga[i].getValor());
            }
        }
        
        System.out.println("    Redimensionamento concluído!\n");
    }
    
    /**
     * Retorna o percentual de ocupação
     */
    public double getOcupacao() {
        return (double) tamanho / capacidade;
    }
    
    /**
     * Imprime o conteúdo da tabela
     */
    public void imprimir() {
        System.out.println("\n========== TABELA HASH ==========");
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Elementos: " + tamanho);
        System.out.println("Ocupação: " + String.format("%.2f%%", getOcupacao() * 100));
        System.out.println("---------------------------------");
        
        for (int i = 0; i < capacidade; i++) {
            EntradaTabela<K, V> entrada = tabela[i];
            String statusStr;
            
            if (entrada.estaVazia()) {
                statusStr = "[VAZIA]";
            } else if (entrada.estaBuscavel()) {
                statusStr = "[OCUPADA] " + entrada.getChave() + " -> " + entrada.getValor();
            } else {
                statusStr = "[DELETADA]";
            }
            
            System.out.printf("[%3d] %s\n", i, statusStr);
        }
        System.out.println("================================\n");
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
}
