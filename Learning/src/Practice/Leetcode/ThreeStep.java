package Practice.Leetcode;

import java.util.Scanner;

/**
 * @Author ShaoHua Sun
 * @Description 三步问题 面试08.01
 * @Date 2021/8/19 21:13
 */
public class ThreeStep {


    public static void main(String[] args) {

        System.out.println(waysToStep(61));
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            arr[i] = arr[i] % 1000000007;
        }
        return (int) (arr[n] % 1000000007);
    }
}
