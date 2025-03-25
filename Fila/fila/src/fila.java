public class Fila {
    private final int N;
    private final int vet[];
    private int cabeca,cauda;

    public Fila(int i) {
        this.N = i;
        this.cabeca = -1;
        this.cauda = -1;
        this.vet = new int[N];
    }
    
    public void enfileirar(int x){
        
    }

    public void desenfileirar(){
        
    }
    
    public int cabeca(){
        return cabeca;
    }

    public int cauda(){
        return cauda;
    }
    
    private boolean vazia(){
        if(cabeca == cauda){
            return true;
        }else
        return false;
    }
    
    private boolean cheia(){
        
        if((cabeca > cauda) && ((cabeca - cauda ) == 1 )){
            return true;
        }
        else if ((cabeca < cauda) && (((cauda - cabeca) + 1) == N)){
            return true;
        }
        else
        return false;
    }
    
    public int tamanho(){
        int tamanho;
        if(cabeca > cauda ){
          tamanho = N - ((cabeca - cauda) - 1) ;
        }
        return tamanho;
    }
    
    public void exibir(){
        
    }
    
    
}
