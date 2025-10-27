public class SelectionSort {
    public static void SelectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            /**
             * tìm min, day ve dau
             */
            for(int j=i+1;j<n;j++){
                if(a[j]<a[i])minIndex=j;
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
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


        // chạy và đo thời gian
        long startTime = System.nanoTime();
        SelectionSort(sorted);
        long endTime = System.nanoTime(); // Kết thúc đo

        long duration = endTime - startTime; // Thời gian chạy (nano giây)
        System.out.println("Thời gian chạy: " + duration + " nanoseconds");

        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

}
