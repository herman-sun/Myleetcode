package Practice.Leetcode;

import java.util.Arrays;

/**
 * @Author ShaoHua Sun
 * @Description 分割和子集
 * @Date 2021/9/2 22:45
 */
public class Partition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1)
        return false;
        sum = sum / 2;
        Arrays.sort(nums);
        int[][] arr = new int[nums.length + 1][sum + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if (i == 0 || i1 == 0) {
                    arr[i][i1] = 0;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int i1 = 1; i1 < arr[i].length; i1++) {
                if (i1 >= nums[i - 1]) {
                    arr[i][i1] = Math.max(arr[i - 1][i1], arr[i - 1][i1 - nums[i - 1]] + nums[i - 1]);
                    if (arr[i][i1] == sum) {
                        return true;
                    }
                } else {
                    arr[i][i1] = arr[i - 1][i1];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{14,9,8,4,3,2};
        System.out.println(canPartition(ar));
    }
}
