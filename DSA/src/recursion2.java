import java.util.HashSet;

// example 1 : (Tower of Hanoi)
//class recursion2{
//    public static void hanoi(int n, String src, String helper, String dest){
//        if(n == 1){
//            System.out.println("transfered disk " + n + " from " + src + " to " + dest);
//            return;
//        }
//        hanoi(n-1, src, dest, helper);
//        System.out.println("transfered disk " + n + " from " + src + " to " + dest);
//        hanoi(n-1, helper, src, dest);
//    }
//
//    public static void main(String[] args){
//        int n = 3;
//        hanoi(n, "source", "helper", "destination");
//    }
//}








// example 2 : (print a string in reverse)
//class recursion2{
//    public  static void printReverseString(String str, int index){
//        if(index == 0){
//            System.out.println(str.charAt(index));
//            return;
//        }
//        System.out.print(str.charAt(index) + " ");
//        printReverseString(str, index - 1);
//    }
//
//    public static void main(String[] args){
//        String str = "mannan";
//        printReverseString(str, str.length() - 1);
//    }
//}







// example : 3 (how to print reverse array)
//class recursion2{
//    public static void printReverseArray(int arr[], int index){
//        if(index == 0){
//            System.out.print(arr[index] + " ");
//            return;
//        }
//        System.out.print(arr[index] + " ");
//        printReverseArray(arr, index - 1);
//    }
//
//    public static void main(String[] args){
//        int arr[] = {1, 2, 3, 4, 5, 6, 7};
//        printReverseArray(arr, arr.length - 1);
//    }
//}








// example 4 : (find the 1st and last occurance of an element in a string)
//class recursion2{
//    public static int first = -1;
//    public static int last = -1;
//
//    public static void findOccurance(String str, int index, char element){
//        if(index == str.length()){
//            System.out.println(first);
//            System.out.println(last);
//            return;
//        }
//        char currChar = str.charAt(index);
//        if(currChar == element){
//            if(first == -1){
//                first = index;
//            }
//            else{
//                last = index;
//            }
//        }
//
//        findOccurance(str, index + 1, element);
//    }
//
//    public static void main(String[] args){
//        String str = "abcaaahaddaf";
//        findOccurance(str, 0, 'a');
//    }
//}







// example : 5 (check if an array is sorted (strictly increasing))
//class recursion2{
//    public static boolean checkArray(int arr[], int index){
//        if(index == arr.length - 1){
//            return true;     // base case
//        }
//
//        if(arr[index] < arr[index + 1]){
//            return checkArray(arr, index + 1);
//        }
//        else{
//            return false;
//        }
//    }
//
//    public static void main(String[] args){
//        int arr[] = {1, 2, 3, 3, 5};
//        System.out.println(checkArray(arr, 0));
//    }
//}









// example : 6 (move all 'x' to the end of the string)
//class recursion2{
//    public static void moveX(String str, int index, int count, String newString){
//        if(index == str.length()){
//            for(int i = 0; i < count; i++){
//                newString += 'x';
//            }
//            System.out.println(newString);
//            return;
//        }
//
//        char currChar = str.charAt(index);
//        if(currChar == 'x'){
//            count++;
//            moveX(str, index+1, count, newString);
//        }
//        else{
//            newString += currChar;
//            moveX(str, index+1, count, newString);
//        }
//    }
//
//    public static void main(String[] args){
//        String str = "axbcxxd";
//        moveX(str, 0, 0, "");
//    }
//}








// example 7 : (remove duplicates in a string)
//class recursion2{
//    public static boolean[] map = new boolean[26];
//
//    public static void removeDuplicates(String str, int index, String newStr){
//        if(index == str.length()){
//            System.out.println(newStr);
//            return;
//        }
//
//        char currChar = str.charAt(index);
//        if(map[currChar - 'a'] == true){
//            removeDuplicates(str, index+1, newStr);
//        }
//        else{
//            newStr += currChar;
//            map[currChar - 'a'] = true;
//            removeDuplicates(str, index+1, newStr);
//        }
//    }
//
//    public static void main(String[] args){
//        String str = "abbccda";
//        removeDuplicates(str, 0, "");
//    }
//}








// important question for interviews
// example : 8 (print all the subsequences of a string)
//class recursion2{
//    public static void subsequences(String str, int index, String newString){
//        if(index == str.length()){
//            System.out.println(newString);
//            return;
//        }
//
//        char currChar = str.charAt(index);
//
//        // to be
//        subsequences(str, index+1, newString + currChar);
//        // or not to be
//        subsequences(str, index+1, newString);
//    }
//
//    public static void main(String[] args){
//        String str = "abc";
//        subsequences(str, 0, "");
//    }
//}


import java.util.HashSet;

// example : 9 (print all the unique subsequences of a string)
class recursion2{
    public static void subsequences(String str, int index, String newString, HashSet<String> set){
        if(index == str.length()){
            if(set.contains(newString)){
                return;
            }
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(index);

        // to be
        subsequences(str, index+1, newString + currChar, set);
        // or not to be
        subsequences(str, index+1, newString, set);
    }

    public static void main(String[] args){
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        subsequences(str, 0, "", set);
    }
}