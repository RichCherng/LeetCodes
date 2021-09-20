class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      
      int maxLength = 0;
      for(int i = 0, start = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          
          map.put(c, i);
          if(map.size() > k) {
              int leftMost = Collections.min(map.values());
              
              start = leftMost + 1;
              map.remove(s.charAt(leftMost));
          }
          maxLength = Math.max(maxLength, i - start + 1);
      }
      
      
      return maxLength;
  }
}

/**
eceba
 -
ceeba
---
eecba

"abaccc"


abee
--
*/