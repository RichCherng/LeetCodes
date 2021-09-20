/**
 * 772 Basic Calculator III
 * Same as Basic Calculator II
 */
class Solution {
    
  int i = 0;
  public int calculate(String s) {
      
      Stack<Integer> stack = new Stack<Integer>();
      
      int num = 0;
      char op = '+';
      
      for(; i < s.length(); i++) {
          char c = s.charAt(i);
                      
          if(c == ')') {
              break;
          }
          if(Character.isDigit(c) || c == '(') {
              
              if(c == '(') {
                  i++;
                  num = calculate(s);
              } else {
                  while(i < s.length() && Character.isDigit(s.charAt(i))) {
                      c = s.charAt(i++);
                      num = num * 10 + (c -'0');
                  }
                  i--;
              }

              
              
              if(op == '-') {
                  stack.add(-num);
              } else if(op == '/') {
                  stack.add(stack.pop() / num);
              } else if (op == '*') {
                  stack.add(stack.pop() * num);  
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