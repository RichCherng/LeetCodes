/**
 * 20 Valid Parentheses
 */
class Solution {
  public boolean isValid(String s) {
      Stack<Character> stack = new Stack<Character>();
      Map<Character, Character> map = new HashMap<Character, Character>();
      map.put(')', '(');
      map.put('}', '{');
      map.put(']', '[');
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          
          if(map.containsKey(c)) {
              // closing
              char valid = map.get(c);
              if(stack.isEmpty() || stack.pop() != valid) {
                  return false;
              }
          } else {
              // open
              stack.add(c);
          }
      }
      
      return stack.isEmpty();
  }
}