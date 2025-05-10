public class App {

    

    public static void main(String[] args) {
        
        // Pilha p1 = new Pilha();

        // p1.empilhar(2);
        // p1.empilhar(4);
        // p1.empilhar(3);

        // p1.exibe();

        // System.out.println(p1.topo());


        ListaPrima lp1 = new ListaPrima();
        int N = 42;
        for(int i = 0; i < N + 1; i++){
            lp1.inserir(i);
        }

        lp1.exibeInverso();

        lp1.filtrar(N);

        lp1.exibeInverso();
        
    }

   

}