package Practice.Leetcode;

/**
 * @Author ShaoHua Sun
 * @Description LCS乘积最大子数组 1143
 * @Date 2021/8/24 21:28
 */
public class LongestCommon {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ace","ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int dp[][] = new int[arr1.length][arr2.length];
        int a = 0;
        int b = 0;
        for (; a < arr1.length; a++) {
            if (arr1[a] == arr2[0]) {
                dp[a][0] = 1;
                break;
            }
        }
        for (;a < arr1.length; a++) {
            dp[a][0] = 1;
        }


        for (; b < arr2.length; b++) {
            if (arr2[b] == arr1[0]) {
                dp[0][b] = 1;
                break;
            }
        }
        for (;b < arr2.length; b++) {
            dp[0][b] = 1;
        }

        for (int i = 1; i < arr1.length; i++) {
            for (int i1 = 1; i1 < arr2.length; i1++) {
                if (arr1[i] == arr2[i1]) {
                    dp[i][i1] = dp[i - 1][i1 - 1] + 1;
                } else {
                    dp[i][i1] = Math.max(dp[i][i1 - 1], dp[i - 1][i1]);
                }
            }
        }
        return dp[arr1.length - 1][arr2.length - 1];
    }
}
