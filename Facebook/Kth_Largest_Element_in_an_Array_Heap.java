class Solution {
  public int findKthLargest(int[] nums, int k) {
      Queue<Integer> que = new PriorityQueue<Integer>();
      for(int n: nums){
          que.add(n);
      }
      
      while(que.size() > k) que.poll();
      
      return que.poll();
  }
}