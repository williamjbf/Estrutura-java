package williamjbf.com.github.estruturadados.listasligadas;

public class ListaLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        }
        this.tamanho++;
    }

    public void inseirPrimeiro(T elemento) {
        inserirEm(0, elemento);
    }

    public void inseirUltimo(T elemento) {
        inserirEm(tamanho() - 1, elemento);
    }

    public void inserirEm(int posicao, T elemento) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida", posicao));
        }
        if (posicao == 0) {
            No<T> novoNo = new No<T>(elemento);
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo = novoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> novoNo = new No<T>(elemento);
            this.ultimoNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnteior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<>(elemento);
            noAnteior.setProximo(novoNo);
            novoNo.setProximo(noAtual);
        }
        this.tamanho++;
    }

    public T recuperar(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida", posicao));
        }
        No<T> no = recuperarNo(posicao);
        if (no != null) {
            return no.getElemento();
        }
        return null;
    }

    public int indice(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void remover(int posicao){
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida", posicao));
        }
        if(posicao ==0){
            No<T> noProximo = this.primeiroNo.getProximo();
            this.primeiroNo.setProximo(null);
            this.primeiroNo = noProximo;
        } else if(posicao == tamanho()-1){
            No<T> noAnterior = recuperarNo(tamanho()-2);
            noAnterior.setProximo(null);
            this.ultimoNo = noAnterior;
        }else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noProximo = recuperarNo(posicao + 1);
            No<T> noAtual = recuperarNo(posicao);
            noAnterior.setProximo(noProximo);
            noAtual.setProximo(null);
        }
        tamanho--;
    }

    public void remover(T elemento){
        int indice = indice(elemento);
        if (indice == -1){
            throw new IllegalArgumentException("Elemento inválido " +elemento.toString() );
        }
        remover(indice);
    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("A posição [%d] é inválida", posicao));
        }
        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.primeiroNo;
            } else {
                resultado = resultado.getProximo();
            }
        }
        return resultado;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "Lista {}";
        } else {
            No<T> noAtual = this.primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista {");
            sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
            while (noAtual.getProximo() != null) {
                sb.append(",");
                sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString() : "<NULO>");
                noAtual = noAtual.getProximo();
            }
            sb.append("}");
            return sb.toString();
        }

    }
}
