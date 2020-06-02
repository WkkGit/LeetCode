package sliding_window.q121_BestTimeToBuyAndSellStock;

/*
    使用双指针，一个指向buy的日期，一个指向sell的日期，
    当sell的价格小于buy的时候，更新buy = sell

    空间复杂度：O(1)
    时间复杂度：O(n)
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while(sell < prices.length){

            if(prices[buy] > prices[sell]){
                // 将buy跟新到更小的价格
                buy = sell;
            }else{
                // 计算收益
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }

            sell ++;
        }
        return maxProfit;
    }
}
