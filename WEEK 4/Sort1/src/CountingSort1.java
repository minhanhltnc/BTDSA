import java.util.Scanner;

/**
 * bài này chỉ yêu cầu in ra mảng tuần suất, ko yêu cầu sắp xếp
 */
public class CountingSort1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > max) max = a[i];
        }

        int[] freq = new int[max + 1];//  độ dài mảng tuần suất là max+1
        for (int i = 0; i < n; i++) {
            freq[a[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            System.out.print(freq[i] + " ");
        }
    }

}