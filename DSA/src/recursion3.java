// advance recursion : example : 01 (print all permutations of a string)
//public class recursion3 {        // time complexity = O(n!)
//    public static void printPermutations(String str, String permutations){
//        if(str.length() == 0){
//            System.out.println(permutations);
//        }
//
//        for(int i = 0; i < str.length(); i++){
//            char currChar = str.charAt(i);
//            String newStr = str.substring(0, i) + str.substring(i+1);
//            printPermutations(newStr, permutations+currChar);
//        }
//    }
//
//    public static void main(String[] args){
//        String str = "abc";
//        printPermutations(str, "");
//    }
//}







// example : 2 (count total paths in a maze to move from (0,0) to (n,m))
//class recursion3{
//    public static int countPaths(int i, int j, int n, int m){
//        if(i == n || j == m){      // Time complexity =
//            return 0;
//        }
//        if(i == n-1 && j == m-1){
//            return 1;
//        }
//
//        // move downwards
//        int downPaths = countPaths(i+1, j, n, m);
//
//        // move right
//        int rightPaths = countPaths(i, j+1, n, m);
//
//        return downPaths + rightPaths;
//    }
//
//    public static void main(String[] args){
//        int n = 3, m = 3;
//        System.out.println(countPaths(0, 0, n, m));
//    }
//}








// example : 3 (Place tiles of size 1xm in a floor of size nxm)
//class recursion3{
//    public static int placeTiles(int n, int m){
//        if(n == m){
//            return 2;
//        }
//        if(n < m){
//            return 1;
//        }
//
//        // place vertically
//        int placeVertical = placeTiles(n-m, m);
//
//        // place horizontally
//        int placeHorizontal = placeTiles(n-1, m);
//
//        return placeVertical + placeHorizontal;
//    }
//
//    public static void main(String[] args){
//        int n=4, m=2;
//        System.out.println(placeTiles(n, m));
//    }
//}





// example : 4 (Find the number of ways in which you can invite n people to your party, single or in pairs)
//class recursion3{
//    public static int invitePeople(int n){
//        if(n <= 1){
//            return 1;
//        }
//
//        // single invite
//        int single = invitePeople(n-1);
//
//        // pair invite
//        int pair = invitePeople(n-2);
//
//        return single + pair;
//    }
//
//    public static void main(String[] args){
//        int n = 4;
//        System.out.println(invitePeople(n));
//
//    }
//}