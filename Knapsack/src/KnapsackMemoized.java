public class KnapsackMemoized {

    public int knapsack(int wt[],int val[],int W,int n,int dp[][]){
        if(W==0||n==0)
            return 0;
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        else if(wt[n-1]<=W)
            return dp[n][W]=Math.max(val[n-1]+knapsack(wt,val,W-wt[n-1],n-1,dp),knapsack(wt,val,W,n-1,dp));
        else
            return dp[n][W]=knapsack(wt,val,W,n-1,dp);
    }
}
