package TrabalhoED2.src.arvorerebronegramodificada;

public class ArvoreRubroNegraModificada<T extends Comparable<T>> {
    private NoRN<T> raiz;
    private NoRN<T> ultimoInserido;
    private int tamanho;
    
    public ArvoreRubroNegraModificada() {
        this.raiz = null;
        this.tamanho = 0;
    }
    
    public void inserir(T chave) {
    if (chave == null) {
        throw new IllegalArgumentException("Chave não pode ser nula");
    }

    ultimoInserido = null;

    raiz = rbInsert(raiz, chave);

    if (ultimoInserido != null) {
        fixupInsercao(ultimoInserido);
        atualizarIrmaosRecursivo(raiz);
        tamanho++;
    }

    if (raiz != null) {
        raiz.setCor(CorNo.PRETO);
    }
}
    
    private NoRN<T> rbInsert(NoRN<T> node, T chave) {

    if (node == null) {
        ultimoInserido = new NoRN<>(chave);
        return ultimoInserido;
    }

    int cmp = chave.compareTo(node.getChave());

    if (cmp < 0) {
        node.setEsquerdo(rbInsert(node.getEsquerdo(), chave));
    }
    else if (cmp > 0) {
        node.setDireito(rbInsert(node.getDireito(), chave));
    }
    else {
        return node;
    }
    return node;
}
    public void fixupInsercao(NoRN<T> z) {
        while (z != raiz && z.getPai() != null && z.getPai().ehVermelho()) {
            
            if (z.getPai() == z.getPai().getPai().getEsquerdo()) {
                // Caso: Pai é filho esquerdo do avó
                NoRN<T> tio = z.getPai().getIrmao();
                
                if (tio != null && tio.ehVermelho()) {
                    // CASO 1: Tio é vermelho
                    z.getPai().setCor(CorNo.PRETO);
                    tio.setCor(CorNo.PRETO);
                    z.getPai().getPai().setCor(CorNo.VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    // Tio é preto
                    if (z == z.getPai().getDireito()) {
                        // CASO 2: z é filho direito 
                        z = z.getPai();
                        rotacaoEsquerda(z);
                    }
                    // CASO 3: z é filho esquerdo 
                    z.getPai().setCor(CorNo.PRETO);
                    z.getPai().getPai().setCor(CorNo.VERMELHO);
                    rotacaoDireita(z.getPai().getPai());
                }
            } else {
                // Caso simétrico: Pai é filho direito do avó
                NoRN<T> tio = z.getPai().getIrmao();
                
                if (tio != null && tio.ehVermelho()) {
                    // CASO 1: Tio é vermelho
                    z.getPai().setCor(CorNo.PRETO);
                    tio.setCor(CorNo.PRETO);
                    z.getPai().getPai().setCor(CorNo.VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    // Tio é preto
                    if (z == z.getPai().getEsquerdo()) {
                        // CASO 2: z é filho esquerdo 
                        z = z.getPai();
                        rotacaoDireita(z);
                    }
                    // CASO 3: z é filho direito 
                    z.getPai().setCor(CorNo.PRETO);
                    z.getPai().getPai().setCor(CorNo.VERMELHO);
                    rotacaoEsquerda(z.getPai().getPai());
                }
            }
        }
        raiz.setCor(CorNo.PRETO);
    }
    
    public void rotacaoEsquerda(NoRN<T> x) {

    if (x == null || x.getDireito() == null) {
        return;
    }

    NoRN<T> y = x.getDireito();

    x.setDireito(y.getEsquerdo());

    y.setPai(x.getPai());

    if (x.getPai() == null) {
        raiz = y;
    } else if (x == x.getPai().getEsquerdo()) {
        x.getPai().setEsquerdo(y);
    } else {
        x.getPai().setDireito(y);
    }

    y.setEsquerdo(x);
    x.setPai(y);

    atualizarIrmaosRecursivo(raiz);
}
    
    public void rotacaoDireita(NoRN<T> y) {

    if (y == null || y.getEsquerdo() == null) {
        return;
    }

    NoRN<T> x = y.getEsquerdo();

    y.setEsquerdo(x.getDireito());

    x.setPai(y.getPai());

    if (y.getPai() == null) {
        raiz = x;
    } else if (y == y.getPai().getEsquerdo()) {
        y.getPai().setEsquerdo(x);
    } else {
        y.getPai().setDireito(x);
    }

    x.setDireito(y);
    y.setPai(x);

    atualizarIrmaosRecursivo(raiz);
}
    
    private void atualizarIrmaos(NoRN<T> node) {

    if (node == null) {
        return;
    }

    if (node.getPai() == null) {
        node.setIrmao(null);
        return;
    }

    if (node == node.getPai().getEsquerdo()) {
        node.setIrmao(node.getPai().getDireito());
    } else {
        node.setIrmao(node.getPai().getEsquerdo());
    }
}

    private void atualizarIrmaosRecursivo(NoRN<T> node) {

    if (node == null) {
        return;
    }

    atualizarIrmaos(node);

    atualizarIrmaosRecursivo(node.getEsquerdo());
    atualizarIrmaosRecursivo(node.getDireito());
}
    
    public void remover(T chave) {
        NoRN<T> node = buscarNode(raiz, chave);
        if (node != null) {
            rbDelete(node);
            tamanho--;
        }
    }
    
    private void rbDelete(NoRN<T> z) {
        NoRN<T> y = z;
        CorNo corOriginal = y.getCor();
        NoRN<T> x;
        
        if (z.getEsquerdo() == null) {
            x = z.getDireito();
            transplante(z, z.getDireito());
        } else if (z.getDireito() == null) {
            x = z.getEsquerdo();
            transplante(z, z.getEsquerdo());
        } else {
            y = minimo(z.getDireito());
            corOriginal = y.getCor();
            x = y.getDireito();
            
            if (y.getPai() == z) {
                if (x != null) {
                    x.setPai(y);
                }
            } else {
                transplante(y, y.getDireito());
                y.setDireito(z.getDireito());
            }
            
            transplante(z, y);
            y.setEsquerdo(z.getEsquerdo());
            y.setCor(z.getCor());
        }
        
        if (corOriginal == CorNo.PRETO && x != null) {
            fixupDelecao(x);
        }
    }
    
    private void fixupDelecao(NoRN<T> x) {
        while (x != raiz && x.ehPreto()) {
            if (x == x.getPai().getEsquerdo()) {
                NoRN<T> w = x.getPai().getDireito();
                
                // CASO 1: Irmão é vermelho
                if (w != null && w.ehVermelho()) {
                    w.setCor(CorNo.PRETO);
                    x.getPai().setCor(CorNo.VERMELHO);
                    rotacaoEsquerda(x.getPai());
                    w = x.getPai().getDireito();
                }
                
                // CASO 2: Irmão é preto com dois filhos pretos
                if (w != null &&
                    (w.getEsquerdo() == null || w.getEsquerdo().ehPreto()) &&
                    (w.getDireito() == null || w.getDireito().ehPreto())) {
                    w.setCor(CorNo.VERMELHO);
                    x = x.getPai();
                } else if (w != null) {
                    // CASO 3: Irmão preto, filho esquerdo vermelho
                    if (w.getDireito() == null || w.getDireito().ehPreto()) {
                        if (w.getEsquerdo() != null) {
                            w.getEsquerdo().setCor(CorNo.PRETO);
                        }
                        w.setCor(CorNo.VERMELHO);
                        rotacaoDireita(w);
                        w = x.getPai().getDireito();
                    }
                    // CASO 4: Irmão preto, filho direito vermelho
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(CorNo.PRETO);
                    if (w.getDireito() != null) {
                        w.getDireito().setCor(CorNo.PRETO);
                    }
                    rotacaoEsquerda(x.getPai());
                    x = raiz;
                }
            } else {
                // Caso simétrico
                NoRN<T> w = x.getPai().getEsquerdo();
                
                // CASO 1
                if (w != null && w.ehVermelho()) {
                    w.setCor(CorNo.PRETO);
                    x.getPai().setCor(CorNo.VERMELHO);
                    rotacaoDireita(x.getPai());
                    w = x.getPai().getEsquerdo();
                }
                
                // CASO 2
                if (w != null &&
                    (w.getDireito() == null || w.getDireito().ehPreto()) &&
                    (w.getEsquerdo() == null || w.getEsquerdo().ehPreto())) {
                    w.setCor(CorNo.VERMELHO);
                    x = x.getPai();
                } else if (w != null) {
                    // CASO 3
                    if (w.getEsquerdo() == null || w.getEsquerdo().ehPreto()) {
                        if (w.getDireito() != null) {
                            w.getDireito().setCor(CorNo.PRETO);
                        }
                        w.setCor(CorNo.VERMELHO);
                        rotacaoEsquerda(w);
                        w = x.getPai().getEsquerdo();
                    }
                    // CASO 4
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(CorNo.PRETO);
                    if (w.getEsquerdo() != null) {
                        w.getEsquerdo().setCor(CorNo.PRETO);
                    }
                    rotacaoDireita(x.getPai());
                    x = raiz;
                }
            }
        }
        x.setCor(CorNo.PRETO);
    }
    
    private void transplante(NoRN<T> u, NoRN<T> v) {
        if (u.getPai() == null) {
            raiz = v;
        } else if (u == u.getPai().getEsquerdo()) {
            u.getPai().setEsquerdo(v);
        } else {
            u.getPai().setDireito(v);
        }
        
        if (v != null) {
            v.setPai(u.getPai());
        }
    }
    
    private NoRN<T> minimo(NoRN<T> node) {
        while (node.getEsquerdo() != null) {
            node = node.getEsquerdo();
        }
        return node;
    }
    
    private NoRN<T> buscarNode(NoRN<T> node, T chave) {
        if (node == null) {
            return null;
        }
        
        int cmp = chave.compareTo(node.getChave());
        if (cmp < 0) {
            return buscarNode(node.getEsquerdo(), chave);
        } else if (cmp > 0) {
            return buscarNode(node.getDireito(), chave);
        } else {
            return node;
        }
    }
    
    public boolean contem(T chave) {
        return buscarNode(raiz, chave) != null;
    }
    
    public void imprimirEmOrdem() {
        imprimirEmOrdemAux(raiz);
        System.out.println();
    }
    
    private void imprimirEmOrdemAux(NoRN<T> node) {
        if (node != null) {
            imprimirEmOrdemAux(node.getEsquerdo());
            System.out.print("[" + node.getChave() + ":" + node.getCor() + "] ");
            imprimirEmOrdemAux(node.getDireito());
        }
    }
    
    public void imprimirArvore() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        }
        imprimirArvoreAux(raiz, "", true);
    }
    
    private void imprimirArvoreAux(NoRN<T> node, String prefixo, boolean isLast) {
        if (node != null) {
            System.out.println(prefixo + (isLast ? "└── " : "├── ") + 
                             node.getChave() + " (" + node.getCor() + ")");
            String novosPrefixo = prefixo + (isLast ? "    " : "│   ");
            
            if (node.getEsquerdo() != null || node.getDireito() != null) {
                imprimirArvoreAux(node.getEsquerdo(), novosPrefixo, 
                                node.getDireito() == null);
                imprimirArvoreAux(node.getDireito(), novosPrefixo, true);
            }
        }
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public NoRN<T> getRaiz() {
        return raiz;
    }
}
