class Solution {
    List<String> ans;
    public void helper(String s, int ind, HashMap<Character,String> map,StringBuilder temp){
        if(ind==s.length()){
            ans.add(temp.toString());
            return;
        }
        
        for(char ch:map.get(s.charAt(ind)).toCharArray()){
            temp.append(ch);
            helper(s,ind+1,map,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        if(digits.length()==0)return ans;
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"edf");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(digits,0,map,new StringBuilder());
        return ans;

    }
}
