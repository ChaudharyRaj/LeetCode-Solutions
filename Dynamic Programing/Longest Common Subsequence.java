/*Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.*/


Below are the both solution Tabulation and Memoization Technique wiht java !

***Tabulation Method : ***

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int  n = s1.length();
        int  m = s2.length();
       
        int[][] dp = new  int[n+1][m+1];
        
        for(int i =  1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){           
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
Memoization Method

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) // initialize all values with '-1'
			for (int j = 0; j < text2.length(); j++)
				dp[i][j] = -1;
		   return findLCS(text1, text2,0,0,dp);
  }
    
      private int findLCS(String s1,String s2,int i1,int i2,int[][] dp){
        
         if(i1 == s1.length() || i2 ==  s2.length()) return 0;
        
         if(dp[i1][i2] == -1){
              if(s1.charAt(i1) == s2.charAt(i2)){
                 dp[i1][i2] =  1 + findLCS(s1,s2,i1+1, i2+1,dp);
                  return dp[i1][i2];
              }else{
                 int opt1 = findLCS(s1,s2,i1+1,i2,dp);
                 int opt2 = findLCS(s1,s2,i1,i2+1,dp);
                dp[i1][i2] = Math.max(opt1,opt2);   
              }
         }
          return dp[i1][i2];
      }
}