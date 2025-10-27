public class InsertionSort {
    /** Bài 1
     * Đây là hàm sắp xếp toàn bộ mảng, dùng InsertionSort
     */
    public static void InsertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];   // phần tử cần chèn
            int j = i - 1;
            //So sanh key voi cac phan tu dung truoc no
            // dịch chuyển các phần tử lớn hơn key sang phải
            // j duyệt ngươc từ vị trí phần tử đứng đc key
            //khi nao den j chay het  hoac gap phan tu be hon key thi dung
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            // chèn key vào đúng vị trí
            a[j + 1] = key;
        }
    }

    /** Bài 3
     * Đây là hàm chèn phần tử cuối cùng vào mảng đã được sắp xếp trước đó (trừ phần tử cuối).
     * in mảng sau các bước chèn
     */
    public static void insertIntoSorted1(int[] a) {
        int i=a.length - 1;//chi so cua key
        int key = a[i];
        int j = a.length - 2;//chi so bat dau duyet

        // Dịch các phần tử lớn hơn key sang phải
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            printArray(a);
            j--;
        }

        // Chèn key vào đúng vị trí
        a[j + 1] = key;
        printArray(a);
    }

    /** Bài 5
     * Giống như InsertTionSort, nhưng in mảng sau mỗi lần chèn.
     * @param a
     */
    public static void insertionSortPart2(int[] a)
    {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];   // phần tử cần chèn
            int j = i - 1;
            //So sanh key voi cac phan tu dung truoc no
            // dịch chuyển các phần tử lớn hơn key sang phải
            //khi nao den a[0] hoac gap phan tu be hon key thi dung
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            // chèn key vào đúng vị trí
            a[j + 1] = key;
            //in ra sau mỗi lần chèn
            printArray(a);
        }
    }


    // Hàm in mảng
    public static void printArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        int[] sorted = {1, 2, 3, 4, 5};
        int[] reversed = {5, 4, 3, 2, 1};
        int[] random = {3, 1, 4, 5, 2};



        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nMảng sau khi sắp xếp:");
        //insertIntoSorted1(arr);
        //insertionSortPart2(arr);
        long startTime = System.nanoTime();
        InsertionSort(sorted);
        long endTime = System.nanoTime(); // Kết thúc đo

        long duration = endTime - startTime; // Thời gian chạy (nano giây)
        System.out.println("Thời gian chạy: " + duration + " nanoseconds");

        //printArray(arr);
    }

}
