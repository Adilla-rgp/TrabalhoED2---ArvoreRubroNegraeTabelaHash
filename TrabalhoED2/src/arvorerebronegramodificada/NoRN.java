package TrabalhoED2.src.arvorerebronegramodificada;

public class NoRN<T extends Comparable<T>> {
    private T chave;
    private CorNo cor;
    
    // Referências verticais (clássicas)
    private NoRN<T> pai;
    private NoRN<T> esquerdo;
    private NoRN<T> direito;
    
    // MODIFICAÇÃO: Referência horizontal entre irmãos
    private NoRN<T> irmao;
    
    public NoRN(T chave) {
        this.chave = chave;
        this.cor = CorNo.VERMELHO; // Novo nó sempre começa vermelho
        this.pai = null;
        this.esquerdo = null;
        this.direito = null;
        this.irmao = null;
    }
    
    public T getChave() {
        return chave;
    }
    
    public void setChave(T chave) {
        this.chave = chave;
    }
    
    public CorNo getCor() {
        return cor;
    }
    
    public void setCor(CorNo cor) {
        this.cor = cor;
    }
    
    public NoRN<T> getPai() {
        return pai;
    }
    
    public void setPai(NoRN<T> pai) {
        this.pai = pai;
    }
    
    public NoRN<T> getEsquerdo() {
        return esquerdo;
    }
    
    public void setEsquerdo(NoRN<T> esquerdo) {
        this.esquerdo = esquerdo;
        if (esquerdo != null) {
            esquerdo.setPai(this);
        }
    }
    
    public NoRN<T> getDireito() {
        return direito;
    }
    
    public void setDireito(NoRN<T> direito) {
        this.direito = direito;
        if (direito != null) {
            direito.setPai(this);
        }
    }
    
    public NoRN<T> getIrmao() {
        return irmao;
    }
    
    public void setIrmao(NoRN<T> irmao) {
        this.irmao = irmao;
    }
    
    /** Retorna o tio do nó atual usando a referência do PAI ao invés do avô (MODIFICAÇÃO)*/
    public NoRN<T> getTio() {
        if (pai == null) {
            return null;
        }
        // O tio é o irmão do pai
        return pai.getIrmao();
    }
    
    /**Retorna o irmão deste nó*/
    public NoRN<T> getIrmaoAtual() {
        if (pai == null) {
            return null;
        }
        
        if (pai.getEsquerdo() == this) {
            return pai.getDireito();
        } else {
            return pai.getEsquerdo();
        }
    }
    
    /** Verifica se o nó é preto*/
    public boolean ehPreto() {
        return cor == CorNo.PRETO;
    }
    
    /* Verifica se o nó é vermelho*/
    public boolean ehVermelho() {
        return cor == CorNo.VERMELHO;
    }
    
    @Override
    public String toString() {
        return "NoRN{" +
                "chave=" + chave +
                ", cor=" + cor +
                '}';
    }
}