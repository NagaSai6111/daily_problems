class Solution {
    /*
    Approch: 
    Mark island as 1 and 2 using bfs/dfs
    start from 1 and do bfs to get shorted path to island 2
    return the distance
    */
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // Marking 1 island with 2
        boolean isMarked = false;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1){
                    markIsland(i, j, grid);
                    isMarked = true;
                    break;
                }
            }
            if(isMarked) break;
        }
     
        // Adding first island in queue
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< n; i++)
            for(int j = 0; j< n; j++)
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
        
        // Using multi source BFS to find nearest cell of second island (2) from first island cells (1) 
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size--!=0){
                int[] cur = q.poll();
                for(int[] d: dirs){
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 1 || visited[x][y]) continue;
                    if(grid[x][y] == 2) return dist;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            dist++;
        }
        return dist;
    }
    // DFS to mark one island cells as 2
    private void markIsland(int i, int j, int[][] grid){
        grid[i][j] = 2;
        for(int[] d: dirs){
            int x = i+d[0], y = j+d[1];
            if(x < 0 || y < 0 || x == grid.length || y == grid.length || grid[x][y] != 1)
                continue;
            markIsland(x, y, grid);
        }
    } 
}