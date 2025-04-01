

public class App {

    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {

        insereInicio(5);
        exibe(inicio);


    }

    private static void insereInicio(int x) {
        No novo = new No(x);
        if(inicio == null){
            inicio = novo;
        }
        novo.prox = inicio;
        inicio = novo;
        
    }

    private static void insereFim(int x) {

    }

    private static void removeInicio() {

    }

    private static void removeFim() {

    }

    private static void exibe(No temp) {
        if(temp != null){
            System.out.println(temp.valor);
            exibe(temp.prox);
        }
    }

    private static void exibeInverso() {

    }

}