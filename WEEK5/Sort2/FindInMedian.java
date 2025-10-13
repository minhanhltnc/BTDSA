import java.util.*;

public class FindInMedian {

    public static int findMedian(List<Integer> a) {
        if (a == null || a.size() % 2 == 0 || a.isEmpty()) {
            return -1;
        }
        int n = a.size() / 2;
        return quickSelect(a, 0, a.size() - 1, n);
    }

    private static int quickSelect(List<Integer> a, int low, int high, int n) {
        if (low == high) return a.get(low);

        int pivotIndex = partition(a, low, high);

        if (pivotIndex == n) {
            return a.get(pivotIndex);//tra lai phan tu trung vi vua tim duoc
        } else if (pivotIndex > n) {
            return quickSelect(a, low, pivotIndex - 1, n);
        } else {
            return quickSelect(a, pivotIndex + 1, high, n);
        }
    }

    private static int partition(List<Integer> a, int low, int high) {
        int pivot = a.get(low);
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= j && a.get(i) <= pivot) i++;
            while (i <= j && a.get(j) > pivot) j--;
            if (i >= j) break;

            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }

        int temp = a.get(low);
        a.set(low, a.get(j));
        a.set(j, temp);

        return j;
    }

    public static void print(List<Integer> a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(9, 2, 7, 4, 5));
        System.out.print("Dãy ban đầu: ");
        print(a);

        int median = findMedian(a);
        if (median == -1) {
            System.out.println("Danh sách không hợp lệ!");
        } else {
            System.out.println("Trung vị là: " + median);
        }
    }
}