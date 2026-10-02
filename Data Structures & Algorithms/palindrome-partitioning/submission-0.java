class Solution {
    List<List<String>> ans;
    public boolean isPalindrome(String str){
        int l=0;
        int r=str.length()-1;
        while(l<=r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public void helper(String s, List<String> temp, int ind){
        if(ind==s.length()){
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int i=ind;i<s.length();i++){
            String sub=s.substring(ind,i+1);
            if(isPalindrome(sub)){
                temp.add(sub);
                helper(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
            
        }
        
        return;
    }
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        helper(s,new ArrayList<>(),0);
        return ans;
    }
}
