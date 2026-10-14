
import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;

        while (i < n && j < m) {

            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if (start1 <= start2) {

                if (start2 <= end1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);

                    List<Integer> list = new ArrayList<>();
                    list.add(s);
                    list.add(e);
                    res.add(list);
                }

            } else {

                if (start1 <= end2) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);

                    List<Integer> list = new ArrayList<>();
                    list.add(s);
                    list.add(e);
                    res.add(list);
                }
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int k = 0; k < res.size(); k++) {
            ans[k][0] = res.get(k).get(0);
            ans[k][1] = res.get(k).get(1);
        }

        return ans;
    }
}
