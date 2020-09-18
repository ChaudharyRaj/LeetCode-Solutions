/*Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')*/


*Memoization Method: *

class Solution {
   public int minDistance(String word1, String word2) {
       
       int[][] dp =  new int[word1.length()+1][word2.length()+1];
       return memo(word1, word2,dp);
   }
   private int memo (String s1,String s2, Integer[][] dp){
       
       if(s1.length() == 0)
           return s2.length();
       
       if(s2.length() == 0)
           return s1.length();
       
       if(dp[s1.length()][s2.length()] != null){
           return dp[s1.length()][s2.length()];
       }
       
       if(s1.charAt(0) == s2.charAt(0)){
           return dp [s1.length()][s2.length()] = memo(s1.substring(1), s2.substring(1), dp);
       }else{
           int opt1 = memo(s1.substring(1),s2, dp);
           int opt2 = memo(s1,s2.substring(1), dp);
           int opt3 = memo(s1.substring(1), s2.substring(1), dp);
           return dp [s1.length()][s2.length()] = 1 + Math.min(opt1, Math.min(opt2,opt3));
           
       }
   }
}
*** Tabulation Method:***

class Solution {
   public int minDistance(String word1, String word2) {
       
       int[][] dp =  new int[word1.length()+1][word2.length()+1];
			 for(int i = 0; i<=s1.length(); i++){
               for(int j =0; j<=s2.length(); j++){
				   if(i == 0) 
					   dp[i][j] =  j;
				   else if(j == 0)
					   dp[i][j] = i;
				   else if(s1.charAt(i-1) == s2.charAt(j-1)){
					   dp[i][j] = dp[i-1][j-1];
				   }else{
					   dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				   }
               }
           }
		return dp[s1.length()][s2.length()];
   }
}