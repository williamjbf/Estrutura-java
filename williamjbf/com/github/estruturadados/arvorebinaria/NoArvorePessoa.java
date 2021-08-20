package williamjbf.com.github.estruturadados.arvorebinaria;

import williamjbf.com.github.estruturadados.modelos.Pessoa;

public class NoArvorePessoa extends NoArvore<Pessoa> {

    public NoArvorePessoa(Pessoa valor) {
        super(valor);
    }

    @Override
    public int peso() {
        return this.valor.getId();
    }
}
