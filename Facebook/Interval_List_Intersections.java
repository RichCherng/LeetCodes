/**
 * # 986 Interval List Intersections
 * 
 * Solution: 
 *  - get intersection: get max start time and min end time
 *  - intersected if ( start <= end)
 *  - move pointer of the min endTime
 * 
 * Run Time complexity: O(s1 + s2)
 * Space Complexity: O(s1+s2)
 */
class Solution {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      
      List<int[]> intersect = new ArrayList<int[]>();
      
      for(int p1 = 0, p2 = 0; p1 < firstList.length && p2 < secondList.length;) {
          int start = Math.max(firstList[p1][0], secondList[p2][0]);
          int end = Math.min(firstList[p1][1], secondList[p2][1]);
          
          // if(start )
          if (start <= end)
              intersect.add(new int[]{start, end});
          
          if(firstList[p1][1] < secondList[p2][1]) {
              p1++;
          } else {
              p2++;
          }
      }
      
      int[][] ans = new int[intersect.size()][2];
      for(int i = 0; i < ans.length; i++) {
          ans[i][0] = intersect.get(i)[0];
          ans[i][1] = intersect.get(i)[1];
      }
      
      return ans;
  }
}