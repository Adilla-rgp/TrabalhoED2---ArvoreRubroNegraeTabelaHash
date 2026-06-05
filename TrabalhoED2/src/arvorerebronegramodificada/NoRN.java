package TrabalhoED2.src.arvorerebronegramodificada;

public class NoRN<T extends Comparable<T>> {
    private T chave;
    private CorNo cor;
    
    private NoRN<T> pai;
    private NoRN<T> esquerdo;
    private NoRN<T> direito;
    private NoRN<T> irmao;
    
    public NoRN(T chave) {
        this.chave = chave;
        this.cor = CorNo.VERMELHO; 
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
    
    public NoRN<T> getTio() {
        if (pai == null) {
            return null;
        }
        return pai.getIrmao();
    }
    
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
    
    public boolean ehPreto() {
        return cor == CorNo.PRETO;
    }
    
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