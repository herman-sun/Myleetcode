package Practice.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ShaoHua Sun
 * @Description TODO
 * @Date 2021/9/2 0:02
 */
public class Util {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pq.add(3);
        pq.add(5);
        pq.add(1);
        System.out.println(pq.peek());
    }
}
