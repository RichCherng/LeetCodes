/**
 * 200 Number of Island
 * 
 * Solution: Count '1', remove associated "landmass" by dfs
 * 
 * Run Time Complexity: O(M*N)
 * M - rows
 * N - cols
 * We iterate to every cell (with some overlapping)
 * 
 * Space Complexity: O(M * N)
 * - Worse Case, the whole grid is '1'. 
 * - Recursion stack will group to the size of the grid
 * - (alternatively) BFS will reduce this to O(min(M,N))
 */
class Solution {
  int[][] dir = new int[][]
  {{0, -1}, {0, 1}, {1,0}, {-1,0}};
  
  public int numIslands(char[][] grid) {
      
      int count = 0;
      for(int i = 0; i < grid.length; i++){
          for(int ii = 0; ii < grid[i].length; ii++) {
              if(grid[i][ii] == '1') {
                  count++;
                  removeIsland(grid, i, ii);
              }
          }
      }
      
      return count;
  }    
  
  private void removeIsland(char[][] grid, int row, int col) {
      if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') return;
      
      grid[row][col] = '0';
      for(int[] d: dir) {
          removeIsland(grid, row + d[0], col + d[1]);
      }
  }
}