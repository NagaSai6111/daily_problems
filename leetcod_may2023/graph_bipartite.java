class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // Array to store the colors of nodes
        Arrays.fill(colors, -1); // Initialize all nodes with no color
        
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !isBipartiteUtil(graph, colors, i)) {
                return false;
            }
        }
        
        return true;
    }
    private boolean isBipartiteUtil(int[][] graph, int[] colors, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 0; // Assign the first color to the starting node
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            
            for (int neighbor : graph[currNode]) {
                if (colors[neighbor] == colors[currNode]) {
                    return false; // If adjacent nodes have the same color, the graph is not bipartite
                } else if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[currNode]; // Assign the opposite color to the neighbor node
                    queue.offer(neighbor);
                }
            }
        }
        
        return true;
    }
}