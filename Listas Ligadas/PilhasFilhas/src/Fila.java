public class Fila {

    static No inicio = null;
    static No fim = null;

    public static void insereInicio(int x) {
        No novo = new No(x);
        if (inicio == null)
            inicio = fim = novo;
        else {
            novo.prox = inicio;
            inicio = novo;
        }
    }

    public static void insereFim(int x) {
        No novo = new No(x);
        if (inicio == null)
            inicio = fim = novo;
        else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public static void removeInicio() {
        if (inicio == null)
            System.out.println("Lista Vazia, impossível remover o início!");
        else if (inicio == fim)
            inicio = fim = null;
        else
            inicio = inicio.prox;
    }

    public static void removeFim() {
        if (inicio == null)
            System.out.println("Lista Vazia, impossível remover o fim!");
        else if (inicio == fim)
            inicio = fim = null;
        else {
            No temp = inicio;
            while (temp.prox != fim)
                temp = temp.prox;
            temp.prox = null;
            fim = temp;
        }
    }

    public static void exibe() {
        if (inicio == null)
            System.out.println("Lista Vazia, nada a exibir!");
        else {
            No temp = inicio;
            while (temp != null) {
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

    public static void exibeInverso() {
        exibeInversoRecursivo(inicio);
    }

    private static void exibeInversoRecursivo(No temp) {
        if (temp != null) {
            exibeInversoRecursivo(temp.prox);
            System.out.println(temp.valor);
        }
    }
    
}
