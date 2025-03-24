package edd_24_03_pilhas_filas;

public class Pilha {

    int vet[];
    int topo = -1;
    

    
    public Pilha(int i) {
        this.vet = new int[i];
        
    }
    public void empilhar(int x){
        
        if(this.cheia() == false){
            vet[++topo] = x;
        }
        else {
            System.out.println("vetor cheio impossível empilhar");
        }

    }

    public void desempilhar(){
        
        if(this.vazia() == false){
            --topo;
        }
        else{
            System.out.println("vetor vazio impossível desempilhar");
        }

    }

    public void exibe(){
            if(this.vazia()){
                System.out.println("esta pilha está vazia!!!");
            }else
            System.out.println("exibindo");
            for(int i = topo; i >=0; i--){
                System.out.println(vet[i]);
            }
        

       
    }
    public int tamanho(){
        return topo + 1;
    }
    public int topo(){
        return topo;
    }

    
    private boolean cheia(){
        if(topo == (vet.length -1)){
            return true;
        }
        else {
            return false;
        }
        
    }

    private boolean vazia(){
        if (tamanho() <= 0) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
}
