
/**
 * 827 Making A Large Island
 * 
 * Solution: Union Set
 * - Group each island into union set
 * - Keep track of each island size
 * - keep tracking of large size found so far (handling no 0)
 * - iterate through grid to find 0, check 4 direction to find set of union
 * - add all union size and compare max size
 * 
 * Run Time Complexity: O(N^2)
 * - O(N*N) iteration
 * - O(N*N) for dfs
 * - O(N*N) for last iteration
 * 
 * Space Complexity: O(N^2)
 * - O(N*N) for size of unions
 * - O(N*N) for dfs to size of the grid
 */
class Solution {
  public int largestIsland(int[][] grid) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // <Group index, island size>
      int maxSize = 0;
      int index = 2; // because 1 is on the map, can't use 1
      
      for(int i = 0; i < grid.length; i++) {
          for(int ii = 0; ii < grid[i].length; ii++) {
              if(grid[i][ii] == 1) {
                  // set them to group (Union)
                  int size = dfs(grid, i, ii, index);
                  map.put(index, size);
                  maxSize = Math.max(size, maxSize); // in case the whole grid is 1;
                  index++;
              }
          }
      }
      
      // if(map.size() == 1) return map.get(2);
      
      for(int i = 0; i < grid.length; i++) {
          for(int ii = 0; ii < grid[i].length; ii++){
              if(grid[i][ii] == 0) {
                  Set<Integer> groups = new HashSet<Integer>();
                  groups.add(getGroup(grid, i, ii -1, map));
                  groups.add(getGroup(grid, i, ii +1, map));
                  groups.add(getGroup(grid, i-1, ii, map));
                  groups.add(getGroup(grid, i+1, ii, map));
                  int size = 1;
                  for(int g: groups) {
                      size += map.getOrDefault(g, 0);
                  }
                  
                  maxSize = Math.max(size, maxSize);
              }
          }
      }
      
      return maxSize;
  }
  
  private int getGroup(int[][] grid, int row, int col, Map<Integer, Integer> map) {
      if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) return 0;
      
      return grid[row][col];
      
  }
  
  private int dfs(int[][] grid, int row, int col, int index) {
      if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] != 1) return 0;
      
      grid[row][col] = index; // union
      
      return 1 
          + dfs(grid, row, col - 1, index)
          + dfs(grid, row, col + 1, index)
          + dfs(grid, row -1, col, index)
          + dfs(grid, row + 1, col, index);
  }
}


/*
1. Union islands into groups
2. Keep track of size
3. Flip zero and add all adjacent group
*/