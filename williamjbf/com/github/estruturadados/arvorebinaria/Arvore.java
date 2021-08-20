package williamjbf.com.github.estruturadados.arvorebinaria;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore(){
        this.raiz = null;
    }

    public NoArvore<T> getRaiz(){
        return this.raiz;
    }

    public void inserir(NoArvore<T> no) {
        no.setNoDireito(null);
        no.setNoEsquerdo(null);
        if (this.raiz == null) {
            this.raiz = no;
        } else {
            this.inserir(this.raiz, no);
        }
    }

    private void inserir(NoArvore<T> ref, NoArvore<T> novoNo) {
        if (ref.peso() < novoNo.peso()) {
            if (ref.getNoDireito() == null) {
                ref.setNoDireito(novoNo);
            } else {
                inserir(ref.getNoDireito(), novoNo);
            }
        } else {
            if (ref.getNoEsquerdo() == null) {
                ref.setNoEsquerdo(novoNo);
            } else {
                inserir(ref.getNoEsquerdo(), novoNo);
            }
        }
    }

    public NoArvore<T> buscar(NoArvore<T> noBusca){
        if(this.raiz == null){
            return null;
        }else{
            return buscar(this.raiz, noBusca);
        }
    }

    private NoArvore<T> buscar(NoArvore<T> ref, NoArvore<T> noBusca){
        if (ref.getValor() == noBusca.getValor()){
            return ref;
        }else{
            if(ref.peso() < noBusca.peso()){
                if(ref.getNoDireito() == null){
                    throw new IllegalArgumentException("Elemento não encontrado na árvore");
                } else {
                    System.out.println("Buscando pela direita");
                    return buscar(ref.getNoDireito(), noBusca);
                }
            }else{
                if(ref.getNoEsquerdo() == null){
                    throw new IllegalArgumentException("Elemento não encontrado na árvore");
                }else{
                    System.out.println("Buscando pela esquerda");
                    return buscar(ref.getNoEsquerdo(),noBusca);
                }
            }
        }
    }

    public void emOrdem(){
        this.emOrdem(this.raiz);
    }

    public void preOrdem(){
        this.preOrdem(this.raiz);
    }

    public void posOrdem(){
        this.posOrdem(this.raiz);
    }

    public int altura(){
        return this.altura(this.raiz);
    }

    private void emOrdem(NoArvore<T> ref){
        if(ref.getNoEsquerdo()!= null){
            emOrdem(ref.getNoEsquerdo());
            System.out.println(ref.getValor().toString());
            if(ref.getNoDireito() != null){
                emOrdem(ref.getNoDireito());
            }
        }else{
            System.out.println(ref.getValor().toString());
            if(ref.getNoDireito() != null){
                emOrdem(ref.getNoDireito());
            }
        }
    }

    private void preOrdem(NoArvore<T> ref){
        System.out.println(ref.getValor().toString());
        if(ref.getNoEsquerdo() != null){
            preOrdem(ref.getNoEsquerdo());
            if (ref.getNoDireito() != null){
                preOrdem(ref.getNoDireito());
            }
        }else{
            if(ref.getNoDireito() != null){
                preOrdem(ref.getNoDireito());
            }
        }
    }

    private void posOrdem(NoArvore<T> ref){
        if(ref.getNoEsquerdo() != null){
            posOrdem(ref.getNoEsquerdo());
            if(ref.getNoDireito() != null){
                posOrdem(ref.getNoDireito());
            }
            System.out.println(ref.getValor().toString());
        }else{
            if (ref.getNoDireito() != null){
                posOrdem(ref.getNoDireito());
                System.out.println(ref.getValor().toString());
            }else{
                System.out.println(ref.getValor().toString());
            }
        }
    }

    private int altura(NoArvore<T> ref){
        if(ref == null){
            return -1;
        }
        int altEsquerda = altura(ref.getNoEsquerdo());
        int altDireita = altura(ref.getNoDireito());
        return altEsquerda > altDireita ? altEsquerda+1 : altDireita+1;
    }

    @Override
    public String toString() {
        return this.raiz == null ? "[(X)]" : this.raiz.toString();
    }
}
