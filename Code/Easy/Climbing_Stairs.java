/**
 * 70 Climbing Stiars
 * 
 * Run Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
  public int climbStairs(int n) {
      int[] mem = new int[n + 1];
      return climb(n, mem);
  }
  
  private int climb(int n, int[] mem) {
      
      if(n == 1) return 1;
      if(n == 2) return 2;
      
      if(mem[n] != 0) return mem[n];
      
      mem[n] = climb(n - 1, mem) + climb(n - 2, mem);
      
      return mem[n];
  }
}