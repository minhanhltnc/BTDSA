import java.util.*;

public class MergeSortForList {

    public static void sort(List<Integer> arr) {
        if (arr == null || arr.size() < 2) return;
        mergeSort(arr, 0, arr.size() - 1);
    }

    private static void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(List<Integer> arr, int left, int mid, int right) {
        List<Integer> leftArr = new ArrayList<>(arr.subList(left, mid + 1));
        List<Integer> rightArr = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k++, leftArr.get(i++));
            } else {
                arr.set(k++, rightArr.get(j++));
            }
        }

        while (i < leftArr.size()) {
            arr.set(k++, leftArr.get(i++));
        }

        while (j < rightArr.size()) {
            arr.set(k++, rightArr.get(j++));
        }
    }
}