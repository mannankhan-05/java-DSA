// insertion sort practise

import java.util.Scanner;
public class insertionSortPractise {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of elements of array to sort : ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of array");
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int sorted = i - 1;

            while(sorted >= 0 && current < arr[sorted]){
                arr[sorted + 1] = arr[sorted];
                sorted--;
            }

            // placement
            arr[sorted + 1] = current;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
