/**
 * # 224 Basic Calculator
 * 
 * Solution: Same solution as Basic Calculator II except with recursion for dealing with parenthesis
 * 
 * Run Time Complexity: O(N)
 *  N is the length of the string
 * 
 * Space Complexity: O(N)
 *  N stack(s) will grow at most N, no larger
 */
class Solution {
    
  int i = 0;
  public int calculate(String s) {
      
      Stack<Integer> stack = new Stack<Integer>();
      int num = 0;
      char op = '+';
      for(; i < s.length(); i++) {
          char c = s.charAt(i);
          
          if(c == ' ') continue;
          if(Character.isDigit(c) || c == '(') {
              if(c == '(') {
                  i++;
                  num = calculate(s);
              } else {
                  while(i < s.length() && Character.isDigit(s.charAt(i))){
                      c = s.charAt(i++);
                      num = num * 10 + (int)(c - '0');
                  }
                  i--;
              }


              if(op == '-') {
                  stack.add(-num);
              } else {
                  stack.add(num);
              }

              num = 0;
          } else if(c == ')') {
              break;  
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