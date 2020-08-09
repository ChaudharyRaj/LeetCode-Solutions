/*Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].*/

//Trie Node 
class TrieNode{
    String word;
    TrieNode[] childrend = new TrieNode[26];
    TrieNode(){}
}

class Solution {
    TrieNode root;
    String result = "";
    public String longestWord(String[] words) {
        root = new TrieNode();
        if(words == null) return result;
        for(String w: words){
            insert(w);
        }
        dfs(root);
        
        return result;
    }
    
    private void dfs(TrieNode node){
        if(node == null) return;
        
        if(node.word != null){
            if(node.word.length() > result.length()){
                result = node.word;
            }else if(node.word.length() == result.length() && node.word.compareTo(result) < 0){
                result = node.word;
            }
        }
        
        for(TrieNode child : node.childrend){
            if(child != null && child.word != null)
                dfs(child);
        }
        
    }
    
    private void insert(String word){
        TrieNode curr = root;
        
        for(char c: word.toCharArray()){
            
            if(curr.childrend[c-'a'] == null){
                curr.childrend[c-'a'] = new TrieNode();
            }
            curr = curr.childrend[c-'a']; 
        }
        
        curr.word = word;
    }
}