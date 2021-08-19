package Practice.Leetcode;

import java.util.Scanner;

/**
 * @Author ShaoHua Sun
 * @Description 64.最小路径和
 * @Date 2021/8/19 21:55
 */
public class PlusForRoad {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }
    static int[][] arr;
    public static int minPathSum(int[][] grid) {
        arr = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (i == 0 && i1 == 0) {
                    arr[i][i1] = grid[i][i1];
                    continue;
                }
                if (i == 0) {
                    arr[i][i1] = grid[i][i1] + arr[i][i1 - 1];
                    continue;
                }
                if (i1 == 0) {
                    arr[i][i1] = arr[i - 1][i1] + grid[i][i1];
                    continue;
                }
                arr[i][i1] = Math.min(arr[i][i1 - 1], arr[i - 1][i1]) + grid[i][i1];
            }
        }
        return arr[grid.length - 1][grid[0].length - 1];
    }
}
