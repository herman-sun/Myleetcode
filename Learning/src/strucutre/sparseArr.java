package strucutre;

public class sparseArr {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        //转换为稀疏数组
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if (arr[i][i1] != 0) {
                    count++;
                }
            }
        }
        int[][] arr2 = new int[count + 1][3];
        arr2[0][0] = 11;
        arr2[0][1] = 11;
        arr2[0][2] = count;
        int stage = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                if (arr[i][i1] != 0) {
                    arr2[stage][0] = i;
                    arr2[stage][1] = i1;
                    arr2[stage][2] = arr[i][i1];
                    stage++;
                }
            }

        }
        for (int i = 0; i < arr2.length; i++) {
            for (int i1 = 0; i1 < arr2[i].length; i1++) {
                System.out.print(arr2[i][i1] + " ");
            }
            System.out.println();
        }

    }
}
