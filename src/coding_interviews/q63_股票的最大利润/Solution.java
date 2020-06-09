package coding_interviews.q63_股票的最大利润;
/**
    假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 */
/*
    该题与leetcode 121题一样
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // buy记录的是买入日期，sell是卖出日期
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while(sell < prices.length){
            // 如果有更低的购入价格，更改购入日期
            if(prices[buy] >= prices[sell]){
                buy = sell;
            }else{
                // 计算这一天卖出的利润，并与之前比较保留最大值
                maxProfit = Math.max(maxProfit,prices[sell]-prices[buy]);
            }
            sell ++;
        }
        return maxProfit;
    }
}
