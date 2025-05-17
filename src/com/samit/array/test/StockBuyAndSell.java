package com.samit.array.test;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] prices={1,5,3,8,12};
        int profit=maxProfit(prices,0,prices.length-1);
        System.out.println(profit);
    }
    static int maxProfit(int[] prices,int start,int end) {
        if(start>=end){
            return 0;
        }
        int maxProfit = 0;
        for(int i=start;i<end;i++) {
            for(int j=i+1;j<=end;j++) {
                if(prices[i]<prices[j]) {
                    int currentProfit = prices[j]-prices[i]+maxProfit(prices,start,i-1)+maxProfit(prices,j+1,end);
                    maxProfit = Math.max(maxProfit,currentProfit);
                }
            }
        }
        return maxProfit;
    }
}
