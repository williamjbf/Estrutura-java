package williamjbf.com.github.estruturadados.main;

import williamjbf.com.github.estruturadados.listasligadas.ListaLigada;
import williamjbf.com.github.estruturadados.modelos.Pessoa;
import williamjbf.com.github.estruturadados.vetores.Vetor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a opção desejada");
        System.out.println("1- Gerencia de memoria");
        System.out.println("2- Vetores");
        System.out.println("3- Lista ligada");
        try {
            opcao = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Digite um valor inteiro");
        }

        switch (opcao) {
            case 1 -> fazerGerenciamentoMemoria();
            case 2 -> fazerVetor();
            case 3 -> fazerListaLigada();
        }

        scan.close();
    }

    private static void fazerGerenciamentoMemoria() {
        int a = 3;
        System.out.println(a);
        int b = a;
        System.out.println(b);
        b = 2;
        System.out.println("*****************");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

        System.out.println("-----------------");
        Pessoa p1 = new Pessoa(1, "Rafael");
        System.out.println(p1);
        Pessoa p2 = new Pessoa(1, "Rafael");
        System.out.println(p2);
        System.out.println("*****************");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }

    private static void fazerVetor() {
        Vetor<Pessoa> vetorPessoas = new Vetor<>();
        vetorPessoas.inserir(new Pessoa(1, "Rafael"));
        vetorPessoas.inserir(new Pessoa(2, "Kauanny"));
        vetorPessoas.inserir(new Pessoa(3, "William"));
        vetorPessoas.inserir(new Pessoa(4, "Milany"));
        vetorPessoas.inserirEm(1, new Pessoa(5, "Kelly"));
        System.out.println(vetorPessoas);
        System.out.println("Lista de pessoas: ");
        for (int i = 0; i < vetorPessoas.tamanho(); i++) {
            System.out.println(vetorPessoas.recuperar(i).getNome());
        }
        Pessoa pessoExistente = vetorPessoas.recuperar(1);
        Pessoa pessoNaoExistente = new Pessoa(100, "Dani");
        System.out.println(vetorPessoas.contem(pessoExistente));
        System.out.println(vetorPessoas.indice(pessoExistente));
        System.out.println(vetorPessoas.contem(pessoNaoExistente));
        System.out.println(vetorPessoas.indice(pessoNaoExistente));
        vetorPessoas.remover(2);
        //vetorPessoas.remover(10);
        System.out.println(vetorPessoas);
        vetorPessoas.remover(pessoExistente);
        //vetorPessoas.remover(pessoNaoExistente);
        System.out.println(vetorPessoas);
    }

    private static void fazerListaLigada() {
        ListaLigada<Pessoa> listaPessoas = new ListaLigada<>();
        listaPessoas.inserir(new Pessoa(1, "Rafael"));
        listaPessoas.inserir(new Pessoa(2, "Kauanny"));
        listaPessoas.inserir(new Pessoa(3, "William"));
        System.out.println(listaPessoas);
        listaPessoas.inserirEm(1, new Pessoa(4, "Milany"));
        listaPessoas.inseirPrimeiro(new Pessoa(5, "Kelly"));
        listaPessoas.inseirUltimo(new Pessoa(6, "Jeff"));
        System.out.println(listaPessoas);
        System.out.println(listaPessoas.recuperar(1));
        System.out.println(listaPessoas.indice(new Pessoa(1,"Rafael")));
        System.out.println(listaPessoas.contem(new Pessoa(1,"Rafael")));
        listaPessoas.remover(1);
        listaPessoas.remover(new Pessoa(5, "Kelly"));
        System.out.println(listaPessoas);
        for(int i =0; i< listaPessoas.tamanho();i++){
            System.out.println(listaPessoas.recuperar(i));
        }
    }
}
