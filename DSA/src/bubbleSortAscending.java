public class bubbleSortAscending {
    // function to print the sorted array
    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {7, 3, 5, 1, 2};

        // bubble sort for ascending order
        for(int i = 0; i < arr.length - 1; i++){
            // each time the loop runs 1 element will be sorted. that's why not checking the ith element
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }
}
