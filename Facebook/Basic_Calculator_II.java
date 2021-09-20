
/**
 * # 227 Basic Calculator II
 * 
 * Solution: Iterative and stack to process '*' or '/' first
 * Empty the stack to do the sum operation 
 * 
 * Run Time Complexity: O(N)
 *  N = Length of the string
 *  iterate over string twice (through loop and stack)
 * 
 * Space Complexity: O(N)
 *  N = Length of the string
 *  Stack can grow no larger than the length of the string
 */
class Solution {
    
  public int calculate(String s) {
      Stack<Integer> stack = new Stack<Integer>();
      
      char op = '+';
      int num = 0;
      for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          
          if(c == ' ') continue;
          
          if(Character.isDigit(c)) {
              while(i < s.length() && Character.isDigit(s.charAt(i))) {
                  c = s.charAt(i++);
                  num = num * 10 + (int)(c - '0');
              }
              i--; 
              
              if(op == '-'){
                  stack.add(-num);
              } else if(op == '*') {
                  stack.add(stack.pop() * num);
              } else if(op == '/') {
                  stack.add(stack.pop() / num);
              } else {
                  stack.add(num);
              }      
              num = 0;
          } else {
              op = c;
          }
      }
      
      int res = 0;
      while(!stack.isEmpty()) {
          res += stack.pop();
      }
      
      return res;
  }
}