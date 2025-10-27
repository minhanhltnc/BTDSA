import java.util.*;

public class Quicksort {

    public static void sort(List<Integer> arr) {
        if (arr == null || arr.size() < 2) return;
        quickSort(arr, 0, arr.size() - 1);
    }

    private static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= j && arr.get(i) <= pivot) {
                i++;//chay i den bao gio gap lon hon privot
            }
            while (i <= j && arr.get(j) > pivot) {
                j--;
            }
            if (i >= j) break;
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        //sau khi sap xep xong, j luu phan tu cuoi cung nho hon privot

        // Đưa pivot về đúng vị trí
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        //tra ve vi tri cuar pivot,pivot da o vi tri chua cua no
        return j;
    }

    public static void print(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}