# Estruturas de Dados II - Trabalho Unidade 2

## Aluna

Àdilla Roberta Gomes Pereira

## Disciplina

Estruturas de Dados II

---

## Descrição

Este trabalho apresenta a implementação de duas estruturas de dados estudadas na disciplina:

- Árvore Rubro-Negra Modificada
- Tabela Hash com Endereçamento Aberto

O objetivo é demonstrar o funcionamento das operações fundamentais de inserção, remoção, busca, balanceamento e tratamento de colisões utilizando implementações próprias em Java.

---

## Estruturas Implementadas

### 1. Árvore Rubro-Negra Modificada

Estrutura baseada em árvore binária de busca balanceada.

#### Operações implementadas

- Inserção
- Remoção
- Busca
- Rotações à esquerda
- Rotações à direita
- Correção após inserção (RB-INSERT-FIXUP)
- Correção após remoção (RB-DELETE-FIXUP)
- Impressão em ordem
- Impressão estrutural

#### Propriedades mantidas

- Todo nó é vermelho ou preto
- A raiz é sempre preta
- Nós vermelhos possuem apenas filhos pretos
- Todo caminho da raiz até uma folha possui a mesma quantidade de nós pretos

#### Complexidade

| Operação | Complexidade |
| -------- | ------------ |
| Busca | O(log n) |
| Inserção | O(log n) |
| Remoção | O(log n) |

---

### 2. Tabela Hash com Endereçamento Aberto

Estrutura baseada em espalhamento utilizando:

- Método da Multiplicação
- Hash Quadrático
- Redimensionamento Dinâmico

### Operações da Tabela Hash

- Inserção
- Busca
- Remoção lógica
- Atualização de valores
- Tratamento de colisões
- Redimensionamento automático

#### Características

- Fator de carga máximo de 70%
- Crescimento por fator 3
- Capacidades sempre números primos

#### Complexidade da Tabela Hash

| Operação | Caso Médio |
| -------- | ---------- |
| Inserção | O(1) |
| Busca | O(1) |
| Remoção | O(1) |

---

## Testes Disponíveis

### Árvore Rubro-Negra

1. Inserções simples
2. Inserções com balanceamento
3. Remoções
4. Inserções aleatórias
5. Inserção simples com 3 elementos
6. Busca de elementos
7. Chaves duplicadas

### Tabela Hash

1. Inserção simples
2. Tratamento de colisões
3. Redimensionamento dinâmico
4. Buscas e remoções
5. Inserções aleatórias
6. Atualização de valores

---

## Como Executar

Compile o projeto:

```bash
javac Main.java
```

Execute:

```bash
java Main
```

---

## Estrutura do Projeto

```text
src/
├── arvorerebronegramodificada/
│   ├── ArvoreRubroNegraModificada.java
│   ├── CorNo.java
│   └── NoRN.java
│
├── tabelahash/
│   ├── EntradaTabela.java
│   ├── StatusEntrada.java
│   └── TabelaHash.java
│
└── utilitarios/
    └── FuncaoHash.java

testes/
├── TesteArvoreRubroNegra.java
└── TesteTabelaHash.java

Main.java
```

---

## Resultados

Todos os testes executados demonstram:

- Balanceamento correto da árvore
- Busca eficiente
- Tratamento adequado de duplicatas
- Tratamento de colisões na tabela hash
- Redimensionamento automático
- Atualização de valores existentes
- Remoções corretas

---

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- Estruturas de Dados
