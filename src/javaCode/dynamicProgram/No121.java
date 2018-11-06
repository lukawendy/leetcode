package javaCode.dynamicProgram;

/** 
 * LeetCode
 * No.121 Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author Alina
 * @since 2.0
 * @see #Alina
 **/

public class No121 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 1) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        // 第i天的价格可以看作是买入价也可以看作是卖出价
        for (int i = 1; i < prices.length; i++) {
            // 找到更低的买入价
            if (min > prices[i]) {
                // 更新买入价
                min = prices[i];
            } 
            // 当天的价格不低于买入价
            else {
                // 如果当天买出的价格比之前卖出的价格高
                if (profit < prices[i] - min) {
                    // 更新卖出价
                    profit = prices[i] - min;
                } 
            }
        }

        return profit;
    }
    
	public static void main(String[] args) {
		No121 solution = new No121();
		int[] list = new int[]{7,1,5,3,6,4};
		System.out.println(solution.maxProfit(list));
	}
}



