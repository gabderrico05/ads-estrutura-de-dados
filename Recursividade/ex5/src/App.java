public class App {

    public static int somaElementos(int vet[], int n){

        if(n > 0 ){
            
            
          vet[n] += vet[somaElementos(vet, n - 1)];
        }

        return n;
    }
    public static void main(String[] args) throws Exception {
        
        int vet[] = {5,3,2,10,8};

        System.out.println(vet);

        somaElementos(vet, 4);
        



    }
}
