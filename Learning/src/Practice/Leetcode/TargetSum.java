package Practice.Leetcode;

import java.util.Arrays;

/**
 * @Author ShaoHua Sun
 * @Description 494.目标和
 * @Date 2021/9/6 20:46
 */
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
        }
        if ((sum - target) % 2 == 1 || sum - target < 0) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int[][] arr = new int[nums.length + 1][neg + 1];
        arr[0][0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                arr[i][i1] = arr[i - 1][i1];
                if (i1 >= nums[i - 1]) {
                    arr[i][i1] = arr[i - 1][i1]+arr[i][i1];
                }

            }
        }
        return arr[nums.length][neg];
    }

    public static void main(String[] args) {

    }
}
