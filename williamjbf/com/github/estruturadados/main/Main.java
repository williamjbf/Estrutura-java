package williamjbf.com.github.estruturadados.main;

import williamjbf.com.github.estruturadados.conjunto.Conjunto;
import williamjbf.com.github.estruturadados.filas.Fila;
import williamjbf.com.github.estruturadados.listasligadas.ListaDuplamenteLigada;
import williamjbf.com.github.estruturadados.listasligadas.ListaLigada;
import williamjbf.com.github.estruturadados.modelos.Pessoa;
import williamjbf.com.github.estruturadados.pilhas.Pilha;
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
        System.out.println("4- Lista duplamente ligada");
        System.out.println("5- Pilhas");
        System.out.println("6- Filas");
        System.out.println("7- Conjuntos");

        try {
            opcao = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Digite um valor inteiro");
        }

        switch (opcao) {
            case 1 -> fazerGerenciamentoMemoria();
            case 2 -> fazerVetor();
            case 3 -> fazerListaLigada();
            case 4 -> fazerListaDuplamenteLigada();
            case 5 -> fazerPilha();
            case 6 -> fazerFila();
            case 7 -> fazerConjunto();
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

    private static void fazerListaDuplamenteLigada() {
        ListaDuplamenteLigada<Pessoa> listaPessoas = new ListaDuplamenteLigada<>();
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

    public static void fazerPilha(){
        Pilha<Pessoa> pilhaPessoas = new Pilha<>();
        System.out.println(pilhaPessoas.estaVazia());
        pilhaPessoas.empilhar(new Pessoa(1, "Rafael"));
        pilhaPessoas.empilhar(new Pessoa(2, "Kauanny"));
        pilhaPessoas.empilhar(new Pessoa(3, "William"));
        System.out.println(pilhaPessoas.desempilhar().toString());
    }

    public static void fazerFila(){
        Fila<Pessoa> filaPessoas = new Fila<>();
        System.out.println(filaPessoas.estaVazia());
        filaPessoas.enfileirar(new Pessoa(1, "Rafael"));
        filaPessoas.enfileirar(new Pessoa(2, "Kauanny"));
        filaPessoas.enfileirar(new Pessoa(3, "William"));
        System.out.println(filaPessoas.desenfileirar().toString());
    }

    public static void fazerConjunto(){
        Conjunto<Pessoa> conjuntoPessoas = new Conjunto<>();
        System.out.println(conjuntoPessoas.estaVazio());
        Pessoa pessoa = new Pessoa(1, "Rafael");
        System.out.println(conjuntoPessoas.inserir(pessoa));
        System.out.println(conjuntoPessoas.inserir(pessoa));
        conjuntoPessoas.inserir(new Pessoa(3, "William"));
        System.out.println(conjuntoPessoas);
        conjuntoPessoas.remover(pessoa);
        System.out.println(conjuntoPessoas);
        System.out.println(conjuntoPessoas.inserir(pessoa));
        System.out.println(conjuntoPessoas);
    }
}
