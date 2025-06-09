public class App {

    static  NoA raiz = null;
    public static void main(String[] args) throws Exception {
        
       

        inserir(10);
        inserir(5);
        inserir(7);
        inserir(2);
        inserir(3);
        inserir(4);
        inserir(1);
        inserir(11);
        inserir(9);

        exibir(raiz);

        System.out.println("Maior valor: " + maior(raiz));
        System.out.println("Menor valor: " + menor(raiz));

        exibeArvore(raiz, 0);

        exibeFolhas(raiz);

        System.out.println("profundidade da arvore " + profundidade(raiz));
        System.out.println("tamanho da arvore " + tamanho(raiz, 1));

    }

    public static int maior(NoA temp){

        if(temp != null){
            if(temp.dir != null){
                return maior(temp.dir);
            }
            else
                return temp.valor;

        }
        else 
        throw new IllegalArgumentException("Árvore vazia: não existe maior valor.");
    }


    public static int menor(NoA temp){

        if (temp != null) {
            if(temp.esq != null){
                return menor(temp.esq);
            }
            else{
                return temp.valor;
            }
            
        }
         throw new IllegalArgumentException("Árvore vazia: não existe menor valor.");
    }


     public static void exibir(NoA temp){
        if(temp != null){
            exibir(temp.esq);
            System.out.println(temp.valor);
            exibir(temp.dir);
        }
    }

    public static void exibeFolhas(NoA temp){
        if(temp == raiz){
            System.out.println("\nFolhas da Arvore binária em ordem crescente \n");
        }
        if(temp != null){

            exibeFolhas(temp.esq);
            if(temp.esq == null && temp.dir == null){
                System.out.println(temp.valor);
            }
            exibeFolhas(temp.dir);
        }
    }
    
    private static boolean ehFolha(NoA temp) {
        if((temp.esq == null) && (temp.dir==null))
            return true;
        return false;
    }

      private static int profundidade(NoA temp) {
        if(temp != null){
            if(ehFolha(temp))
                return 0;
            else{
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x>y)? x : y;
                return r+1;
            }
        }
        return -1;
    }

    private static int tamanho(NoA temp, int i){
       
        if(temp != null){

            if(temp.esq != null){
                i++;
              i = tamanho(temp.esq, i);
            }
            if(temp.dir != null){
                i++;
              i = tamanho(temp.dir, i++);
            }
           return i;
        }
        return 0;
        
    }


    public static void inserir(int x){
        NoA novo = new NoA(x);
        
        if(raiz == null)
            raiz = novo;
        
        else{
            
            NoA temp = raiz;
            boolean inseriu = false;
            
            while(!inseriu){
                if(novo.valor <= temp.valor){
                    if(temp.esq == null){
                        temp.esq = novo;
                        inseriu = true;
                    }else{
                        temp = temp.esq;
                    }
                }else{
                    if(temp.dir == null){
                        temp.dir = novo;
                        inseriu = true;
                    }else{
                        temp = temp.dir;
                    }
                }
            }
        }
    }

    static void exibeArvore(NoA n, int x){

        if(n.dir != null)
            exibeArvore(n.dir, x+1);
        else
            System.out.println();

        for(int i=1; i<=x; i++)
            System.out.print("|  ");
        
        if((n.esq == null)&&(n.dir == null))
            System.out.print("["+n.valor+"]");
        else
            System.out.print(n.valor);
   
        if(n.esq != null)
            exibeArvore(n.esq, x+1);
        else
            System.out.println();
        
    }

    static boolean existe(NoA temp, int x){

         if(temp != null){

            if(temp.valor == x){

                return true;
            }
            else {
                boolean e; 

                 if(temp.esq != null){
            
                    e = existe(temp.esq, x);
                 }
                 if(temp.dir != null){
                
                    e = existe(temp.dir, x);
                 }
            }


           
           
        }
        return 0;
    }






}
