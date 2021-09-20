/**
 * 1249 Minimum Remove to Make Valid Parenthese
 * 
 * Solution: 
 * - stack to keep track of '(' index
 * - remove from stack if these is a valid ')'
 * - remove ')' if stack is empty (meaning invalid)
 * - using '*' as an indication for removal
 * - Empty stack after iteration, set invalid '(' to be remove
 * 
 * Run time complexity: O(N)
 * - N length of the string
 * - O(N) for string iteration
 * - O(N) for stack iteration
 * - O(N) for replaceAll operation
 * - O(3N) = O(N)
 * 
 * Space Complexity: O(N)
 * - O(N) for stringbuilder
 * - O(N) for stack
 * - O(2N) = O(N)
 */
class Solution {
  public String minRemoveToMakeValid(String s) {
      Stack<Integer> stack = new Stack<Integer>(); // keep track of '(' index
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if(c == '(') {
              sb.append(c);
              stack.add(i);
          } else if (c == ')') {
              if(!stack.isEmpty()){
                  stack.pop();
                  sb.append(c);
              } else {
                  // else remove this parentheses if no valid open
                  sb.append('*'); // so we can use correct index for later
              }
              
          } else {
              sb.append(c);
          }
      }
      
      while(!stack.isEmpty()) {
          // deal with invalid open
          sb.setCharAt(stack.pop(), '*');
      }
      
      return sb.toString().replaceAll("\\*", "");
  }
}
