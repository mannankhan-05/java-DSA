
public class quickSortAscending {
    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;    // tracking the empty spaces where elements can be which is less than pivot

        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;     // aik jagah khaali kar raha hoon for the smaller than pivot element
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;      // pivot index
    }

    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 3, 9, 5, 2, 4};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
