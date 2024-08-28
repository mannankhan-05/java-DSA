/*
* You are given an array of students' grades (as integers) that needs to be sorted.
* Each grade represents the score a student achieved in an exam. Your task is to
* write a Java program that sorts these grades in ascending order using one of the
* sorting algorithms: bubble sort, selection sort, or insertion sort.
*/

import java.util.Scanner;

public class practiseSorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Scores(n) you want to Enter : ");
        int n = sc.nextInt();
        System.out.println("Enter the " + n + " Scores ");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

       // bubble sort algorithm
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}