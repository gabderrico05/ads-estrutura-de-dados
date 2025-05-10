public class App {
    public static void main(String[] args) {

        int N = 30000;

        int vet[] = new int[N];

        inicializarVetor(vet, N, 2); //0-aleatório, 1-crescente, 2-decrescente

        int vet2[] = vet.clone();
        int vet3[] = vet.clone();
        int vet4[] = vet.clone();
        int vet5[] = vet.clone();
        int vet6[] = vet.clone();
        int vet8[] = vet.clone();

        long inicio, fim, tempoS, tempoMS;

        inicio = System.currentTimeMillis();
        bubbleSort(vet, N); 
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Bubble Sort: " + tempoS + "s" + tempoMS + "ms"  + '\n');

        inicio = System.currentTimeMillis();
        selectionSort(vet2, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 1
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Selection Sort: " + tempoS + "s" + tempoMS + "ms" + '\n');
       
        inicio = System.currentTimeMillis();
        insertionSort(vet3, N); 
        fim = System.currentTimeMillis();
       
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Inserction Sort: " + tempoS + "s" + tempoMS + "ms"  + '\n');        
        
        inicio = System.currentTimeMillis();
        
        mergeSort(vet4, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 3
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Merge Sort: " + tempoS + "s" + tempoMS + "ms" + '\n');

        inicio = System.currentTimeMillis();
        
        heapSort(vet5, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 3
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Heap Sort: " + tempoS + "s" + tempoMS + "ms" + '\n');

        inicio = System.currentTimeMillis();
        
        countingSort(vet6, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 3
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Counting Sort: " + tempoS + "s" + tempoMS + "ms" + '\n');

        inicio = System.currentTimeMillis();
        
        quickSort(vet8, N); // ESSE É O MÉTODO COM A SOLUÇÃO DO PROBLEMA 3
        fim = System.currentTimeMillis();

        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;

        System.out.println("Tempo de ordenacao Quick Sort: " + tempoS + "s" + tempoMS + "ms" + '\n');
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
                    vet[i-1] = N - i;
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

    private static void bubbleSort(int[] vet, int N) {
        int i = 0; 
        do{

            for(int j = 0; j < ((N-1)-i); j++){
                
                if(vet[j] > vet[j+1]){
                    troca(vet, j, j+1);
                    
                }
            }
            i++;

        }while(i < N);
        
    }

    private static void selectionSort(int num[], int tam) { 
        int i, j, min, aux;
        for (i = 0; i < (tam-1); i++) 
        {
           min = i;
           for (j = (i+1); j < tam; j++) {
             if(num[j] < num[min]) 
               min = j;
           }
           if (i != min) {
             aux = num[i];
             num[i] = num[min];
             num[min] = aux;
           }
        }
    }

    private static void insertionSort(int[] vetor, int tam){
        for (int i = 1; i < tam ; i++){
            int aux = vetor[i];
            int j = i;
            while ((j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;
        }
    }

    private static void Juntar(int vetor[], int ini, int meio, int fim, int vetAux[]) {
        int esq = ini;
        int dir = meio;
        for (int i = ini; i < fim; ++i) {
            if ((esq < meio) && ((dir >= fim) || (vetor[esq] < vetor[dir]))) {
                vetAux[i] = vetor[esq];
                ++esq;
            }
            else{
                vetAux[i] = vetor[dir];
                ++dir;
            }
        }
        //copiando o vetor de volta
        for (int i = ini; i < fim; ++i) {
            vetor[i] = vetAux[i];
        }
    }
    
    private static void MergeSort(int vetor[], int inicio, int fim, int vetorAux[]) {
        if ((fim - inicio) < 2) return;
        
        int meio = ((inicio + fim)/2);
        MergeSort(vetor, inicio, meio, vetorAux);
        MergeSort(vetor, meio, fim, vetorAux);
        Juntar(vetor, inicio, meio, fim, vetorAux);
    }
    
    private static void mergeSort(int vetor[], int tam) {
        int[] vetorAux= new int[tam];
        MergeSort(vetor, 0, tam, vetorAux);
    }

    public static void heapSort(int[] vetor, int tamanho){
        int i = tamanho / 2, pai, filho, t;
        while (true){
            if (i > 0){
                i--; t = vetor[i];
            }else{
                tamanho--;
                if (tamanho <= 0) {return;}
                t = vetor[tamanho];
                vetor[tamanho] = vetor[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho){
                if ((filho + 1 < tamanho) && (vetor[filho + 1] > vetor[filho])) {filho++;}
                if (vetor[filho] > t){
                    vetor[pai] = vetor[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                }else {break;}
            }
            vetor[pai] = t;
        }
    }

    private static void countingSort(int[] v, int tam) {
        // Encontra o maior valor em v[]
        int maior = v[0];
        for (int i = 1; i < tam; i++) {
            if (v[i] > maior) {
                maior = v[i];
            }
        }

        // Conta quantas vezes cada valor de v[] aparece
        int[] c = new int[maior + 1]; // +1 pois se 10 for o maior valor, ele iria apenas de 0 a 9
        for (int i = 0; i < tam; i++) {
            c[v[i]] += 1;
        }

        // Acumula as vezes de cada elemento de v[] com os elementos anteriores a este
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // Adiciona os elementos em suas posições conforme o acúmulo de suas frequências
        int[] b = new int[tam];
        for (int i = tam - 1; i >= 0; i--) { // Percorre do fim para o início para manter estável
            b[c[v[i]] - 1] = v[i];
            c[v[i]]--;
        }

        // Copia os elementos ordenados de volta para o vetor original
        for (int i = 0; i < tam; i++) {
            v[i] = b[i];
        }
    }

    private static void quicksort(int[] values, int begin, int end) {
        if (begin >= end - 1) return; // Caso base: array de 1 ou 0 elementos já está ordenado

        int i = begin, j = end - 1;
        int pivot = values[begin + (end - begin) / 2];
        int aux;

        while (i <= j) {
            while (i < end && values[i] < pivot)
                i++;
            while (j >= begin && values[j] > pivot)
                j--;

            if (i <= j) {
                aux = values[i];
                values[i] = values[j];
                values[j] = aux;
                i++;
                j--;
            }
        }

        if (begin < j)
            quicksort(values, begin, j + 1);
        if (i < end)
            quicksort(values, i, end);
    }

    private static void quickSort(int[] values, int tam) {
        quicksort(values, 0, tam);
    }
}




