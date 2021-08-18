package williamjbf.com.github.estruturadados.filas;


import williamjbf.com.github.estruturadados.listasligadas.ListaLigada;

public class Fila<T> {

    private ListaLigada<T> elementos;

    public Fila(){
        this.elementos = new ListaLigada<>();
    }

    public boolean estaVazia(){
        return this.elementos.estaVazia();
    }

    public void enfileirar(T elemento){
        this.elementos.inserir(elemento);
    }

    public T desenfileirar(){
        if(estaVazia()){
            return null;
        }
        T resultado = this.elementos.recuperar(0);
        this.elementos.remover(0);
        return resultado;
    }


}
