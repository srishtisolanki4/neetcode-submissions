class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' ||  ch=='{' || ch=='['){
                st.push(ch);
            }else if(st.isEmpty())return false;
            else if(ch==')'){
                char popped=st.pop();
                if(popped!='(')return false;
            }
            else if(ch=='}'){
                char popped=st.pop();
                if(popped!='{')return false;
            }
            else if(ch==']'){
                char popped=st.pop();
                if(popped!='[')return false;
            }
                
            
        }
        if(st.isEmpty())return true;
        return false;
    }
}
