import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class IntrotoTutorialsChallenger {
    public static int introTutorial(int V, List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) == V) {
                return mid;
            } else if (arr.get(mid) < V) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    public static void InsertionSort(List<Integer> a) {
        int n = a.size();
        for (int i = 1; i < n; i++) {
            int key = a.get(i);   // phần tử cần chèn
            int j = i - 1;
            // So sánh key với các phần tử đứng trước nó
            // dịch chuyển các phần tử lớn hơn key sang phải
            // khi nào đến a[0] hoặc gặp phần tử bé hơn key thì dừng
            while (j >= 0 && a.get(j) > key) {
                a.set(j + 1, a.get(j));
                j--;
            }
            // chèn key vào đúng vị trí
            a.set(j + 1, key);
        }
    }
    public static void print(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        //InsertionSort(arr);
        MergeSortForList mergeSortForList=new MergeSortForList();
        mergeSortForList.sort(arr);

        System.out.println("mang da duoc sap xep :\n");
        print(arr);

        int index = introTutorial(V, arr);
        System.out.println(index);
        scanner.close();
    }



}
