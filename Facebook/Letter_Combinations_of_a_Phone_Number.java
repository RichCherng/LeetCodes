/**
 * 17 Letter Combinations of a Phone Number
 * 
 * Solution: iteration
 * 
 * Run Time Complexity: O( 4 ^ N * N)
 * N = length of the string
 * O(N) - iterate over digits
 * O(4 ^ N) - for every digits, we could split up to 4 unique combo
 * 
 * Space Complexity: O(N)
 * - if we don't count the output
 * O(N) to just hold the string being process
 * - Couting the output, O(4 ^ N)?
 */
class Solution {
  public List<String> letterCombinations(String digits) {
      List<String> ans = new ArrayList<String>();
      if(digits.length() == 0) return ans;
      Map<Character, String> map = new HashMap<Character, String>();
      map.put('2', "abc");
      map.put('3', "def");
      map.put('4', "ghi");
      map.put('5', "jkl");
      map.put('6', "mno");
      map.put('7', "pqrs");
      map.put('8', "tuv");
      map.put('9', "wxyz");
      
      ans.add("");
      
      for(int i = 0; i < digits.length(); i++) {
          char digit = digits.charAt(i);
          String letters = map.get(digit); // can be optimized if using StringBuilder
          
          List<String> newList = new ArrayList<String>();
          for(String s: ans) { // can be optimized if using Queue
              for(char l: letters.toCharArray()) {
                  newList.add(s+l);
              }
          }
          
          ans = newList;
      }
      
      return ans;
  }
}