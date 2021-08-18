package williamjbf.com.github.estruturadados.conjunto;

import williamjbf.com.github.estruturadados.espalhamento.TabelaEspalhamento;

public class Conjunto<T> {

    private final TabelaEspalhamento<T> elementos;

    public Conjunto(){
        this.elementos = new TabelaEspalhamento<>();
    }

    public boolean inserir(T elemento){
        return this.elementos.inserir(elemento);
    }

    public boolean estaVazio(){
        return this.elementos.tamanho() == 0;
    }

    public int tamanho(){
        return this.elementos.tamanho();
    }

    public boolean contem(T elemento){
        return this.elementos.contem(elemento);
    }

    public void remover(T elemento){
        this.elementos.remover(elemento);
    }

    @Override
    public String toString() {
        return "Conjunto[" + "elementos=" + elementos +']';
    }
}
