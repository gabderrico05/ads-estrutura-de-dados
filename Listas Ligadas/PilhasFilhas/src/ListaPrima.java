
public class ListaPrima {

    static No inicio = null;
    static No fim = null;

    public void inserir(int x){
        No novo = new No(x);
        if (inicio == null)
            inicio = fim = novo;
        else {
            novo.prox = inicio;
            inicio = novo;
        }
    }

    public void exibeInverso() {
        exibeInversoRecursivo(inicio);
    }

    private void exibeInversoRecursivo(No temp) {
        if (temp != null) {
            exibeInversoRecursivo(temp.prox);
            System.out.println(temp.valor);
        }
    }
    

    public void filtrar(int tam){
        
        
        inicio = inicio.prox.prox;

        No temp1 = inicio;

        while (temp1.prox != null && temp1.valor != tam/2) {
            No temp2 = temp1;

            while (temp2.prox != null ) {
                if(temp2.prox.valor % temp1.valor == 0 ){
                    temp2.prox = temp2.prox.prox;
                }

                if (temp2.prox != null) {
                    temp2 = temp2.prox;
                }
            } 

            temp1 = temp1.prox;
        }
         

    }


}