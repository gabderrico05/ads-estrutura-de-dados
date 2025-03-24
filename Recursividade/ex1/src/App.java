public class App {

    
    public static int soma(int n){
        
        
        if(n >= 1){
            return n += soma(n-1);
        }
        else{
            return 0;
        } 

    
    }

    public static void main(String[] args) throws Exception {
      
        int n = 10;

        System.out.println(soma(n));


}

}