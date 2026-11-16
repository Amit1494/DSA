class Solution {
    public String digitSum(String s, int k) {
        StringBuffer sb=new StringBuffer(s);
        while(sb.length()>k){
            StringBuffer next=new StringBuffer();
            for(int i=0;i<sb.length();i+=k){
                int start=i;
                int end=Math.min(i+k,sb.length());
                String result = sb.substring( start, end);
                next.append(add(result));
            }
            sb=next;
        }  
        return sb.toString();
    }
    public String add(String sb){
        int sum=0;
        for(int i=0;i<sb.length();i++){
            sum+=sb.charAt(i)-'0';
        }
        return String.valueOf(sum);
    }
}