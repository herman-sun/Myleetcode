package Practice.Leetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ShaoHua Sun
 * @Description 120.三角形最短路径
 * @Date 2021/8/24 23:59
 */
public class Triangle {
//    [[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0],[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        String str = "[[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0],[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]";
        str = str.substring(1, str.length() - 1);
        String[] strArr = str.split("],\\[");
        strArr[0] = strArr[0].replace("[", "");
        strArr[strArr.length - 1] = strArr[strArr.length - 1].replace("]", "");
        for (int i = 0; i < strArr.length; i++) {
            List<Integer> list = new ArrayList<>();
            String[] strArr1 = strArr[i].split(",");
            for (int i1 = 0; i1 < strArr1.length; i1++) {
                list.add(Integer.parseInt(strArr1[i1]));
            }
            triangle.add(list);
        }


        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> list = new ArrayList<>();
        int sum = sum = 0;;
        int index = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> tempList = new ArrayList<>();
            if (i == 0) {
                tempList.add(triangle.get(0).get(0));
                list.add(tempList);
                continue;
            }
            if (i == 1) {
                tempList.add(triangle.get(0).get(0) + triangle.get(1).get(0));
                tempList.add(triangle.get(0).get(0) + triangle.get(1).get(1));
                list.add(tempList);
                continue;
            }
            List<Integer> lastList = list.get(i - 1);
            List<Integer> thisList = triangle.get(i);
            for (int i1 = 0; i1 < thisList.size(); i1++) {
                if (i1 == 0) {
                    tempList.add(lastList.get(0) + thisList.get(0));
                } else if (i1 == thisList.size() - 1) {
                    tempList.add(thisList.get(thisList.size() - 1) + lastList.get(lastList.size() - 1));
                } else {
                    int max = Math.min(lastList.get(i1), lastList.get(i1 - 1)) + thisList.get(i1);
                    tempList.add(max);
                }
            }
            list.add(tempList);
        }
        List<Integer> list1 = list.get(list.size() - 1);
        Collections.sort(list1);
        return list1.get(0);
    }
}
