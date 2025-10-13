public class InsertionSort {
    public static void InsertionSort(int[] a) {
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
        }
    }
    public static void insertIntoSorted(int[] a) {
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
        int[] arr = {1, 4, 3 ,5 ,6,d 2};

        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nMảng sau khi sắp xếp:");
        //insertIntoSorted(arr);
        //insertionSortPart2(arr);
        //InsertionSort(arr);
        //printArray(arr);
    }

}
