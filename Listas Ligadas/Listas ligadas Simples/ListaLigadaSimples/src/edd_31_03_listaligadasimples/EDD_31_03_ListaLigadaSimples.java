package edd_31_03_listaligadasimples;

public class EDD_31_03_ListaLigadaSimples {

    static No inicio = null; // <- VARIÁVEL GLOBAL
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 50);
            insereOrdenado(x);
            exibir(inicio);
            System.out.println("\n");
        }
        
        
        System.out.println("\n");
        
    }

    private static void inserir(int x) {
        No novo = new No(x);
        
        if(inicio == null)
            inicio = novo;
        else{
            No temp = inicio;
            while(temp.prox != null)
                temp = temp.prox;
            temp.prox = novo;
        }
    }

    private static void insereOrdenado(int x) {
        No novo = new No(x);
        
        if(inicio == null)
            inicio = novo;

        else if(novo.valor < inicio.valor){
           novo.prox = inicio;
           inicio = novo;

        }
        else {
            No temp = inicio;

            while ((temp.prox != null) && (temp.prox.valor < novo.valor) ){
                temp = temp.prox;
            }
            
            if(temp.prox == null){
                temp.prox = novo;
            }
            else{
                novo.prox = temp.prox;

                temp.prox = novo;
            }
        }
        
    }

    private static void exibir(No temp) {
       if(temp != null){
           System.out.println(temp.valor);
           exibir(temp.prox);
       }
       
    }

    private static void removeUltimo(No temp){
        if(temp != null && temp.prox != null){
            while(temp.prox.prox != null)
            temp = temp.prox;
        
            temp.prox = null;

        }
        else if (temp != null){
            inicio = null;
        }
        else{
            System.out.println("não existem elementos a serem retirados da lista");
        }
       
            
    }

    
    
    
}
