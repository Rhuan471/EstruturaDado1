package estruturas;

public class Vetor {
    public void adicionarNoInicio(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }
    
        // Move todos os elementos uma posição à frente
        for (int i = this.tamanho; i > 0; i--) {
            this.elementos[i] = this.elementos[i - 1];
        }
    
        // Insere o novo valor no início
        this.elementos[0] = valor;
        this.tamanho++;
    }
    
    public void buscaBinaria(Integer valor) {
        int inicio = 0;
        int fim = this.tamanho - 1;
    
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
    
            if (this.elementos[meio].equals(valor)) {
                System.out.println("Valor encontrado na posição " + meio);
                return;
            } else if (this.elementos[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
    
        System.out.println("Valor não encontrado");
    }
    

    public static void main(String[] args) {
        Lista lista = new Lista();
        
        lista.adicionarAoInicio(54);
        lista.adicionarAoInicio(42);
        lista.adicionarAoInicio(33);
        lista.adicionarAoInicio(27);
        lista.adicionarAoInicio(21);
        lista.adicionarAoInicio(16);
        lista.adicionarAoInicio(12);
        lista.adicionarAoInicio(9);
        lista.adicionarAoInicio(7);
        lista.adicionarAoInicio(2);

        lista.mostrarNos();

        System.out.println("-----");

        lista.remover(21);
        lista.mostrarNos();
    }
}
