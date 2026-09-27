class Solution {
    public String reverseParentheses(String s) {        
       Stack<StringBuffer> sb=new Stack<>();
       StringBuffer stt=new StringBuffer();

       
       for(int i=0;i<s.length();i++){

        if(s.charAt(i)=='('){
            sb.push(stt);
            stt=new StringBuffer();


        }
        else if(s.charAt(i)==')'){
            stt.reverse();
            stt=sb.pop().append(stt);
        }
        else{
            stt.append(s.charAt(i));
        }
       }
       return stt.toString();
    }
    
}