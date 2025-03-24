public class App {

    public static int pot(int x, int n){

        if(n > 1){

            x = x*pot(x, n - 1);
            
        }
        else if(n == 0){
            return 1;
        }

         return x;
    }
    public static void main(String[] args) throws Exception {
        
        int x = 4;
        int n = 4;

        System.out.println(pot(x, n));

    }
}
