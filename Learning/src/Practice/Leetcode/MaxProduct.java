package Practice.Leetcode;

import java.util.Arrays;

/**
 * @Author ShaoHua Sun
 * @Description 乘积最大子数组 152
 * @Date 2021/8/23 23:24
 */
public class MaxProduct {
    public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
}

    static int tmp[];
    public static int lengthOfLIS(int[] nums) {
        tmp = new int[nums.length];
        tmp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < i; i1++) {
                if (nums[i] > nums[i1]) {
                    tmp[i] = Math.max(tmp[i], tmp[i1] + 1);
                } else if (tmp[i] == 0) {
                    tmp[i] = 1;
                }
            }
        }
        Arrays.sort(tmp);
        return tmp[tmp.length - 1];
    }
}

