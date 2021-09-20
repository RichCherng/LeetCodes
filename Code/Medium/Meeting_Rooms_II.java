/**
 * # 253 Meeting Rooms II
 * 
 * Solution: 
 *  - Sort start times and end times
 *  - Iterate through start time and increment room usage
 *  - each iteration, remove each room that ended
 * 
 * Run Time Complexity: O(n log n)
 *  - n is the length of the array
 *  - 2 sort O(2n log n) 
 *  - 2 iteration of n
 *  - O(2(nlogn) + 2n) = O(n log n)
 * 
 * Space Complexity: O(N)
 *  - 2 N for arrays of start and end time
 */
class Solution {
  public int minMeetingRooms(int[][] intervals) {
      
      int[] startTimes = new int[intervals.length];
      int[] endTimes = new int[intervals.length];
          
      for(int i = 0; i < intervals.length; i++){
          startTimes[i] = intervals[i][0];
          endTimes[i] = intervals[i][1];
      }
      
      Arrays.sort(startTimes);
      Arrays.sort(endTimes);
      
      int room = 0;
      int maxRoom = 0;
      for(int s = 0, e = 0; s < startTimes.length; s++) {
          int start = startTimes[s];
          room++;
          
          
          while(e < endTimes.length && endTimes[e] <= start){
              room--;
              e++;
          }
          
          maxRoom = Math.max(maxRoom, room);
      }
      
      return maxRoom;
  }
}