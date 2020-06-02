package sliding_window.q121_BestTimeToBuyAndSellStock;

/**
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    注意：你不能在买入股票前卖出股票。

    示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 */

/*
    在遍历的过程中，记录下之前看到的最低股价
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0 ; i < prices.length ; i ++){
            // 找到当前的最小值
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                // 计算当前收益
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
