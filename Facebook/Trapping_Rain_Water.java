/**
 * 42 Trapping Rain Water
 * 
 * Solution: keep tracking of max height so far on each size, move from smaller size each iteration
 * 
 * Run Time Complexity: O(N)
 * N - size of height array
 * 
 * Space Complexity: O(1)
 */
class Solution {
  public int trap(int[] height) {
      if(height.length <= 1) return 0;
      
      int maxLeft = height[0], maxRight = height[height.length - 1], water = 0;
      for(int lp = 0, rp = height.length-1; lp < rp;) {
          if(height[lp] < height[rp]) {
              maxLeft = Math.max(maxLeft, height[++lp]);
              water += maxLeft - height[lp];
          } else {
              maxRight = Math.max(maxRight, height[--rp]);
              water += maxRight - height[rp];
          }
      }
      
      return water;
  }
}