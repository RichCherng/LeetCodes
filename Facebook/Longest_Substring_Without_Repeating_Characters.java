/**
 * 3 Longest Substring without Repeating Character
 * 
 * Solution: 
 * - Map character to latest occurance index to handle duplicate
 * - Sliding window
 * - Keep track of maxLength
 * 
 * Run Time Complexity: O(N)
 * - N = size of the string. Run through it once
 * 
 * Space Complexity: O(N)
 * - Store in Map at most N
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
      if(s.isEmpty()) return 0;
      
      int maxLength = 0;
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      
      for(int start = 0, i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(map.containsKey(c)) {
              start = Math.max(start, map.get(c) + 1);
          } 
          map.put(c, i);
          
          maxLength = Math.max(maxLength, i - start + 1);
      }
      
      return maxLength;
  }
}