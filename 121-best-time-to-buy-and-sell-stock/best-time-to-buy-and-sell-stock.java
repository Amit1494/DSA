class Solution {
    public int maxProfit(int[] prices) {
        int mProfit = 0;
        int min = prices[0];
        
        for(int i = 0; i < prices.length; i++) {
            
            if(prices[i] < min) min = prices[i];
            
            mProfit = Math.max(mProfit, (prices[i] - min));
        }
        return mProfit;
    }
}