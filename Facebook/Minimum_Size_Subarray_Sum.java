/**
 * 209 Minimum Size Subarray Sum
 * 
 * Run Time Complexity: O(N)
 * N - size of the array
 * Space Complexity: O(1)
 */
class Solution {
  public int minSubArrayLen(int target, int[] nums) {
      int minLength = nums.length + 1;
      int sum = 0;
      for(int start = 0, i = 0; i < nums.length; i++) {
          sum += nums[i];
          
          while(start <= i && sum >= target) {
              minLength = Math.min(minLength, i - start + 1);
              sum -= nums[start++];
          }
      }
      
      return minLength == nums.length + 1? 0: minLength;
  }
}