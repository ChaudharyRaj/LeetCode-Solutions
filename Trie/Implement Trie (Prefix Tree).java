/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/

class TrieNode{
    TrieNode[] childrend = new  TrieNode[26];
     boolean isEnd;
}
class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
         root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.childrend[c-'a'] == null){
                node.childrend[c-'a'] = new TrieNode();
            }
            node = node.childrend[c-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i =0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.childrend[c-'a'] == null)
                return false;
            node =  node.childrend[c-'a'];
        }
        return node.isEnd; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i =0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.childrend[c-'a'] == null)
                return false;
            node = node.childrend[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */