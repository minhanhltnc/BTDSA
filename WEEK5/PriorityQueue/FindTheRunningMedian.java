import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Tóm tắt: Đọc lần lượt vào N số nguyên.
 * Sau mỗi lần đọc vào số thứ i, in ra giá trị trung vị của i số đã nhập vào.
 * Dùng qu
 */

public class FindTheRunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {

        List <Double> result = new ArrayList<>();
        // chia làm 2 nửa bằng hoặc gần bằng ,
        // tính trung vị dựa trên max của mảng bé, min của mảng lớn

        // Max-Pqueue cho nửa nhỏ hơn
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        // Min-Pqueue cho nửa lớn hơn
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        for (int num : a) {
            // Thêm số vào heap phù hợp
            if(lower.isEmpty()||num<=lower.peek()){
                //nếu lower rổng hoặc num<=phần tử lớn nhất trong lower
                //lower lưu các phần tử bé hơn or= phần tử đang xét
                lower.add(num);
            }
            else {
                //phai là else, ko thi se co kha nang bi trung du lieu o hai queu
                higher.add(num);
            }
            // Cân bằng hai heap lower.size-higher.size<=1
            if(lower.size()-higher.size()>1){
                int x=lower.poll();
                higher.add(x);
            }
            if(lower.size()-higher.size()<0){
                int y=higher.poll();
                lower.add(y);
            }

            // Tính trung vị
            if (lower.size() == higher.size()) {
                double median = (lower.peek() + higher.peek()) / 2.0;
                result.add(median);
            } else {
                result.add((double) lower.peek());
            }

        }

        return result;
    }
}