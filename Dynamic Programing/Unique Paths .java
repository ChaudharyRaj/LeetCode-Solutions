class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
         if(m==0 && n==0) return 0;
        
        //return memo(0,0,m-1,n-1);
        for(int i =0; i<m; i++) dp[i][n-1] =1;
        for(int i =0; i<n; i++) dp[m-1][i] =1;
        
        for(int i =m-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
//     private int memo(int si,int sj,int ei,int ej){
        
//         if(si == ei && sj == ej)
//             return 1;
//         if(si > ei || sj > ej)
//             return 0;
        
//         if(dp[si][sj] !=0) return dp[si][sj];
        
//         int path1 = memo(si+1,sj,ei,ej);
//         int path2 = memo(si,sj+1,ei,ej);
//         return dp[si][sj] = path1+path2;
//     }
}