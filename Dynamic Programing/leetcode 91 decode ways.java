class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()+1];
        int ans = noWays(s,0,dp);
        return ans;
    }
    private int noWays(String s, int index, Integer[] dp){
        
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(index == s.length()-1) return 1;
        
        if(dp[index] != null ) return dp[index];
        
        int way1 = noWays(s,index+1,dp);
        int way2 = 0;
        if(index < s.length()-1 && Integer.parseInt(s.substring(index,index+2)) <= 26){
            way2 = noWays(s,index+2,dp);
        }
        dp[index] = way1+way2;
        return dp[index];
    }
}