class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int profit=0;
        for(int price:prices){
            profit=Math.max(profit,price-minPrice);
            minPrice=Math.min(minPrice,price);
        }
        return profit;
    }
}
