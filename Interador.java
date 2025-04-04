package estruturas;

class No {
    int dado;
    No proximo;
    No anterior;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}

class Lista {
    No inicio;
    No fim;

    public void adicionarFim(int valor) {
        No novo = new No(valor);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void mostrarLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

class Interador {
    No atual;
    Lista lista;

    public Interador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public int getDado(){
        return atual.dado;
    }

    public void inserirAposAtual(int valor) {
        No novo = new No(valor);
        No proximo = atual.proximo;

        atual.proximo = novo;
        novo.anterior = atual;

        if (proximo != null) {
            novo.proximo = proximo;
            proximo.anterior = novo;
        } else {
            lista.fim = novo;
        }
    }

    public void removerAposAtual() {
        if (atual.proximo == null) return;

        No remover = atual.proximo;
        No novoProximo = remover.proximo;

        atual.proximo = novoProximo;
        if (novoProximo != null) {
            novoProximo.anterior = atual;
        } else {
            lista.fim = atual;
        }
    }

    public void inserirAntesDoAtual(int valor) {
        No novo = new No(valor);
        No anterior = atual.anterior;

        novo.proximo = atual;
        atual.anterior = novo;

        if (anterior != null) {
            anterior.proximo = novo;
            novo.anterior = anterior;
        } else {
            lista.inicio = novo;
        }
    }

    public void removerAntesDoAtual() {
        if (atual.anterior == null) return;

        No remover = atual.anterior;
        No novoAnterior = remover.anterior;

        atual.anterior = novoAnterior;
        if (novoAnterior != null) {
            novoAnterior.proximo = atual;
        } else {
            lista.inicio = atual;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        int[] valores = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};
        for (int v : valores) {
            lista.adicionarFim(v);
        }

        System.out.println("Lista original:");
        lista.mostrarLista();

        Interador it = new Interador(lista, lista.inicio.proximo.proximo); // atual = 9

        System.out.println("\nInserir 10 após o atual (" + it.getDado() + "):");
        it.inserirAposAtual(10);
        lista.mostrarLista();

        System.out.println("\nRemover após o atual (" + it.getDado() + "):");
        it.removerAposAtual();
        lista.mostrarLista();

        System.out.println("\nInserir 8 antes do atual (" + it.getDado() + "):");
        it.inserirAntesDoAtual(8);
        lista.mostrarLista();

        System.out.println("\nRemover antes do atual (" + it.getDado() + "):");
        it.removerAntesDoAtual();
        lista.mostrarLista();
    }
}
