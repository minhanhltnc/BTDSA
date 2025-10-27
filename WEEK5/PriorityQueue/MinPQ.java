public class MinPQ {
    private int[] arr;
    private int size;
    private int maxSize;

    public MinPQ(int capacity) {
        maxSize = capacity;
        arr = new int[maxSize];
        size = 0;
    }

    // Thêm phần tử và duy trì thứ tự tăng dần
    public boolean offer(int x) {
        if (isFull()) return false;
        // mảng được lưu dưới dạng tăng dần
        int i = size - 1;
        while (i >= 0 && arr[i] > x) {
            arr[i + 1] = arr[i]; // dịch sang phải
            i--;
        }
        //i lúc này đang trỏ vào phần tử đầu tiên nhỏ hơn x
        // ví dụ x=3, a[i]=2,a[i+1]=a[i+2]=4, ta chèn x vào đúng vị trí
        // a[i+1] đang là bị trùnd vì dịch mảng sang phải
        arr[i + 1] = x;
        size++;
        return true;
    }

    // Lấy phần tử nhỏ nhất
    public int poll() {
        if (isEmpty()) return -1;
        int value = arr[0];
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i]; // dịch sang trái
        }
        size--;
        return value;
    }

    // Xem phần tử nhỏ nhất
    public int peek() {
        if (isEmpty()) return -1;
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }
}