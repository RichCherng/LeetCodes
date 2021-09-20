/**
 * 509 Fibonacci Number
 * 
 * O(N)
 */
class Solution {

  int[] mem;
  public int fib(int n) {
      
      if(n < 1) return 0;
      mem = new int[n + 1];
      mem[0] = 0;
      mem[1] = 1; 
      return helper(n);
  }
  
  private int helper(int n) {
      if(n == 0 || mem[n] != 0) return mem[n];
      
      mem[n] = helper(n - 1) + helper(n - 2);
      
      return mem[n];
  }
}