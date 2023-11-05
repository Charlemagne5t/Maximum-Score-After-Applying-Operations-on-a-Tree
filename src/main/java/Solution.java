import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Maximum Score After Applying Operations on a Tree
public class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer, List<Integer>> adjList  = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int out = edge[0];
            int in = edge[1];
            adjList.get(out).add(in);
        }
        long sum = 0;
        Map<String, Long> memo = new HashMap<>();
        return dfs(0, adjList, values, false, memo);
    }
    private long dfs(int i, Map<Integer, List<Integer>> adjList, int[] values, boolean hasValueOnThisPath, Map<String, Long> memo){
        if(adjList.get(i).isEmpty() && hasValueOnThisPath){
            return values[i];
        }
        if(adjList.get(i).isEmpty() && !hasValueOnThisPath){
            return 0;
        }
        if(memo.containsKey(i + " " + hasValueOnThisPath)){
            return memo.get(i + " " + hasValueOnThisPath);
        }
        long result = 0;
        long take = 0;
        long leave = 0;

        if(hasValueOnThisPath){
            take = values[i];
            for (int j = 0; j < adjList.get(i).size(); j++) {
                take += dfs(adjList.get(i).get(j), adjList, values, true, memo);
            }
        }
        if(!hasValueOnThisPath){
            for (int j = 0; j < adjList.get(i).size(); j++) {
                leave += dfs(adjList.get(i).get(j), adjList, values, true, memo);
            }
            take = values[i];
            for (int j = 0; j < adjList.get(i).size(); j++) {
                take += dfs(adjList.get(i).get(j), adjList, values, false, memo);
            }
        }
        result = Math.max(leave, take);
        memo.put(i + " " + hasValueOnThisPath, result);
        return result;
    }
}
