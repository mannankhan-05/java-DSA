
public class quickSortPractise {
    public static int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++){   // this for loop will not iterate through the pivot element
            if(arr[j] <= pivot){
                System.out.println("i before incrementing in for loop : " + i);
                i++;
                System.out.println("i after incrementing in for loop : " + i);
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println("i before incrementing after for loop : " + i);
        i++;
        System.out.println("i after incrementing after for loop : " + i);
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }

    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            partition(arr, low, high);

            quickSort(arr, low, high - 1);
            quickSort(arr, low + 1, high);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 4, 3, 7, 4, 5};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
