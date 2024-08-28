// example : 1
//public class recursion {
//    public static void printNumbers(int n){
//        if(n == 6){
//            return;   // base case
//        }
//        System.out.println(n);
//        printNumbers(n + 1);      // recursion
//    }
//
//    public static void main(String[] args){
//        int n = 1;
//        printNumbers(n);
//    }
//}





// example : 2
//class recursion {
//    public static void printSum(int i, int n, int sum){
//        if(i == n){
//            sum += i;
//            System.out.println("The sum is : " + sum);
//            return;
//        }
//        sum += i;
//        printSum(i + 1, n, sum);
//        System.out.println(i);
//    }
//
//    public static void main(String[] args){
//        printSum(1, 5, 0);
//    }
//}







// example : 3
//class recursion {
//    public static void printFactorial(int i, int n, int factorial){
//        if(i > n){
//            System.out.println("The factorial of " + (i - 1) + " is " + factorial);
//            return;
//        }
//        factorial *= i;
//        printFactorial(i + 1, n, factorial);
//    }
//
//    public static void main(String[] args){
//        printFactorial(1, 6, 1);
//    }
//}








// example : 4  (fibonacci sequence)
class recursion {
    public static void printFibonacci(int a, int b, int n){
        // a - second last term
        // b - last term
        if(n == 0){
            return;
        }
        int c = a + b;
        System.out.println(c);
        printFibonacci(b, c, n-1);
    }

    public static void main(String[] args){
        int a = 0, b = 1;
        System.out.println(a);
        System.out.println(b);
        int n = 7;
        printFibonacci(a, b, n-2);
    }
}
