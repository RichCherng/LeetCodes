/**
 * 15 3Sum
 * 
 * Solution
 * - iterative with 2 pointer
 * - or iterative with remainder hashset
 * 
 * Run Time Complexity: O(N^2)
 * Space Complexity: O(log n) ( from sorting)
 */
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      
      for(int i = 0; i < nums.length - 2; i++){
          // avoid process the same starting number
          if(i > 0 && nums[i-1] == nums[i]) continue;
          int sum = nums[i];
          for(int start = i + 1, end = nums.length-1; start < end; ){
              
              // in this iteration, it can be down with remainder hashset instead (Like two sum question). No sort will be needed
              sum = nums[i] + nums[start] + nums[end];
                  
              if(sum == 0) {
                  ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                  start++;
                  while(start < end && nums[start] == nums[start-1]) {
                      start++;
                  }
              } else if(sum > 0) {
                  end--;
              } else {
                  start++;
              }
              
              
          }
      }
      
      return ans;
  }
}