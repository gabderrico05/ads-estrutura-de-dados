public class Pilha {

    static No inicio = null;
    static No fim = null;
 
public void empilhar(int x){

    Fila.insereFim(x);
}

public void desempilhar(){
    Fila.removeFim();
}

public int topo(){
    if (fim != null) {
        return fim.valor;
    }
    else
    {
        throw new IllegalStateException("A pilha está vazia!");  
    }

}

public boolean vazia(){
    if(inicio == null){
        return true;
    }
    else
        return false;   
}

public int tamanho(){

    if (inicio == null)
            return 0;
        else {
            No temp = inicio;
            int i = 0;
            while (temp != null) {
                i++;
                temp = temp.prox;
            }
            return i;
        }

}

public void exibe(){
    Fila.exibe();
}

}