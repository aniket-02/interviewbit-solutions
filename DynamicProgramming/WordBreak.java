class TrieNode{
    TrieNode[] child;
    boolean isEndOfWord;
    
    TrieNode() {
        child = new TrieNode[26];
        isEndOfWord = false;
    }
    
    void addToTrie(String s){
        TrieNode currentNode = this;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (currentNode.child[index] == null) {
                currentNode.child[index] = new TrieNode();                
            }
            currentNode = currentNode.child[index];
        }
        currentNode.isEndOfWord = true;
    }
}

public class Solution {
    public boolean wordBreakUtil(String str, int index, boolean[] dp, boolean[] visited, TrieNode root) {
        int n = str.length();
        if (index == n)
            return true;
        
        if (visited[index] == true) {
            return dp[index];
        }
        visited[index] = true;
        
        boolean dividable = false;
        
        TrieNode current = root;
        
        for (int i = index; i < n; i++) {
            int position = str.charAt(i) - 'a';
            if (current.child[position] == null)
                break;
            
            current = current.child[position];
            if (current.isEndOfWord == true) {
                dividable = dividable || wordBreakUtil(str, i+1, dp, visited, root);
            }
        }
        dp[index] = dividable;
        return dp[index];
    }
    
    public int wordBreak(String A, List<String> B) {
        TrieNode root = new TrieNode();
        for (String word : B) {
            root.addToTrie(word);
        }
        int n = A.length();
        boolean[] dp = new boolean[n];
        boolean[] visited = new boolean[n];
        
        wordBreakUtil(A,0,dp,visited,root);
        return dp[0] ? 1 : 0;
    }
}
