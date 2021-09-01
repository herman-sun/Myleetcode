package Practice.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ShaoHua Sun
 * @Description 354.信封
 * @Date 2021/9/1 23:41
 */
public class Envolope {
    public static void main(String[] args) {

    }

    public static int maxEnvelopes(int[][] envelopes) {
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        for (int i = 0; i < envelopes.length; i++) {
            pq.add(envelopes[i]);
        }
        int[] max = new int[envelopes.length];
        int[][] arr = new int[envelopes.length][2];
        max[0] = 1;
        arr[0] = pq.poll();
        for (int i = 1; i < envelopes.length; i++) {
            arr[i] = pq.poll();
            max[i] = 1;
            for (int i1 = 0; i1 < i; i1++) {
                if ((arr[i][0] > arr[i1][0]) && (arr[i][1] > arr[i1][1])) {
                    max[i] = Math.max(max[i], max[i1] + 1);
                }
            }

        }
        Arrays.sort(max);
        return max[max.length - 1];
    }
}
