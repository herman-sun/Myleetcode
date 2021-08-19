package Practice.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ShaoHua Sun
 * @Description 152. 乘积最大子数组
 * @Date 2021/8/19 23:29
 */
public class MaxArrByProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
    static int[] maxarr;
    static int[] minarr;
    public static int maxProduct(int[] nums) {
        maxarr = new int[nums.length];
        minarr = new int[nums.length];
        maxarr[0] = nums[0];
        minarr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxarr[i] = Math.max(nums[i], maxarr[i-1] * nums[i]);
                minarr[i] = Math.min(nums[i], minarr[i-1] * nums[i]);
            }
            if (nums[i] <= 0) {
                maxarr[i] = Math.max(nums[i], minarr[i-1] * nums[i]);
                minarr[i] = Math.min(nums[i], maxarr[i-1] * nums[i]);
            }
        }
        Arrays.sort(maxarr);
        return maxarr[maxarr.length - 1];
    }
}
