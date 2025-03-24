public class App {
    public static void main(String[] args) {

        int N = 6;

        int vet[] = new int[N];

        inicializarVetor(vet, N, 0); //0-aleatório, 1-crescente, 2-decrescente

        int vet2[] = vet.clone();
        int vet3[] = vet.clone();
        int vet4[] = vet.clone();

        long inicio, fim, tempoS, tempoMS;

        inicio = System.currentTimeMillis();
        ordenarVetorPior(vet, N); // ESSE É O MÉTODO PADRÃO COM DOIS FOR ATÉ N
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Pior: " + tempoS + "s" + tempoMS + "ms");

        inicio = System.currentTimeMillis();
        ordenarVetorMelhor(vet2, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 1
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Melhor: " + tempoS + "s" + tempoMS + "ms");

        inicio = System.currentTimeMillis();
        ordenarVetorMelhorAinda(vet4, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 1 E 2
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Melhor Ainda: " + tempoS + "s" + tempoMS + "ms");        
        
        inicio = System.currentTimeMillis();
        ordenarMaiorMenor(vet3, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 3
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao MaiorMenor: " + tempoS + "s" + tempoMS + "ms");

    }

    static void inicializarVetor(int vet[], int N, int s) {
        switch(s){
            case 0:         
                for (int i = 0; i < N; i++) 
                    vet[i] = (int) (Math.random() * (N * 2));
            break;
            case 1: 
                for (int i = 0; i < N; i++) 
                    vet[i] = i+1;
            break;
            case 2: 
                for (int i = N; i > 0; i--) 
                    vet[i-1] = i;
            break;

        }

    }

    private static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) {
                System.out.print("0" + vet[i] + " ");
            } else {
                System.out.print(vet[i] + " ");
            }
        }
        System.out.println("");
    }

        private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }

    
    private static void ordenarVetorPior(int[] vet, int N) {
        exibirVetor(vet, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < (N -1); j++){
                if(vet[i] < vet[j]){
                    troca(vet, i, j);
                    
                }
                exibirVetor(vet, N);
            }
        }
        exibirVetor(vet, N);
    }
    

    private static void ordenarVetorMelhor(int[] vet, int N) {
        for(int i = 0; i < N; i++){
            boolean troca = false;

            for(int j = 0; j < (N -1); j++){
                if(vet[i] < vet[j]){
                    troca(vet, i, j);
                    troca = true;
                }
            }

            if(!troca){
                i = N - 1;
            }
        }
        exibirVetor(vet, N);
    }
    

    private static void ordenarVetorMelhorAinda(int[] vet, int N) {
        int i = 0; 
        do{

            for(int j = 0; j < ((N-1)-i); j++){
                
                if(vet[j] > vet[j+1]){
                    troca(vet, j, j+1);
                    
                }

                exibirVetor(vet, N);
            }
            i++;

            
        }while(i < N);
        
        exibirVetor(vet, N);
    }
    private static void ordenarMaiorMenor(int[] vet, int N) {
    }

}




