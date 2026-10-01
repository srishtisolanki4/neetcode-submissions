class Solution {
    List<String> ans;
    public void helper(int n, int open, int close, StringBuilder temp){
        if(open==n && close==n){
            ans.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append('(');
            helper(n,open+1,close,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            helper(n,open,close+1,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        helper(n,0,0,new StringBuilder());
        return ans;
    }
}

