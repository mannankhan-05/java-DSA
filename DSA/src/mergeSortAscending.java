
public class mergeSortAscending {
    public static void conquer(int arr[], int si, int mid, int ei){
        int merged[] = new int[ei - si + 1];    // size of array (ei - si + 1)

        int index1 = si;      // tracking first array
        int index2 = mid + 1;          // tracking second array
        int x = 0;

        while(index1 <= mid && index2 <= ei){
            if(arr[index1] <= arr[index2]){
                merged[x] = arr[index1];
                x++;
                index1++;
            }
            else{
                merged[x] = arr[index2];
                x++;
                index2++;
            }
        }

        while(index1 <= mid){
            merged[x++] = arr[index1++];
        }

        while(index2 <= ei){
            merged[x++] = arr[index2++];
        }

        for(int i = 0, j= si; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[],  int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = (si + ei)/2;         // we can also do this, si  + (ei - si) / 2
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);

        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args){  // time complexity = nlogn
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n-1);

        // print sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
