/**
 * 1091 Shortest Path in Binary Matrix
 * 
 * Solution: BFS
 * 
 * Run Time Comlexity: O(N)
 * N - Number of cell in the grid
 * 
 * Space Complexity: O(N)
 * 
 */
class Solution {
    
  int[][] dir = new int[][]{
      {0,1}, // right
      {1,0}, // down
      {1,1}, // bottom right
      {1,-1}, //bottom left
      {-1,-1}, // top left
      {-1, 1}, // top right
      {0, -1}, // left
      {-1,0}, // top
  };
  public int shortestPathBinaryMatrix(int[][] grid) {
      if(grid[0][0] == 1) return -1; // cannot start
      
      Queue<int[]> que = new LinkedList<int[]>();
      que.add(new int[]{0,0});
      grid[0][0] = 1;
      
      while(!que.isEmpty()) {
          int[] cell = que.poll();
          int x = cell[0];
          int y = cell[1];
          
          
          int distance = grid[x][y];
          if(x == grid.length -1 && y == grid[x].length - 1) return distance;
          
          
          for(int[] d: dir) {
              int row = x + d[0];
              int col = y + d[1];
              if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 0) {
                  // out of bound or not a path
                  continue;
              }

              grid[row][col] = distance + 1;
              que.add(new int[]{row,col});
                              
          }
          
          
      }
      return -1; // have not found the clear path
  }
}

/**
0 1 1 0 1
0 1 0 1 0
0 1 0 1 0
1 0 1 1 0
1 1 1 1 0
*/