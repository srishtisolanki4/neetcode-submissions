class Solution {
    public boolean isAN(char c){
        if((c>='a' && c<='z') || (c>='0' && c<='9')){return true;}
        return false;
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        
        int l=0,r=s.length()-1;
        while(l<=r){
            if(isAN(s.charAt(l)) && isAN(s.charAt(r)) && (s.charAt(l)==(s.charAt(r)))){
                l++;
                r--;
            }else if(!isAN(s.charAt(l))){l++;}
            else if(!isAN(s.charAt(r)))r--;
            else{
                return false;
            }
            
        }
    return true;
    }
}
