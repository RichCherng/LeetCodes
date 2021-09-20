/**
 * 39 Combination Sum
 * 
 * Solution: Backtracking
 * 
 * Run Time Complexity: O(N ^ (T/M))
 * - N : Number of Candidates
 * - T : Target Number
 * - M : smallest candidates
 * 
 *  Each recursion could potential split down the "recursion tree" to the dept of tree (T/M)
 *  Run Time Complexity is the leaf of this recursion tree.
 *
 * Space Complexity: O(T/M) 
 * - max recusion dept at any given point in time is the dept of the tree
 */

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      
      helper(candidates, target, new ArrayList<Integer>(), ans, 0);
      
      return ans;
  }
  
  private void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> ans, int index) {
      
      if (target == 0) {
          ans.add(new ArrayList<Integer>(list));
          return;
      }
      
      if(target < 0) return;
      
      for(int i = index; i < candidates.length; i++) {
          list.add(candidates[i]);
          helper(candidates, target - candidates[i], list, ans, i);
          list.remove(list.size() - 1);
      }
      
      
  }
}