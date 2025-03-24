public class App {

    public static int NumerosCrescentes(int n){

        System.out.println(n);
        
        if(n>0){
            

            NumerosCrescentes(n -1);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        
        int n = 10;

        NumerosCrescentes(n);
    }
}
