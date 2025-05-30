public class ListasDuplamenteLigadas {

    static No inicio = null;
    
    public static void main(String[] args) {

        inserirOrdenado(3);
        
        inserirOrdenado(2);
 

        exibir();



        exibir();


    }
    
    static void inserir(int x){
        No novo = new No(x);
        
        if(inicio == null){
            novo.prox = novo;
            novo.ant = novo;
            inicio = novo;
        }
        else{
           
            No temp = inicio;

            while(temp.prox != inicio){
                temp = temp.prox;
            }

            temp.prox = novo;
            temp.prox.ant = temp;
            temp.prox.prox = inicio;
            inicio.ant = temp.prox;
        }
    }

    static void inserirOrdenado(int x){
        
        No novo = new No(x);

        if(inicio == null){
            novo.prox = novo;
            novo.ant = novo;
            inicio = novo;
        }
        else{
           
            No temp = inicio;

            while(novo.valor > temp.valor && temp.prox != inicio ){
                    temp = temp.prox;
            }
            if (novo.valor < temp.valor) {

                novo.prox = temp;
                novo.ant = temp.ant;

                temp.ant.prox = novo;
                temp.ant = novo; 
                
                
            }
            else{

                novo.prox = inicio;
                novo.ant = temp;
                inicio.ant = novo;
                temp.prox = novo;    
                
            }
            
                
            
        }
    }

    static void exibir(){
        No temp = inicio;

           
        while(temp.prox != inicio){
            System.out.println(temp.valor);
            temp = temp.prox;
        }

        System.out.println(temp.valor + "\n");
    }

    static void exibirInverso(){


    }

    static void remover(int x){


        
        if(inicio == null){
            System.out.println("Lista duplamente ligada vazia");
        }
        else if(inicio.prox == inicio){
            
            inicio = null;
        }
        else{
           
            No temp = inicio;

            while( temp.valor != x && temp.prox != inicio ){
                temp = temp.prox;
            }

            if (temp.valor == x) {
                System.out.println("removendo nó de valor: " + temp.valor);
                 
                temp.ant.prox = temp.prox; 
                temp.prox.ant = temp.ant;
            }
            else{
                 System.out.println("Nó de valor: "+ x + "Não encontrado");
            }


           
            
           
        }

    }

    static void removerPrimeiro(){
        
        inicio.ant.prox = inicio.prox;
        inicio.prox.ant = inicio.ant;
        inicio = inicio.prox;
        

    }

    static void removerUltimo(){
        inicio.ant.ant.prox = inicio;
        inicio.ant = inicio.ant.ant;
    }

}
    

