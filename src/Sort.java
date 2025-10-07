public class Sort {
    public static void SelectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[i])minIndex=j;
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    public static void InsertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];   // phần tử cần chèn
            int j = i - 1;

            // dịch chuyển các phần tử lớn hơn key sang phải
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            // chèn key vào đúng vị trí
            a[j + 1] = key;
        }
    }
    public static void BubleSort(int[] a){
        int n=a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Mảng ban đầu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        SelectionSort(arr);
        //BubleSort(arr);
        //InsertionSort(arr);

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
