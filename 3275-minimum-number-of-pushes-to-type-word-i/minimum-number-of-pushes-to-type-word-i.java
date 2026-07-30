class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int ans = 0, prod = 1;
        int quo = len / 8;
        int rem = len % 8;

        while(prod <= quo){
            ans += (prod * 8);
            prod++;
        }
        ans += (rem * prod);
        return ans;
    }
}