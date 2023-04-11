class Solution {
    public String removeStars(String s) {
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < s.length(); i++){
          if (s.charAt(i) == '*'){
            str.pop();
          }
          else{
            str.push(s.charAt(i));
          }
        }
        
        StringBuilder answer = new StringBuilder();
        while (!str.isEmpty()) {
            answer.append(str.pop());
        }
        return answer.reverse().toString();
    }
}