import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String... args) throws InterruptedException {
        int[] bigArry = new int[10000];
        bigArry = fillArray(bigArry);

        int[] arrOne = Arrays.copyOfRange(bigArry, 0, bigArry.length/2);
        int[] arrTwo = Arrays.copyOfRange(bigArry, bigArry.length/2, bigArry.length);

        ThreadedSort one = new ThreadedSort(arrOne);
        ThreadedSort two = new ThreadedSort(arrTwo);

        one.start();
        two.start();
        one.join();
        two.join();

        int[] tempArrayOne = one.getSortedArray();
        int[] tempArrayTwo = two.getSortedArray();

        int[] tempFinalArray = new int[tempArrayOne.length + tempArrayTwo.length];

        tempFinalArray = mergeArrays(tempArrayOne, tempArrayTwo, tempFinalArray);

        System.out.println(Arrays.toString(tempFinalArray));
        
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while (i<n1 && j <n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            }
            else {
                arr3[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            arr3[k++] = arr1[i++];
        }

        while (j < n2) {
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }

    private static int[] fillArray(int[] arry) {
        Random rnd = new Random();
        for(int i=0; i < arry.length; i++) {
            arry[i] = rnd.nextInt(10000);
        }
        return arry;
    }
}
