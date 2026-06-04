package TrabalhoED2.src.tabelahash;

public class EntradaTabela<K, V> {
    private K chave;
    private V valor;
    private StatusEntrada status;
    
    public EntradaTabela() {
        this.chave = null;
        this.valor = null;
        this.status = StatusEntrada.VAZIA;
    }
    
    public EntradaTabela(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
        this.status = StatusEntrada.OCUPADA;
    }
    
    // ===== GETTERS E SETTERS =====
    
    public K getChave() {
        return chave;
    }
    
    public void setChave(K chave) {
        this.chave = chave;
    }
    
    public V getValor() {
        return valor;
    }
    
    public void setValor(V valor) {
        this.valor = valor;
    }
    
    public StatusEntrada getStatus() {
        return status;
    }
    
    public void setStatus(StatusEntrada status) {
        this.status = status;
    }
    
    public boolean estaBuscavel() {
        return status == StatusEntrada.OCUPADA;
    }
    
    public boolean estaVazia() {
        return status == StatusEntrada.VAZIA;
    }
    
    public boolean estaLivre() {
        return status == StatusEntrada.VAZIA || status == StatusEntrada.DELETADA;
    }
    
    @Override
    public String toString() {
        return "EntradaTabela{" +
                "chave=" + chave +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
