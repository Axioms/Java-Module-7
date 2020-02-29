import java.util.Arrays;

public class ThreadedSort extends Thread {
    int[] arr;
    private int[] sortedArray;

    protected ThreadedSort(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        sortedArray = bubbleSort(arr);
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    int[] bubbleSort(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) { 
            for (int j = 0; j < n-i-1; j++) { 
                if (arr[j] > arr[j+1]) {  
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
            }
        }
        return arr; 
    }
}
