import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    static  NoA raiz = null;
    public static void main(String[] args) throws Exception {
        
       
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    int valor = Integer.parseInt(linha.trim());
                    inserir(valor);
                } catch (NumberFormatException e) {
                    // Ignora linhas que não são números
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }


        exibeArvore(raiz, 0);

        for(int i = 0; i <1000; i++){
            remover(i);
        }

        exibeFolhas(raiz);

       
        balancear();
        exibeArvore(raiz, 0);


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

    private static int tamanho(NoA temp) {
    if (temp == null) return 0;
    return 1 + tamanho(temp.esq) + tamanho(temp.dir);
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
            if(temp.valor == x){

                return true;
            }
            else if(temp.esq != null) {
                boolean e = false; 

                 if(temp.esq.valor == x){
                    return true;
                 }
                 else if(temp.esq != null){
                     e = existe(temp.esq, x);
                 }

                if(temp.dir.valor == x){
                    return true;
                 }
                else if( e == false && temp.dir != null){
                
                    e = existe(temp.dir, x);
                 }

                 return e;
            }
            else return false;
    }

    public static void insereExclusivo(int x){
        NoA novo = new NoA(x);
        
        if(raiz == null)
            raiz = novo;
        
        else{
            
            NoA temp = raiz;
            boolean inseriu = false;
            if (existe(raiz, novo.valor) == false){

                while(!inseriu){
                if(novo.valor <= temp.valor){
                        if(temp.esq == null){
                            temp.esq = novo;
                            inseriu = true;
                        }
                        else{
                            temp = temp.esq;
                        }
                    }   
                    else{
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
    }

    static void remover(int x){
	   if(raiz.valor == x){
		   if((raiz.esq == null) && (raiz.dir==null))
				raiz = null;
			else 
				if((raiz.esq != null) && (raiz.dir != null))
					removeDoisFilhos(raiz,x);
				else
					if(raiz.esq == null)
						raiz = raiz.dir;
					else
						raiz = raiz.esq;
	   }
	   else
		removeNo(raiz, x);
   } 
       
    static void removeNo(NoA n, int x){
        
        int f = contaFilhos(n,x);
              
        switch(f){
			case -1: System.out.println("O nó não existe na árvore"); break;
			case  0: removeFolha(n,x); break;
			case  1: removeUmFilho(n,x); break; 
			case  2: removeDoisFilhos(n,x); break;
		}
    }
    
    static int contaFilhos(NoA n, int x){
        int nro_filhos = 0;
        
        if(n.valor == x){
            if(n.esq != null)
                nro_filhos++;
            if(n.dir != null)
                nro_filhos++;
        }else{

			if(x < n.valor)
				if(n.esq != null)
                    nro_filhos+=contaFilhos(n.esq,x);    
                else
					return -1;
                    
			if(x > n.valor)
                if(n.dir != null)
                    nro_filhos+=contaFilhos(n.dir,x);
                else
                    return -1;
        }    
        return nro_filhos;
    }
    
    static void removeFolha(NoA n, int x) {
        
        if(n.esq != null){
            if (n.esq.valor == x) {
                n.esq = null;
            }else{ 
                if(n.valor > x){
                    removeFolha(n.esq, x);
                }
            }
        }

        if(n.dir != null){
            if (n.dir.valor == x) {
                n.dir = null;
            }else{ 
                if(n.valor < x){
                    removeFolha(n.dir, x);
                }
            }
        }
    }
                    
        
    static void removeUmFilho(NoA n, int x) {
        boolean removeu = false;
        
        if (n.esq != null) {
            if (n.esq.valor == x) {
                removeu = true;
                if (n.esq.esq != null) {
                    n.esq = n.esq.esq;
                } else if (n.esq.dir != null) {
                    n.esq = n.esq.dir;
                }
            }
        }

        if (n.dir != null) {
            if (n.dir.valor == x) {
                removeu = true;
                if (n.dir.esq != null) {
                    n.dir = n.dir.esq;
                } else if (n.dir.dir != null) {
                    n.dir = n.dir.dir;
                }
            }

        }

        if (!removeu) {
            if (x < n.valor) {
                removeUmFilho(n.esq, x);
            } else {
                removeUmFilho(n.dir, x);
            }
        }
    }
		

    static void removeDoisFilhos(NoA n, int x){
         if(n.valor == x){
			
			NoA tmp = noMaisAEsquerda(n.dir);
			
			// ISSO SERVE PARA RESOLVER O PROBLEMA DO N.DIR SER O NUMERO A SER REMOVIDO
			int novovalor = tmp.valor;
			// ESTA SENDO PASSADO POR PARAMETRO O VALOR DE N (PAI DE N.DIR)
			removeNo(n,tmp.valor);
			n.valor = novovalor;
			
		} else{
			if(x<n.valor)
				removeDoisFilhos(n.esq, x);
			else
				removeDoisFilhos(n.dir, x);
		}		
    }
    
    
    static NoA noMaisAEsquerda(NoA n){
		NoA retorno = null;
		if(n.esq!=null){
			
			retorno = noMaisAEsquerda(n.esq);
		}
			else
				retorno = n;
		
		return retorno;
		
	}



    public static NoA girarDireita(NoA x){
        NoA y = x.esq; //Seja Y o filho à esquerda de X
        x.esq = y.dir; // Torne o filho à direita de Y o filho à esquerda de X.
        y.dir = x; // Torne X o filho à direita de Y
        return y;
    }

    public static NoA girarEsquerda(NoA x){
        NoA y = x.dir; //Seja Y o filho à direita de X
        x.dir = y.esq; // Torne o filho à esquerda de Y o filho à direita de X.
        y.esq = x; // Torne X o filho à esquerda de Y
        return y;
    }
    
    // Adicione este método para coletar os valores em ordem
    private static void emOrdem(NoA n, List<Integer> lista) {
        if (n == null) return;
        emOrdem(n.esq, lista);
        lista.add(n.valor);
        emOrdem(n.dir, lista);
    }

    // Método para construir árvore balanceada a partir da lista ordenada
    private static NoA construirBalanceada(List<Integer> lista, int inicio, int fim) {
        if (inicio > fim) return null;
        int meio = (inicio + fim) / 2;
        NoA novo = new NoA(lista.get(meio));
        novo.esq = construirBalanceada(lista, inicio, meio - 1);
        novo.dir = construirBalanceada(lista, meio + 1, fim);
        return novo;
    }

    // Método principal de balanceamento
    public static void balancear() {
        List<Integer> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        raiz = construirBalanceada(lista, 0, lista.size() - 1);
    }

    }