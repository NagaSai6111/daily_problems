class Solution {
  public int lps(String s, int n,int m, int[][] memo){
    if(memo[n][m]!=0){
      return memo[n][m];
    }
    if(n>m){
      return 0;
    }
    if(n==m){
      return 1;
    }
    if(s.charAt(n)==s.charAt(m)){
     memo[n][m] = lps(s, n + 1, m - 1, memo) + 2;
        } else {
       memo[n][m] = Math.max(lps(s, n + 1, m, memo), lps(s, n, m - 1, memo));
    }
    return memo[n][m];
  }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        return lps(s, 0, n - 1, memo);
    }
}