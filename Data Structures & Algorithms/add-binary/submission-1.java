class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1, j=b.length()-1;
        StringBuilder sum=new StringBuilder();
        int carry=0;
        while(i>=0 && j>=0){
            int cA=a.charAt(i)-'0';
            int cB=b.charAt(j)-'0';
            int s=cA+cB+carry;
            if(s<=1){
                sum.append(s);
                carry=0;
            }else if(s==2){
                sum.append(0);
                carry=1;
            }else{
                sum.append(1);
                carry=1;
            }
            i--;j--;
        }
        while(i>=0){
           int cA=a.charAt(i)-'0';
           int s=cA+carry; 
           if(s<=1){
                sum.append(s);
                carry=0;
            }else if(s==2){
                sum.append(0);
                carry=1;
            }
            i--;
        }


        while(j>=0){
           int cB=b.charAt(j)-'0';
           int s=cB+carry; 
           if(s<=1){
                sum.append(s);
                carry=0;
            }else if(s==2){
                sum.append(0);
                carry=1;
            }
            j--;
        }
        if(carry!=0)sum.append(carry);
        return sum.reverse().toString();
    }
}