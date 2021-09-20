class Solution {
  public List<List<Integer>> getFactors(int n) {
      
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      if(n <= 1) return ans;
      helper(n, new ArrayList<Integer>(),ans);
      return ans;
  }
  
  private void helper(int n, List<Integer> list,List<List<Integer>> ans) {
      if(n == 1) {
          if(list.size() > 1) {
              // prevent itself to be part of the answer
              ans.add(new ArrayList<Integer>(list));   
          }
          return;
      }
      
      for(int f = list.isEmpty()? 2: list.get(list.size() - 1); f*f <= n; f++) {
          if(n % f == 0) {
              list.add(f);
              helper(n / f, list, ans);
              list.remove(list.size() - 1);
          }
      }
  }
}