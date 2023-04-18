class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Math.max(m,n); i++){
          if(i<m){
            str.append(word1.charAt(i));
          }
          if(i<n){
            str.append(word2.charAt(i));
          }
        } 
        return str.toString();
    }
}