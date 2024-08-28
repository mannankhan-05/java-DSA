
public class recursion {
    public static void printNumbers(int n){
        if(n == 0){
            return;   // base case
        }
        System.out.println(n);
        printNumbers(n - 1);      // recursion
    }

    public static void main(String[] args){
        int n = 5;
        printNumbers(n);
    }
}
