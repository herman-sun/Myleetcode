package Practice.Leetcode;

/**
 * @Author ShaoHua Sun
 * @Description 198。打家劫舍
 * @Date 2021/9/1 22:50
 */
public class Robber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        } else {
            int[] arr = new int[nums.length];
            arr[0] = nums[0];
            arr[1] = Math.max(nums[0], nums[1]);
            arr[2] = Math.max(nums[0] + nums[2], nums[1]);
            for (int i = 3; i < nums.length; i++) {
                arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);
            }
            return arr[arr.length - 1];
        }
    }
}
