/**
 * 252 Meeting Rooms
 * 
 * Solution: 
 * 1. Sort input by start time
 * 2. check if current end time is greater than next start time, return false
 *  - Otherwise return true
 * 
 * Run Time Complexity: O(n log n)
 *  - n is the length of the array
 *  - Sorting Algorithm is (n log n)
 *  - Iteration of intervals is n
 *  - O(n log n + n) = O(n log n)
 * Space Complexity: O(1)
 */
class Solution {
  public boolean canAttendMeetings(int[][] intervals) {

      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      
      for(int i = 0; i < intervals.length - 1; i++) {
          int end = intervals[i][1];
          int nextStart = intervals[i+1][0];
          
          if(end > nextStart) {
              return false;
          }
          
      }
      return true;
  }
}