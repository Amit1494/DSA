class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int months[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aa=helper(months,arriveAlice);
        int la=helper(months,leaveAlice);
        int ab=helper(months,arriveBob);
        int lb=helper(months,leaveBob);
        int start=Math.max(aa,ab);
        int end=Math.min(la,lb);
        return Math.max(0,end-start+1);
    }
    public int helper(int[] months,String date){
        int month=Integer.parseInt(date.substring(0,2));
        int day=Integer.parseInt(date.substring(3));
        int total=day-1;
        for(int i=0;i<month-1;i++){
            total+=months[i];
        }
        return total;
    }
    
}